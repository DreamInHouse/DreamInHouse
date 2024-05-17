package com.dreaminhouse.platform;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Fonts
 */
public class Fonts {
    private GraphicsEnvironment gEnvironment;

    public Fonts() {
        this.gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Register Custom Fonts
        registerFont("BerkshireSwash-Regular");  /* Font: Berkshire Swash */
        registerFont("Belleza-Regular");  /* Font: Belleza */
    }

    private void registerFont(String fontName) {
        try {
            this.gEnvironment.registerFont(Font.createFont(
                Font.TRUETYPE_FONT, Fonts.class.getResourceAsStream(
                    "/fonts/" + fontName.replace(" ", "\\ ") + ".ttf"
                )
            ));
        } catch (IOException | FontFormatException exception) {
            System.out.format(
                "Failed to register font '%s': %s", fontName, exception
            );
        }
    }

    public void printAllAvailableFonts() {
        for (String fontName: this.gEnvironment.getAvailableFontFamilyNames()) {
            System.out.format("Font: %s\n", fontName);
        }
    }
}
