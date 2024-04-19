package com.dreaminhouse.views.session;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.camera.CameraPanel;
import com.dreaminhouse.views.components.NavigablePanel;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;

import net.miginfocom.swing.MigLayout;

/**
 * AccountCreationNext
 */
public class AccountCreationNext extends NavigablePanel {
    public static String IDENTIFIER = "AccountCreationNext";

    public AccountCreationNext() {
        setBackground(Constants.BACKGROUND_COLOR);
        setLayout(new MigLayout(
            "center, fillx", "10%[]10%", "10%[][]5%[][]10%"
        ));

        // Header
        JLabel header = new JLabel("Adicionar Foto de Perfil");
        header.setFont(Constants.TITLE_FONT);
        // header.setFont(Constants.TEXT_FONT.deriveFont(48f));
        header.setForeground(Constants.TITLE_COLOR);
        add(header, "left, growx, split 1");

        // Back Button
        JButton backButton = new JButton("Voltar");
        backButton.setFont(Constants.TEXT_FONT);
        backButton.addActionListener(
            (ActionEvent e) -> switchTo(Landing.IDENTIFIER)
        );
        add(backButton, "right, wrap");

        // Header Separator
        JSeparator headerSeparator = new JSeparator(JSeparator.HORIZONTAL);
        headerSeparator.setForeground(Constants.TITLE_COLOR);
        headerSeparator.setMinimumSize(Constants.MINIMUM_SEPARATOR_SIZE);
        add(headerSeparator, "center, growx, span");

        // Camera
        CameraPanel cameraPanel = new CameraPanel();
        cameraPanel.getCaptureButton().setFont(Constants.TEXT_FONT);
        cameraPanel.getCaptureButton().setBackground(Constants.TITLE_COLOR);
        cameraPanel.getCaptureButton().setForeground(Color.WHITE);
        this.add(cameraPanel.getPanel(), "center, span");
        this.add(cameraPanel.getCaptureButton(), "center, span");
    }
}
