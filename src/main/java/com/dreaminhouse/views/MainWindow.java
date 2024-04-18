package com.dreaminhouse.views;

import javax.swing.*;

import com.dreaminhouse.views.session.Landing;

import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        // Set Behaviour
        super("DreamInHouse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(Constants.MINIMUM_SIZE);
        setLocationRelativeTo(null);
        setResizable(true);

        // Layout
        setLayout(new CardLayout());

        // Background Color
        setBackground(Constants.BACKGROUND_COLOR);

        // Components
        add(new Landing());

        // Set visibility
        setVisible(true);
    }
}
