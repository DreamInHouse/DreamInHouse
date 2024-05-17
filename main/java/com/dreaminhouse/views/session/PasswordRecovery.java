package com.dreaminhouse.views.session;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.NavigablePanel;

import net.miginfocom.swing.MigLayout;

public class PasswordRecovery extends NavigablePanel {
    public static String IDENTIFIER = "PasswordRecovery";

    public PasswordRecovery() {
        // Layout and Background Color
        setLayout(new MigLayout(
            "center, fillx", "30%[]30%", "10%[]10%[][][][][]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Test Label
        JLabel testLabel = new JLabel("Recuperação de Contas");
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
