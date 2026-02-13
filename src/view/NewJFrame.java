/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AeroportDAOController;
import controller.VolDAOController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aeroport;
import model.Vol;
import view.AddAeroportUI;
import controller.EscaleDAOController;
import java.awt.Color;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import model.Escale;



/**
 *
 * @author CHAWKI
 */
public class NewJFrame extends javax.swing.JFrame {
    private VolDAOController volDAO = new VolDAOController();
private AeroportDAOController aeroportDAO = new AeroportDAOController();
private EscaleDAOController escaleDAO = new EscaleDAOController();

private javax.swing.table.TableRowSorter<javax.swing.table.TableModel> volSorter;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
     initComponents();
    loadAeroports();
    loadVols();

    // Placeholder pour la recherche de vol
    txtSearchVol.setText("Id ou nom aéroport départ");
    txtSearchVol.setForeground(Color.GRAY);

    txtSearchVol.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (txtSearchVol.getText().equals("Id ou nom aéroport départ")) {
                txtSearchVol.setText("");
                txtSearchVol.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (txtSearchVol.getText().trim().isEmpty()) {
                txtSearchVol.setText("Id ou nom aéroport départ");
                txtSearchVol.setForeground(Color.GRAY);
            }
        }
    });
    loadAeroports();
    loadVols(); 
    // important pour que le modèle soit rempli

    // --- initialisation du filtre sur jTableVol ---
    volSorter = new javax.swing.table.TableRowSorter<>(jTableVol.getModel());
    jTableVol.setRowSorter(volSorter);

    txtSearchVol.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filterVols(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filterVols(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filterVols(); }
        }
    );
    }

// méthode pour remplir le tableau des vols
private void loadVols() {

    DefaultTableModel model = (DefaultTableModel) jTableVol.getModel();
    model.setRowCount(0);

    ArrayList<Vol> vols = volDAO.getAll();
    if (vols != null) {
        for (Vol v : vols) {
            System.out.println("Vol id=" + v.getId()
                    + " dep=" + (v.getAeroportDepart() != null ? v.getAeroportDepart().getNom() : "null")
                    + " arr=" + (v.getAeroportArrivee() != null ? v.getAeroportArrivee().getNom() : "null"));

            String nomDep = v.getAeroportDepart() != null ? v.getAeroportDepart().getNom() : "";
            String nomArr = v.getAeroportArrivee() != null ? v.getAeroportArrivee().getNom() : "";

            model.addRow(new Object[] {
                v.getId(),
                nomDep,
                nomArr,
                v.getDateDepart(),
                v.getHeureDepart(),
                v.getDateArrivee(),
                v.getHeureArrivee(),
                v.isReservable() ? "Oui" : "Non"   // colonne Réservable
            });
        }
    }
}



private void filterVols() {
    String text = txtSearchVol.getText().trim();

    if (text.isEmpty() || text.equals("Id ou nom aéroport départ")) {
        volSorter.setRowFilter(null);
        return;
    }

    // Si l'utilisateur tape un nombre: filtrer par id exact
    if (text.matches("\\d+")) {
        int id = Integer.parseInt(text);
        volSorter.setRowFilter(new javax.swing.RowFilter<javax.swing.table.TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends javax.swing.table.TableModel, ? extends Integer> entry) {
                Object val = entry.getValue(0); // colonne id
                return val != null && val.toString().equals(String.valueOf(id));
            }
        });
    } else {
        // Sinon, filtrer par aéroport départ (colonne 1), insensible à la casse
        String pattern = java.util.regex.Pattern.quote(text);
        volSorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + pattern, 1));
    }
}









