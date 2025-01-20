package de.sommer.msab_builder.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import io.github.cdimascio.dotenv.Dotenv;

class PostgreSQLJDBCConnection {

     private static BasicDataSource ds = new BasicDataSource();
    private static Dotenv dotenv = Dotenv.load();
    
    // Database URL
    private static final String DB_URL = dotenv.get("DB_URL");
    
    // Database credentials
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

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