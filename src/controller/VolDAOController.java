package controller;

import model.Vol;
import model.Aeroport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.MyConnection;

public class VolDAOController implements DAO<Vol, Integer> {

    public void save(Vol v) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "INSERT INTO vol (dateDepart, heureDepart, dateArrivee, heureArrivee, reservable, aeroport_depart_id, aeroport_arrivee_id) "
                    + "VALUES ('" + v.getDateDepart() + "', '"
                    + v.getHeureDepart() + "', '"
                    + v.getDateArrivee() + "', '"
                    + v.getHeureArrivee() + "', "
                    + (v.isReservable() ? 1 : 0) + ", "
                    + v.getAeroportDepart().getId() + ", "
                    + v.getAeroportArrivee().getId() + ")";
            System.out.println("INSERTION Vol Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("INSERTION Vol Failed!");
        }
    }

    public void delete(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "DELETE FROM vol WHERE id=" + id;
            System.out.println("DELETE Vol Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("DELETE Vol Failed!");
        }
    }

    public void update(Vol v, Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "UPDATE vol SET "
                    + "dateDepart='" + v.getDateDepart() + "', "
                    + "heureDepart='" + v.getHeureDepart() + "', "
                    + "dateArrivee='" + v.getDateArrivee() + "', "
                    + "heureArrivee='" + v.getHeureArrivee() + "', "
                    + "reservable=" + (v.isReservable() ? 1 : 0) + ", "
                    + "aeroport_depart_id=" + v.getAeroportDepart().getId() + ", "
                    + "aeroport_arrivee_id=" + v.getAeroportArrivee().getId()
                    + " WHERE id=" + id;
            System.out.println("UPDATE Vol Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("UPDATE Vol Failed!");
        }
    }

   public ArrayList<Vol> getAll() {
    try {
        Statement st = MyConnection.getInstance().getConnection().createStatement();

        String req =
            "SELECT v.*, " +
            "       ad.nom AS nom_aero_dep, " +
            "       aa.nom AS nom_aero_arr " +
            "FROM vol v " +
            "JOIN aeroport ad ON v.aeroport_depart_id = ad.id " +
            "JOIN aeroport aa ON v.aeroport_arrivee_id = aa.id";

        System.out.println("getAll Vol Done!");
        ArrayList<Vol> liste = new ArrayList<>();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            Vol v = new Vol();
            v.setId(rs.getInt("id"));
            v.setDateDepart(rs.getDate("dateDepart").toLocalDate());
            v.setHeureDepart(rs.getTime("heureDepart").toLocalTime());
            v.setDateArrivee(rs.getDate("dateArrivee").toLocalDate());
            v.setHeureArrivee(rs.getTime("heureArrivee").toLocalTime());
            v.setReservable(rs.getBoolean("reservable"));

            Aeroport dep = new Aeroport();
            dep.setId(rs.getInt("aeroport_depart_id"));
            dep.setNom(rs.getString("nom_aero_dep"));

            Aeroport arr = new Aeroport();
            arr.setId(rs.getInt("aeroport_arrivee_id"));
            arr.setNom(rs.getString("nom_aero_arr"));

            v.setAeroportDepart(dep);
            v.setAeroportArrivee(arr);

            liste.add(v);
        }
        return liste;
    } catch (SQLException ex) {
        Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
        System.err.println("getAll Vol Failed!");
        return null;
    }
}


    public Vol findById(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM vol WHERE id=" + id;
            System.out.println("findById Vol Done!");
            Vol v = null;
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                v = new Vol();
                v.setId(rs.getInt("id"));
                v.setDateDepart(rs.getDate("dateDepart").toLocalDate());
                v.setHeureDepart(rs.getTime("heureDepart").toLocalTime());
                v.setDateArrivee(rs.getDate("dateArrivee").toLocalDate());
                v.setHeureArrivee(rs.getTime("heureArrivee").toLocalTime());
                v.setReservable(rs.getBoolean("reservable"));
            }
            return v;
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("findById Vol Failed!");
            return null;
        }
    }
}
