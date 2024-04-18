package com.dreaminhouse.views.feed;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.NavigablePanel;
import com.dreaminhouse.views.session.Landing;

import net.miginfocom.swing.MigLayout;

public class UserFeed extends NavigablePanel {
    public static String IDENTIFIER = "UserFeed";

    public UserFeed() {
        // Layout and Background Color
        setLayout(new MigLayout(
            "center, fillx", "30%[]30%", "10%[]10%[][][][][]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Test Label
        JLabel testLabel = new JLabel("Feed do Usuário");
        testLabel.setFont(Constants.TEXT_FONT);
        add(testLabel);

        // Test Button
        JButton testButton = new JButton("Voltar");
        testButton.setFont(Constants.TEXT_FONT);
        testButton.addActionListener(
            (ActionEvent e) -> switchTo(Landing.IDENTIFIER)
        );
        add(testButton, "center, grow, span");
    }
}
