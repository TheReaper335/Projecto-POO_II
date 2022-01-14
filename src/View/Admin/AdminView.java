
package View.Admin;

import Controller.AdminController;
import Model.ValueObjects.Admin;
import JanelaComum.ConexaoBD;
import View.Doador.*;
import View.Login.ViewLogin;
import View.Paciente.*;
import View.Usuario.UsuarioPainel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.*;
import javax.swing.plaf.ColorUIResource;
public class AdminView extends JFrame implements ActionListener{

        public JPanel contentPane; 
        private JPanel painelLateral;
        private JLabel fotoPerfil, administrador;
        private JPanel painelPerfil;
        private PainelHome painelPrincipal;
        private JButton btHome, btDoador, btPaciente, btExit, btLogout, btn, btAdminPerfil, btUsuario;
        private Admin a;
        private Timer timer;
        private int locationY; private String lastLogin;
        public DoadorAdmin doadorAdminPanel;
        public PacienteAdmin pacienteAdminPanel;
        public VisualizarDoadorDialog vdd;
        public VisualizarPacienteDialog vpd;
        public DoadorPainel dp;
        public PacientePainel pp;
        public RegistoDoador rd;
        public RegistoPaciente rp;
        public AdminPerfilPainel app;
        public UsuarioPainel up;
        private AdminController ac;
        
   
        
