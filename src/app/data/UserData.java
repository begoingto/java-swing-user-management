/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import app.AppForm;
import java.sql.*;
import app.models.User;
import app.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begoingto
 */
public class UserData {

    private static String table = "customer";

    public static List<User> list() throws SQLException {
        String query = "SELECT * FROM " + table + " ORDER BY ID ASC;";
        List<User> customers = new ArrayList<>();
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String username = resultSet.getString("username");
            String fullName = resultSet.getString("full_name");
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            Boolean status = resultSet.getBoolean("is_active");
            User customer = new User(id, username, fullName, gender, password, role, status);
            customers.add(customer);
        }
        Logger.getLogger(AppForm.class.getName()).info("fetch user table");
        conn.close();
        return customers;
    }

    public static User addUser(User u) throws SQLException {
        String query = "SELECT create_user(?, ?, ?, ?, ?, ?);";
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getFullName());
        stmt.setString(3, u.getGender());
        stmt.setString(4, u.getPassword());
        stmt.setString(5, u.getRole());
        stmt.setBoolean(6, u.getStatus());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int userId = rs.getInt(1);
            u.setId(userId);
        }
        conn.close();
        Logger.getLogger(AppForm.class.getName()).info("create user id=" + u.getId());
        return u;
    }

    public static Boolean updateUser(User u) throws SQLException {
        String query = "UPDATE " + table + " SET username = ?, full_name = ?, gender = ?, password = ?, role = ?, is_active = ? WHERE id = ?;";
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getFullName());
        stmt.setString(3, u.getGender());
        stmt.setString(4, u.getPassword());
        stmt.setString(5, u.getRole());
        stmt.setBoolean(6, u.getStatus());
        stmt.setInt(7, u.getId());
        int rowsAffected = stmt.executeUpdate();
        conn.close();
        Logger.getLogger(AppForm.class.getName()).info("update user id=" + u.getId());
        return rowsAffected > 0;
    }

    public static Boolean deleteUser(User user) throws SQLException {
        String query = "DELETE FROM " + table + " WHERE id = ? ;";
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, user.getId());
        int rowsAffected = stmt.executeUpdate();
        conn.close();
        Logger.getLogger(AppForm.class.getName()).info("delete user id=" + user.getId());
        return rowsAffected > 0;
    }

    public User getByUuid(UUID uuid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
