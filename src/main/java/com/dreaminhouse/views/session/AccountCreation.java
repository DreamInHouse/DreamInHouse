package com.dreaminhouse.views.session;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.dreaminhouse.views.Constants;
import com.dreaminhouse.views.components.InputField;
import com.dreaminhouse.views.components.NavigablePanel;

import net.miginfocom.swing.MigLayout;

public class AccountCreation extends NavigablePanel {
    public static String IDENTIFIER = "AccountCreation";

    public AccountCreation() {
        // Layout and Background Color
        setLayout(new MigLayout(
            "center, fillx", "10%[]10%", "10%[][]5%[]10%"
        ));
        setBackground(Constants.BACKGROUND_COLOR);

        // Header
        JLabel header = new JLabel("Criar Conta");
        header.setFont(Constants.TITLE_FONT);
        // header.setFont(Constants.TEXT_FONT.deriveFont(48f));
        header.setForeground(Constants.TITLE_COLOR);
        add(header, "left, growx, split 1");

        // Test Button
        JButton testButton = new JButton("Voltar");
        testButton.setFont(Constants.TEXT_FONT);
        testButton.addActionListener(
            (ActionEvent e) -> switchTo(Landing.IDENTIFIER)
        );
        add(testButton, "right, growx, wrap");

        // Header Separator
        JSeparator headerSeparator = new JSeparator(JSeparator.HORIZONTAL);
        headerSeparator.setForeground(Constants.TITLE_COLOR);
        headerSeparator.setMinimumSize(Constants.MINIMUM_SEPARATOR_SIZE);
        add(headerSeparator, "center, growx, span");

        // Components
        JPanel inputFields = new JPanel();
        inputFields.setLayout(new MigLayout("center, fillx", "[]"));
        inputFields.setBackground(Constants.BACKGROUND_COLOR);
        inputFields.add(new InputField("Usuário", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Senha", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Repita a Senha", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Nome Completo", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Data de Nascimento", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("E-mail de Contato", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Telefone de Contato", true, Constants.TEXT_FONT), "grow, span");
        inputFields.add(new InputField("Gênero", false, Constants.TEXT_FONT), "grow, span");

        JScrollPane contentPanel = new JScrollPane(inputFields);
        contentPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.getVerticalScrollBar().setBackground(Constants.BACKGROUND_COLOR);
        contentPanel.getVerticalScrollBar().setUnitIncrement(10);
        contentPanel.setBorder(BorderFactory.createEmptyBorder());
        add(contentPanel, "center, growx, span");
    }
}
