package com.shailja.Customer_SpringBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
        public static void main(String[] args) {
            String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc_crud?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "";

            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
                if (conn != null) {
                    System.out.println("Connection successful!");
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

