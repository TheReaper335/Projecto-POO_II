
package View.Usuario;

import Controller.*;
import Model.ValueObjects.*;
import View.Admin.AdminView;
import View.Doador.VisualizarDoadorDialog;
import View.Paciente.VisualizarPacienteDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class UsuarioPainel extends JPanel{
    private JLabel cabecalho;
    private JTable tabela;
    public String condition="";
    private AdminView am;
    private UsuarioController uc;
    private DoadorController dc;
    private PacienteController pc;
	

    public UsuarioPainel(AdminView a){
        this();
        this.am = a;
        uc = new UsuarioController();
        dc = new DoadorController();
        pc = new PacienteController();
        
	criarModeloTabela();
        
	tabela.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(e.getClickCount() > 1 && e.getButton()==MouseEvent.BUTTON1){
                    JTable t=(JTable) e.getSource();
                    int row = t.getSelectedRow();
                    
                    String perfilUsuario = tabela.getValueAt(row, 0)+"";
		    String idUsuario = tabela.getValueAt(row, 1)+"";
                    String [] kk = new String[2];
                    kk = idUsuario.split("-");
                    int cod = Integer.parseInt(kk[1]);
		
                if(perfilUsuario.equals("Doador")){
                    Doador d = dc.getDoadorInfo(cod);
                    if(am != null){
                        am.vdd = new VisualizarDoadorDialog (d,am, "");
                        am.vdd.setVisible(true);
                        am.vdd.setVisible(false);
                        am.vdd.setLocation(238,0);
                        am.vdd.setVisible(true);
                        am.vdd.setFocusable(true);
                        am.vdd.btApagar.setVisible(false);
                        am.vdd.btAtualizar.setVisible(false);}
                
                }else if(perfilUsuario.equals("Paciente")){
                    Paciente p = pc.getPacienteInfo(cod);
                    if(am != null){
                        am.vpd = new VisualizarPacienteDialog (p,am, "");
                        am.vpd.setVisible(true);
                        am.vpd.setVisible(false);
                        am.vpd.setLocation(238,0);
                        am.vpd.setVisible(true);
                        am.vpd.setFocusable(true);
                        am.vpd.btApagar.setVisible(false);
                        am.vpd.btAtualizar.setVisible(false);}  }  }}  });
	}
    
    
	public UsuarioPainel() {
            uc = new UsuarioController();
            dc = new DoadorController();
            pc = new PacienteController();
            setBackground(Color.WHITE);
            this.setSize(1116, 705);
            setLayout(null);
            setName("Painel de Usuarios");
		
            cabecalho = new JLabel("  Usuários");
            cabecalho.setBackground(new Color(255, 12, 12, 250));
            cabecalho.setForeground(new Color(255, 255, 255));
            cabecalho.setFont(new Font("Segoe UI", Font.BOLD, 30));
            cabecalho.setHorizontalAlignment(JLabel.LEFT);
            cabecalho.setBounds(10, 0, 1096, 183);
            cabecalho.setOpaque(true);
            add(cabecalho);
		
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
            scrollPane.setBounds(10, 194, 1096, 500);
            for(Component c: scrollPane.getComponents()){
                c.setBackground(Color.white);}
            add(scrollPane);
		
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
            tabela.setDefaultEditor(Object.class, null);
            tabela.setCursor(new Cursor(Cursor.HAND_CURSOR));
            tabela.setGridColor(Color.LIGHT_GRAY);
            tabela.getTableHeader().setReorderingAllowed(false);	
            scrollPane.setViewportView(tabela);}
	
	public void criarModeloTabela(){
            ArrayList<Usuario> lista = uc.getUsuarioInfo(condition);
            String colunas[]= {"Perfil de Usuário", "iD do Usuário", "Nome do Usuário", "Data Login" ,"Tempo Login"};
            DefaultTableModel model = new DefaultTableModel(colunas,0);
            for(int i=0; i<lista.size(); i++){
                Usuario user = lista.get(i);
		model.addRow(new Object[0]);
		model.setValueAt(user.getPerfilUsuario(), i, 0);
		model.setValueAt(user.getIdUsuario(), i, 1);
		model.setValueAt(user.getNome(), i, 2);
		model.setValueAt(user.getDataLogin(), i, 3);
		model.setValueAt(user.getTempoLogin(), i, 4);}
            
		tabela.setModel(model);
		
		tabela.getColumnModel().getColumn(0).setMaxWidth(200);
		tabela.getColumnModel().getColumn(1).setMaxWidth(200);
		tabela.getColumnModel().getColumn(2).setMaxWidth(200);
		tabela.getColumnModel().getColumn(3).setMaxWidth(300);
		tabela.getColumnModel().getColumn(4).setMaxWidth(200);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tabela.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		tabela.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		tabela.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
		tabela.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
		tabela.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());}
        
        
	private class CellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                this.setHorizontalAlignment(JLabel.CENTER);
		return this;}  }
    
}
