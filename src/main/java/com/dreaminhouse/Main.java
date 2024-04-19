package com.dreaminhouse;


import java.awt.Font;

import com.dreaminhouse.controllers.UserController;
import com.dreaminhouse.platform.OperatingSystem;
import com.dreaminhouse.views.MainWindow;

import com.dreaminhouse.platform.Fonts;
import com.dreaminhouse.platform.Theme;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        // Operating System Handling
        new OperatingSystem();

        // Testing context controller
        System.out.println("\u001b[33mTesting Context Manager\u001b[00m");
        UserController uController = new UserController();
        // uController.createUser("Claudio");
        // uController.createUser("Marcelo");

        // Register Local Fonts
        new Fonts();

        // Install Theme
        new Theme();

        // for (User user : UserController.getAllUsers()) {
        //     System.out.format("User: %s\n", user.getUserName());
        // }

        new MainWindow();
    }
}
