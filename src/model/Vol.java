package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vol {

    private Integer id;
    private LocalDate dateDepart;
    private LocalTime heureDepart;
    private LocalDate dateArrivee;
    private LocalTime heureArrivee;
    private boolean reservable;

    // relations (tu pourras les utiliser plus tard)
    private Aeroport aeroportDepart;
    private Aeroport aeroportArrivee;

    public Vol() {
    }

    public Vol(Integer id, LocalDate dateDepart, LocalTime heureDepart,
               LocalDate dateArrivee, LocalTime heureArrivee,
               boolean reservable) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.dateArrivee = dateArrivee;
        this.heureArrivee = heureArrivee;
        this.reservable = reservable;
    }

    public Vol(LocalDate dateDepart, LocalTime heureDepart,
               LocalDate dateArrivee, LocalTime heureArrivee,
               boolean reservable) {
        this(null, dateDepart, heureDepart, dateArrivee, heureArrivee, reservable);
    }

    // getters / setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public boolean isReservable() {
        return reservable;
    }

    public void setReservable(boolean reservable) {
        this.reservable = reservable;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(Aeroport aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", dateDepart=" + dateDepart +
                ", heureDepart=" + heureDepart +
                ", dateArrivee=" + dateArrivee +
                ", heureArrivee=" + heureArrivee +
                ", reservable=" + reservable +
                '}';
    }
}
