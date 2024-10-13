/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.data;

import app.AppForm;
import app.models.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import raven.toast.Notifications;

/**
 *
 * @author begoingto
 */
public class ImportUserTable extends TransactionDB<User> {

    public ImportUserTable(List data, String selectedTable) {
        super(data, selectedTable);
    }

    private int success = 0, fail = 0;

    @Override
    public ImportResponces<User> addDataToTable() {
        List<User> users = this.dataToObject(itemData);
        Logger.getLogger(AppForm.class.getName()).info("Starting import user ...");

        users = users.stream().map(entry -> {
            try {
                User user = UserData.addUser(entry);
                success++;
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 5000, "Import: " + entry.getUsername() + " have been successed");
                return user;
            } catch (Exception ex) {
                fail++;
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, 5000, "User: " + entry.getUsername() + " have been existed!!!");
            }

            return null;
        }).collect(Collectors.toList());
        Logger.getLogger(AppForm.class.getName()).info("End import user.");
        return ImportResponces.<User>builder()
                .data(users)
                .totalFail(fail)
                .totalSuccess(success)
                .build();
    }

    private List<User> dataToObject(List<List> data) {
        List<User> users = data.stream()
                .map(entry -> new User(
                String.valueOf(entry.get(1)),
                String.valueOf(entry.get(2)),
                String.valueOf(entry.get(3)),
                String.valueOf(entry.get(4)),
                String.valueOf(entry.get(5)),
                String.valueOf(entry.get(6)).toLowerCase().equals("true")
        )).collect(Collectors.toList());
        return users;
    }
}
