package com.dreaminhouse.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainCadastro extends JFrame {
    private boolean isLoggedIn;

    public MainCadastro() {
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

        JLabel titleLabel = new JLabel("Criar conta");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28)); 
        titleLabel.setForeground (new Color(51, 204, 255));
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel nomeLabel = new JLabel("Nome*");
        nomeLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        nomeLabel.setForeground (Color.BLACK);
        panel.add(nomeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(300, 40));
        nomeField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(nomeField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel usernameLabel = new JLabel("Username*");
        usernameLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        usernameLabel.setForeground (Color.BLACK);
        panel.add(usernameLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 40));
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel emailLabel = new JLabel("E-mail*");
        emailLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        emailLabel.setForeground (Color.BLACK);
        panel.add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 40));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel telefoneLabel = new JLabel("Telefone*");
        telefoneLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        telefoneLabel.setForeground (Color.BLACK);
        panel.add(telefoneLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField telefoneField = new JTextField();
        telefoneField.setPreferredSize(new Dimension(300, 40));
        telefoneField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(telefoneField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel dataLabel = new JLabel("Data de nascimento*");
        dataLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        dataLabel.setForeground (Color.BLACK);
        panel.add(dataLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField dataField = new JTextField();
        dataField.setPreferredSize(new Dimension(300, 40));
        dataField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(dataField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);

        JLabel generoLabel = new JLabel("Gênero");
        generoLabel.setFont(new Font("HELVETICA", Font.BOLD, 20)); 
        generoLabel.setForeground (Color.BLACK);
        panel.add(generoLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 10, 20);
    
        JTextField generoField = new JTextField();
        generoField.setPreferredSize(new Dimension(300, 40));
        generoField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(generoField, gbc);

     add(panel);
    }
}
