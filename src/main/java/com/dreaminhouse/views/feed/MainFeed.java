package com.dreaminhouse.views.feed;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.NavigablePanel;
import com.dreaminhouse.views.session.Landing;

import net.miginfocom.swing.MigLayout;

public class MainFeed extends NavigablePanel {
    public static String IDENTIFIER = "UserFeed";
    private JPanel sidebarPanel;
    private JPanel feedPanel;

    public MainFeed() {
        // Layout and Background Color
        setLayout(new MigLayout("center, fillx", "[25%][][]", "10%[][][][][][][][]"));
        setBackground(Constants.BACKGROUND_COLOR);

        // Logo Placeholder
        JTextArea logoArea = new JTextArea("DH");
        logoArea.setFont(new Font("Arial", Font.BOLD, 35));
        logoArea.setLineWrap(true);
        logoArea.setWrapStyleWord(true);
        logoArea.setEditable(false);
        logoArea.setOpaque(false);
        logoArea.setForeground(Color.WHITE);
        add(logoArea, "cell 0 0");

        // Test Button
        JButton testButton = new JButton("Voltar");
        testButton.setFont(new Font("Arial", Font.PLAIN, 14));
        testButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        testButton.setForeground(Color.WHITE);
        testButton.setBackground(new Color(35, 185, 250));
        testButton.setBorderPainted(false);
        testButton.setFocusPainted(false);
        testButton.addActionListener((ActionEvent e) -> switchTo(Landing.IDENTIFIER));
        add(testButton, "cell 1 9, center");

        // Burger Menu Button
        JButton menuButton = new JButton("");
        menuButton.setFont(new Font("Arial", Font.PLAIN, 16));
        menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButton.setBackground(Color.BLACK);
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        menuButton.addActionListener((ActionEvent e) -> toggleSidebar());
        add(menuButton, "cell 1 0, align center");

        ImageIcon profileImageIcon4 = new ImageIcon(getClass().getResource("/icons/menu.png"));
        Image scaledImage4 = profileImageIcon4.getImage().getScaledInstance(50, -1, Image.SCALE_SMOOTH);
        profileImageIcon4 = new ImageIcon(scaledImage4);
        JLabel profileImageLabel4 = new JLabel(profileImageIcon4);
        profileImageLabel4.setHorizontalAlignment(JLabel.CENTER);
        menuButton.add(profileImageLabel4, "center, wrap, span 2, gapbottom 30");

        // Search Button
        JButton burgerButton = new JButton("");
        burgerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        burgerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        burgerButton.setBackground(Color.BLACK);
        burgerButton.setBorderPainted(false);
        burgerButton.setFocusPainted(false);

        add(burgerButton, "cell 1 0, align center");
        ImageIcon profileImageIcon3 = new ImageIcon(getClass().getResource("/icons/search.png"));
        Image scaledImage3 = profileImageIcon3.getImage().getScaledInstance(35, -1, Image.SCALE_SMOOTH);
        profileImageIcon3 = new ImageIcon(scaledImage3);
        JLabel profileImageLabel3 = new JLabel(profileImageIcon3);
        profileImageLabel3.setHorizontalAlignment(JLabel.CENTER);
        burgerButton.add(profileImageLabel3, "center, wrap, span 2, gapbottom 30");

        // User Info
        JPanel profilePanel = new JPanel(new MigLayout("center"));
        profilePanel.setBackground(Constants.BACKGROUND_COLOR);
        Font labelFont = new Font("Arial", Font.BOLD, 22);
        JLabel nameLabel = new JLabel("Usuário");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        profilePanel.add(nameLabel, "center, wrap, span");
        ImageIcon profileImageIcon = new ImageIcon(getClass().getResource("/images/orb.png"));
        Image scaledImage = profileImageIcon.getImage().getScaledInstance(50, -1, Image.SCALE_SMOOTH);
        profileImageIcon = new ImageIcon(scaledImage);
        JLabel profileImageLabel = new JLabel(profileImageIcon);
        profileImageLabel.setHorizontalAlignment(JLabel.CENTER);
        profilePanel.add(profileImageLabel, "center, wrap, span 2, gapbottom 30");

        // Sidebar
        sidebarPanel = new JPanel(new MigLayout("fill, flowx"));
        sidebarPanel.setBackground(new Color(15, 15, 15));
        sidebarPanel.setBorder(new EmptyBorder(50, 10, 50, 10));
        addSidebarButton(sidebarPanel, "Novo post");
        addSidebarButton(sidebarPanel, "Home");
        addSidebarButton(sidebarPanel, "Chat");
        addSidebarButton(sidebarPanel, "Perfil");
        addSidebarButton(sidebarPanel, "Configurações");
        sidebarPanel.setVisible(false);
        add(sidebarPanel, "cell 0 1, growy, spany 10, hidemode 3");

        // Feed Panel with Scroll
        feedPanel = new JPanel(new MigLayout("fillx, wrap 1, gapy 10", "", "[]10[]"));
        feedPanel.setBackground(Color.BLACK);
        feedPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JScrollPane scrollPane = new JScrollPane(feedPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, "cell 1 1 2");

        // Add sample posts
        addPost("User1", "Descrição da postagem 1", "10/05/2024", 20, 5);
        addPost("User2", "Descrição da postagem 2", "09/05/2024", 15, 3);
        addPost("User3", "Descrição da postagem 3", "08/05/2024", 30, 10);
        addPost("User4", "Descrição da postagem 4", "07/05/2024", 25, 8);
    }

