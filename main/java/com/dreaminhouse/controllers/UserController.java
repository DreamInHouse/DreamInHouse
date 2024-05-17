package com.dreaminhouse.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.dreaminhouse.models.User;
import com.dreaminhouse.storage.UserStorage;

/**
 * UserController
 */
public class UserController {
    /* Get an ArrayList of all Users */
    public ArrayList<User> getAllUsers() {
        return UserStorage.getAllUsers();
    }

    /* Get a specific User by its id from internalStorage */
    public User getUserById(int id) {
        List<User> users = UserStorage.applyFilter(u -> u.getUserId() == id);
        return (users.size() > 0)? users.get(0): null;
    }

    /* Add a specific User by its id to internalStorage */
    public void setUserById(User user) {
        UserStorage.persist(user);
    }

    public User getUserByUsername(String username) {
        // for (User tmp_user: UserStorage.getAllUsers()) {
        //     System.out.format("\u001b[35mId: %d | User: %s\u001b[00m\n", tmp_user.getUserId(), tmp_user.getUserName());
        // }
        List<User> users = UserStorage.applyFilter(u -> u.getUserName().equals(username));
        User result = (users.size() > 0)? users.get(0): null;
        // System.out.format("Query by Username: %s\n", (result != null)? result.getFullName(): "None");
        return result;
    }

    public User createUser(User user) {
        int id = UserStorage.generateId();
        System.out.format("\u001b[36mGenerated Id: %d\u001b[00m\n", id);
        user.setUserId(id);
        UserStorage.persist(user);
        return user;
    }

    // public User createUser(String name) {
    //     int id = UserStorage.generateId();
    //     User user = new User();
    //     user.setUserId(id);
    //     user.setUserName(name);
    //     if (getUserById(id) == null) {
    //         setUserById(user);
    //     }
    //     UserStorage.persist(user);
    //     return user;
    // }

    public void updateUser(User user) {
        UserStorage.persist(user);
    }

    public void prettyPrint(User user) {
        System.out.format(
            "User(Id: %d | Username: %s | Name: %s, %s: | Password: %s)\n", 
            user.getUserId(),
            user.getUserName(),
            String.join(" ", user.getFamilyNames()).toUpperCase(),
            user.getFirstName(),
            user.getUserPassword().toString()
        );
    }
}
