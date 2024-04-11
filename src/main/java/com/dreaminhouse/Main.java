package com.dreaminhouse;

import com.dreaminhouse.controllers.UserController;
import com.dreaminhouse.models.User;
import com.dreaminhouse.views.MainWindow;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        // Testing context controller
        System.out.println("\u001b[33mTesting Context Manager\u001b[00m");
        UserController uController = new UserController();
        uController.createUser("Claudio");
        uController.createUser("Marcelo");

        for (User user : UserController.getAllUsers()) {
            System.out.format("User: %s\n", user.getUserName());
        }

        new MainWindow();
    }
}
