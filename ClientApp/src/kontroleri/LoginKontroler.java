/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Veterinar;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gazda
 */
public class LoginKontroler {
    private final LoginForma lf;

    public LoginKontroler(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String user = lf.getjTextField1().getText().trim();
                String pass = String.valueOf(lf.getjPasswordField1().getPassword());
                
                komunikacija.Komunikacija.getInstanca().konekcija();
                Veterinar ulogovaniVet = komunikacija.Komunikacija.getInstanca().login(user,pass);
                
                if(ulogovaniVet == null) {
                    JOptionPane.showMessageDialog(lf,"Prijava na sistem neuspesan!","GRESKA", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(lf,"Prijava na sistem uspesan!","CAR SI", JOptionPane.INFORMATION_MESSAGE);
                    lf.dispose();
                }
                
            }
        });
        
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
}
