package Model;

public class Employee {
    // Attributs de la classe Employee
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private double salaire;
    private Role role;
    private Poste poste;

    // Constructeur avec paramètres pour créer un nouvel employé
    public Employee(String nom, String prenom, String email, String phone, double salaire, Role role, Poste poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.salaire = salaire;
        this.role = role;
        this.poste = poste;
    }

    // Constructeur par défaut
    public Employee() {
    }

    // Getters et setters pour chaque attribut de la classe Employee
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Poste getPoste() { return poste; }
    public void setPoste(Poste poste) { this.poste = poste; }

    // Méthode setnom non utilisée, à compléter ou supprimer si inutile
    public void setnom(String nouveauNom) {
    }
}
