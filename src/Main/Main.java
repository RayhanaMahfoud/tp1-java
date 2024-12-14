package Main;

import Controller.EmployeeController;
import View.EmployeeView;

public class Main {
    public static void main(String[] args) {
        // Création de la vue de l'application
        EmployeeView view = new EmployeeView();
        // Création du contrôleur en passant la vue en paramètre
        new EmployeeController(view);
        // Rendre la vue visible
        view.setVisible(true);
    }
}
