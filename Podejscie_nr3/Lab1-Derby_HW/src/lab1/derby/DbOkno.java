/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.derby;
import lab1.derby.DbManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import lab1.derby.DbManager;
import static lab1.derby.DbManager.QUERY;

/**
 *
 * @author student
 */
public class DbOkno extends javax.swing.JFrame {

    private boolean connect;

    /**
     * Creates new form DbOkno
     */
    public DbOkno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPole = new javax.swing.JTextArea();
        labelInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bttnDodaj = new javax.swing.JButton();
        bttnPolacz = new javax.swing.JButton();
        bttnRozlacz = new javax.swing.JButton();
        bttnWypisz = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bttnUsun = new javax.swing.JButton();
        bttnOdswiez = new javax.swing.JButton();
        bttnAktualizuj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add sculpture");

        tPole.setColumns(20);
        tPole.setRows(5);
        jScrollPane1.setViewportView(tPole);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(labelInfo))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelInfo))
        );

        bttnDodaj.setText("Dodaj");
        bttnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnDodajActionPerformed(evt);
            }
        });

        bttnPolacz.setText("Połącz");
        bttnPolacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPolaczActionPerformed(evt);
            }
        });

        bttnRozlacz.setText("Rozłącz");
        bttnRozlacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnRozlaczActionPerformed(evt);
            }
        });

        bttnWypisz.setText("Wypisz");
        bttnWypisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnWypiszActionPerformed(evt);
            }
        });

        jLabel3.setText("Baza");

        jLabel4.setText("Rzezba");

        bttnUsun.setText("Usun");
        bttnUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnUsunActionPerformed(evt);
            }
        });

        bttnOdswiez.setText("Odswiez");
        bttnOdswiez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnOdswiezActionPerformed(evt);
            }
        });

        bttnAktualizuj.setText("Aktualizuj");
        bttnAktualizuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAktualizujActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bttnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttnUsun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bttnPolacz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttnRozlacz)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bttnWypisz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttnOdswiez))
                            .addComponent(bttnAktualizuj))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnPolacz)
                    .addComponent(bttnRozlacz)
                    .addComponent(bttnWypisz)
                    .addComponent(bttnOdswiez))
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnDodaj)
                    .addComponent(bttnUsun)
                    .addComponent(bttnAktualizuj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnWypiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnWypiszActionPerformed
        // TODO add your handling code here:
        try {
            if (connect) {
                String out = DbManager.getData();
                tPole.removeAll();
                tPole.setText(out);
            } else {
                tPole.setText("Nie połączono");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bttnWypiszActionPerformed

    private void bttnRozlaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnRozlaczActionPerformed
        // TODO add your handling code here:
        try {
            connect = DbManager.Disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DbOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (connect) {
            tPole.setText("Rozłączono");
        } else {
            tPole.setText("Nie rozłączono");
        }
    }//GEN-LAST:event_bttnRozlaczActionPerformed

    private void bttnPolaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPolaczActionPerformed
        try {
            // TODO add your handling code here:
            connect = DbManager.Connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbOkno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (connect) {
            tPole.setText("Połączono");
        } else {
            tPole.setText("Nie połączono");
        }
    }//GEN-LAST:event_bttnPolaczActionPerformed

    private void bttnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnDodajActionPerformed
        // TODO add your handling code here:
        dbDodaj dd = new dbDodaj();
        dd.setVisible(true);
    }//GEN-LAST:event_bttnDodajActionPerformed

    private void bttnUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnUsunActionPerformed
        // TODO add your handling code here:
        DbUsun dd = new DbUsun();
        dd.setVisible(true);
    }//GEN-LAST:event_bttnUsunActionPerformed

    private void bttnOdswiezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnOdswiezActionPerformed
        // TODO add your handling code here:
        try {
            if (connect) {                               
                tPole.removeAll();                
                tPole.setText(DbManager.getData());            
            } else {    
                tPole.removeAll();
                tPole.setText("Nie połączono");            
            }        
        } catch (SQLException ex) {
            tPole.setText("Nie udalo sie odwiezyc");       
        }
    }//GEN-LAST:event_bttnOdswiezActionPerformed

    private void bttnAktualizujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAktualizujActionPerformed
        // TODO add your handling code here:
        dbAktualizuj dd = new dbAktualizuj();
        dd.setVisible(true);
    }//GEN-LAST:event_bttnAktualizujActionPerformed

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
            java.util.logging.Logger.getLogger(DbOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DbOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DbOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DbOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DbOkno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAktualizuj;
    private javax.swing.JButton bttnDodaj;
    private javax.swing.JButton bttnOdswiez;
    private javax.swing.JButton bttnPolacz;
    private javax.swing.JButton bttnRozlacz;
    private javax.swing.JButton bttnUsun;
    private javax.swing.JButton bttnWypisz;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JTextArea tPole;
    // End of variables declaration//GEN-END:variables

}