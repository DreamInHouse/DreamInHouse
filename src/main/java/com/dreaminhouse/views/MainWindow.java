package com.dreaminhouse.views;

import javax.swing.*;

import com.dreaminhouse.platform.Fonts;

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
        titleLabel.setFont(new Font("Berkshire Swash", Font.BOLD, 28)); 
        titleLabel.setForeground (new Color(51, 204, 255));
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
        JButton loginButton = new JButton("Entrar");
        loginButton.setPreferredSize(new Dimension(150, 40));
        loginButton.setBackground(new Color(51, 204, 255));
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

        gbc.gridy++;
        gbc.insets = new Insets(10, 20, 20, 20);
        JButton cadastroButton = new JButton("Não tem uma conta? Cadastre-se");
        cadastroButton.setPreferredSize(new Dimension(150, 40));
        cadastroButton.setBackground(new Color(240, 240, 240));
        cadastroButton.setForeground(new Color(51, 204, 255));
        cadastroButton.setFont(new Font("Helvetica", Font.BOLD, 16));
        cadastroButton.setBorderPainted(false);
        cadastroButton.addActionListener(
            (ActionEvent e) -> {
                setVisible(false);
                MainCadastro cadastro = new MainCadastro();
                cadastro.setVisible(true);
            }
        );
        panel.add(cadastroButton, gbc);
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
}
