/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Doador;

/**
 *
 * @author eciom
 */
import View.Admin.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DoadorPainel extends JPanel implements ActionListener{
    public AdminView am;
    
    public DoadorPainel(AdminView am){
        this();
	this.am=am;}

    public DoadorPainel() {
        setName("Painel Doador");
        setBackground(new Color(255, 255, 255));
	setSize(1116, 705);
	setLayout(null);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
