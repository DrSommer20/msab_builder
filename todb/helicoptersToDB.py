import inspect
import psycopg2
import dcs.helicopters as helicopters_module
from dcs.weapons_data import Weapons

# Database connection details
DB_HOST = "192.168.2.121"
DB_PORT = "5588"
DB_NAME = "msab_builder"
DB_USER = "admin"
DB_PASS = "admin"

# Connect to the PostgreSQL database
conn = psycopg2.connect(
    host=DB_HOST,
    port=DB_PORT,
    dbname=DB_NAME,
    user=DB_USER,
    password=DB_PASS
)
cur = conn.cursor()

# Create tables
cur.execute("""
CREATE TABLE IF NOT EXISTS helicopters (
    id SERIAL PRIMARY KEY,
    helicopter_id VARCHAR(255) NOT NULL,
    flyable BOOLEAN,
    height FLOAT,
    width FLOAT,
    length FLOAT,
    fuel_max FLOAT,
    max_speed FLOAT,
    chaff INTEGER,
    flare INTEGER,
    charge_total INTEGER,
    chaff_charge_size INTEGER,
    flare_charge_size INTEGER,
    radio_frequency FLOAT
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS helicopter_pylons (
    id SERIAL PRIMARY KEY,
    helicopter_id INTEGER REFERENCES helicopters(id),
    pylon_number INTEGER,
    weapon_clsid VARCHAR(255)
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS helicopter_tasks (
    id SERIAL PRIMARY KEY,
    helicopter_id INTEGER REFERENCES helicopters(id),
    task VARCHAR(255)
)
""")

# Function to insert helicopter data into the database
def insert_helicopter(helicopter):
    cur.execute("""
    INSERT INTO helicopters (helicopter_id, flyable, height, width, length, fuel_max, max_speed, chaff, flare, charge_total, chaff_charge_size, flare_charge_size, radio_frequency)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) RETURNING id
    """, (helicopter.id, helicopter.flyable, helicopter.height, helicopter.width, helicopter.length, helicopter.fuel_max, helicopter.max_speed, helicopter.chaff, helicopter.flare, helicopter.charge_total, helicopter.chaff_charge_size, helicopter.flare_charge_size, helicopter.radio_frequency))
    return cur.fetchone()[0]

# Function to insert pylon data into the database
def insert_pylon(helicopter_id, pylon_number, weapon_clsid):
    cur.execute("""
    INSERT INTO helicopter_pylons (helicopter_id, pylon_number, weapon_clsid)
    VALUES (%s, %s, %s)
    """, (helicopter_id, pylon_number, weapon_clsid))

# Function to insert task data into the database
def insert_task(helicopter_id, task):
    cur.execute("""
    INSERT INTO helicopter_tasks (helicopter_id, task)
    VALUES (%s, %s)
    """, (helicopter_id, str(task)))

# Discover all helicopter classes in the helicopters module
helicopter_classes = [cls for name, cls in inspect.getmembers(helicopters_module, inspect.isclass) if issubclass(cls, helicopters_module.HelicopterType) and cls is not helicopters_module.HelicopterType]

# Insert all helicopters from the discovered helicopter classes
for helicopter_class in helicopter_classes:
    helicopter = helicopter_class()
    helicopter_id = insert_helicopter(helicopter)

    # Insert pylons
    for pylon_name, pylon in helicopter_class.__dict__.items():
        if pylon_name.startswith("Pylon"):
            pylon_number = int(pylon_name[5:])
            for weapon_name, weapon in pylon.__dict__.items():
                if isinstance(weapon, tuple) and len(weapon) == 2:
                    weapon_clsid = weapon[1].get('clsid')
                    insert_pylon(helicopter_id, pylon_number, weapon_clsid)

    # Insert tasks
    for task in helicopter_class.tasks:
        insert_task(helicopter_id, task)

# Commit the transaction
conn.commit()

# Close the cursor and connection
cur.close()
conn.close()