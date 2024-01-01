/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.operation.stavkerezervacije;

import rs.ac.bg.fon.ps.domain.StavkaRezervacije;
import rs.ac.bg.fon.ps.operation.AbstractGenericOperation;

/**
 * Konkretna klasa za brisanje stavki rezervacija.
 * Nasleđuje apstraktnu klasu AbstractGenericOperation.
 * Implementira metode za proveru preduslova, izvrsenje i potvrdu izvrsenja transakcije.
 * @author andjelalaus
 */
public class DeleteStavka extends AbstractGenericOperation {
     /**
     * Flag koji označava da li je dodavanje stavke uspešno.Po defaultu je false.
     */
    private boolean flag = false;
    /**
     * Poruka o izuzetku vezanom za broj sedista.
     */
    private String exceptionBrojSedista;
     /**
     * Poruka o izuzetku vezanom za popust.
     */
    private String exceptionPopust;
     /**
     * Poruka o izuzetku vezanom za null koji nije koriscen u ovoj verziji koda.
     */
     private String exceptionNULL;
     /**
     * Poruka o svim izuzecima.
     */
    private String exception;
    @Override
    protected void preconditions(Object param) throws Exception {
         StavkaRezervacije t = (StavkaRezervacije)param;
      
      
        if(t.getBrojSedista()<0){
            exceptionBrojSedista = "Broj sedista ne sme biti manje od 0";
            exception = exceptionBrojSedista + "," + exception;
        }
          if(t.getBrojSedista()<0 || t.getBrojSedista()>101){
            exceptionPopust = "Popust ne sme biti manje od 0 ili veci od 100";
            exception = exceptionPopust + "," + exception;
        }
          
         if(exceptionBrojSedista!=null || exceptionPopust!=null){
            throw new Exception(exception);
        }
         
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((StavkaRezervacije)param);
    }
    /**
    * Proverava da li je brisanje stavke uspešno.
    *
    * @return true ako je brisanje stavke uspešno, false ako nije
    */
    public boolean confirm(){
        return flag;
    }
}
