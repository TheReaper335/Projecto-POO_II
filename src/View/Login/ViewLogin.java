
package View.Login;

/**
 *
 * @author eciom
 */
import Controller.LoginController;
import JanelaComum.ConexaoBD;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class ViewLogin extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton btAdmin, btDoador, btPaciente;
    private PanelLogin lpAdmin,lpDoador, lpPaciente;
    private boolean admin = false, doador = false, paciente = false;
    Timer timer,imagetimer;
    private int undX = 280, undY = 140, adminX = -2300, adminY = 240, doadorX = 500, doadorY = 240;
    private int pacienteX = -900, pacienteY = 240;
    private JLabel labelUnd, labelImagem;
    private JPanel painelBotao, painelLogo;

    public ViewLogin() {
        timer = new Timer(5,this);
	imagetimer = new Timer(5000,this);
	imagetimer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1380,733);
	setLocationRelativeTo(null);
	contentPane = new JPanel();
        painelBotao = new JPanel();
        labelImagem = new JLabel();
        
	contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
	contentPane.setBackground(new Color(255, 255, 255));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        /*  Painel onde tem o nome e o logo do Banco de Sangue
        */
        painelLogo = new JPanel();                              // Painel onde ficará o logotipo
        painelLogo.setBackground(new Color(255, 12, 12, 250));
        painelLogo.setBounds(0, 26, 1364, 159);
        contentPane.add(painelLogo);
        painelLogo.setLayout(null);
        
        JLabel nome = new JLabel("Sunflower Blood Bank");           // Label do Nome do Banco de Sangue
        nome.setForeground(Color.WHITE);
	nome.setFont(new Font("Segoe UI", Font.BOLD, 30));
	nome.setHorizontalAlignment(SwingConstants.CENTER);
	nome.setBounds(340, 43, 749, 57);
	painelLogo.add(nome);
        
        lpAdmin = new PanelLogin ("Administrador", new ImageIcon            //Construtor para chamar o painel de login do Administrador
        ("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/adminlogin.png"), this);
        lpAdmin.setVisible(true);
        lpAdmin.setLocation(adminX, adminY);
        
        lpDoador = new PanelLogin("Doador", new ImageIcon
        ("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/iconeDoador.png"), this);         // Construtor para chamar o painel de login do Doador
        lpDoador.setVisible(true);
        lpDoador.setLocation(doadorX, doadorY);
        
        lpPaciente = new PanelLogin("Paciente", new ImageIcon
        ("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/iconePaciente.png"), this);
        lpPaciente.setVisible(true);
        lpPaciente.setLocation(pacienteX, pacienteY);
        
        contentPane.add(lpDoador);
        contentPane.add(lpPaciente);
        contentPane.add(lpAdmin);
        
        painelBotao = new JPanel() {
                    protected void paintComponent (Graphics g){             //   Criação do painel onde os botões para mudar quem está a fazer 
                        g.setColor (getBackground());                       // o login
                        g.fillRect(0, 0, getWidth(), getHeight());
                        super.paintComponent(g);}};
        painelBotao.setOpaque(false);
        painelBotao.setBackground(new Color(0, 0, 0, 80));
        painelBotao.setBounds(500, 189, 420, 40);
        painelBotao.setLayout(null);
        contentPane.add(painelBotao);
        
        btAdmin = new JButton("Administrador");
        btAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btAdmin.setForeground(new Color(255, 12, 12, 250));
                
                btPaciente.setForeground(Color.WHITE);
                btDoador.setForeground(Color.WHITE);               //   Botão para mudar para o painel para efectuar o login do Admin
                admin = true;                               
                doador = false;
                paciente = false;
                timer.start();}});
        
        estiloBotao(btAdmin);                                   
        btAdmin.setBounds(0, 0, 140, 35);                           
        painelBotao.add(btAdmin);
        
      
        btPaciente = new JButton("Paciente");
        btPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btPaciente.setForeground(new Color(255, 12, 12, 250));
                btAdmin.setForeground(Color.WHITE);
                btDoador.setForeground(Color.WHITE);               //   Botão para mudar para o painel para efectuar o login do Paciente
                paciente = true;                               
                doador = false;
                admin = false;
                timer.start();}});        
        
        estiloBotao(btPaciente);                                    
        btPaciente.setBounds(140, 0, 140, 35);
        painelBotao.add(btPaciente);
        
        
        btDoador = new JButton("Doador");
        btDoador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                btDoador.setForeground(new Color(255, 12, 12, 250));
                btAdmin.setForeground(Color.WHITE);
                btPaciente.setForeground(Color.WHITE);               //   Botão para mudar para o painel para efectuar o login do Doador
                doador = true;                                     
                paciente = false;
                admin = false;
                timer.start();}});        
        
        btDoador.setBounds(280, 0, 140, 35);
        estiloBotao(btDoador);
        painelBotao.add(btDoador);
        btDoador.setForeground(new Color(255, 12, 12, 250));
        
        labelUnd = new JLabel();                                // Label do traço vermelho (slideBar) que desliza que ao mudar de perfil
        labelUnd.setBorder(new MatteBorder(3,0, 0, 0, (Color) new Color(255, 12, 12, 250)));
        labelUnd.setBounds(undX, 37,undY, 4);
        painelBotao.add(labelUnd);
        
        labelImagem.setBounds(0, 11, 1380, 683);   // Label da imagem de fundo
	contentPane.add(labelImagem);
        Image image = null;
            try {
                image = ImageIO.read(new File("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/fundoAdmin.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
	labelImagem.setIcon(new ImageIcon(image.getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_SMOOTH)));
    }
        
    public void login(){
        LoginController lc = new LoginController();
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try {
                    if(lc.verificarConexao()){
                        ViewLogin frame = new ViewLogin();
                        frame.setVisible(true);
			frame.setLocation(-7, 0);
                    
                    }else {
                        JOptionPane.showMessageDialog(null, "Você não está conectado a Base de Dados","Error",JOptionPane.ERROR_MESSAGE);}
                    
                } catch (Exception e) {
                    e.printStackTrace();}  }});
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(admin){
            if(adminX == 500){
                admin = false;
                timer.stop();
            }else{
                adminX += 50;
                doadorX += 50;
                pacienteX += 50;
                undX -= 5;} }
        
        else if(paciente){
            if(pacienteX == 500){
		paciente = false;
                timer.stop();
            }else {
                if(pacienteX > 500){
                    adminX -= 50;
                    doadorX -= 50;
                    pacienteX -= 50;	
                    undX += 5;}
                else{
                    adminX += 50;
                    doadorX += 50;
                    pacienteX += 50;
                    undX -= 5;} }}		
            
        else if(doador){
                if(doadorX == 500){
                    doador = false;
                    timer.stop();
                }else{
                    adminX -= 50;
                    doadorX -= 50;
                    pacienteX -= 50;
                    undX += 5;}}
                    
        lpDoador.setLocation(doadorX, doadorY);
        lpPaciente.setLocation(pacienteX, pacienteY);
        lpAdmin.setLocation(adminX, adminY);
        labelUnd.setLocation(undX,labelUnd.getY());             
        repaint();}
    
    private void estiloBotao(JButton botao) {
		botao.setFocusable(true);
		botao.setForeground(Color.WHITE);
		botao.setFont(new Font("Segoe UI", Font.BOLD, 15));
		botao.setBorder(new EmptyBorder(0,0,0,0));
		botao.setBackground(Color.black);
		botao.setFocusPainted(false);
		botao.setBorderPainted(false);
		botao.setOpaque(false);}}
