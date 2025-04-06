package com.example.socialnetwork.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/social_network";
    private static final String USER = "root"; // Thay bằng username MySQL của bạn
    private static final String PASSWORD = "251204"; // Thay bằng password MySQL của bạn

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Sử dụng driver cho MySQL 5.1.49
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }
    }
}