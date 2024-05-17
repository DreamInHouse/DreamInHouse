package com.dreaminhouse.views;

import javax.swing.*;

import com.dreaminhouse.Main;
import com.dreaminhouse.views.feed.MainFeed;
import com.dreaminhouse.views.feed.UserFeed;
import com.dreaminhouse.views.session.AccountCreation;
import com.dreaminhouse.views.session.AccountCreationNext;
import com.dreaminhouse.views.session.Landing;
import com.dreaminhouse.views.session.PasswordRecovery;

import java.awt.*;

public class MainWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    public Landing landingPanel;
    public AccountCreation accountCreationPanel;
    public AccountCreationNext accountCreationNextPanel;
    public PasswordRecovery passwordRecoveryPanel;
    public UserFeed userFeedPanel;
    public MainFeed mainFeedPanel;

    public MainWindow() {
        // Set Behaviour
        super(Constants.PROJECT_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(Constants.MINIMUM_SIZE);
        setLocationRelativeTo(null);
        setResizable(true);

        // Layout
        this.contentPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.contentPanel.setLayout(this.cardLayout);

        // Background Color
        this.contentPanel.setBackground(Constants.BACKGROUND_COLOR);

        // Components
        this.landingPanel = new Landing();
        this.contentPanel.add(this.landingPanel, Landing.IDENTIFIER);

        this.accountCreationPanel = new AccountCreation();
        this.contentPanel.add(this.accountCreationPanel, AccountCreation.IDENTIFIER);

        this.accountCreationNextPanel = new AccountCreationNext();
        this.contentPanel.add(this.accountCreationNextPanel, AccountCreationNext.IDENTIFIER);

        this.passwordRecoveryPanel = new PasswordRecovery();
        this.contentPanel.add(this.passwordRecoveryPanel, PasswordRecovery.IDENTIFIER);

        this.userFeedPanel = new UserFeed();
        this.contentPanel.add(this.userFeedPanel, UserFeed.IDENTIFIER);

        this.mainFeedPanel = new MainFeed();
        this.contentPanel.add(this.mainFeedPanel, MainFeed.IDENTIFIER);

        // Set layout default visibility
        this.cardLayout.show(this.contentPanel, MainFeed.IDENTIFIER);

        // Set visibility
        add(this.contentPanel);
        setVisible(true);
    }

    private void switchView(String label) {
        this.cardLayout.show(this.contentPanel, label);
    }
}
