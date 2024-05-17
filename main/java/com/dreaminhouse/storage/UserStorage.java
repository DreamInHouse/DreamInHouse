package com.dreaminhouse.storage;

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import com.dreaminhouse.models.User;

public class UserStorage {
    /* Where 'Users' will be stored. */
    private static ArrayList<User> storedUsers = new ArrayList<>();
    /* The id generator marker. */
    protected static Integer lastGeneratedId = 0;

    // Return the entire internal storage
    public static ArrayList<User> getAllUsers() {
        return storedUsers;
    }

    // Apply a predicate filter to the internal storage.
    public static List<User> applyFilter(Predicate<? super User> filter) {
        return storedUsers.parallelStream().filter(filter).toList();
    }

    // Generate a new 'Id'.
    public static Integer generateId() {
        /* Return the id and increment it. */
        UserStorage.lastGeneratedId += 1;
        return lastGeneratedId;
    }

    // Get the last generated id
    public static Integer getLastGeneratedId() {
        return lastGeneratedId;
    }

    // Add user to the internal storage.
    public static void persist(User user) {
        storedUsers.add(user);
        // if (applyFilter(f -> f.getUserId() == user.getUserId()) == null) {
        //     storedUsers.add(user);
        // }
    }

    // Delete user from the internal storage.
    public static void delete(User user) {
        if (applyFilter(f -> f.getUserId() == user.getUserId()) != null) {
            storedUsers.remove(user);
        }
    }
}
