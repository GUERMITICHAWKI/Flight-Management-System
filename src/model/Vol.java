package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Vol {

    private int id;
    private LocalDate dateDepart;
    private LocalTime heureDepart;
    private LocalDate dateArrivee;
    private LocalTime heureArrivee;
    private boolean reservable;
    private Aeroport aeroportDepart;
    private Aeroport aeroportArrivee;
    private List<Escale> escales = new ArrayList<>();

    public Vol() {
    }

    public Vol(int id,
               LocalDate dateDepart, LocalTime heureDepart,
               LocalDate dateArrivee, LocalTime heureArrivee,
               boolean reservable,
               Aeroport aeroportDepart, Aeroport aeroportArrivee) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.dateArrivee = dateArrivee;
        this.heureArrivee = heureArrivee;
        this.reservable = reservable;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
    }

    public Vol(LocalDate dateDepart, LocalTime heureDepart,
               LocalDate dateArrivee, LocalTime heureArrivee,
               boolean reservable,
               Aeroport aeroportDepart, Aeroport aeroportArrivee) {
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.dateArrivee = dateArrivee;
        this.heureArrivee = heureArrivee;
        this.reservable = reservable;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDateDepart() { return dateDepart; }
    public void setDateDepart(LocalDate dateDepart) { this.dateDepart = dateDepart; }

    public LocalTime getHeureDepart() { return heureDepart; }
    public void setHeureDepart(LocalTime heureDepart) { this.heureDepart = heureDepart; }

    public LocalDate getDateArrivee() { return dateArrivee; }
    public void setDateArrivee(LocalDate dateArrivee) { this.dateArrivee = dateArrivee; }

    public LocalTime getHeureArrivee() { return heureArrivee; }
    public void setHeureArrivee(LocalTime heureArrivee) { this.heureArrivee = heureArrivee; }

    public boolean isReservable() { return reservable; }
    public void setReservable(boolean reservable) { this.reservable = reservable; }

    public Aeroport getAeroportDepart() { return aeroportDepart; }
    public void setAeroportDepart(Aeroport aeroportDepart) { this.aeroportDepart = aeroportDepart; }

    public Aeroport getAeroportArrivee() { return aeroportArrivee; }
    public void setAeroportArrivee(Aeroport aeroportArrivee) { this.aeroportArrivee = aeroportArrivee; }

    public List<Escale> getEscales() { return escales; }
    public void setEscales(List<Escale> escales) { this.escales = escales; }

    public void ajouterEscale(Escale e) {
        escales.add(e);
    }

    @Override
    public String toString() {
        return "Vol{" + "id=" + id +
                ", dateDepart=" + dateDepart +
                ", heureDepart=" + heureDepart +
                ", dateArrivee=" + dateArrivee +
                ", heureArrivee=" + heureArrivee +
                ", reservable=" + reservable + '}';
    }
}
