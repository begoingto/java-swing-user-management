/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import raven.toast.Notifications;

/**
 *
 * @author begoingto
 */
public class ConnectionDB {

    private static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/java_";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "root";

    private static Connection connection = null;

    // Method to establish a connection to the database
    public static Connection getConnection() {

        try {
            if (connection == null || connection.isClosed()) {
                // Register PostgreSQL JDBC driver
                Class.forName("org.postgresql.Driver");

                // Open a connection
                return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            }

        } catch (ClassNotFoundException e) {
            Notifications.getInstance().show(
                    Notifications.Type.ERROR,
                    Notifications.Location.TOP_RIGHT,
                    "Error loading JDBC driver: " + e.getMessage()
            );
            System.err.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            Notifications.getInstance().show(
                    Notifications.Type.ERROR,
                    Notifications.Location.TOP_RIGHT,
                    5000,
                    "Error connecting to the database: " + e.getMessage()
            );
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.err.println("Error closing the connection: " + e.getMessage());
            }
        }
    }

    public static List<Object> getAllTable() throws SQLException {
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' ORDER BY 1 ASC;";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        List<Object> data = new ArrayList();
        while (resultSet.next()){
            data.add(resultSet.getString("table_name"));
        }
        conn.close();
        return data;
    }
}
