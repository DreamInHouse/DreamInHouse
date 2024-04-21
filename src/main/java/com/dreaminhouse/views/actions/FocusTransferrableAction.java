package com.dreaminhouse.views.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class FocusTransferrableAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        Component c = (Component) e.getSource();
        c.transferFocus();
    }
}
