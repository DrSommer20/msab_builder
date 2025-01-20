package de.sommer.msab_builder.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.sommer.msab_builder.util.ComboItem;

public class SQLDB {

    public static List<ComboItem> getAirports() {
        return ComboItem.sort(getComboItems("SELECT id value, name displayValue FROM airports"));
    }

    public static List<ComboItem> getPlanes() {
        return getComboItems("SELECT plane_id displayValue, id value FROM planes");
    }

    public static List<ComboItem> getHelicopters() {
        return getComboItems("SELECT helicopter_id displayValue, id value FROM helicopters");
    }

    public static List<ComboItem> getFlyableAircrafts() {
        return getComboItems("SELECT plane_id displayValue, id value FROM planes where flyable = true");
    }

    public static List<ComboItem> getFlyableHelicopters() {
        return  getComboItems("SELECT helicopter_id displayValue, id value FROM helicopters where flyable = true");
    }

    public static List<ComboItem> getAircraftsAI() {
        return getComboItems("SELECT * FROM planesAI");
    }

    public static List<ComboItem> getWeather() {
        return  getComboItems("SELECT * FROM weather");
    }

    public static List<ComboItem> getWind() {
        return getComboItems("SELECT * FROM wind");
    }

    public static List<ComboItem> getMissionTypes() {
        return getComboItems("SELECT * FROM missionTypes");
    }

    public static List<ComboItem> getTimePeriods() {
        return getComboItems("SELECT * FROM timeperiod");
    }

    public static List<ComboItem> getMisc() {
        return getComboItems("SELECT * FROM misc");
    }

    private static List<ComboItem> getComboItems(String query) {
        List<ComboItem> items = new ArrayList<>();
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String displayValue = rs.getString("displayValue");
                String value = rs.getString("value");
                items.add(new ComboItem(displayValue, value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    // Mission JSON
    public static String getMissionJSON(String name){
        String query = "SELECT * FROM public.\"missionJSON\" WHERE name = '" + name + "'";
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("json");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ParkingSlots for Airport
    public static List<ComboItem> getParkingSlots(String airportId){
        List<ComboItem> items = new ArrayList<>();
        String query = "SELECT * FROM public.\"parking_slots\" WHERE airport_id = " + airportId;
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String displayValue = rs.getString("slot_name");
                String value = Integer.toString(rs.getInt("id"));
                items.add(new ComboItem(displayValue, value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static List<ComboItem> getAirports(String aircraft_Type) {
        String query = "";
        if(aircraft_Type.equals("Plane")) {
            query = "SELECT Distinct airports.id value, airports.name displayValue FROM public.\"parking_slots\" join public.\"airports\" On airports.id = parking_slots.airport_id WHERE airplanes = true";
        }
        else if(aircraft_Type.equals("Helicopter")) {
            query = "SELECT Distinct airports.id value, airports.name displayValue FROM public.\"parking_slots\" join public.\"airports\" On airports.id = parking_slots.airport_id WHERE heli = true";
        }
        return ComboItem.sort(getComboItems(query));
    }

    // ParkingSlots for Aircraft at Airport
    public static List<ComboItem> getParkingSlots(String airport_id, String aircraft_Type ,String aircraft_id) {
        String queryParking = "";
        String queryAircraft = "";
        double aircraft_length = 0;
        double aircraft_width = 0;
        double aircraft_height = 0;

        if(aircraft_Type.equals("Plane")) {
            queryParking = "SELECT * FROM public.\"parking_slots\" WHERE airport_id = " + airport_id + " AND airplanes = true";
            queryAircraft = "SELECT * FROM public.\"planes\" WHERE id = " + aircraft_id;
        }
        else if(aircraft_Type.equals("Helicopter")) {
            queryParking = "SELECT * FROM public.\"parking_slots\" WHERE airport_id = " + airport_id + " AND heli = true";
            queryAircraft = "SELECT * FROM public.\"helicopters\" WHERE id = " + aircraft_id;
        }

        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryAircraft)) {

            if (rs.next()) {
                aircraft_length = rs.getDouble("length");
                aircraft_width = rs.getDouble("width");
                aircraft_height = rs.getDouble("height");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<ComboItem> items = new ArrayList<>();
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryParking)) {

            while (rs.next()) {
                double slot_length = rs.getDouble("length");
                double slot_width = rs.getDouble("width");
                double slot_height = rs.getDouble("height");

                if(aircraft_length <= slot_length && aircraft_width <= slot_width && aircraft_height <= slot_height) {
                    String displayValue = rs.getString("slot_name");
                    String value = Integer.toString(rs.getInt("id"));
                    items.add(new ComboItem(displayValue, value));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static List<Integer> getPylonNames(String aircraft_id){
        List<Integer> items = new ArrayList<>();
        String query = "SELECT DISTINCT pylons.pylon_number\r\n" + //
                        "\tFROM public.planes Join public.pylons on planes.id = pylons.plane_id\r\n" + //
                        "\tWhere planes.id = " + aircraft_id + ";";
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                items.add(rs.getInt("pylon_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(items);
        return items;
    }

    public static List<ComboItem> getWeaponForPylon(String aircraft_id, String pylon_number){
        List<ComboItem> items = new ArrayList<>();
        String query = "SELECT DISTINCT weapons.name, weapons.clsid\r\n" + //
                        "\tFROM public.planes \r\n" + //
                        "\tJoin public.pylons on planes.id = pylons.plane_id\r\n" + //
                        "\tJoin public.weapons on pylons.weapon_clsid = weapons.clsid\r\n" + //
                        "\tWhere planes.id = " + aircraft_id + " AND pylons.pylon_number = " + pylon_number +";";
        try (Connection conn = PostgreSQLJDBCConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String displayValue = rs.getString("name");
                String value = rs.getString("clsid");
                items.add(new ComboItem(displayValue, value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return ComboItem.sort(items);
        }
        


    public static void main(String[] args) {
        System.out.println(getPylonNames("5"));
    }
}


