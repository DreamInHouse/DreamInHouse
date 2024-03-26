package com.dreaminhouse.controllers;

import java.util.HashMap;
import java.util.ArrayList;
import com.dreaminhouse.models.User;

/**
 * UserController
 */
public class UserController {
    /* This is where 'Users' will be stored volatilely. */
    private static HashMap<Integer, User> internalStorage = new HashMap<>();
    private static int lastGeneratedId = 0;

    /* Get an ArrayList of all Users */
    public static ArrayList<User> getAllUsers() {
        if (internalStorage == null) {
            return null;
        }
        return new ArrayList<User>(internalStorage.values());
    }

    /* Get a specific User by its id from internalStorage */
    public static User getUserById(int id) {
        return internalStorage.get(id);
    }

    /* Add a specific User by its id to internalStorage */
    public static void setUserById(User user) {
        internalStorage.put(user.getUserId(), user);
    }

    public User createUser(String name) {
        int id = lastGeneratedId++;  /* Create the user using its id */
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        if (getUserById(id) == null) {
            setUserById(user);
        }
        return new User();

    }
}
