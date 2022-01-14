
package View.Paciente;


import View.Admin.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PacienteAdmin extends JPanel implements ActionListener{
    private JPanel cabecalho, painelRegisto, painelAtualizar, painelVisualizar;
    private JButton btRegisto, btAtualizar, btVisualizar;
    private JLabel textoCabecalho;
    private AdminView av;

    public PacienteAdmin(AdminView av) {
        this();
        this.av = av;}

    public PacienteAdmin() {
        setBorder(new EmptyBorder(0, 0, 0, 0));
	setBackground(Color.WHITE);                                       // Configuração do Painel Principal
	setForeground(Color.WHITE);
	setSize(1116, 705);
	setLayout(null);

        painelRegisto = new JPanel();
	painelRegisto.setBorder(new LineBorder(new Color(192, 192, 192), 3));
	painelRegisto.setBounds(20, 244, 253, 247);                              // Painel para o botão de novo registo
	add(painelRegisto);
	painelRegisto.setBackground(new Color(255, 255, 255));
	painelRegisto.setLayout(null);

		
	btRegisto = new JButton("Novo Registo", 
                new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Novo_Registo_Doador.png"));
	btRegisto.setFont(new Font("Segoe UI", Font.BOLD, 25));
	btRegisto.setForeground(new Color(128, 128, 128));
	btRegisto.setHorizontalAlignment(SwingConstants.CENTER);                   // Criação do botão Novo Registo
	btRegisto.setHorizontalTextPosition(JLabel.CENTER);                    
	btRegisto.setVerticalTextPosition(JLabel.BOTTOM);
	btRegisto.setBounds(0, 0, 253, 247);     //10, 31, 233, 142
	btRegisto.addActionListener(this);
        painelRegisto.add(btRegisto);
        btRegisto.setFocusable(false);
        
	painelAtualizar = new JPanel();
	painelAtualizar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
	painelAtualizar.setLayout(null);                                        // Painel para o botão atualizar dados
	painelAtualizar.setBackground(Color.WHITE);
	painelAtualizar.setBounds(420, 244, 253, 247);
	add(painelAtualizar);


	btAtualizar = new JButton("Atualizar Dados", 
                new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Atualizar.png"));
	btAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
	btAtualizar.setForeground(new Color(128, 128, 128));
	btAtualizar.setHorizontalAlignment(SwingConstants.CENTER);                   // Criação do botão Novo Registo
	btAtualizar.setHorizontalTextPosition(JLabel.CENTER);                    
	btAtualizar.setVerticalTextPosition(JLabel.BOTTOM);
	btAtualizar.setBounds(0, 0, 253, 247);     //10, 31, 233, 142
	btAtualizar.addActionListener(this);
        painelAtualizar.add(btAtualizar);
        btAtualizar.setFocusable(false);
        
        
        painelVisualizar = new JPanel();
	painelVisualizar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
	painelVisualizar.setLayout(null);                                        // Painel para a contabilização das bolsas de sangue
	painelVisualizar.setBackground(Color.WHITE);
	painelVisualizar.setBounds(842, 244, 253, 247);
	add(painelVisualizar);


	btVisualizar = new JButton("Visualizar Dados", 
                new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Visualizar_Dados_Doador.png"));
	btVisualizar.setHorizontalAlignment(SwingConstants.CENTER);
	btVisualizar.setForeground(new Color(128, 128, 128));
	btVisualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
	btVisualizar.setBounds(0, 0, 253, 247);                      // Botão para visualizar dados dos pacientes                            
        btVisualizar.setHorizontalTextPosition(JLabel.CENTER);
	btVisualizar.setVerticalTextPosition(JLabel.BOTTOM);
        btVisualizar.addActionListener(this);
	painelVisualizar.add(btVisualizar);
        btVisualizar.setFocusable(false);
        
        
        cabecalho = new JPanel();
	cabecalho.setBorder(new EmptyBorder(0, 0, 0, 0));                   // Painel do Cabeçalho da pagina inicial
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setLayout(null);
	cabecalho.setBounds(10, 0, 1096, 279);
	add(cabecalho);


	textoCabecalho = new JLabel("Informações do Paciente");
	textoCabecalho.setIcon(null);
	textoCabecalho.setForeground(Color.WHITE);                      // Label do texto do cabeçalho
	textoCabecalho.setFont(new Font("Segoe UI", Font.BOLD, 29));    
	textoCabecalho.setBounds(395, 97, 377, 45);
	cabecalho.add(textoCabecalho);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btRegisto){
            RegistoPaciente rp = new RegistoPaciente();
            rp.setLocationRelativeTo(null);
            rp.setVisible(true);}
        
        if (ae.getSource() == btAtualizar){
            ProcurarDialog_P ad = new ProcurarDialog_P(this, av);
            ad.setLocationRelativeTo(null);
            ad.setVisible(true);}
        
        if(ae.getSource() == btVisualizar){
            av.desabilitarPainel();
            av.pp = new PacientePainel(av);
            av.pp.setLocation(250, 0);
            av.pp.setFocusable(true);
            av.contentPane.add(av.pp);
            av.pp.setVisible(true);}
    
    }
    
}
