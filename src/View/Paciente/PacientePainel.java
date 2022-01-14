
package View.Paciente;

import Controller.PacienteController;
import JanelaComum.TextFieldCriar;
import Model.ValueObjects.Paciente;
import View.Admin.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class PacientePainel extends JPanel implements ActionListener{
    public AdminView am;
    private JScrollPane tabelaScroll;
    private JTable tabela;
    private JPanel cabecalho;
    private JLabel textoCabecalho;
    private PacienteController pc;
    private TextFieldCriar procurarField;
    private JComboBox<String> grupoSanguineo;
    private JButton procurar;
    private final String [] grupos = {"Todos os Grupos","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    
    public PacientePainel(AdminView am){
        this();
	this.am=am;}

    public PacientePainel() {
        setName("Visualizar Paciente");
        setBackground(new Color(255, 255, 255));
	setSize(1116, 705);
	setLayout(null);
        pc = new PacienteController();
        
        tabelaScroll = new JScrollPane();
	tabelaScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
	tabelaScroll.setBounds(10, 194, 1096, 500);
	
        for(Component c : tabelaScroll.getComponents()){
            c.setBackground(Color.white);}
        add(tabelaScroll);
		
		
	tabela = new JTable();
	tabela.setBorder(new LineBorder(Color.LIGHT_GRAY));
	tabela.getTableHeader().setBackground(new Color(255, 12, 12, 250));
	tabela.getTableHeader().setForeground(Color.white);
	tabela.setSelectionBackground(new Color(240, 255, 255));
	tabela.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
	tabela.setFont(new Font("Segoe UI",Font.PLAIN,20));
	tabela.getTableHeader().setPreferredSize(new Dimension(50,40));
	tabela.setFocusable(false);
	tabela.setDragEnabled(false);
	tabela.setRowHeight(40);
	criarModeloTabela();
	tabela.setDefaultEditor(Object.class, null);
	tabela.setCursor(new Cursor(Cursor.HAND_CURSOR));
	tabela.setGridColor(Color.LIGHT_GRAY);
	tabela.getTableHeader().setReorderingAllowed(false);	
	tabelaScroll.setViewportView(tabela);
		
        
        tabela.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if((e.getClickCount() > 1)  &&  (e.getButton()==MouseEvent.BUTTON1)){
                    JTable t = (JTable) e.getSource();
                    int row = t.getSelectedRow(); 
                    
                    String id = tabela.getValueAt(row,0)+""; 
                    String [] kk = new String[2];
                    kk = id.split("-");
                    int cod = Integer.parseInt(kk[1]);
 
                    Paciente p = pc.getPacienteInfo(cod);
				
                    if(am != null){
                        am.vpd = new VisualizarPacienteDialog (p,am, "");
                        am.vpd.setVisible(true);
                        am.vpd.setVisible(false);
                        am.vpd.setLocation(238,0);
                        am.vpd.setVisible(true);
                        am.vpd.setFocusable(true);
                        am.vpd.btApagar.setVisible(false);
                        am.vpd.btAtualizar.setVisible(false);}  }  }  });
		
	cabecalho = new JPanel();
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setBounds(10, 0, 1096, 183);
	add(cabecalho);
	cabecalho.setLayout(null);
        
        textoCabecalho = new JLabel("Todos os Doadores");
	textoCabecalho.setIcon(null);
	textoCabecalho.setForeground(Color.WHITE);                      // Label do texto do cabeçalho
	textoCabecalho.setFont(new Font("Segoe UI", Font.BOLD, 29));    
	textoCabecalho.setBounds(395, 75, 377, 45);
	cabecalho.add(textoCabecalho);
        
        
        procurarField = new TextFieldCriar("Procurar");
        procurarField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	procurarField.setForeground(Color.DARK_GRAY);
	procurarField.setBounds(714, 129, 248, 40);
	cabecalho.add(procurarField);
	procurarField.setColumns(10);
		
        
        grupoSanguineo = new JComboBox<String>();
	grupoSanguineo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        grupoSanguineo.setModel(new DefaultComboBoxModel<String>(grupos));
	grupoSanguineo.setBounds(490, 128, 214, 40);
	grupoSanguineo.addActionListener(this);
	cabecalho.add(grupoSanguineo);
        
        
	procurar = new JButton();
	procurar.setForeground(new Color(255, 12, 12, 250));
	procurar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	procurar.setText("Procurar");
	procurar.setBorder(new EmptyBorder(0, 0, 0, 0));
	procurar.setBackground(new Color(255, 255, 255));
	procurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	procurar.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Pesquisar.png"));
	procurar.setBounds(972, 129, 114, 40);
	procurar.addActionListener(this);
	procurar.setFocusable(false);
	cabecalho.add(procurar);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == procurar){
            criarModeloTabelProcurar();}}
    
    
    public void criarModeloTabela(){
        ResultSet rs = pc.getPacienteInfo();
	if(rs!=null){
            tabela.setModel(DbUtils.resultSetToTableModel(rs));}
                
        tabela.getColumnModel().getColumn(0).setMaxWidth(125);
	tabela.getColumnModel().getColumn(1).setMaxWidth(300);
	tabela.getColumnModel().getColumn(2).setMaxWidth(250);
	tabela.getColumnModel().getColumn(3).setMaxWidth(150);
	tabela.getColumnModel().getColumn(4).setMaxWidth(280);
        tabela.getColumnModel().getColumn(5).setMaxWidth(300);
	tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    
    public void criarModeloTabelProcurar(){
        String txtProcurar = procurarField.getText().trim();
        String grupo = null, condition = "where";
        
        if((grupoSanguineo.getSelectedIndex() != 0) && (!txtProcurar.isEmpty() )){
            grupo = grupoSanguineo.getSelectedItem() + "";
            condition += " grupoSanguineo = '" + grupo + "' and (nome like '" +txtProcurar + "%' or apelido like '" + txtProcurar+"%')";
        
        }else if(grupoSanguineo.getSelectedIndex() != 0){
            grupo = grupoSanguineo.getSelectedItem() + "";
            condition += " grupoSanguineo = '" + grupo + "'";
        
        }else if(!txtProcurar.isEmpty()){
            condition += "(nome like '" +txtProcurar + "%' or apelido like '" + txtProcurar+"%')";
        
        }else if(grupoSanguineo.getSelectedIndex() == 0 && txtProcurar.isEmpty()){
            condition = "";}
        
        ResultSet rs = pc.getPacienteInfo(condition);
        if(rs != null){
            tabela.setModel(DbUtils.resultSetToTableModel(rs));}
        
        tabela.getColumnModel().getColumn(0).setMaxWidth(125);
	tabela.getColumnModel().getColumn(1).setMaxWidth(300);
	tabela.getColumnModel().getColumn(2).setMaxWidth(250);
	tabela.getColumnModel().getColumn(3).setMaxWidth(150);
	tabela.getColumnModel().getColumn(4).setMaxWidth(280);
        tabela.getColumnModel().getColumn(5).setMaxWidth(300);
	tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
    }
    
    

    
    
}
