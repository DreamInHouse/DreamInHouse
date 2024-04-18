package com.dreaminhouse.views.components;

import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dreaminhouse.views.Constants;

import net.miginfocom.swing.MigLayout;

public class InputField extends JPanel {
    private JLabel inputLabel;
    private JLabel mandatoryMarker;
    private JTextField inputField;

    public InputField(String labelText, boolean isMandatory, Font font) {
        // Layout
        setLayout(new MigLayout("", "[][]"));
        setBackground(Constants.BACKGROUND_COLOR);

        // Label
        this.inputLabel = new JLabel(labelText);
        this.inputLabel.setFont(font);
        add(this.inputLabel, "left");

        // Mandatory Marker
        this.mandatoryMarker = new JLabel("");
        this.mandatoryMarker.setForeground(Color.RED);
        if (isMandatory) {
            this.mandatoryMarker.setText("*");
        }
        this.mandatoryMarker.setFont(font);
        add(this.mandatoryMarker, "left, pushx, wrap");

        // Input
        this.inputField = new JTextField();
        this.inputField.setMargin(new Insets(2,10,2,10));
        this.inputField.setFont(font);
        add(this.inputField, "center, growx, span");
    }
}
