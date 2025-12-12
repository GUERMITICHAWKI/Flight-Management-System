package model;

import java.time.LocalTime;

public class Escale {

    private int id;
    private LocalTime heureArrivee;
    private LocalTime heureDepart;
    private int ordre;          // pour garder l'ordre des escales
    private Vol vol;
    private Aeroport aeroport;

    public Escale() {
    }

    public Escale(int id, LocalTime heureArrivee, LocalTime heureDepart,
                  int ordre, Vol vol, Aeroport aeroport) {
        this.id = id;
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
        this.ordre = ordre;
        this.vol = vol;
        this.aeroport = aeroport;
    }

    public Escale(LocalTime heureArrivee, LocalTime heureDepart,
                  int ordre, Vol vol, Aeroport aeroport) {
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
        this.ordre = ordre;
        this.vol = vol;
        this.aeroport = aeroport;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalTime getHeureArrivee() { return heureArrivee; }
    public void setHeureArrivee(LocalTime heureArrivee) { this.heureArrivee = heureArrivee; }

    public LocalTime getHeureDepart() { return heureDepart; }
    public void setHeureDepart(LocalTime heureDepart) { this.heureDepart = heureDepart; }

    public int getOrdre() { return ordre; }
    public void setOrdre(int ordre) { this.ordre = ordre; }

    public Vol getVol() { return vol; }
    public void setVol(Vol vol) { this.vol = vol; }

    public Aeroport getAeroport() { return aeroport; }
    public void setAeroport(Aeroport aeroport) { this.aeroport = aeroport; }

    @Override
    public String toString() {
        return "Escale{" + "id=" + id +
                ", heureArrivee=" + heureArrivee +
                ", heureDepart=" + heureDepart +
                ", ordre=" + ordre + '}';
    }
}
