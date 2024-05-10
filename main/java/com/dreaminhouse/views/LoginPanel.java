package com.dreaminhouse.views;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.dreaminhouse.views.camera.CameraPanel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import net.miginfocom.swing.MigLayout;

public class LoginPanel extends JPanel {
    private JLabel showcaseLabel;
    private JTextField showcaseInput;
    private JButton exampleButton;
    private boolean exampleButtonToggle = false;
    public static float fontSize = 24f;

    public LoginPanel() {
        // Run JPanel Stuff
        super();

        // Set layout
        setLayout(new MigLayout("fillx", "10%[][]10%"));

        // "Hello World" Label
        showcaseLabel = new JLabel("Hello, world!");
        showcaseLabel.setFont(showcaseLabel.getFont().deriveFont(fontSize));
        add(showcaseLabel, "align left");

        // Text Field
        showcaseInput = new JTextField();
        showcaseInput.setFont(showcaseInput.getFont().deriveFont(fontSize));
        add(showcaseInput, "growx, align center, wrap");

        // Camera
        CameraPanel camera = new CameraPanel();
        add(camera.getPanel(), "align center, span");

        JButton captureButton = camera.getCaptureButton();
        captureButton.setFont(captureButton.getFont().deriveFont(fontSize));
        add(captureButton, "growx, align center, span");
    }
}
