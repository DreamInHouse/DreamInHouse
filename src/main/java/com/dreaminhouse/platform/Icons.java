package com.dreaminhouse.platform;

import javax.swing.ImageIcon;

/**
 * Icons
 */
public class Icons {
    public static ImageIcon getIcon(String iconName) {
        return new ImageIcon(Icons.class.getResource("/icons/" + iconName + ".png"));
    }
}
