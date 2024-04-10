package com.dreaminhouse.views.camera;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

/**
 * CameraPanel
 */
public class CameraPanel {
    public static String imageFormat = ImageUtils.FORMAT_JPG;
    private Webcam camera;
    private WebcamPanel panel;
    private JButton captureButton;
    private BufferedImage capturedImage;

    public CameraPanel() {
        // Webcam
        this.camera = Webcam.getDefault();
        this.camera.setViewSize(WebcamResolution.VGA.getSize());

        // Webcam Panel
        this.panel = new WebcamPanel(this.camera);
        this.panel.setFPSDisplayed(true);
        this.panel.setDisplayDebugInfo(true);
        this.panel.setMirrored(true);

        // Capture Button
        this.captureButton = new JButton("Capturar");
        this.captureButton.addActionListener(
            (ActionEvent action) -> this.capturedImage = captureImage()
        );
    }

    public Webcam getCamera() {
        return camera;
    }

    public WebcamPanel getPanel() {
        return panel;
    }

    public JButton getCaptureButton() {
        return captureButton;
    }

    public BufferedImage getCapturedImage() {
        return capturedImage;
    }

    private BufferedImage captureImage() {
        byte[] imageBytes = WebcamUtils.getImageBytes(this.camera, imageFormat);
        try {
            BufferedImage capture = ImageIO.read(new ByteArrayInputStream(imageBytes));
            System.out.format(
                "Captured Image (%dx%d)", this.capturedImage.getWidth(), this.capturedImage.getHeight()
            );
            return capture;
        } catch (IOException e) {
        }
        return null;
    }
}
