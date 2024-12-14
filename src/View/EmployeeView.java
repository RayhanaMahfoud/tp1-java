package View;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
    // Déclaration des composants de l'interface utilisateur
    public JTable employeeTable;
    public JButton addButton, listButton, deleteButton, modifyButton;
    public JTextField nameField, surnameField, emailField, phoneField, salaryField;
    public JComboBox<String> roleCombo, posteCombo;

    // Constructeur de la classe EmployeeView
    public EmployeeView() {
        // Paramètres de la fenêtre principale
        setTitle("Gestion des Employés");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau pour les champs de saisie avec une grille de 2 colonnes
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 lignes et 2 colonnes

        // Ajouter les labels et champs de saisie au panneau
        inputPanel.add(new JLabel("Nom:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Prénom:"));
        surnameField = new JTextField();
        inputPanel.add(surnameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Téléphone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Salaire:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        inputPanel.add(new JLabel("Rôle:"));
        roleCombo = new JComboBox<>(new String[]{"Admin", "Employe"});
        inputPanel.add(roleCombo);

        inputPanel.add(new JLabel("Poste:"));
        posteCombo = new JComboBox<>(new String[]{"INGENIEURE_ETUDE_ET_DEVELOPPEMENT", "TEAM_LEADER", "PILOTE"});
        inputPanel.add(posteCombo);

        // Ajouter le panneau de saisie à la partie nord de la fenêtre
        add(inputPanel, BorderLayout.NORTH);

        // Table pour afficher les employés
        employeeTable = new JTable();
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Ajouter");
        buttonPanel.add(addButton);
        listButton = new JButton("Afficher");
        buttonPanel.add(listButton);
        deleteButton = new JButton("Supprimer");
        buttonPanel.add(deleteButton);
        modifyButton = new JButton("Modifier");
        buttonPanel.add(modifyButton);

        // Ajouter le panneau de boutons à la partie sud de la fenêtre
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
