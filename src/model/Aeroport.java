package model;

public class Aeroport {

    private int id;
    public String nom;
    private String pays;

    public Aeroport() {
    }

    public Aeroport(int id, String nom, String pays) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
    }

    public Aeroport(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    @Override
    public String toString() {
        return "Aeroport{" + "id=" + id + ", nom=" + nom + ", pays=" + pays + '}';
    }   
}
