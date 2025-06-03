/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Veterinar;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gazda
 */
public class Komunikacija {
    private Socket socket;
    private static Komunikacija instanca;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
    }

    public static Komunikacija getInstanca() {
        if(instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }
    
    public void konekcija() {
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("Server nije pokrenut");
        }
    }

    public Veterinar login(String user, String pass) {
        Veterinar v = new Veterinar();
        v.setLozinka(pass);
        v.setKorisnickoIme(user);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, v);
        
        posiljalac.posalji(v);
        
        Odgovor odg = (Odgovor) primalac.primi();
        v = (Veterinar) odg.getOdgovor();
       
        return v;
        
    }
    
    
}
