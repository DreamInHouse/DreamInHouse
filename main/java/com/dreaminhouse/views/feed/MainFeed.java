package com.dreaminhouse.views.feed;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
        JButton burgerButton = new JButton("-");
        burgerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        burgerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        burgerButton.setForeground(Color.WHITE);
        burgerButton.setBackground(new Color(35, 185, 250));
        burgerButton.setBorderPainted(false);
        burgerButton.setFocusPainted(false);
        burgerButton.addActionListener((ActionEvent e) -> toggleSidebar());
        add(burgerButton, "cell 1 0, align center");

        // Sidebar
        sidebarPanel = new JPanel(new MigLayout("fill, flowx"));
        sidebarPanel.setBackground(new Color(25, 27, 28));
        sidebarPanel.setBorder(new EmptyBorder(50, 10, 50, 10));
        addSidebarButton(sidebarPanel, "Home");
        addSidebarButton(sidebarPanel, "Chat");
        addSidebarButton(sidebarPanel, "Perfil");
        addSidebarButton(sidebarPanel, "Configurações");
        add(sidebarPanel, "cell 0 0, growy, spany 10, hidemode 3");

        // Feed Panel with Scroll
        feedPanel = new JPanel(new MigLayout("fillx, wrap 1, gapy 10", "", "[]10[]"));
        JScrollPane scrollPane = new JScrollPane(feedPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, "cell 1 1 2 8, grow");

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
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(35, 185, 250));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    // Method to add a post to the feed panel
    private void addPost(String user, String description, String date, int likes, int comments) {
        JPanel postPanel = new JPanel(new MigLayout("fillx, insets 0", "", "[][][][]"));
        postPanel.setBackground(new Color(20, 20, 20));
        postPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel userLabel = new JLabel("@" + user);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);
        postPanel.add(userLabel, "wrap, gapbottom 5");

        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setForeground(Color.WHITE);
        descriptionArea.setOpaque(false); // Make JTextArea transparent
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

        feedPanel.add(postPanel, "wrap, growx");
    }
}