    // Method to toggle sidebar visibility
    private void toggleSidebar() {
        sidebarPanel.setVisible(!sidebarPanel.isVisible());
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
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    // Method to add a post to the feed panel
    private void addPost(String user, String description, String date, int likes, int comments) {
        JPanel postPanel = new JPanel(new MigLayout("fillx, insets 0", "", "[][][][]"));
        postPanel.setBackground(new Color(20, 20, 20));

        JLabel userLabel = new JLabel("@" + user);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);
        postPanel.add(userLabel, "wrap, gapbottom 5");

        ImageIcon profileImageIcon = new ImageIcon(getClass().getResource("/images/post_template.png"));
        Image scaledImage = profileImageIcon.getImage().getScaledInstance(180, -1, Image.SCALE_SMOOTH);
        profileImageIcon = new ImageIcon(scaledImage);
        JLabel profileImageLabel = new JLabel(profileImageIcon);
        profileImageLabel.setHorizontalAlignment(JLabel.CENTER);
        postPanel.add(profileImageLabel, "center, wrap, span 2, gapbottom 30");

        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false);
        descriptionArea.setForeground(Color.WHITE);
        postPanel.add(descriptionArea, "wrap, gapbottom 5");

        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateLabel.setForeground(Color.WHITE);
        postPanel.add(dateLabel, "wrap, gapbottom 5");

        JLabel likesLabel = new JLabel("Likes: " + likes);
        likesLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        likesLabel.setForeground(Color.WHITE);
        postPanel.add(likesLabel);

        JLabel commentsLabel = new JLabel("Comments: " + comments);
        commentsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        commentsLabel.setForeground(Color.WHITE);
        postPanel.add(commentsLabel, "wrap");

        ImageIcon barIcon = new ImageIcon(getClass().getResource("/images/bar.png"));
        Image scaledImage2 = barIcon.getImage().getScaledInstance(150, -1, Image.SCALE_SMOOTH);
        barIcon = new ImageIcon(scaledImage2);
        JLabel profileImageLabel2 = new JLabel(barIcon);
        profileImageLabel2.setHorizontalAlignment(JLabel.CENTER);
        postPanel.add(profileImageLabel2, "center, wrap, span 2");

        feedPanel.add(postPanel, "wrap, growx");
    }
}