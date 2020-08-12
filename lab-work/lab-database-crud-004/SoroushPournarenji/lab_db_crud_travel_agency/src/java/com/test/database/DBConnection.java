package com.test.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private String driver;
    private String user;
    private String pass;
    private String url;
    private Connection connection;
    private static DBConnection dbConnection = null;

    public DBConnection() {
    }

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        File file = new File("src/resources/application.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        this.driver = properties.getProperty("db.driver");
        this.user = properties.getProperty("db.user");
        this.pass = properties.getProperty("db.password");
        this.url = properties.getProperty("db.url");
        Class.forName(this.driver);
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            synchronized (DBConnection.class) {
                dbConnection = new DBConnection();
            }
        }
        return dbConnection;
    }
}
