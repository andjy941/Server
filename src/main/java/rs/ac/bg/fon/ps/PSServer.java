/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps;

import rs.ac.bg.fon.ps.form.FrmMain;
import rs.ac.bg.fon.ps.server.Server;

/**
 * Klasa koja sadrzi main metodu za pokretanje glavne severske forme i cele serverske aplikacije
 * @author andjelalaus
 */
public class PSServer {
    /**
    * Main metoda: Pokreće glavnu formu aplikacije.
    *
    * @param args argument komandne linije (nije korišćeno)
    */
    public static void main(String[] args) {
        new FrmMain().setVisible(true);
    }
}
