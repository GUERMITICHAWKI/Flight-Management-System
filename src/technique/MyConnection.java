/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FCFC
 */ 
public class MyConnection {
    private String url = "jdbc:mysql://localhost:3306/gestvol";
    private String login = "root";
    private String pwd = "";
    
    private static MyConnection instance;
    private static Connection connection;

    private MyConnection(){
        try {
            // Step 1: Chargement du pilot
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Etablissement de la connection
            connection = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection done !");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erreur au niveau de cnx SGBD");
        }        
    }
    
    public static MyConnection getInstance() {
        if(instance == null){
            instance = new MyConnection();
        }
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }
    
  
  
    
}