    public AdminView() {
        ac = new AdminController();
        a = ac.getAdminInfo();
	ActionListener setActivo = new ActionListener(){
            
            public void actionPerformed(ActionEvent ae) {
                int result = ac.setActivo(a.getActivo());}  };
	
        timer = new Timer(2000,setActivo);
        timer.start();
        locationY = 0;
	UIManager.put("ComboBoxUI", "com.sun.java.swing.plaf.windows.WindowsComboBoxUI");
	UIManager.put("ComboBox.selectionBackground", new ColorUIResource(new Color(32,178,170)));
	UIManager.put("ComboBox.background", new ColorUIResource(Color.white));
	UIManager.put("ComboBox.foreground", new ColorUIResource(Color.DARK_GRAY));
	UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.WHITE));
	UIManager.put("ScrollBarUI", "com.sun.java.swing.plaf.windows.WindowsScrollBarUI");
        
        setResizable(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	contentPane = new JPanel();
	contentPane.setForeground(Color.DARK_GRAY);
	contentPane.setBackground(Color.DARK_GRAY);
	contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        setBounds(-2,0,1370,733);
        painelPerfil = new JPanel();
	painelPerfil.setBounds(5, 7, 240, 63);
	contentPane.add(painelPerfil);                          // Painel de Perfil no canto superior esquerdo
	painelPerfil.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
	painelPerfil.setBackground(Color.DARK_GRAY);
	painelPerfil.setLayout(null);
        
        administrador = new JLabel();
	administrador.setForeground(Color.WHITE);
	administrador.setHorizontalAlignment(SwingConstants.LEFT);
	administrador.setFont(new Font("Tw Cen MT", Font.BOLD, 25));                // Label da palavra Administrador
	administrador.setBackground(Color.DARK_GRAY);
	administrador.setText("Administrador");
	administrador.setOpaque(true);
	administrador.setBounds(65, 5, 171, 36);
	painelPerfil.add(administrador);
        
        fotoPerfil = new JLabel();
	fotoPerfil.setBounds(5, 0, 50, 50);
	painelPerfil.add(fotoPerfil);
	fotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);           // Label para a foto do perfil
	fotoPerfil.setBackground(Color.DARK_GRAY);
	fotoPerfil.setBorder(new LineBorder(Color.black, 0));
	fotoPerfil.setOpaque(true);
        
        criarPainelPrincipal();
        
        /*Criação do Painel Lateral para os botões*/
        painelLateral = new JPanel();
	painelLateral.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(64, 64, 64)));
	painelLateral.setBackground(Color.DARK_GRAY);
	painelLateral.setBounds(5, 75, 240, 654);
	contentPane.add(painelLateral);
	painelLateral.setLayout(null);
        
        btHome = criarBotao("Home");
	painelLateral.add(btHome);
	btn = btHome;
        
        btDoador = criarBotao("Doador");
        painelLateral.add(btDoador);
        
        btPaciente = criarBotao("Paciente");
        painelLateral.add(btPaciente);                  //Criação dos Botões do painel lateral
        
        btUsuario = criarBotao("Usuários");
        painelLateral.add(btUsuario);
        
        btAdminPerfil = criarBotao("Perfil Admin");
        painelLateral.add(btAdminPerfil);
        
        btLogout = criarBotao ("Log Out");
        painelLateral.add(btLogout);
        
        btExit = criarBotao ("Exit");
        painelLateral.add(btExit);
        
        activarBotao(btHome);
	painelPrincipal.setVisible(true);
        
        //this.setDetalhesFoto();
        lastLogin = a.getLastLogin();
	painelPrincipal.setLastLogin(lastLogin);
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
        Date loginTime = new Date();
        
        a.setLastLogin(f.format(loginTime));
        a.setActivo(true);
	int result = ac.atualizarAdminInfo(a);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
	    public void windowClosing(final WindowEvent windowenent) {
                abrirPainel(btExit);} });
    }
        
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    if(ConexaoBD.verificarConexao()){
                        AdminView frame = new AdminView();	
			frame.setVisible(true);
                        
                    } else{
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JOptionPane.showMessageDialog(null, "Você não está conectado a Base de Dados",
                                "Error",JOptionPane.ERROR_MESSAGE);}
                    
		new Thread().start();
		} catch (Exception e) {
                    e.printStackTrace();}  }});
    
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        abrirPainel(e.getSource());}
    
    private void abrirPainel(Object ae){
        if(ae == btHome){
            activarBotao(btHome);
            painelPrincipal = new PainelHome(a);
            painelPrincipal.setLocation(250, 0);                        
            painelPrincipal.setFocusable(true);
            contentPane.add(painelPrincipal);
            painelPrincipal.setVisible(true);}
        
        else if(ae == btDoador){
            activarBotao(btDoador);
            doadorAdminPanel = new DoadorAdmin(this);
            doadorAdminPanel.setLocation(250, 0);
            doadorAdminPanel.setFocusable(true);
            contentPane.add(doadorAdminPanel);
            doadorAdminPanel.setVisible(true);}
        
	else if(ae == btPaciente){
            activarBotao(btPaciente);
            pacienteAdminPanel = new PacienteAdmin(this);
            pacienteAdminPanel.setLocation(250, 0);
            pacienteAdminPanel.setFocusable(true);
            contentPane.add(pacienteAdminPanel);
            pacienteAdminPanel.setVisible(true);}
        
        else if(ae == btUsuario){
            activarBotao(btUsuario);
            up = new UsuarioPainel(this);
            up.setLocation(250, 0);
            up.setFocusable(true);
            contentPane.add(up);
            up.setVisible(true);}
        
        else if(ae == btAdminPerfil){
            activarBotao(btAdminPerfil);
            app = new AdminPerfilPainel(this);
            app.setLocation(250, 0);
            app.setVisible(true);
            app.setFocusable(true);
            contentPane.add(app);}
        
	else if(ae == btLogout){
            int result = JOptionPane.showConfirmDialog(null,"Tem a certeza que quer fazer Log Out?","Log Out",JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                 a.setActivo(false);
                timer.stop();
                desabilitarPainel();
                dispose();
                ViewLogin login = new ViewLogin();
                login.setVisible(true);
                login.setLocationRelativeTo(null);} }
        
        else if(ae == btExit){
            int result = JOptionPane.showConfirmDialog(null,"Tem a certeza que quer sair da Aplicação?  ","Exit",JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
		a.setActivo(false);
                timer.stop();
		desabilitarPainel();
                dispose();
		}}
    }
    
    private void activarBotao(JButton button){
        btn.setForeground(Color.LIGHT_GRAY);
        btn.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        btn.setBackground(Color.DARK_GRAY);
	btn.setDisabledIcon(new ImageIcon(""));
	btn.setIcon(new ImageIcon("C:/Users/ecio/Documents/NetBeansProjects/POO_II_Projecto/Icones/"+btn.getName()+"dac.png"));
	btn = button;
	btn.setForeground(Color.white);
	btn.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
	btn.setIcon(new ImageIcon("C:/Users/ecio/Documents/NetBeansProjects/POO_II_Projecto/Icones/"+btn.getName()+"ac.png"));
	desabilitarPainel();}
    
    public JButton criarBotao (String txt) {
	JButton button=new JButton();
	button.setForeground(Color.LIGHT_GRAY);
	button.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	button.setBackground(Color.DARK_GRAY);
	button.setHorizontalAlignment(SwingConstants.LEFT);
	button.setFocusable(false);
	button.setContentAreaFilled(false);                             // Método para configurar botões
	button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	button.setBorder(new EmptyBorder(0,0,0,0));
	button.setText(txt);
	button.setName(txt);
        button.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/"+button.getName()+"dac.png"));
	button.addActionListener(this);
	button.setIconTextGap(10);
	button.setLocation(0, locationY);
	button.setSize(234, 40);
	locationY+=95;
	return button;}
    
    public void desabilitarPainel(){
        if(painelPrincipal != null && painelPrincipal.isVisible()){
            painelPrincipal.setVisible(false);}
        
        if(doadorAdminPanel != null && doadorAdminPanel.isVisible()){
            doadorAdminPanel.setVisible(false);}
        
        if(pacienteAdminPanel != null && pacienteAdminPanel.isVisible()){
            pacienteAdminPanel.setVisible(false);}
        
        if(vdd!=null && vdd.isVisible()){
            vdd.setVisible(false);}
        
        if(vpd!=null && vpd.isVisible()){
            vpd.setVisible(false);}
        
        if(rd != null && rd.isVisible()){
            rd.setVisible(false);}
        
        if(rp != null && rp.isVisible()){
            rp.setVisible(false);}
        
        if(dp != null && dp.isVisible()){
            dp.setVisible(false);}
        
        if(pp != null && pp.isVisible()){
            pp.setVisible(false);}
        
        if(app!=null && app.isVisible()){
            app.setVisible(false);}
        
        if(up!= null && up.isVisible()){
            up.setVisible(false);}
        
    }
    
    public void criarPainelPrincipal(){
        painelPrincipal = new PainelHome(a);
	painelPrincipal.setLocation(250, 0);                        // Método para criar o painel principal;
	painelPrincipal.setFocusable(true);
	contentPane.add(painelPrincipal);}
    
    /*public void setDetalhesFoto(){
        a = ac.getAdminInfo();
	fotoPerfil.setIcon(new ImageIcon(a.getRoundedProfilePic(50, 50, 50)));}*/
}
