package com.dreaminhouse.views.components;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dreaminhouse.views.Constants;

import net.miginfocom.swing.MigLayout;

public class InputField extends JPanel {
    private boolean isMandatory;
    private JLabel inputLabel;
    private JLabel mandatoryMarker;
    private JTextField inputField;

    public InputField(String labelText, boolean isMandatory, boolean isPassword) {
        // Layout
        setLayout(new MigLayout("", "[][]"));
        setBackground(Constants.BACKGROUND_COLOR);

        // Label
        this.inputLabel = new JLabel(labelText);
        this.inputLabel.setFont(Constants.TEXT_FONT);
        add(this.inputLabel, "left");

        // Mandatory Marker
        this.mandatoryMarker = new JLabel("");
        this.mandatoryMarker.setForeground(Color.RED);
        if (isMandatory) {
            this.isMandatory = true;
            this.mandatoryMarker.setText("*");
        } else {
            this.isMandatory = false;
        }
        this.mandatoryMarker.setFont(Constants.TEXT_FONT);
        add(this.mandatoryMarker, "left, pushx, wrap");

        // Input
        if (isPassword) {
            JPasswordField passwordField = new JPasswordField();
            passwordField.setEchoChar('*');
            this.inputField = passwordField;
        } else {
            this.inputField = new JTextField();
        }
        this.inputField.setMargin(new Insets(2,10,2,10));
        this.inputField.setFont(Constants.TEXT_FONT);
        add(this.inputField, "center, growx, span");
    }

    public String getLabel() {
        return this.inputLabel.getText();
    }

    public String getInput() {
        return this.inputField.getText();
    }

    public void clearInput() {
        this.inputField.setText("");
    }

    public boolean inputIsEmpty() {
        return this.inputField.getText().trim().isEmpty();
    }

    public boolean isMandatory() {
        return this.isMandatory;
    }
}
