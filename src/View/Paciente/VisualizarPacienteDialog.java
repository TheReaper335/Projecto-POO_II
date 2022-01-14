
package View.Paciente;

import Controller.PacienteController;
import Model.ValueObjects.Paciente;
import View.Admin.AdminView;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class VisualizarPacienteDialog extends JDialog{
    public PacienteAdmin pa;
    public AdminView av;
    public JButton btAtualizar, btApagar;
    private JPanel cabecalho;

    public VisualizarPacienteDialog(Paciente p) {
        setBackground(new Color(255, 255, 255));
        setSize(1116, 750);
	setLayout(null);
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
        
        /*
        Label do cabecalho
        */
	cabecalho = new JPanel();
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setBounds(10, 0, 1095, 188);
	add(cabecalho);
	cabecalho.setLayout(null);
		
	JLabel label = new JLabel(p.getNome()+ " " + p.getApelido()+ " ("+p.getIdString()+")");
	label.setHorizontalAlignment(SwingConstants.RIGHT);
	label.setForeground(new Color(255, 255, 255));
	label.setFont(new Font("Segoe UI", Font.BOLD, 30));
	label.setBounds(0, 11, 1067, 44);
	cabecalho.add(label);
		
        
        
        
        
        JLabel textoCabecalho = new JLabel("Dados do Paciente");
	textoCabecalho.setHorizontalAlignment(SwingConstants.LEFT);
	textoCabecalho.setForeground(Color.WHITE);
	textoCabecalho.setFont(new Font("Segoe UI", Font.BOLD, 30));
	textoCabecalho.setBounds(50, 65, 415, 44);
	cabecalho.add(textoCabecalho);
        
        
        JLabel iDLabel = new JLabel("iD  ");
	iDLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	iDLabel.setBackground(new Color(255, 255, 255));
	iDLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	iDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	iDLabel.setOpaque(true);
	iDLabel.setBounds(309, 66+150, 274, 48);
	add(iDLabel);
		
	
        JLabel nomeLabel = new JLabel("Nome do Paciente  ");
	nomeLabel.setOpaque(true);
	nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	nomeLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	nomeLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	nomeLabel.setBackground(Color.WHITE);
	nomeLabel.setBounds(309, 113+150, 274, 48);
	add(nomeLabel);
		
        
	JLabel enderecoLabel = new JLabel("Endereço  ");
	enderecoLabel.setOpaque(true);
	enderecoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	enderecoLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	enderecoLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	enderecoLabel.setBackground(Color.WHITE);
	enderecoLabel.setBounds(309, 160+150, 274, 48);
	add(enderecoLabel);
		
	
        JLabel emailLabel = new JLabel("Email ID  ");
	emailLabel.setOpaque(true);
	emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	emailLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	emailLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	emailLabel.setBackground(Color.WHITE);
	emailLabel.setBounds(309, 207+150, 274, 48);
	add(emailLabel);
		
        
	JLabel dataNascimentoLabel = new JLabel("Data de Nascimento ");
	dataNascimentoLabel.setOpaque(true);
	dataNascimentoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	dataNascimentoLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	dataNascimentoLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	dataNascimentoLabel.setBackground(Color.WHITE);
	dataNascimentoLabel.setBounds(309, 254+150, 274, 48);
	add(dataNascimentoLabel);
		
	
        JLabel contactoLabel = new JLabel("Contacto  ");
	contactoLabel.setOpaque(true);
	contactoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	contactoLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	contactoLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	contactoLabel.setBackground(Color.WHITE);
	contactoLabel.setBounds(309, 300+150, 274, 48);
	add(contactoLabel);
		
	
        JLabel grupoLabel = new JLabel("Grupo Sanguíneo  ");
	grupoLabel.setOpaque(true);
	grupoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	grupoLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	grupoLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	grupoLabel.setBackground(Color.WHITE);
	grupoLabel.setBounds(20, 359+150, 291, 48);
	add(grupoLabel);
		
        
        JLabel biLabel = new JLabel("Nº BI  ");
	biLabel.setOpaque(true);
	biLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	biLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	biLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	biLabel.setBackground(Color.WHITE);
	biLabel.setBounds(582, 359 + 150, 239, 48);
	add(biLabel);
        
        
	JLabel nomefLabel = new JLabel("Nome Familiar  ");
	nomefLabel.setOpaque(true);
	nomefLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	nomefLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	nomefLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	nomefLabel.setBackground(Color.WHITE);
	nomefLabel.setBounds(20, 405+150, 291, 48);
	add(nomefLabel);
		
        
	JLabel contactofLabel = new JLabel("Contacto Familiar  ");
	contactofLabel.setOpaque(true);
	contactofLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	contactofLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	contactofLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	contactofLabel.setBackground(Color.WHITE);
	contactofLabel.setBounds(582, 405+150, 239, 48);
	add(contactofLabel);
	
        
	JLabel drogaLabel = new JLabel("Droga  ");
	drogaLabel.setOpaque(true);
	drogaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	drogaLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	drogaLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	drogaLabel.setBackground(Color.WHITE);
	drogaLabel.setBounds(20, 452+150, 291, 48);
	add(drogaLabel);
        
        
		
	JLabel doencaLabel = new JLabel("Doenca  ");
	doencaLabel.setOpaque(true);
	doencaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	doencaLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	doencaLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	doencaLabel.setBackground(Color.WHITE);
	doencaLabel.setBounds(582, 452+150, 239, 48);
	add(doencaLabel);
        
	/*
        Label para preenchimento do id do doador
        */
	JLabel id = new JLabel("  "+ p.getIdString());
	id.setOpaque(true);
	id.setHorizontalAlignment(SwingConstants.LEFT);
	id.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	id.setBorder(new LineBorder(new Color(192, 192, 192)));
	id.setBackground(Color.WHITE);
	id.setBounds(582, 66+150, 523, 48);
	add(id);
       	
        /*
        Label para preenchimento do nome completo do doador
        */
	JLabel nome = new JLabel("  "+ p.getNome() + " " + p.getApelido());
	nome.setOpaque(true);
	nome.setHorizontalAlignment(SwingConstants.LEFT);
	nome.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	nome.setBorder(new LineBorder(new Color(192, 192, 192)));
	nome.setBackground(Color.WHITE);
	nome.setBounds(582, 113+150, 523, 48);
	add(nome);
		
        /*
        Label para preenchimento da morada do doador
        */
	JLabel endereco = new JLabel("  "+ p.getEndereco() + ", " + p.getBairro() + ", " + p.getNumero());
	endereco.setOpaque(true);
	endereco.setHorizontalAlignment(SwingConstants.LEFT);
	endereco.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	endereco.setBorder(new LineBorder(new Color(192, 192, 192)));
	endereco.setBackground(Color.WHITE);
	endereco.setBounds(582, 160+150, 523, 48);
	add(endereco);
		
        
        /*
        Label para preenchimento do email do doador
        */
	JLabel email = new JLabel("  "+ p.getEmail());
	email.setOpaque(true);
	email.setHorizontalAlignment(SwingConstants.LEFT);
	email.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	email.setBorder(new LineBorder(new Color(192, 192, 192)));
	email.setBackground(Color.WHITE);
	email.setBounds(582, 207+150, 523, 48);
	add(email);
        
        
	/*
        Label para preenchimento do contacto do doador
        */
	JLabel contacto = new JLabel("  "+ p.getContacto());
	contacto.setOpaque(true);
	contacto.setHorizontalAlignment(SwingConstants.LEFT);
	contacto.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	contacto.setBorder(new LineBorder(new Color(192, 192, 192)));
	contacto.setBackground(Color.WHITE);
	contacto.setBounds(582, 300+150, 523, 48);
	add(contacto);	
        
        
        
        /*
        Label para preenchimento da data de nascimento do doador
        */
	JLabel dataNascimento = new JLabel("  "+ p.getDataNascimento());
	dataNascimento.setOpaque(true);
	dataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
	dataNascimento.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	dataNascimento.setBorder(new LineBorder(new Color(192, 192, 192)));
	dataNascimento.setBackground(Color.WHITE);
	dataNascimento.setBounds(582, 254+150, 523, 48);
	add(dataNascimento);
		
     
        
        /*
        Label para preenchimento do grupo sanguineo do doador
        */
        JLabel grupoSanguineo = new JLabel("  " + p.getGrupoSanguineo());
	grupoSanguineo.setOpaque(true);
	grupoSanguineo.setHorizontalAlignment(SwingConstants.LEFT);
	grupoSanguineo.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	grupoSanguineo.setBorder(new LineBorder(new Color(192, 192, 192)));
	grupoSanguineo.setBackground(Color.WHITE);
	grupoSanguineo.setBounds(309, 359+150, 274, 48);
	add(grupoSanguineo);
        
        
        /*
        Label para preenchimento do nome do familiar do doador
        */
	JLabel nomePai = new JLabel("  "+ p.getNomePai());
	nomePai.setOpaque(true);
	nomePai.setHorizontalAlignment(SwingConstants.LEFT);
	nomePai.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	nomePai.setBorder(new LineBorder(new Color(192, 192, 192)));
	nomePai.setBackground(Color.WHITE);
	nomePai.setBounds(309, 405+150, 523, 48);
	add(nomePai);
        
        
        /*
        Label para preenchimento do contacto do familiar do doador
        */
	JLabel contactoPai = new JLabel("  "+ p.getContactoPai());
	contactoPai.setOpaque(true);
	contactoPai.setHorizontalAlignment(SwingConstants.LEFT);
	contactoPai.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	contactoPai.setBorder(new LineBorder(new Color(192, 192, 192)));
	contactoPai.setBackground(Color.WHITE);
	contactoPai.setBounds(820, 405+150, 523, 48);
	add(contactoPai);
        
        /*
        Label para preenchimento do número de bi do doador
        */
        JLabel bi = new JLabel("  " + p.getBi());
	bi.setOpaque(true);
	bi.setHorizontalAlignment(SwingConstants.LEFT);
	bi.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	bi.setBorder(new LineBorder(new Color(192, 192, 192)));
	bi.setBackground(Color.WHITE);
	bi.setBounds(820, 359 + 150, 285, 48);
	add(bi);
        
        /*
        Label para preenchimento da droga que o doador consome
        */
        JLabel nomeMae = new JLabel("  "+ p.getNomeMae());
	nomeMae.setOpaque(true);
	nomeMae.setHorizontalAlignment(SwingConstants.LEFT);
	nomeMae.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	nomeMae.setBorder(new LineBorder(new Color(192, 192, 192)));
	nomeMae.setBackground(Color.WHITE);
	nomeMae.setBounds(309, 452+150, 274, 48);
	add(nomeMae);
        
        /*
        Label para preenchimento da doenca que o doador padece
        */
        JLabel contactoMae = new JLabel("  "+ p.getContactoMae());
	contactoMae.setOpaque(true);
	contactoMae.setHorizontalAlignment(SwingConstants.LEFT);
	contactoMae.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	contactoMae.setBorder(new LineBorder(new Color(192, 192, 192)));
	contactoMae.setBackground(Color.WHITE);
	contactoMae.setBounds(820, 452+150, 285, 48);
	add(contactoMae);
        
        
        /*
        Label para a foto de do doador
        */
        JLabel fotoPerfil = new JLabel();
	fotoPerfil.setBounds(20, 66+150, 250, 270);
	add(fotoPerfil);
	fotoPerfil.setIcon(new ImageIcon(p.getFotoPerfil(250, 270)));
	fotoPerfil.setBorder(new LineBorder(new Color(192, 192, 192), 2));
	fotoPerfil.setOpaque(true);
	fotoPerfil.setBackground(new Color(240, 248, 255));
	fotoPerfil.setFont(new Font("Tahoma", Font.PLAIN, 16));
	fotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public VisualizarPacienteDialog (Paciente p,AdminView av, String tx){
        this(p);
        this.av = av;
        /*
        Criação do botão actualizar dados
        */
	btAtualizar = new JButton("Atualizar Dados");
	btAtualizar.setBorder(new EmptyBorder(0, 0, 0, 0));
	btAtualizar.setFocusable(false);
	btAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	btAtualizar.setForeground(new Color(255, 12, 12, 250));
	btAtualizar.setBackground(new Color(255, 255, 255));
	btAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btAtualizar.setBounds(932, 141, 140, 35);
	cabecalho.add(btAtualizar);
        
        
        /*
        Criação do botão apagar dados
        */
        btApagar = new JButton("Apagar Dados");
	btApagar.setBorder(new EmptyBorder(0, 0, 0, 0));
	btApagar.setFocusable(false);
        btApagar.setForeground(new Color(0, 139, 139));
	btApagar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btApagar.setBackground(new Color(255, 255, 255));
        btApagar.setForeground(new Color(255, 12, 12, 250));
	btApagar.setBounds(782, 141, 140, 35);
	btApagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	cabecalho.add(btApagar);
        
        
	JLabel dataRegistaLabel = new JLabel("Data do Registo  ");
	dataRegistaLabel.setOpaque(true);
	dataRegistaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	dataRegistaLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	dataRegistaLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	dataRegistaLabel.setBackground(Color.WHITE);
	dataRegistaLabel.setBounds(20, 649, 291, 48);
	add(dataRegistaLabel);
		
	/*
        Label para preenchimento da data em que o doador foi registado
        */
        JLabel dataRegista = new JLabel("  " + p.getDataRegista());
	dataRegista.setOpaque(true);
	dataRegista.setHorizontalAlignment(SwingConstants.LEFT);
	dataRegista.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	dataRegista.setBorder(new LineBorder(new Color(192, 192, 192)));
	dataRegista.setBackground(Color.WHITE);
	dataRegista.setBounds(309, 649, 274, 48);
	add(dataRegista);
		
        
        
        JLabel passwordLabel = new JLabel("Password  ");
	passwordLabel.setOpaque(true);
	passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	passwordLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	passwordLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
	passwordLabel.setBackground(Color.WHITE);
	passwordLabel.setBounds(582, 649, 239, 48);
	add(passwordLabel);
		
        /*
        Label para preenchimento do password do doador
        */
	JLabel password = new JLabel("  "+ p.getPassword());
	password.setOpaque(true);
	password.setHorizontalAlignment(SwingConstants.LEFT);
	password.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
	password.setBorder(new LineBorder(new Color(192, 192, 192)));
	password.setBackground(Color.WHITE);
	password.setBounds(820, 649, 285, 48);
	add(password);
	
	btApagar.addActionListener(new ActionListener(){
            PacienteController pcc = new PacienteController();  
            public void actionPerformed(ActionEvent a) {
                int result = JOptionPane.showConfirmDialog(null,"Tem a certeza deseja apagar esse registo?","Apagar Registo",JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                    int dd = 0;
                    dd = pcc.apagarRegisto(p);
                    if(dd != 0){
                        dispose();
                        JOptionPane.showMessageDialog(null, "Registo apagado com sucesso !", "Apagar Registo"
                            , JOptionPane.INFORMATION_MESSAGE);}}  }    });
	
        
        
	btAtualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ar) {
                av.rp = new RegistoPaciente(p);
		av.rp.setLocationRelativeTo(null);
		av.rp.setVisible(true);}  }  );


		
	}
    
}
