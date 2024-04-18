package com.dreaminhouse.views.session;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.InputField;
import com.dreaminhouse.views.components.NavigablePanel;
import com.dreaminhouse.views.feed.UserFeed;

import net.miginfocom.swing.MigLayout;

/**
 * Landing
 */
public class Landing extends NavigablePanel {
    public static String IDENTIFIER = "Landing";
    public JLabel title;
    public InputField usernameField;
    public InputField passwordField;
    public JButton loginButton;
    public JButton forgotPasswordButton;
    public JPanel createAccountPanel;

    public Landing() {
        // Layout
        setLayout(new MigLayout(
            "center, fillx", "30%[]30%", "10%[]10%[][][][][]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Title
        this.title = new JLabel(Constants.PROJECT_NAME);
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TITLE_COLOR);
        add(title, "center, span");

        // Username Field
        this.usernameField = new InputField("Usuário:", true, Constants.TEXT_FONT);
        add(usernameField, "center, grow, span");

        this.passwordField = new InputField("Senha:", true, Constants.TEXT_FONT);
        add(passwordField, "center, grow, span");

        // Login Button
        this.loginButton = new JButton("Entrar");
        loginButton.setFont(Constants.TEXT_FONT);
        loginButton.setBackground(Constants.TITLE_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(
            (ActionEvent e) -> {
                // Clear input fields
                clearAllFields();

                // Switch panel
                switchTo(UserFeed.IDENTIFIER);
            }
        );
        add(loginButton, "center, grow, span");

        // Forgot my Password
        this.forgotPasswordButton = new JButton("Esqueceu sua Senha?");
        forgotPasswordButton.setFont(Constants.TEXT_FONT);
        forgotPasswordButton.setForeground(Constants.TITLE_COLOR);
        forgotPasswordButton.setBackground(Constants.BACKGROUND_COLOR);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.addActionListener(
            (ActionEvent e) -> {
                // Clear input fields
                clearAllFields();

                // Switch panel
                switchTo(PasswordRecovery.IDENTIFIER);
            }
        );
        add(forgotPasswordButton, "center, span");

        // Create Account
        this.createAccountPanel = new JPanel();
        createAccountPanel.setBackground(Constants.BACKGROUND_COLOR);
        JLabel createAccountLabel = new JLabel("Não tem uma conta?");
        createAccountLabel.setFont(Constants.TEXT_FONT);
        createAccountPanel.add(createAccountLabel);

        JButton createAccountButton = new JButton("Cadastre-se");
        createAccountButton.setFont(Constants.TEXT_FONT);
        createAccountButton.setForeground(Constants.TITLE_COLOR);
        createAccountButton.setBackground(Constants.BACKGROUND_COLOR);
        createAccountButton.setBorderPainted(false);
        createAccountButton.addActionListener(
            (ActionEvent e) -> {
                // Clear input fields
                clearAllFields();

                // Switch panel
                switchTo(AccountCreation.IDENTIFIER);
            }
        );

        createAccountPanel.add(createAccountButton);

        add(createAccountPanel, "center, span");
    }

    private void clearAllFields() {
        this.usernameField.clearInput();
        this.passwordField.clearInput();
    }
}
