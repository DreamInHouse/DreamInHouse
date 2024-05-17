package com.dreaminhouse.views.components;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class NavigablePanel extends JPanel {
    public NavigablePanel() {
        super();
    }

    public void switchTo(String panelIdentifier) {
        JPanel parentPanel = (JPanel) this.getParent();
        CardLayout parentLayout = (CardLayout) parentPanel.getLayout();
        parentLayout.show(parentPanel, panelIdentifier);
    }
}
