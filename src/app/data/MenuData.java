/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import app.models.Menu;
import app.models.UpdatedPermissionEnum;
import app.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import raven.toast.Notifications;

/**
 *
 * @author begoingto
 */
public class MenuData {

    private static String table = "menus";

    public static List<Menu> list() throws SQLException {
        String query = "SELECT * FROM " + table + " ORDER BY ID ASC;";
        List<Menu> data = new ArrayList<>();
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Integer id = Integer.valueOf(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Menu item = new Menu(id, name, description);
            data.add(item);
        }
        conn.close();
        return data;
    }

    public static List<Integer> userPermissions(int userId) throws SQLException {
        String query = "SELECT p.menu_id FROM customer as c "
                + "JOIN user_permissions as p on c.id=p.customer_id WHERE c.id=? AND p.status=TRUE;";
        List<Integer> data = new ArrayList<>();
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Integer id = Integer.valueOf(resultSet.getString("menu_id"));
            data.add(id);
        }
        conn.close();
        return data;
    }


    @AllArgsConstructor
    public class UpdatingPermission {

        private final Connection conn;
        private final String tableName;

        public UpdatingPermission() {
            this.conn = ConnectionDB.getConnection();
            this.tableName = "user_permissions";
            this.setAutoCommit(false);
        }

        void setAutoCommit(boolean status) {
            try {
                conn.setAutoCommit(status);
                System.out.println("setAutoCommit:" + status);
            } catch (SQLException ex) {
                Logger.getLogger(MenuData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void commitData() throws SQLException {
            conn.commit();
        }

        public void rollbackData() throws SQLException {
            conn.rollback();
        }

        public void setAutCommitTrue() {
            this.setAutoCommit(true);
        }

        public void closeConnection() {
            ConnectionDB.closeConnection();
        }

        public void onUpdatePermission(User user, Integer menuId, Boolean checked) {
            System.out.println("AddOrUp: " + user.getUsername());
            onUpsertPermission(user.getId(), menuId, checked);
        }

        private void onUpsertPermission(int userId, int menuId, Boolean checked) {
            String sql = "SELECT upsert_user_menu(?, ?, ?);";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                pstmt.setInt(2, menuId);
                pstmt.setBoolean(3, checked);
                ResultSet rs = pstmt.executeQuery();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Updated permission");
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 5000, ex.getMessage());
                Logger.getLogger(MenuData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private Boolean existedPermission(int userId, int menuId) {
            String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE customer_id = ? AND menu_id=?;";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userId);
                pstmt.setInt(2, menuId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 5000, ex.getMessage());
                Logger.getLogger(MenuData.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        private void onUpdateMenuIdValue(int userId, int menuId, Boolean checked) {
            String sql = "UPDATE " + tableName + " SET status=? WHERE customer_id = ? AND menu_id=?;";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setBoolean(1, checked);
                pstmt.setInt(2, userId);
                pstmt.setInt(3, menuId);
                int rowsAffected = pstmt.executeUpdate();
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, 5000, ex.getMessage());
                Logger.getLogger(MenuData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        private void onAddPermission(int userId, int menuId, Boolean checked) {
            String sql = "INSERT INTO " + tableName + "(customer_id, menu_id) VALUES(?, ?);";
        }
    }
}
