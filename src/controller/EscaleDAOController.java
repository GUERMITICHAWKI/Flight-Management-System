package controller;

import model.Escale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.MyConnection;

public class EscaleDAOController implements DAO<Escale, Integer> {

    @Override
    public void save(Escale e) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "INSERT INTO escale (heureArrivee, heureDepart, ordre, vol_id, aeroport_id) "
        + "VALUES ('" + e.getHeureArrivee().toString() + "', '"
        + e.getHeureDepart().toString() + "', "
        + e.getOrdre() + ", "
        + e.getVol().getId() + ", "
        + e.getAeroport().getId() + ")";
            st.executeUpdate(req);
            System.out.println("INSERTION Escale Done!");
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("INSERTION Escale Failed!");
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "DELETE FROM escale WHERE id=" + id;
            st.executeUpdate(req);
            System.out.println("DELETE Escale Done!");
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("DELETE Escale Failed!");
        }
    }

    @Override
    public void update(Escale e, Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "UPDATE escale SET "
                    + "heureArrivee='" + e.getHeureArrivee() + "', "
                    + "heureDepart='" + e.getHeureDepart() + "', "
                    + "ordre=" + e.getOrdre() + ", "
                    + "vol_id=" + e.getVol().getId() + ", "
                    + "aeroport_id=" + e.getAeroport().getId()
                    + " WHERE id=" + id;
            st.executeUpdate(req);
            System.out.println("UPDATE Escale Done!");
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("UPDATE Escale Failed!");
        }
    }

    @Override
    public ArrayList<Escale> getAll() {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM escale";
            ArrayList<Escale> liste = new ArrayList<>();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Escale e = new Escale();
                e.setId(rs.getInt("id"));
               e.setHeureArrivee(rs.getTime("heureArrivee").toLocalTime());
e.setHeureDepart(rs.getTime("heureDepart").toLocalTime());
                e.setOrdre(rs.getInt("ordre"));
                // plus tard : charger vol et aéroport si besoin
                liste.add(e);
            }
            System.out.println("getAll Escale Done!");
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("getAll Escale Failed!");
            return null;
        }
    }

    @Override
    public Escale findById(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM escale WHERE id=" + id;
            Escale e = null;
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                e = new Escale();
                e.setId(rs.getInt("id"));
               e.setHeureArrivee(rs.getTime("heureArrivee").toLocalTime());
               e.setHeureDepart(rs.getTime("heureDepart").toLocalTime());
                e.setOrdre(rs.getInt("ordre"));
            }
            System.out.println("findById Escale Done!");
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("findById Escale Failed!");
            return null;
        }
    }

    public ArrayList<Escale> getAllByVolId(int idVol) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM escale WHERE vol_id = " + idVol + " ORDER BY ordre";
            ArrayList<Escale> liste = new ArrayList<>();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Escale e = new Escale();
                e.setId(rs.getInt("id"));
               e.setHeureArrivee(rs.getTime("heureArrivee").toLocalTime());
e.setHeureDepart(rs.getTime("heureDepart").toLocalTime());
                e.setOrdre(rs.getInt("ordre"));
                // plus tard : charger aéroport et vol via leurs DAO
                liste.add(e);
            }
            System.out.println("getAllByVolId Escale Done!");
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(Escale.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("getAllByVolId Escale Failed!");
            return null;
        }
    }
}
