import sys
import psycopg2
import inspect
from psycopg2 import sql
import dcs.planes as planes_module
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

# Create tables if they don't exist
cur.execute("""
CREATE TABLE IF NOT EXISTS planes (
    id SERIAL PRIMARY KEY,
    plane_id VARCHAR(255),
    flyable BOOLEAN,
    height DOUBLE PRECISION,
    width DOUBLE PRECISION,
    length DOUBLE PRECISION,
    fuel_max DOUBLE PRECISION,
    max_speed DOUBLE PRECISION,
    chaff INTEGER,
    flare INTEGER,
    charge_total INTEGER,
    chaff_charge_size INTEGER,
    flare_charge_size INTEGER,
    radio_frequency DOUBLE PRECISION
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS pylons (
    id SERIAL PRIMARY KEY,
    plane_id INTEGER REFERENCES planes(id),
    pylon_number INTEGER,
    weapon_clsid VARCHAR(255)
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    plane_id INTEGER REFERENCES planes(id),
    task VARCHAR(255)
)
""")

# Function to insert plane data into the database
def insert_plane(plane):
    cur.execute("""
    INSERT INTO planes (plane_id, flyable, height, width, length, fuel_max, max_speed, chaff, flare, charge_total, chaff_charge_size, flare_charge_size, radio_frequency)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) RETURNING id
    """, (plane.id, plane.flyable, plane.height, plane.width, plane.length, plane.fuel_max, plane.max_speed, plane.chaff, plane.flare, plane.charge_total, plane.chaff_charge_size, plane.flare_charge_size, plane.radio_frequency))
    return cur.fetchone()[0]

# Function to insert pylon data into the database
def insert_pylon(plane_id, pylon_number, weapon_clsid):
    cur.execute("""
    INSERT INTO pylons (plane_id, pylon_number, weapon_clsid)
    VALUES (%s, %s, %s)
    """, (plane_id, pylon_number, weapon_clsid))

# Function to insert task data into the database
def insert_task(plane_id, task):
    cur.execute("""
    INSERT INTO tasks (plane_id, task)
    VALUES (%s, %s)
    """, (plane_id, str(task)))

# Discover all plane classes in the planes module
plane_classes = [cls for name, cls in inspect.getmembers(planes_module, inspect.isclass) if issubclass(cls, planes_module.PlaneType) and cls is not planes_module.PlaneType]

# Insert all planes from the discovered plane classes
for plane_class in plane_classes:
    plane = plane_class()
    plane_id = insert_plane(plane)

    # Insert pylons
    for pylon_name, pylon in plane_class.__dict__.items():
        if pylon_name.startswith("Pylon"):
            pylon_number = int(pylon_name[5:])
            for weapon_name, weapon in pylon.__dict__.items():
                if isinstance(weapon, tuple) and len(weapon) == 2:
                    weapon_clsid = weapon[1].get('clsid')
                    insert_pylon(plane_id, pylon_number, weapon_clsid)

    # Insert tasks
    for task in plane_class.tasks:
        insert_task(plane_id, task)

# Commit the transaction
conn.commit()

# Close the cursor and connection
cur.close()
conn.close()