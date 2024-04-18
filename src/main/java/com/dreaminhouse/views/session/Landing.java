package com.dreaminhouse.views.session;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.InputField;

import net.miginfocom.swing.MigLayout;

/**
 * Landing
 */
public class Landing extends JPanel {
    public Landing() {
        // Layout
        setLayout(new MigLayout(
            "center, fillx", "30%[]30%", "10%[]10%[][][][][]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Title
        JLabel title = new JLabel(Constants.PROJECT_NAME);
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TITLE_COLOR);
        add(title, "center, span");

        // Username Field
        InputField usernameField = new InputField("Usuário:", true, Constants.TEXT_FONT);
        add(usernameField, "center, grow, span");

        InputField passwordField = new InputField("Senha:", true, Constants.TEXT_FONT);
        add(passwordField, "center, grow, span");

        // Login Button
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(Constants.TEXT_FONT);
        loginButton.setBackground(Constants.TITLE_COLOR);
        loginButton.setForeground(Color.WHITE);
        add(loginButton, "center, grow, span");

        // Forgot my Password
        JButton forgotPasswordButton = new JButton("Esqueceu sua Senha?");
        forgotPasswordButton.setFont(Constants.TEXT_FONT);
        forgotPasswordButton.setForeground(Constants.TITLE_COLOR);
        forgotPasswordButton.setBackground(Constants.BACKGROUND_COLOR);
        forgotPasswordButton.setBorderPainted(false);
        add(forgotPasswordButton, "center, span");

        // Create Account
        JPanel createAccountPanel = new JPanel();
        createAccountPanel.setBackground(Constants.BACKGROUND_COLOR);
        JLabel createAccountLabel = new JLabel("Não tem uma conta?");
        createAccountLabel.setFont(Constants.TEXT_FONT);
        createAccountPanel.add(createAccountLabel);

        JButton createAccountButton = new JButton("Cadastre-se");
        createAccountButton.setFont(Constants.TEXT_FONT);
        createAccountButton.setForeground(Constants.TITLE_COLOR);
        createAccountButton.setBackground(Constants.BACKGROUND_COLOR);
        createAccountButton.setBorderPainted(false);
        createAccountPanel.add(createAccountButton);

        add(createAccountPanel, "center, span");
    }
}
