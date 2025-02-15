package Controller;
import DAO.EmployeeDAOI;
import DAO.EmployeeDAOImpl;
import Model.Employee;
import Model.Poste;
import Model.Role;
import View.EmployeeView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeController {
    // Vue de l'application et DAO pour la gestion des employés
    private final EmployeeView view;
    private final EmployeeDAOI dao;

    // Constructeur de la classe EmployeeController
    public EmployeeController(EmployeeView view) {
        this.view = view;
        this.dao = new EmployeeDAOImpl();

        // Écouteur pour le bouton Ajouter
        view.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        // Écouteur pour le bouton Lister
        view.listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listEmployees();
            }
        });

        // Écouteur pour le bouton Supprimer
        view.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        // Écouteur pour le bouton Modifier
        view.modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyEmployee();
            }
        });
    }

    // Méthode pour ajouter un employé
    private void addEmployee() {
        try {
            // Récupération des données saisies dans les champs de texte de la vue
            String nom = view.nameField.getText();
            String prenom = view.surnameField.getText();
            String email = view.emailField.getText();
            String phone = view.phoneField.getText();
            double salaire = Double.parseDouble(view.salaryField.getText());
            Role role = Role.valueOf(view.roleCombo.getSelectedItem().toString().toUpperCase());
            Poste poste = Poste.valueOf(view.posteCombo.getSelectedItem().toString().toUpperCase());

            // Création d'un nouvel employé avec les données saisies
            Employee employee = new Employee(nom, prenom, email, phone, salaire, role, poste);
            // Ajout de l'employé via le DAO
            dao.add(employee);
            // Affichage d'un message de succès
            JOptionPane.showMessageDialog(view, "Employé ajouté avec succès.");
        } catch (Exception ex) {
            // Affichage d'un message d'erreur en cas de problème
            JOptionPane.showMessageDialog(view, "Erreur: " + ex.getMessage());
        }
    }

    // Méthode pour afficher la liste des employés
    private void listEmployees() {
        // Récupération de la liste des employés via le DAO
        List<Employee> employees = dao.listAll();
        // Définition des colonnes du tableau
        String[] columnNames = {"ID", "Nom", "Prénom", "Email", "Téléphone", "Salaire", "Rôle", "Poste"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Ajout des employés dans le modèle de table
        for (Employee emp : employees) {
            Object[] row = {emp.getId(), emp.getNom(), emp.getPrenom(), emp.getEmail(), emp.getPhone(), emp.getSalaire(), emp.getRole(), emp.getPoste()};
            model.addRow(row);
        }

        // Mise à jour du modèle de table dans la vue
        view.employeeTable.setModel(model);
    }

    // Méthode pour supprimer un employé
    private void deleteEmployee() {
        try {
            // Demande de l'ID de l'employé à supprimer
            int id = Integer.parseInt(JOptionPane.showInputDialog(view, "Entrez l'ID de l'employé à supprimer :"));
            // Suppression de l'employé via le DAO
            dao.delete(id);
            // Affichage d'un message de succès
            JOptionPane.showMessageDialog(view, "Employé supprimé avec succès.");
        } catch (Exception ex) {
            // Affichage d'un message d'erreur en cas de problème
            JOptionPane.showMessageDialog(view, "Erreur: " + ex.getMessage());
        }
    }

    // Méthode pour modifier un employé
    private void modifyEmployee() {
        try {
            // Vérifier si une ligne est sélectionnée dans le tableau
            int selectedRow = view.employeeTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Veuillez sélectionner un employé dans le tableau.");
                return;
            }
    
            // Récupérer l'ID de l'employé sélectionné
            int id = (int) view.employeeTable.getValueAt(selectedRow, 0);
    
            // Charger les nouvelles informations depuis les champs
            String nom = view.nameField.getText();
            String prenom = view.surnameField.getText();
            String email = view.emailField.getText();
            String phone = view.phoneField.getText();
            double salaire = Double.parseDouble(view.salaryField.getText());
            Role role = Role.valueOf(view.roleCombo.getSelectedItem().toString().toUpperCase());
            Poste poste = Poste.valueOf(view.posteCombo.getSelectedItem().toString().toUpperCase());
    
            // Créer un nouvel objet Employee avec les informations mises à jour
            Employee updatedEmployee = new Employee(nom, prenom, email, phone, salaire, role, poste);
    
            // Mettre à jour dans la base de données via le DAO
            dao.update(updatedEmployee, id);
    
            // Rafraîchir la table
            JOptionPane.showMessageDialog(view, "Employé mis à jour avec succès.");
            listEmployees();
        } catch (Exception ex) {
            // Affichage d'un message d'erreur en cas de problème
            JOptionPane.showMessageDialog(view, "Erreur: " + ex.getMessage());
        }
    }  
}
