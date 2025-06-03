/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.LoginForma;
import kontroleri.LoginKontroler;

/**
 *
 * @author gazda
 */
public class Kordinator {
    private static Kordinator instanca;
    private LoginKontroler loginKontroler;
    
    private Kordinator() {
        
    }
    
    public static Kordinator getInstanca() {
        if(instanca == null) {
            instanca = new Kordinator();
        }
        return instanca;
    }

    public void otvoriLoginFormu() {
        loginKontroler = new LoginKontroler(new LoginForma());
        loginKontroler.otvoriFormu();
    }
    
        
}
 