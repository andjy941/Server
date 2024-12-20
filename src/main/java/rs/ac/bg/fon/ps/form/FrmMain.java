/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.form;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import rs.ac.bg.fon.ps.form.component.table.UserTableModel;
import rs.ac.bg.fon.ps.server.Server;

/**
 * Glavna forma koja se prva pokrece pri pokretanju serverske aplikacije
 * nasledjuje JFrame
 * moze da startuje i stopira server
 * 
 * 
 * @author andjelalaus
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * paramtera klase server koja se zove server
     */
    private Server server;

    /**
    * Konstruktor klase FrmMain.
    * Inicijalizuje komponente prozora, postavlja prošireno stanje prozora na maksimizirano,
    * onemogućava dugme btnStop, postavlja status servera na isključen i boju teksta na crvenu.
    */
    public FrmMain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        btnStop.setEnabled(false);
        serverStatus.setText("Server is turn off. ");
        serverStatus.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverStatus = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jmbMain = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serverStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serverStatus.setText(" ");

        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Server");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        jmServer.setText("Server");
        jmServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmServerActionPerformed(evt);
            }
        });

        jMenuItem1.setText(" Active users");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmServer.add(jMenuItem1);

        jmbMain.add(jmServer);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(serverStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(serverStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Metoda koja se poziva kada se pritisne dugme btnStart.
    * Pokreće server ako server nije već pokrenut.
    * Ažurira stanje dugmica i prikazuje status servera da je on
    *
    * @param evt događaj akcije
    * @throws IOException u slučaju greške prilikom pokretanja servera
    */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (server == null || !server.isAlive()) {
            try {
                server = new Server();
                server.start();
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                serverStatus.setText("Server is turn on");
                serverStatus.setForeground(Color.GREEN);
            } catch (IOException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnStartActionPerformed

    /**
    * Metoda koja se poziva kada se pritisne dugme btnStop.
    * Zaustavlja server ako postoji aktivni server socket.
    * Ažurira stanje dugmica i prikazuje status servera da je off
    *
    * @param evt događaj akcije
    * @throws IOException u slučaju greške prilikom zatvaranja server socket-a
    */
    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (server.getServerSocket() != null) {
            try {
                server.getServerSocket().close();
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
                serverStatus.setText("Server is turn off. ");
                serverStatus.setForeground(Color.red);
                System.exit(1);
            } catch (IOException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnStopActionPerformed

    /**
    * Metoda koja se poziva kada se izabere opcija jmServer.
    * Implementacija ove metode se može dodati za obrađivanje događaja klika na tu opciju.
    *
    * @param evt događaj akcije
    */
    private void jmServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmServerActionPerformed
        
    }//GEN-LAST:event_jmServerActionPerformed

    /**
    * Metoda koja se poziva kada se izabere opcija jMenuItem1.
    * Otvora dijalog FrmActiveUsers za prikaz aktivnih korisnika servera.
    *
    * @param evt događaj akcije
    */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       new FrmActiveUsers(this, rootPaneCheckingEnabled, server.getActiveUsers()).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JLabel serverStatus;
    // End of variables declaration//GEN-END:variables

}
