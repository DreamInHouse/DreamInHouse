package com.dreaminhouse.views.feed;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.NavigablePanel;
import com.dreaminhouse.views.session.Landing;

import net.miginfocom.swing.MigLayout;

public class UserFeed extends NavigablePanel {
    public static String IDENTIFIER = "UserFeed";

    public UserFeed() {
        // Layout and Background Color
        setLayout(new MigLayout(
            "center, fillx", "[25%][][]", "10%[][][][][][][][]"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Test Button
        JButton testButton = new JButton("Voltar");
        testButton.setFont(new Font("Arial", Font.PLAIN, 14));
        testButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        testButton.setForeground(Color.WHITE);
        testButton.setBackground(new Color(35, 185, 250));
        testButton.setBorderPainted(false);
        testButton.setFocusPainted(false);
        testButton.addActionListener(
            (ActionEvent e) -> switchTo(Landing.IDENTIFIER)
        );
        add(testButton, "cell 1 3, center");

        // Sidebar
        JPanel sidebarPanel = new JPanel(new MigLayout("fill, flowx"));
        sidebarPanel.setBackground(new Color(25, 27, 28));
        sidebarPanel.setBorder(new EmptyBorder(50, 10, 50, 10));
        addSidebarButton(sidebarPanel, "Home");
        addSidebarButton(sidebarPanel, "Chat");
        addSidebarButton(sidebarPanel, "Perfil");
        addSidebarButton(sidebarPanel, "Configurações");
        add(sidebarPanel, "cell 0 0, growy");

        // User Profile
        JPanel profilePanel = new JPanel(new MigLayout("center"));
        profilePanel.setBackground(Constants.BACKGROUND_COLOR);
        profilePanel.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        ImageIcon profileImageIcon = new ImageIcon(getClass().getResource("/images/orb.png"));
        Image scaledImage = profileImageIcon.getImage().getScaledInstance(250, -1, Image.SCALE_SMOOTH);
        profileImageIcon = new ImageIcon(scaledImage);
        JLabel profileImageLabel = new JLabel(profileImageIcon);
        profileImageLabel.setHorizontalAlignment(JLabel.CENTER);
        profilePanel.add(profileImageLabel, "center, wrap, span 2, gapbottom 10"); 
        Font labelFont = new Font("Arial", Font.BOLD, 28);
        profilePanel.add(new JLabel("Nome do Usuário"), "center, wrap, span");
        profilePanel.add(new JLabel("@nomedeusuario"), "center, wrap, span");
        profilePanel.add(new JLabel("Descrição do usuário"), "center, wrap, span");

        // Edit and Share Buttons
        JButton editProfileButton = new JButton("Editar Perfil");
        JButton shareProfileButton = new JButton("Compartilhar Perfil");
        styleButton(editProfileButton);
        styleButton(shareProfileButton);
        profilePanel.add(editProfileButton, "grow");
        profilePanel.add(shareProfileButton, "grow");
        add(profilePanel, "cell 1 0, grow");
    }

    // Auxiliar method to add sidebar buttons
    private void addSidebarButton(JPanel sidebarPanel, String text) {
        JButton button = new JButton(text);
        styleButton(button);
        sidebarPanel.add(button, "wrap, growx");
    }

    // Auxiliar method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(35, 185, 250));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }
}
