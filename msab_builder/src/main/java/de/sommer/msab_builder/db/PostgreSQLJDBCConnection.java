package de.sommer.msab_builder.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

class PostgreSQLJDBCConnection {

    private static BasicDataSource ds = new BasicDataSource();
    
    // Database URL
    private static final String DB_URL = "jdbc:postgresql://192.168.2.121:5588/msab_builder";
    
    // Database credentials
    private static final String USER = "admin";
    private static final String PASS = "admin";

    static {
        ds.setUrl(DB_URL);
        ds.setUsername(USER);
        ds.setPassword(PASS);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private PostgreSQLJDBCConnection(){ }
    
}