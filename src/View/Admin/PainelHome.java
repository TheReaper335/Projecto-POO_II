package View.Admin;


import Controller.AdminController;
import Controller.DoadorController;
import Controller.PacienteController;
import Model.ValueObjects.Admin;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PainelHome extends JPanel{
        private JPanel cabecalho, painelDoador, painelPaciente, painelBolsas;
        private JLabel totalDoadores, totalPacientes, totalBolsas, lastLoginLabel;
        private JLabel doador, paciente, bolsa, textoCabecalho, bemVindo;
	int pos[]= {20,294,568,842};

    public PainelHome() {
        setBorder(new EmptyBorder(0, 0, 0, 0));                                 // Configuração do Painel Principal
	setBackground(Color.WHITE);
	setForeground(Color.WHITE);
	setSize(1116, 705);
	setLayout(null);

        painelDoador = new JPanel();
	painelDoador.setBorder(new LineBorder(new Color(192, 192, 192), 3));
	painelDoador.setBounds(20, 244, 253, 247);                              // Painel para a contabilização dos doadores
	add(painelDoador);
	painelDoador.setBackground(new Color(255, 255, 255));
	painelDoador.setLayout(null);
		
	totalDoadores = new JLabel("0");
	totalDoadores.setForeground(new Color(128, 128, 128));
	totalDoadores.setFont(new Font("Tahoma", Font.BOLD, 25));               // Label onde irá ficar o número total de doadores
	totalDoadores.setHorizontalAlignment(SwingConstants.CENTER);
	totalDoadores.setBounds(10, 174, 233, 35);
	painelDoador.add(totalDoadores);
		
	doador = new JLabel("Doadores");
	doador.setFont(new Font("Segoe UI", Font.BOLD, 25));
	doador.setForeground(new Color(128, 128, 128));
	doador.setHorizontalAlignment(SwingConstants.CENTER);                   // Label onde irá ficar o icone do Doador na Pagina
	doador.setHorizontalTextPosition(JLabel.CENTER);                    //  inicial
	doador.setVerticalTextPosition(JLabel.BOTTOM);
	doador.setBounds(10, 31, 233, 142);
	painelDoador.add(doador);
	doador.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Doador_Pagina_Inicial.png"));

	painelPaciente = new JPanel();
	painelPaciente.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
	painelPaciente.setLayout(null);                                        // Painel para a contabilização dos pacientes
	painelPaciente.setBackground(Color.WHITE);
	painelPaciente.setBounds(420, 244, 253, 247);
	add(painelPaciente);

	totalPacientes = new JLabel("0");
	totalPacientes.setHorizontalAlignment(SwingConstants.CENTER);
	totalPacientes.setForeground(Color.GRAY);                               //  Label onde ficará o número total de pacientes
	totalPacientes.setFont(new Font("Tahoma", Font.BOLD, 25));
	totalPacientes.setBounds(10, 174, 233, 35);
	painelPaciente.add(totalPacientes);

	paciente = new JLabel("Pacientes");
	paciente.setHorizontalAlignment(SwingConstants.CENTER);
	paciente.setForeground(Color.GRAY);
	paciente.setIcon(null);
	paciente.setFont(new Font("Segoe UI", Font.BOLD, 25));               // Label onde irá ficar o icone do Paciente na Pagina
	paciente.setBounds(10, 32, 233, 144);                              // inicial
	paciente.setHorizontalTextPosition(JLabel.CENTER);
	paciente.setVerticalTextPosition(JLabel.BOTTOM);
	painelPaciente.add(paciente);
	paciente.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Paciente_Pagina_Inicial.png"));
        
        
        painelBolsas = new JPanel();
	painelBolsas.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
	painelBolsas.setLayout(null);                                        // Painel para a contabilização das bolsas de sangue
	painelBolsas.setBackground(Color.WHITE);
	painelBolsas.setBounds(842, 244, 253, 247);
	add(painelBolsas);

	
        totalBolsas = new JLabel("0");
	totalBolsas.setHorizontalAlignment(SwingConstants.CENTER);
	totalBolsas.setForeground(Color.GRAY);                              //  Label onde ficará o número total de Bolsas de Sangue
	totalBolsas.setFont(new Font("Tahoma", Font.BOLD, 25));
	totalBolsas.setBounds(10, 174, 233, 35);
	painelBolsas.add(totalBolsas);

	bolsa = new JLabel("Bolsas de Sangue");
	bolsa.setHorizontalAlignment(SwingConstants.CENTER);
	bolsa.setForeground(Color.GRAY);
	bolsa.setFont(new Font("Segoe UI", Font.BOLD, 25));
	bolsa.setBounds(10, 40, 233, 141);                      // Label onde irá ficar o icone das Bolsas de Sangue na Pagina
	bolsa.setIconTextGap(10);                               // inical
	bolsa.setHorizontalTextPosition(JLabel.CENTER);
	bolsa.setVerticalTextPosition(JLabel.BOTTOM);
	painelBolsas.add(bolsa);
        bolsa.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Sangue_Pagina_Inicial.png"));
        
        
        cabecalho = new JPanel();
	cabecalho.setBorder(new EmptyBorder(0, 0, 0, 0));                   // Painel do Cabeçalho da pagina inicial
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setLayout(null);
	cabecalho.setBounds(10, 0, 1096, 279);
	add(cabecalho);

	bemVindo = new JLabel("Seja Bem-Vindo");
	bemVindo.setHorizontalAlignment(SwingConstants.RIGHT);
	bemVindo.setFont(new Font("Segoe UI", Font.BOLD, 30));          // Label do texto de boas vindas.
	bemVindo.setForeground(Color.WHITE);
	bemVindo.setBounds(10, 11, 1076, 45);
	cabecalho.add(bemVindo);

	textoCabecalho = new JLabel("Home Page");
	textoCabecalho.setIcon(null);
	textoCabecalho.setForeground(Color.WHITE);                      // Label do texto do cabeçalho
	textoCabecalho.setFont(new Font("Segoe UI", Font.BOLD, 29));    
	textoCabecalho.setBounds(60, 97, 377, 45);
	cabecalho.add(textoCabecalho);
        
        lastLoginLabel = new JLabel("Last Login : Primeira Vez");
	lastLoginLabel.setBackground(Color.WHITE);
	lastLoginLabel.setForeground(Color.WHITE);
	lastLoginLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	lastLoginLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	lastLoginLabel.setBounds(20, 47, 1066, 30);
	cabecalho.add(lastLoginLabel);
    }
        
    public PainelHome(Admin a) {
	this();
        AdminController ad = new AdminController();
        DoadorController dc = new DoadorController();
        PacienteController pc = new PacienteController();
        
        
	totalDoadores.setText("" + dc.totalDoadores());
	totalPacientes.setText("" + pc.getTotalPacientes());
	totalBolsas.setText("0");
	bemVindo.setText("Seja Bem-Vindo "+(ad.retornarNome()));}
    
    public void setLastLogin(String lastLogin) {
        if (lastLogin == null || lastLogin.isEmpty() || lastLogin.equals("")) {
            this.lastLoginLabel.setText("Last login : Primeira Vez");
	} else {
            this.lastLoginLabel.setText("Last login : " + lastLogin);}}
    
    
}
