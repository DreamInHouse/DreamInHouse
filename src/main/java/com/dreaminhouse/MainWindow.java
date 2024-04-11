package com.dreaminhouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private boolean isLoggedIn;

    public MainWindow() {
        super("DreamInHouse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);

        JLabel titleLabel = new JLabel("DreamInHouse");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 28));
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 40));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        addPlaceholder(usernameField, "Username");
        panel.add(usernameField, gbc);

        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 40));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        addPlaceholder(passwordField, "Password");
        panel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 20, 20, 20);
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(150, 40));
        loginButton.setBackground(new Color(0, 149, 246));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Helvetica", Font.BOLD, 16));
        loginButton.setBorderPainted(false);
        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                isLoggedIn = true;
                openHomeScreen();
            } else {
                JOptionPane.showMessageDialog(this, "Nome de usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(loginButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void addPlaceholder(JTextField field, String placeholder) {
        field.setForeground(new Color(180, 180, 180));
        field.setFont(field.getFont().deriveFont(Font.ITALIC));
        field.setText(placeholder);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    field.setFont(field.getFont().deriveFont(Font.PLAIN));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(180, 180, 180));
                    field.setFont(field.getFont().deriveFont(Font.ITALIC));
                }
            }
        });
    }

    private void openHomeScreen() {
        // Implementação da tela inicial
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}