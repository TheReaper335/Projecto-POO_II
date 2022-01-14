
package View.Doador;


import Controller.DoadorController;
import Model.ValueObjects.Doador;
import View.Admin.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class ProcurarDialog extends JDialog implements ActionListener{
    private static ProcurarDialog dialog;
    private JComboBox<String> grupoSanguineo, nome;
    private JButton procurar;
    private AdminView av;
    private JLabel error;
    private final String [] grupos = {"--- Select ---","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    public DoadorAdmin da;

    public ProcurarDialog(DoadorAdmin a, AdminView av) {
        super(dialog, "", Dialog.ModalityType.APPLICATION_MODAL);
	this.da = a;
        this.av = av;
	setResizable(false);
	getContentPane().setBackground(Color.WHITE);
	setSize(520, 382);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
	getContentPane().setLayout(null);
        
	JLabel cabecalho = new JLabel("Visualizar Dados do Doador");
	cabecalho.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
	cabecalho.setBounds(0, 0, 514, 53);
	getContentPane().add(cabecalho);
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setOpaque(true);
	cabecalho.setForeground(new Color(255, 255, 255));
	cabecalho.setFont(new Font("Arial", Font.BOLD, 23));
	cabecalho.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        
        /*
        Criação do ComboBox dos Grupos Sanguineos
        */
        grupoSanguineo = new JComboBox<String>();
	grupoSanguineo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        grupoSanguineo.setModel(new DefaultComboBoxModel<String>(grupos));
	grupoSanguineo.setFocusable(false);
	grupoSanguineo.setBackground(Color.WHITE);
	grupoSanguineo.setBounds(239, 98, 251, 43);
	grupoSanguineo.addActionListener(this);
	getContentPane().add(grupoSanguineo);
        
        
        /*
        Criação do ComboBox para escolher o nome a pesquisa
        */
        nome = new JComboBox<String>();
        nome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	nome.setFocusable(false);
        nome.setBackground(Color.WHITE);
	nome.setBounds(210, 191, 280, 43);
	nome.addActionListener(this);
	getContentPane().add(nome);
        
        
        
        
        /*
        Criação do painel onde irá ficar o botão para efectuar a pesquisa do doador
        */
        JPanel painel = new JPanel();
	painel.setBackground(Color.WHITE);
	painel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
	painel.setBounds(0, 300, 514, 53);
	getContentPane().add(painel);
	painel.setLayout(null);
        
        
        /*
        Botão para procurar dados do doador
        */
        procurar = new JButton("Procurar Dados");
	procurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	procurar.setFocusable(false);
	procurar.setFont(new Font("Segoe UI", Font.BOLD, 14));
	procurar.setForeground(new Color(255, 255, 255));
	procurar.setBackground(new Color(255, 12, 12, 250));
	procurar.addActionListener(this);
	procurar.setBounds(351, 11, 139, 33);
	painel.add(procurar);
		
        
        JLabel grupo = new JLabel("Grupo Sanguíneo  :");
	grupo.setHorizontalAlignment(SwingConstants.RIGHT);
	grupo.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 18));
	grupo.setBounds(24, 98, 180, 43);
	getContentPane().add(grupo);
		
        
        JLabel nomeLabel = new JLabel("Nome do Doador :");
	nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	nomeLabel.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 18));
	nomeLabel.setBounds(24, 191, 176, 43);
	getContentPane().add(nomeLabel);
        
        
        /*Label para mensagem de erro*/
        error = new JLabel("*Não pode deixar este campo em branco !");
	error.setForeground(new Color(255, 0, 0));
	error.setFont(new Font("Calibri", Font.PLAIN, 16));
	error.setBounds(21, 127, 250, 17);
	error.setVisible(false);
	getContentPane().add(error);
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        DoadorController dc = new DoadorController();
        if(e.getSource()== procurar){
            if(grupoSanguineo.getSelectedIndex()==0){
                mostrarErro(grupoSanguineo);
            
            
            }else if(nome.getSelectedIndex() == 0){
                mostrarErro(nome);
                
            } else{
                String grupo = grupoSanguineo.getSelectedItem() + "";
                String nomeD = (nome.getSelectedItem() + "").trim();
                String [] txt = nomeD.split(" ");
                String Nome = txt[0];
                String apelido = txt[1];
                
    
		Doador d = dc.getDoadorInfo(grupo, Nome, apelido);
                av.vdd = new VisualizarDoadorDialog (d,av, "");
                this.setVisible(false);
		av.vdd.setVisible(true);
		av.vdd.setLocation(238,0);
		av.vdd.setVisible(true);
		av.vdd.setFocusable(true);
		this.dispose();}}
            
        if(e.getSource()==grupoSanguineo){
            if(grupoSanguineo.getSelectedIndex()==0){
                nome.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
            }else{
                String grupo = grupoSanguineo.getSelectedItem() + "";
                nome.setModel(new DefaultComboBoxModel<String>(dc.getNomeByGrupos(grupo)));} } 
    }


    public void mostrarErro(JComponent jc){
        error.setVisible(true);
	error.setBounds(jc.getX(), jc.getY()+jc.getHeight()-5, 250,26);}
    
}
