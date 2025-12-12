package controller;

import model.Aeroport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.MyConnection;

public class AeroportDAOController implements DAO<Aeroport, Integer> {

    public void save(Aeroport a) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "INSERT INTO aeroport (nom, pays) VALUES ('"
                    + a.getNom() + "', '" + a.getPays() + "')";
            System.out.println("INSERTION Aeroport Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("INSERTION Aeroport Failed!");
        }
    }

    public void delete(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "DELETE FROM aeroport WHERE id=" + id;
            System.out.println("DELETE Aeroport Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("DELETE Aeroport Failed!");
        }
    }

    public void update(Aeroport a, Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "UPDATE aeroport SET nom='" + a.getNom()
                    + "', pays='" + a.getPays()
                    + "' WHERE id=" + id;
            System.out.println("UPDATE Aeroport Done!");
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("UPDATE Aeroport Failed!");
        }
    }

    public ArrayList<Aeroport> getAll() {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM aeroport";
            System.out.println("getAll Aeroport Done!");
            ArrayList<Aeroport> liste = new ArrayList<>();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Aeroport a = new Aeroport(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("pays")
                );
                liste.add(a);
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("getAll Aeroport Failed!");
            return null;
        }
    }

    public Aeroport findById(Integer id) {
        try {
            Statement st = MyConnection.getInstance().getConnection().createStatement();
            String req = "SELECT * FROM aeroport WHERE id=" + id;
            System.out.println("findById Aeroport Done!");
            Aeroport a = null;
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                a = new Aeroport(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("pays")
                );
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("findById Aeroport Failed!");
            return null;
        }
    }
}
