package com.gestor.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public ConexionBD() {}
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3307/Gestor";
        String user = "appuser";
        String password = "1234";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
