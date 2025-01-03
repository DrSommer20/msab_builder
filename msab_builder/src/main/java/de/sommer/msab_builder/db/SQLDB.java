package de.sommer.msab_builder.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sommer.msab_builder.util.ComboItem;

public class SQLDB {

    public static List<ComboItem> getAirports() {
        return getComboItems("SELECT * FROM airport");
    }

    public static List<ComboItem> getAircrafts() {
        return getComboItems("SELECT * FROM planes");
    }

    public static List<ComboItem> getAircraftsAI() {
        return getComboItems("SELECT * FROM planesAI");
    }

    public static List<ComboItem> getWeather() {
        return getComboItems("SELECT * FROM weather");
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
}
