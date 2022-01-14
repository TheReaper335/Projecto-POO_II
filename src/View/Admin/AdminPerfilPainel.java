
package View.Admin;

import Controller.AdminController;
import Model.ValueObjects.Admin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
        
public class AdminPerfilPainel  extends JPanel {
    private JPanel painel;
    private Admin a;
    private JLabel cabecalhoLabel;
    private JButton btAtualizar;
    private AdminView av;
    private AdminController ac;

    public AdminPerfilPainel(AdminView av) {
        this();
        this.av = av;
        ac = new AdminController();
        
        cabecalhoLabel.setText("Perfil Admin");
        
	btAtualizar = new JButton("Atualizar Dados");
	btAtualizar.setFocusPainted(false);
	btAtualizar.setBorder(new EmptyBorder(0, 0, 0, 0));
	btAtualizar.setForeground(new Color(255, 12, 12, 250));
	btAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btAtualizar.setBackground(Color.WHITE);
	btAtualizar.setBounds(925, 139, 161, 33);
	btAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	btAtualizar.addActionListener(e-> {
            AtualizarDadosAdmin ada = new AtualizarDadosAdmin(a,av);
            ada.setLocationRelativeTo(null);
            ada.setVisible(true);});
        
	painel.add(btAtualizar);}
    
    
    public AdminPerfilPainel() {
        ac = new AdminController();
        a = ac.getAdminInfo();
        
	setBackground(new Color(255, 255, 255));
	this.setSize(1116, 705);
	setLayout(null);
        
	painel = new JPanel();
	painel.setBackground(new Color(255, 12, 12, 250));
	painel.setBounds(10, 0, 1096, 183);
	add(painel);
	painel.setLayout(null);
        
	cabecalhoLabel = new JLabel("");
	cabecalhoLabel.setIcon(null);
	cabecalhoLabel.setBounds(10, 65, 272, 44);
	painel.add(cabecalhoLabel);
	cabecalhoLabel.setBackground(new Color(255, 12, 12, 250));
	cabecalhoLabel.setHorizontalAlignment(SwingConstants.LEFT);
	cabecalhoLabel.setForeground(Color.WHITE);
	cabecalhoLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
	cabecalhoLabel.setOpaque(true);
		
		
	JLabel fotoPerfilLabel = new JLabel();
	fotoPerfilLabel.setHorizontalAlignment(SwingConstants.CENTER);
	fotoPerfilLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	fotoPerfilLabel.setIcon(new ImageIcon(a.getPerfilFoto(200, 180)));
	fotoPerfilLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
	fotoPerfilLabel.setBounds(24, 273, 200, 180);
	add(fotoPerfilLabel);
        
		
	JLabel nomeLabel = new JLabel("Nome do Admin  :  ");
	nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	nomeLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	nomeLabel.setBounds(233, 273, 191, 48);
	add(nomeLabel);
		
	JLabel adminNome = new JLabel("  "+a.getNome());
	adminNome.setHorizontalAlignment(SwingConstants.LEFT);
	adminNome.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	adminNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
	adminNome.setBounds(423, 273, 672, 48);
	add(adminNome);
		
	JLabel biLabel = new JLabel("Nº de BI  :  ");
	biLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	biLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	biLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	biLabel.setBounds(233, 320, 191, 48);
	add(biLabel);
		
	JLabel adminBI = new JLabel("  "+a.getBi());
	adminBI.setHorizontalAlignment(SwingConstants.LEFT);
	adminBI.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	adminBI.setBorder(new LineBorder(Color.LIGHT_GRAY));
	adminBI.setBounds(423, 320, 672, 48);
	add(adminBI);
		
	JLabel contactoLabel = new JLabel("Contacto  :  ");
	contactoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	contactoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	contactoLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	contactoLabel.setBounds(233, 367, 191, 48);
	add(contactoLabel);
		
	JLabel adminContacto = new JLabel("  "+a.getContacto());
	adminContacto.setHorizontalAlignment(SwingConstants.LEFT);
	adminContacto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	adminContacto.setBorder(new LineBorder(Color.LIGHT_GRAY));
	adminContacto.setBounds(423, 367, 672, 48);
	add(adminContacto);
		
	JLabel usernameLabel = new JLabel("Email/Username  :  ");
	usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	usernameLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	usernameLabel.setBounds(233, 414, 191, 48); 
	add(usernameLabel);
		
        JLabel adminUsername = new JLabel("  "+a.getEmail());
	adminUsername.setHorizontalAlignment(SwingConstants.LEFT);
	adminUsername.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	adminUsername.setBorder(new LineBorder(Color.LIGHT_GRAY));
	adminUsername.setBounds(423, 414, 672, 48);
	add(adminUsername);
        
	
	JLabel moradaLabel = new JLabel("Morada  :  ");
	moradaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	moradaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	moradaLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	moradaLabel.setBounds(23, 461, 211, 48);
	add(moradaLabel);
		
	JLabel addresslabel = new JLabel("  "+a.getMorada() + " " + a.getBairro());
	addresslabel.setHorizontalAlignment(SwingConstants.LEFT);
	addresslabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	addresslabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
	addresslabel.setBounds(233, 461, 862, 48);
	add(addresslabel);
		
	
    }
    
    
    
}
