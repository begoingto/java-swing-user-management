/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begoingto
 */
public abstract class TransactionDB<T> {

    protected final List<List> itemData;
    private final Connection conn;
    protected final String tableName;

    public TransactionDB(List<List> data, String table) {
        this.conn = ConnectionDB.getConnection();
        itemData = data;
        tableName = table;
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

    protected abstract ImportResponces<T> addDataToTable();
}
