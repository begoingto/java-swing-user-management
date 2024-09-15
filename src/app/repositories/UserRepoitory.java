/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repositories;

import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.models.User;
import app.services.MainService;
import app.services.UserService;

/**
 *
 * @author begoingtodev
 */
public class UserRepoitory extends MainService<User> implements UserService{

    public UserRepoitory() {
        super("user", User.class);
        super.LoadData();
    }
    
    
    @Override
    public User addUser(User user) {
        
        return user;
    }

    @Override
    public void updateUser(Integer index,User user) {
        List<User> users = new ArrayList<>(){{
            addAll(items);
        }};
        users.set(index,user);
        super.writeItemsToJson(users);
    }

    @Override
    public void deleteUser(User user) {
        List<User> users = new ArrayList<>(){{
            addAll(items);
        }};
        users.remove(user);
        super.writeItemsToJson(users);
    }

    @Override
    public User getByUuid(UUID uuid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getAll() {
        try {
            Type userListType = new TypeToken<List<User>>() {}.getType();
            List<User> userList = gson.fromJson(new FileReader(path+"/data/user.json"), userListType);
            return userList;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserRepoitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
