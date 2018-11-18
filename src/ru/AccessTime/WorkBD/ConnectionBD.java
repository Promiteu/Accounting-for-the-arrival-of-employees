package ru.AccessTime.WorkBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    public Connection getConnection() {
        return connection;
    }

    public static Connection connection;

    public ConnectionBD() {
        try {
            connect();
        } catch (SQLException e) {
            System.out.println("DataBase not found");
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:ServicemanBD.db");
        System.out.println("База подключилась");
    }

    public static void disconnect() throws SQLException {
        connection.close();
        System.out.println("База отключилась");
    }
}
