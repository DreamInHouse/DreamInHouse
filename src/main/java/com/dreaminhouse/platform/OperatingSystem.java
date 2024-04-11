package com.dreaminhouse.platform;

/**
 * OperatingSystem
 */
public class OperatingSystem {
    private String operatingSystemName;

    public enum FontRenderingOptions {
        SYSTEM,
        ON,
        OFF
    }

    public OperatingSystem() {
        this.operatingSystemName = System.getProperty("os.name");
        if (operatingSystemName.equals("Linux")) {
            System.out.println("Setting Linux Defaults");
            setLinuxDefaults();
        }
    }

    public void setLinuxDefaults() {
        setFontRendering(FontRenderingOptions.ON);
    }

    public void setFontRendering(FontRenderingOptions option) {
        System.setProperty("awt.useSystemAAFontSettings", option.toString().toLowerCase());
    }
}
