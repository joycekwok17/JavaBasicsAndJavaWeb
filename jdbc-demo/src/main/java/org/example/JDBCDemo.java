package org.example;

import java.sql.*;

/**
 * @author Xuanchi Guo
 * @project Default (Template) Project
 * @created 7/5/23
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String username = "root";
        String password = "password";
        String sql = "select * from tb_user";

        String jdbcUrl = "jdbc:mysql://localhost:3306/newDB?useSSL=false&serverTimezone=UTC";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Perform your database operations here
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}