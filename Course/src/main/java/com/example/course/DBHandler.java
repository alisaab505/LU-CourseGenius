package com.example.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHandler extends Configs {

    Connection dbConnection;

    public Connection getConnection() {
        // "jdbc:mysql://localhost:3306/invdbfx";
        String connectionString = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbshima;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, Configs.dbuser, Configs.dbpass);
        } catch (Exception e) {
        }
        System.out.println("done");
        return dbConnection;
    }

}