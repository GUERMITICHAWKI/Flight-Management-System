package flight.managementt.system;

import view.NewJFrame;

public class FlightManagementtSystem {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);   // mets ici le nom de ta JFrame
            }
        });
    }
}
