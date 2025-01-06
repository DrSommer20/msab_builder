import re
import psycopg2

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

# Create the weapons table if it doesn't exist
cur.execute("""
CREATE TABLE IF NOT EXISTS weapons (
    id SERIAL PRIMARY KEY,
    clsid VARCHAR(255),
    name VARCHAR(255),
    weight DOUBLE PRECISION
)
""")

# Function to insert weapon data into the database
def insert_weapon(clsid, name, weight):
    cur.execute("""
    INSERT INTO weapons (clsid, name, weight)
    VALUES (%s, %s, %s)
    """, (clsid, name, weight))

# Extract weapon information from the weapons_data.py file
with open('c:/Users/timmi/Documents/Github/msab_builder/pyToDB/dcs/weapons_data.py', 'r') as file:
    content = file.read()

# Regular expression to match weapon data
weapon_pattern = re.compile(r'(\w+)\s*=\s*{\s*"clsid":\s*"([^"]+)",\s*"name":\s*"([^"]+)",\s*"weight":\s*([\d.]+)\s*}')

# Find all matches in the content
matches = weapon_pattern.findall(content)

# Insert each weapon into the database
for match in matches:
    clsid, name, weight = match[1], match[2], float(match[3])
    insert_weapon(clsid, name, weight)

# Commit the transaction
conn.commit()

# Close the cursor and connection
cur.close()
conn.close()