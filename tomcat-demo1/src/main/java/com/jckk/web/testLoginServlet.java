package com.jckk.web;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class testLoginServlet {
    private final String URL= "jdbc:mysql://127.0.0.1:3306/myDatabase?useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "19970713";

    public static void main(String[] args) {
        testLoginServlet test = new testLoginServlet();
        test.connectAndInsertToDB();
    }

    public void connectAndInsertToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("JAVA: Class.forName() error");
            e.printStackTrace();
        }
        try {

            DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error in initializing a connection to MYSQL DB");
            e.printStackTrace();

        }
        ArrayList<String> list = new ArrayList<>();
    }

}
