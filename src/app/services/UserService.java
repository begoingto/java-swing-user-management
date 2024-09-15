/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import java.util.List;
import java.util.UUID;
import app.models.User;

/**
 *
 * @author begoingtodev
 */
public interface UserService {
    List<User> getAll();
    User addUser(User user);
    void updateUser(Integer index,User user);
    void deleteUser(User user);
    User getByUuid(UUID uuid);
}
