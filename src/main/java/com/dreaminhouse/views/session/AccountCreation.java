package com.dreaminhouse.views.session;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dreaminhouse.controllers.PasswordController;
import com.dreaminhouse.controllers.UserController;
import com.dreaminhouse.models.User;
import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.InputField;
import com.dreaminhouse.views.components.NavigablePanel;
import com.dreaminhouse.views.feed.UserFeed;

import net.miginfocom.swing.MigLayout;

public class AccountCreation extends NavigablePanel {
    public static String IDENTIFIER = "AccountCreation";

    private JPanel inputFields;
    private JLabel creationWarning;
    public AccountCreation() {
        // Layout and Background Color
        setLayout(new MigLayout(
            "center, fillx", "10%[]10%", "10%[][]5%[][][]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Header
        JLabel header = new JLabel("Criar Conta");
        header.setFont(Constants.TITLE_FONT);
        // header.setFont(Constants.TEXT_FONT.deriveFont(48f));
        header.setForeground(Constants.TITLE_COLOR);
        add(header, "left, growx, span");

        // Header Separator
        JSeparator headerSeparator = new JSeparator(JSeparator.HORIZONTAL);
        headerSeparator.setForeground(Constants.TITLE_COLOR);
        headerSeparator.setMinimumSize(Constants.MINIMUM_SEPARATOR_SIZE);
        add(headerSeparator, "center, growx, span");

        // Components
        this.inputFields = new JPanel();
        this.inputFields.setLayout(new MigLayout("center, fillx", "[]"));
        this.inputFields.setBackground(Constants.BACKGROUND_COLOR);
        this.inputFields.add(new InputField("Usuário", true, false), "grow, span");
        this.inputFields.add(new InputField("Senha", true, true), "grow, split 1");
        this.inputFields.add(new InputField("Repita a Senha", true, true), "grow, wrap");
        this.inputFields.add(new InputField("Nome Completo", true, false), "grow, span");
        this.inputFields.add(new InputField("Data de Nascimento", true, false), "grow, span");
        this.inputFields.add(new InputField("E-mail de Contato", false, false), "grow, span");
        this.inputFields.add(new InputField("Telefone de Contato", false, false), "grow, span");
        this.inputFields.add(new InputField("Gênero", false, false), "grow, span");

        JScrollPane contentPanel = new JScrollPane(this.inputFields);
        contentPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.getVerticalScrollBar().setBackground(Constants.BACKGROUND_COLOR);
        contentPanel.getVerticalScrollBar().setUnitIncrement(10);
        contentPanel.setBorder(BorderFactory.createEmptyBorder());
        add(contentPanel, "center, growx, span");

        // Creation Warnings
        this.creationWarning = new JLabel("");
        this.creationWarning.setFont(Constants.TEXT_FONT);
        this.creationWarning.setForeground(Color.RED);
        add(this.creationWarning, "center, span");

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Constants.BACKGROUND_COLOR);
        buttonPanel.setLayout(new MigLayout("fill", "[][]"));

        // Create Button
        JButton createAccountButton = new JButton("Criar Conta");
        createAccountButton.setFont(Constants.TEXT_FONT);
        createAccountButton.setBackground(Constants.TITLE_COLOR);
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.addActionListener(
            (ActionEvent e) -> createAccount()
        );
        buttonPanel.add(createAccountButton, "");

        // Back Button
        JButton backButton = new JButton("Voltar");
        backButton.setFont(Constants.TEXT_FONT);
        backButton.addActionListener(
            (ActionEvent e) -> switchTo(Landing.IDENTIFIER)
        );
        buttonPanel.add(backButton, "");

        add(buttonPanel, "center, span");
    }

    private void createAccount() {
        System.out.println("Creating User");

        // Parse all input fields
        boolean valid = true;
        HashMap<String, String> responses = new HashMap<>();
        for (Component component: inputFields.getComponents()) {
            InputField componentAsField = (InputField) component;
            if (component instanceof InputField) {
                if (componentAsField.isMandatory() && componentAsField.inputIsEmpty()) {
                    valid = false;
                } else if (!componentAsField.inputIsEmpty()) {
                    responses.put(componentAsField.getLabel(), componentAsField.getInput());
                }
            }
            // System.out.format(
            //     "%s: %b = %s\n",
            //     componentAsField.getLabel(),
            //     componentAsField.inputIsEmpty() && componentAsField.isMandatory(),
            //     componentAsField.getInput()
            // );
            // System.out.println(component, componentAsField.inputIsEmpty());
        }

        System.out.println(responses);
        // If any of these input fields are invalid, set the warning flag
        System.out.format("Valid: %b\n", valid);
        if (valid) {
            this.creationWarning.setText("");
            // Create Basic User
            UserController uController = new UserController();;
            User user = new User();

            // Validate user
            String username = responses.get("Usuário");
            User foundUser = uController.getUserByUsername(username);
            if (foundUser != null) {
                this.creationWarning.setText("Nome de usuário já está em uso!");
                return;
            } else {
                System.out.format("Found user: %s\n", user.toString());
            }
            user.setUserName(username);

            // Make sure that both password matches
            String p1 = responses.get("Senha");
            String p2 = responses.get("Repita a Senha");
            System.out.format("Senhas: %s | %s\n", p1, p2);
            if (p1.equals(p2)) {
                user.setUserPassword(PasswordController.createPassword(p1));
            } else {
                this.creationWarning.setText("Falha na confirmação de senha: senhas diferentes!");
                return;
            }

            // Set name attributes
            user.setFullName(responses.get("Nome Completo"));

            // TODO: Verify Date Format and Minimum User Age

            // Persist User
            uController.createUser(user);
            uController.prettyPrint(user);

            // Change panels
            // switchTo(UserFeed.IDENTIFIER);
            clearFields();
            switchTo(AccountCreationNext.IDENTIFIER);

            // Field Validation
            // Username checking
            // } else {
            //     user = uController.createUser(username);
            //     user.setFullName(responses.get("Nome Completo"));

            //     // Persist
            //     if (valid) {
            //         uController.updateUser(user);
            //     }
            // }
        } else {
            this.creationWarning.setText("Existem campos obrigatórios vazios!");
        }
    }

    private void clearFields() {
        for (Component component: inputFields.getComponents()) {
            InputField componentAsField = (InputField) component;
            if (component instanceof InputField) {
                componentAsField.clearInput();
            }
        }
    }
}
