package com.dreaminhouse.platform;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

/**
 * Theme
 */
public class Theme {
    public Theme() {
        setLookAndFeel();
        setButtonProperties();
        setScrollbarProperties();
    }

    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException exception) {
            System.out.println("Could not load look and feel: " + exception);
        }
    }

    private void setButtonProperties() {
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
    }

    private void setScrollbarProperties() {
        UIManager.put("ScrollBar.trackArc", 999);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.trackArc", 999);
        UIManager.put("ScrollBar.thumbArc", 999);
    }
}
