package com.dreaminhouse;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.dreaminhouse.controllers.UserController;
import com.dreaminhouse.models.User;
import com.dreaminhouse.platform.OperatingSystem;
import com.dreaminhouse.views.MainWindow;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

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

        // Install Theme
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException exception) {
            System.out.println("Failed to apply look and feel: " + exception);
        }

        // for (User user : UserController.getAllUsers()) {
        //     System.out.format("User: %s\n", user.getUserName());
        // }

        new MainWindow();
    }
}
