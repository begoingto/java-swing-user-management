/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import app.data.infact.Auth;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begoingto
 */
public class Authentication implements Auth {

    private String username;
    private String password;
    private String code;

    public Authentication() {
    }

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Boolean check(String username, String password) {
        String query = "SELECT * FROM customer WHERE username = ? AND password = ?;";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            boolean r = resultSet.next();
            if (r) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Boolean setCode(String code, String username) {
        this.code = code;
        this.username = username;
        String query = "UPDATE customer SET code=?, expire_code=current_timestamp + INTERVAL '2 minutes' WHERE username = ?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code);
            stmt.setString(2, username);
            int resultSet = stmt.executeUpdate();
            return resultSet == 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Boolean verify(String code, String username) {
        String query = """
                       SELECT * FROM customer 
                       WHERE username = ? 
                       AND code = ?
                       AND expire_code >= now() AT TIME ZONE 'Asia/Phnom_Penh';
                       """;
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, code);
            ResultSet resultSet = stmt.executeQuery();
            boolean r = resultSet.next();
            if (r) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