private void loadAeroports() {
    DefaultTableModel model = (DefaultTableModel) jTableAeroport.getModel();
    model.setRowCount(0); // vider le tableau

    ArrayList<Aeroport> liste = aeroportDAO.getAll();
    if (liste != null) {
        for (Aeroport a : liste) {
            model.addRow(new Object[]{
                a.getId(),
                a.getNom(),
                a.getPays()
            });
        }
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpanelMain = new java.awt.Panel();
        JpanelHeader = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        JpanelFooter = new java.awt.Panel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelContents = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAeroport = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonRefersh = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jPanelvols = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonVolAdd = new javax.swing.JButton();
        jButtonVolEdit = new javax.swing.JButton();
        jButtonVolDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVol = new javax.swing.JTable();
        jButtonVolRefresh = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEscale = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearchVol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JpanelHeader.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flight Managment System");

        javax.swing.GroupLayout JpanelHeaderLayout = new javax.swing.GroupLayout(JpanelHeader);
        JpanelHeader.setLayout(JpanelHeaderLayout);
        JpanelHeaderLayout.setHorizontalGroup(
            JpanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JpanelHeaderLayout.setVerticalGroup(
            JpanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        JpanelFooter.setBackground(new java.awt.Color(242, 242, 242));
        JpanelFooter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setName("cxcxcxcx"); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTableAeroport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nom", "Pays"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAeroport);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-50.png"))); // NOI18N
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-50.png"))); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRefersh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-50.png"))); // NOI18N
        jButtonRefersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefershActionPerformed(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-50.png"))); // NOI18N
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContentsLayout = new javax.swing.GroupLayout(jPanelContents);
        jPanelContents.setLayout(jPanelContentsLayout);
        jPanelContentsLayout.setHorizontalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelContentsLayout.createSequentialGroup()
                        .addComponent(jButtonRefersh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanelContentsLayout.setVerticalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRefersh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 592, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(756, 756, 756))
                    .addGroup(jPanelContentsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Aeroport", jPanelContents);

        jPanelvols.setLayout(new java.awt.BorderLayout());

        jButtonVolAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-50.png"))); // NOI18N
        jButtonVolAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolAddActionPerformed(evt);
            }
        });

        jButtonVolEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-50.png"))); // NOI18N
        jButtonVolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolEditActionPerformed(evt);
            }
        });

        jButtonVolDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-50.png"))); // NOI18N
        jButtonVolDelete.setText(" ");
        jButtonVolDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolDeleteActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVolMouseClicked(evt);
            }
        });

        jTableVol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Aéroport départ  ", "Aéroport arrivée  ", "Date départ", "Heure départ", "Date arrivée", "Heure arrivée", "Réservable"
            }
        ));
        jTableVol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVolMouseClicked1(evt);
            }
        });
        jScrollPane2.setViewportView(jTableVol);

        jButtonVolRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-50.png"))); // NOI18N
        jButtonVolRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolRefreshActionPerformed(evt);
            }
        });

        jTableEscale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Ordre", "Aéroport", "Heure arrivée", "Heure départ"
            }
        ));
        jScrollPane3.setViewportView(jTableEscale);
        jTableEscale.getAccessibleContext().setAccessibleName("");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-50.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-50.png"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-50.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-50.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Escale", jPanel4);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText(" Recherche vol");

        txtSearchVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchVolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVolRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVolAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVolDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchVol, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonVolDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVolAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVolEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVolRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearchVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        jPanelvols.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Vols&Escale", jPanelvols);

        javax.swing.GroupLayout JpanelFooterLayout = new javax.swing.GroupLayout(JpanelFooter);
        JpanelFooter.setLayout(JpanelFooterLayout);
        JpanelFooterLayout.setHorizontalGroup(
            JpanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        JpanelFooterLayout.setVerticalGroup(
            JpanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout JpanelMainLayout = new javax.swing.GroupLayout(JpanelMain);
        JpanelMain.setLayout(JpanelMainLayout);
        JpanelMainLayout.setHorizontalGroup(
            JpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JpanelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JpanelMainLayout.setVerticalGroup(
            JpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(JpanelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchVolActionPerformed


    
    }//GEN-LAST:event_txtSearchVolActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTableVolMouseClicked(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = jTableEscale.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionnez une escale.");
            return;
        }

        int idEscale = Integer.parseInt(jTableEscale.getValueAt(row, 0).toString());

        int c = JOptionPane.showConfirmDialog(this,
            "Supprimer cette escale ?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION);
        if (c != JOptionPane.YES_OPTION) return;

        escaleDAO.delete(idEscale);
        jTableVolMouseClicked(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTableVol.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionnez un vol d'abord.");
            return;
        }

        int idVol = Integer.parseInt(jTableVol.getValueAt(row, 0).toString());
        Vol v = volDAO.findById(idVol);

        new AddEscaleUI(v).setVisible(true);   // ta fenêtre d’ajout
        jTableVolMouseClicked(null);  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonVolRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolRefreshActionPerformed
        loadVols();      // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolRefreshActionPerformed

    private void jTableVolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVolMouseClicked
        int row = jTableVol.getSelectedRow();
        if (row == -1) return;

        Object val = jTableVol.getValueAt(row, 0);   // id du vol colonne 0
        int idVol = Integer.parseInt(val.toString());  // lecture sécurisée [web:348][web:371]

        DefaultTableModel model = (DefaultTableModel) jTableEscale.getModel();
        model.setRowCount(0);

        java.util.List<Escale> escales = escaleDAO.getAllByVolId(idVol);
if (escales != null) {
    for (Escale e : escales) {
        String nomAero = e.getAeroport() != null ? e.getAeroport().getNom() : "";
        model.addRow(new Object[] {
            e.getId(),
            e.getOrdre(),
            nomAero,
            e.getHeureArrivee(),
            e.getHeureDepart()
        });
    }
}
      // TODO add your handling code here:
    }//GEN-LAST:event_jTableVolMouseClicked

    private void jTableVolMouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVolMouseClicked1
        int row = jTableVol.getSelectedRow();
        if (row == -1) return;

        Object val = jTableVol.getValueAt(row, 0);   // id du vol colonne 0
        int idVol = Integer.parseInt(val.toString());  // lecture sécurisée [web:348][web:371]

        DefaultTableModel model = (DefaultTableModel) jTableEscale.getModel();
        model.setRowCount(0);

        java.util.List<Escale> escales = escaleDAO.getAllByVolId(idVol);
        if (escales != null) {
            for (Escale e : escales) {
                String nomAero = e.getAeroport() != null ? e.getAeroport().getNom() : "";
                model.addRow(new Object[] {
                    e.getId(),
                    e.getOrdre(),
                    nomAero,
                    e.getHeureArrivee(),
                    e.getHeureDepart()
                });  // ajout de lignes via DefaultTableModel.addRow [web:372][web:383]
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jTableVolMouseClicked1

    private void jButtonVolDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolDeleteActionPerformed

        int row = jTableVol.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionne un Vol d'abord.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Tu veux vraiment supprimer cette Vol ?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // l'utilisateur a cliqué sur NON
        }

        int id = (int) jTableVol.getValueAt(row, 0);
        volDAO.delete(id);    // ta méthode DAO
        loadVols();

        JOptionPane.showMessageDialog(this, "Vol supprimé avec succès.");        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolDeleteActionPerformed

    private void jButtonVolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolEditActionPerformed
        int row = jTableVol.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionnez un vol.");
            return;
        }

        Object value = jTableVol.getValueAt(row, 0);  // colonne 0 = id
        int id;

        if (value instanceof Integer) {
            id = (Integer) value;
        } else {
            id = Integer.parseInt(value.toString());
        }

        EditVolUI ui = new EditVolUI(id);
        ui.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolEditActionPerformed

    private void jButtonVolAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolAddActionPerformed
        AddVolUI f = new AddVolUI();
        f.setVisible(true);   // l’utilisateur remplit et clique Save
        loadVols();           // après la fermeture, on recharge le tableau des vols
    }//GEN-LAST:event_jButtonVolAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed

        try{
            int selectedRow = jTableAeroport.getSelectedRow();
            if (selectedRow == -1 ){
                JOptionPane.showMessageDialog(null, "Error ! Select Row Plz!", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Integer id = (int)  jTableAeroport.getValueAt(selectedRow, 0) ;

            int p = JOptionPane.showConfirmDialog(null, "Do u Really want to edit user with Id: " + id, "Confirmation required !", JOptionPane.YES_NO_OPTION);

            if (p!=1){

                new EditAeroportUI(id).setVisible(true);

            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Delete!", "Error Message", JOptionPane.ERROR_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRefershActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefershActionPerformed

        loadAeroports();
    }//GEN-LAST:event_jButtonRefershActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        AddAeroportUI f = new AddAeroportUI();
        f.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
 int row = jTableAeroport.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Sélectionne un aéroport d'abord.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Tu veux vraiment supprimer cet aéroport ?",
        "Confirmation",
        JOptionPane.YES_NO_OPTION
    );
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    int id = (int) jTableAeroport.getValueAt(row, 0);

    // 1) on tente la suppression (le DAO montre un message si FK)
    aeroportDAO.delete(id);

    // 2) on recharge la liste
    loadAeroports();

    // 3) on vérifie si l'aéroport existe encore dans la table
    boolean encoreLa = false;
    for (int i = 0; i < jTableAeroport.getRowCount(); i++) {
        if ((int) jTableAeroport.getValueAt(i, 0) == id) {
            encoreLa = true;
            break;
        }
    }

    // 4) message de succès UNIQUEMENT s'il a vraiment disparu
    if (!encoreLa) {
        JOptionPane.showMessageDialog(this, "Aéroport supprimé avec succès.");
    }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new NewJFrame().setVisible(true); // ta fenêtre principale
            new AddVolUI().setVisible(true);

        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel JpanelFooter;
    private java.awt.Panel JpanelHeader;
    private java.awt.Panel JpanelMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRefersh;
    private javax.swing.JButton jButtonVolAdd;
    private javax.swing.JButton jButtonVolDelete;
    private javax.swing.JButton jButtonVolEdit;
    private javax.swing.JButton jButtonVolRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelContents;
    private javax.swing.JPanel jPanelvols;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableAeroport;
    private javax.swing.JTable jTableEscale;
    private javax.swing.JTable jTableVol;
    private javax.swing.JTextField txtSearchVol;
    // End of variables declaration//GEN-END:variables
}
