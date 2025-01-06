import sys
import psycopg2
from psycopg2 import sql
from dcs.terrain.syria import Syria
from dcs.terrain.terrain import Terrain
from dcs.terrain.syria.airports import ParkingSlot, Runway, RunwayApproach, AirportBeacon
from dcs.terrain.syria.airports import ALL_AIRPORTS

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
CREATE TABLE IF NOT EXISTS airports (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    tacan VARCHAR(255),
    civilian BOOLEAN,
    slot_version INTEGER,
    atc_radio_hf_hz INTEGER,
    atc_radio_vhf_low_hz INTEGER,
    atc_radio_vhf_high_hz INTEGER,
    atc_radio_uhf_hz INTEGER
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS parking_slots (
    id SERIAL PRIMARY KEY,
    airport_id INTEGER REFERENCES airports(id),
    crossroad_idx INTEGER,
    position_x DOUBLE PRECISION,
    position_y DOUBLE PRECISION,
    large BOOLEAN,
    heli BOOLEAN,
    airplanes BOOLEAN,
    slot_name VARCHAR(255),
    length DOUBLE PRECISION,
    width DOUBLE PRECISION,
    height DOUBLE PRECISION,
    shelter BOOLEAN
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS runways (
    id SERIAL PRIMARY KEY,
    airport_id INTEGER REFERENCES airports(id),
    name VARCHAR(255),
    main_approach_name VARCHAR(255),
    main_approach_heading INTEGER,
    opposite_approach_name VARCHAR(255),
    opposite_approach_heading INTEGER
)
""")

cur.execute("""
CREATE TABLE IF NOT EXISTS beacons (
    id SERIAL PRIMARY KEY,
    airport_id INTEGER REFERENCES airports(id),
    beacon_id VARCHAR(255)
)
""")

# Insert data into the database
def insert_airport(airport):
    atc_radio = airport.atc_radio
    hf_hz = atc_radio.hf_hz if atc_radio else None
    vhf_low_hz = atc_radio.vhf_low_hz if atc_radio else None
    vhf_high_hz = atc_radio.vhf_high_hz if atc_radio else None
    uhf_hz = atc_radio.uhf_hz if atc_radio else None

    cur.execute("""
    INSERT INTO airports (name, tacan, civilian, slot_version, atc_radio_hf_hz, atc_radio_vhf_low_hz, atc_radio_vhf_high_hz, atc_radio_uhf_hz)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s) RETURNING id
    """, (airport.name, airport.tacan, airport.civilian, airport.slot_version, hf_hz, vhf_low_hz, vhf_high_hz, uhf_hz))
    return cur.fetchone()[0]

def insert_parking_slot(airport_id, slot):
    cur.execute("""
    INSERT INTO parking_slots (airport_id, crossroad_idx, position_x, position_y, large, heli, airplanes, slot_name, length, width, height, shelter)
    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """, (airport_id, slot.crossroad_idx, slot.position.x, slot.position.y, slot.large, slot.helicopter, slot.airplanes, slot.slot_name, slot.length, slot.width, slot.height, slot.shelter))

def insert_runway(airport_id, runway):
    cur.execute("""
    INSERT INTO runways (airport_id, name, main_approach_name, main_approach_heading, opposite_approach_name, opposite_approach_heading)
    VALUES (%s, %s, %s, %s, %s, %s)
    """, (airport_id, runway.name, runway.main.name, runway.main.heading, runway.opposite.name, runway.opposite.heading))

def insert_beacon(airport_id, beacon):
    cur.execute("""
    INSERT INTO beacons (airport_id, beacon_id)
    VALUES (%s, %s)
    """, (airport_id, beacon.id))

# Create a Terrain object
terrain = Syria()

# Insert all airports from the ALL_AIRPORTS list
for airport_class in ALL_AIRPORTS:
    airport = airport_class(terrain)
    airport_id = insert_airport(airport)

    # Insert parking slots
    for slot in airport.parking_slots:
        insert_parking_slot(airport_id, slot)

    # Insert runways
    for runway in airport.runways:
        insert_runway(airport_id, runway)

    # Insert beacons
    for beacon in airport.beacons:
        insert_beacon(airport_id, beacon)

# Commit the transaction
conn.commit()

# Close the cursor and connection
cur.close()
conn.close()