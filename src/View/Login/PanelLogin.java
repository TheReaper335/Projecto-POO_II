/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Login;

/**
 *
 * @author eciom
 */
import Model.Admin.AdminDAO;
import View.Admin.AdminView;
import Controller.AdminController;
import JanelaComum.PasswordFieldCriar;
import JanelaComum.TextFieldCriar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class PanelLogin extends JPanel implements ActionListener{
    private TextFieldCriar email;
    private PasswordFieldCriar pass;
    private JButton btLogin;
    private String perfil;
    private JLabel labelPass, labelEmail, perfilLogin, perfilIcone;
    private ViewLogin loginFrame;
    private JCheckBox mostrar;
    private char z;

    public PanelLogin(String profile, ImageIcon icone, ViewLogin lf ) {        
        labelPass = new JLabel();               // JLabel onde fica o icone do password 
        labelEmail = new JLabel();              // JLabel onde fica o icone do user
        perfilLogin = new JLabel(profile + " Login");           // JLabel onde fica quem está a fazer o login (Admin ou Doador)
        perfilIcone = new JLabel();                 //JLabel onde fica o icone de quem está a fazer o login
        btLogin = new JButton("Login");
        mostrar = new JCheckBox("Mostrar Password");            //CheckBox para ficar mostrar o Password
        mostrar.addActionListener(this);
        this.perfil = profile;
        this.loginFrame = lf;
        
        setBorder(new LineBorder(new Color(192, 192, 192)));
        setBackground(new Color(0, 0, 0,80));
	setBounds(490, 206, 420, 434);
	setLayout(null);
        
        /*Criação do Label onde fica o icone do passaword*/
        labelPass.setOpaque(true);
        labelPass.setBackground(new Color(255, 12, 12, 250));
        labelPass.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/password1.png"));
        labelPass.setBounds(20, 272, 60, 44);
        add(labelPass);
        labelPass.setHorizontalAlignment(SwingConstants.CENTER);
        labelPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        labelPass.setBorder(new LineBorder (new Color(192, 192, 192)));

        /*Criação do TextField do email para o login*/
        email = new TextFieldCriar("Email ou Username");    
        email.setBorder(new EmptyBorder (0,3,0,0));
        email.setToolTipText("Email ou Username");
        email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        email.setBounds(80, 196, 323, 44);
        email.setForeground(Color.DARK_GRAY);
        add(email);
        email.setColumns(10);
        
        /*Criação do Label onde fica o icone do user (ao lado do TextField do emal)*/
        labelEmail.setOpaque(true);
        labelEmail.setFocusable(true);
        labelEmail.setBackground(new Color(255, 12, 12, 250));
        labelEmail.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/user.png"));
        labelEmail.setBounds(20, 196, 60, 44);
        add(labelEmail);
        labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
        labelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        labelEmail.setBorder(new LineBorder (new Color(192, 192, 192)));
        
        /*Botão para efectuar o Login*/
        btLogin.setFont(new Font("Segoe UI",Font.BOLD, 16));
        btLogin.setForeground(new Color(255, 255, 255));
        btLogin.addActionListener(this);
        btLogin.setBackground(new Color(255, 12, 12, 250));
        btLogin.setBounds(20, 367, 383, 44);
        btLogin.setFocusable(false);
        btLogin.setBorderPainted(false);
        add(btLogin);
        
        /*Criação do Label onde ficará a informação de quem está a efectuar o login (Admin ou Doador)*/
        perfilLogin.setForeground(new Color(255, 255, 255));
        perfilLogin.setFont(new Font("Segoe UI", Font.BOLD, 25));
        perfilLogin.setHorizontalAlignment(SwingConstants.CENTER);
	perfilLogin.setBounds(10, 121, 420, 38);
	add(perfilLogin);
        
        /*Dependendo de que estiver a fazer o login, a imagem irá mudar*/
        perfilIcone.setIcon(icone);
        perfilIcone.setBounds(169, 28, 100, 98);
        add(perfilIcone);
        
        
        pass = new PasswordFieldCriar("Password");
        pass.setBorder(email.getBorder());
        pass.setToolTipText("Password");             //Criação do PasswordField
        pass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pass.setBounds(80, 272, 323, 44);
        z = pass.retornarEchoChar(pass);
        
        mostrar.setBounds(20, 310, 150, 44);
        mostrar.setBackground(new Color(0, 0, 0,80));
        mostrar.setForeground(new Color(255, 255, 255));
        mostrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        mostrar.setOpaque(false);
        mostrar.setFocusable(false);
        add(pass);
        add(mostrar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pass_2 = String.valueOf(pass.getPassword());
        if(e.getSource() == mostrar){
            if(mostrar.isSelected()){
                pass.setEchoChar((char)0);
            } else {
                pass.setEchoChar(z);} }
        
        if(perfil.equals("Administrador")){
        
            if(e.getSource() == btLogin){
                AdminController ad = new AdminController();
                
                boolean result = ad.verificarPassowrd(email.getText(), pass.getText());
                if(result==true){
                    AdminView am = new AdminView();
                    am.setVisible(true);
                    am.setLocationRelativeTo(null);
                    loginFrame.timer.stop();
                    loginFrame.imagetimer.stop();
                    System.out.println("Timer running "+loginFrame.timer.isRunning());
                    loginFrame.dispose();
                }else{ JOptionPane.showMessageDialog(null, "Username e/ou Senha Errada\nTente Novamente!!!!","Acesso Negado",
                        JOptionPane.ERROR_MESSAGE);}  }  }
        
        
        if(perfil.equals("Paciente")){
           loginFrame.timer.stop();
           loginFrame.imagetimer.stop();}
        
        
        if(perfil.equals("Doador")){
           loginFrame.timer.stop();
           loginFrame.imagetimer.stop();} }
    
}
