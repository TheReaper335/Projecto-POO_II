/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Paciente;

import JanelaComum.TextFieldCriar;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.border.*;
public class RegistoPaciente extends JDialog implements ActionListener, ChangeListener{
    private final JPanel contentPanel;
    private final String []
        grupos = {"--- Selecione o seu Grupo Sanguineo ---","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    private JLabel cabecalho, notaImagem, tamanhoImagem, fotoPerfil, foto, nomeFich, error;
    private TextFieldCriar pNome, uNome, contacto, peso, bi, endereco, bairro,nr, email, 
            password, age, pai, mae, contactoM, contactoP;
    private JComboBox grupoSanguineo, genero;
    private JSpinner dataNascimento;
    private JButton procurar, registar;

    public RegistoPaciente() {
        super(new JFrame(), true);
        contentPanel = new JPanel();
        setResizable(false);
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
	getContentPane().setBackground(Color.WHITE);
        setBounds(300, 52, 850, 650);
	getContentPane().setLayout(null);
	contentPanel.setLayout(null);
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        /*
        Criação do Cabeçalho
        */
        cabecalho = new JLabel("Registar Novo Paciente");
	cabecalho.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
	cabecalho.setBounds(0, 0, 845, 40);
	getContentPane().add(cabecalho);
        
        cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setOpaque(true);
	cabecalho.setForeground(new Color(255, 255, 255));
	cabecalho.setFont(new Font("Arial", Font.BOLD, 23));
	cabecalho.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        
        
        /*
        Criação do TextField do Primeiro Nome
        */
        pNome = new TextFieldCriar("Nome");
        pNome.setToolTipText("Introduza o seu Nome");
        pNome.setForeground(Color.DARK_GRAY);
	pNome.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	pNome.addActionListener(this);
        pNome.setColumns(10);
        pNome.setBounds(10, 51, 400, 40);
	getContentPane().add(pNome);
	
        /*
        Criação do TextField do Apelido
        */
        uNome = new TextFieldCriar("Apelido");
        uNome.setToolTipText("Introduza o seu Apelido");
        uNome.setForeground(Color.DARK_GRAY);
        uNome.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
        uNome.addActionListener(this);
        uNome.setColumns(10);
        uNome.setBounds(424, 51, 400, 40);
        getContentPane().add(uNome);
        
        
        /*
        Criação do texto "Data de Nascimento"
        */
        JLabel data = new JLabel("Data de Nascimento");
	data.setForeground(Color.DARK_GRAY);
	data.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));                
	data.setBounds(10, 112, 140, 40);
	getContentPane().add(data);
        
        
        //Criação do Spinner para a Data de Nascimento
        dataNascimento = new JSpinner();
        dataNascimento.setToolTipText("Data de Nascimento");
        dataNascimento.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    dataNascimento.setFocusable(false);}  }   });
        
        dataNascimento.setFont(new Font ("Segoi UI Historic", Font.PLAIN, 16));
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        dataNascimento.setModel(new SpinnerDateModel());
        dataNascimento.setEditor(new JSpinner.DateEditor(dataNascimento, f.toPattern()));
        dataNascimento.addChangeListener(this);
        dataNascimento.setBounds(170, 112, 110, 40);
        getContentPane().add(dataNascimento);
        
        
        /*
        Criação do ComboBox do Gênero 
        */
        genero = new JComboBox<String>();
        genero.setToolTipText("Escolha o seu Gênero");
	genero.setModel(new DefaultComboBoxModel<String>(new String[] { "---Selecione o Gênero---", "Masculino", "Feminino" }));
	genero.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	genero.setBackground(Color.WHITE);
	//genero.addActionListener(this);           
	genero.setBounds(424, 112, 400, 40);
	genero.setFocusable(false);
	getContentPane().add(genero);
        
        
        /*
        Criação do ComboBox do Grupo Sanguineo
        */
        grupoSanguineo = new JComboBox <String>();
        grupoSanguineo.setToolTipText("Escolha o seu Grupo Sanguineo");
	grupoSanguineo.setModel(new DefaultComboBoxModel<String>(grupos));              
	grupoSanguineo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	grupoSanguineo.setBackground(Color.WHITE);
        //grupoSanguineo.addActionListener(this);
        grupoSanguineo.setBounds(10, 173, 400, 40);
        grupoSanguineo.setFocusable(false);
        getContentPane().add(grupoSanguineo);
        
        
        /*
        Criação do TextField do Peso
        */
        peso = new TextFieldCriar("Peso");
        peso.setToolTipText("Introduza o seu Peso");
        peso.setForeground(Color.DARK_GRAY);
	peso.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	peso.addActionListener(this);
        peso.setColumns(10);
        peso.setBounds(424, 173, 100, 40);
        getContentPane().add(peso);
        
        
        /*
        Criação do TextField do Contacto
        */
        contacto = new TextFieldCriar("Contacto");
        contacto.setToolTipText("Introduza o seu Contacto");
        contacto.setForeground(Color.DARK_GRAY);
	contacto.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	contacto.addActionListener(this);
        contacto.setColumns(10);
        contacto.setBounds(538, 173, 100, 40);  
	getContentPane().add(contacto);
        
        /*
        Criação do Label e do Campo onde irá aparecer da idade
        */
        JLabel idade = new JLabel("Idade");
	idade.setForeground(Color.DARK_GRAY);
	idade.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));                
	idade.setBounds(652, 173, 38, 40);
	getContentPane().add(idade);
        
        age = new TextFieldCriar("");
        age.setForeground(Color.DARK_GRAY);
	age.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        age.addActionListener(this);
        age.setColumns(10);
        age.setBounds(704, 173, 120, 40);
        age.setEditable(false);
        age.setBackground(new Color(222, 222, 222));
        age.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        /*String dataN = dataNascimento.getValue().toString().trim();
        String anoT = dataN.substring(6);
        int ano = Integer.parseInt(anoT);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String idade_2 = String.valueOf(year - ano);
        age.setText(idade_2);
        age.setEditable(false);
        age.setBackground(new Color(152, 152, 152));*/
        getContentPane().add(age);
        
        
        /*
        Criação do TextField do BI
        */
        bi = new TextFieldCriar("Nº do Bilhete de Identidade");
        bi.setToolTipText("Introduza o Número do seu BI");
        bi.setForeground(Color.DARK_GRAY);
        bi.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	bi.addActionListener(this);
        bi.setColumns(10);
        bi.setBounds(10, 234, 250, 40);  
	getContentPane().add(bi);
        
        
        /*
        Criação do TextField do Endereço da Morada
        */
        endereco = new TextFieldCriar("Endereço da Morada");
        endereco.setToolTipText("Introduza a sua Morada");
        endereco.setForeground(Color.DARK_GRAY);
        endereco.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	endereco.addActionListener(this);
        endereco.setColumns(10);
        endereco.setBounds(274, 234, 250, 40);  
        getContentPane().add(endereco);
        
        /*
        Criação do TextField do Nº de Casa
        */
        nr = new TextFieldCriar ("Nº de Casa");
        nr.setToolTipText("Introduza a sua Morada");
        nr.setForeground(Color.DARK_GRAY);
        nr.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	nr.addActionListener(this);
        nr.setColumns(10);
        nr.setBounds(538, 234, 100, 40);  
	getContentPane().add(nr);
        
        /*
        Criação do TextField do Bairro
        */
        bairro = new TextFieldCriar ("Bairro");
        bairro.setToolTipText("Introduza a seu Bairro");
        bairro.setForeground(Color.DARK_GRAY);
        bairro.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	bairro.addActionListener(this);
        bairro.setColumns(10);
        bairro.setBounds(652, 234, 175, 40);  
	getContentPane().add(bairro);
        
        /*
        Criação do TextField para a informação do pai
        */
        pai = new TextFieldCriar ("Nome do Pai");
        pai.setToolTipText("Introduza o nome do pai do paciente");
        pai.setForeground(Color.DARK_GRAY);
        pai.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	pai.addActionListener(this);
        pai.setColumns(10);
        pai.setBounds(10, 295, 400, 40);  
	getContentPane().add(pai);     
        
        
        /*
        Criação do TextField para o contacto do pai
        */
        contactoP = new TextFieldCriar ("Contacto");
        contactoP.setToolTipText("Introduza o contacto do pai do paciente");
        contactoP.setForeground(Color.DARK_GRAY);
        contactoP.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	contactoP.addActionListener(this);
        contactoP.setColumns(10);
        contactoP.setBounds(424, 295, 400, 40);  
	getContentPane().add(contactoP);     
        
        
        /*
        Criação do TextField para a informação da mãe
        */
        mae = new TextFieldCriar ("Nome da Mãe");
        mae.setToolTipText("Introduza o nome da mãe do paciente");
        mae.setForeground(Color.DARK_GRAY);
        mae.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	mae.addActionListener(this);
        mae.setColumns(10);
        mae.setBounds(10, 356, 400, 40);  
	getContentPane().add(mae);    
 
        
        /*
        Criação do TextField para o contacto da mãe
        */
        contactoM = new TextFieldCriar ("Contacto");
        contactoM.setToolTipText("Introduza o contacto da mãe do pacient");
        contactoM.setForeground(Color.DARK_GRAY);
        contactoM.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	contactoM.addActionListener(this);
        contactoM.setColumns(10);
        contactoM.setBounds(424, 356, 400, 40);  
	getContentPane().add(contactoM);
         
        
        /*
        Criação do TextField para o email
        */
        email = new TextFieldCriar ("Email de Login");
        email.setToolTipText("Introduza o Email para Login");
        email.setForeground(Color.DARK_GRAY);
        email.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	email.addActionListener(this);
        email.setColumns(10);
        email.setBounds(10, 417, 400, 40);  
	getContentPane().add(email);   
        
        
        /*
        Criação do TextField para o Password
        */
        password = new TextFieldCriar ("Password de Login");
        password.setToolTipText("Introduza o Password para Login");
        password.setForeground(Color.DARK_GRAY);
        password.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	password.addActionListener(this);
        password.setColumns(10);
        password.setBounds(424, 417, 400, 40);  
	getContentPane().add(password);   

        /*
        Nota para o tamanho máximo da imagem
        */
        notaImagem = new JLabel("Tamanho da Imagem  <  1024 KB");
	notaImagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	notaImagem.setBounds(134, 574, 545, 32);
	getContentPane().add(notaImagem);

	tamanhoImagem = new JLabel("");
	tamanhoImagem.setToolTipText("Tamanho da Imagem");
	tamanhoImagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tamanhoImagem.setBounds(200, 494, 566, 32);
	getContentPane().add(tamanhoImagem);

	/*
        Label para a foto de perfil
        */
        fotoPerfil = new JLabel();
	fotoPerfil.setToolTipText("Profile Picture");
	fotoPerfil.setBorder(new LineBorder(new Color(0, 0, 0)));
	fotoPerfil.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	fotoPerfil.setBounds(10, 486, 100, 120);
	getContentPane().add(fotoPerfil);
	fotoPerfil.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/Projecto_POO_II/Icones/Perfil_Icon.jpg"));

	/*
        Botão para procurar imagem
        */
        procurar = new JButton("Procurar");
	procurar.addActionListener(this);
	procurar.setFocusable(false);
	procurar.setBackground(new Color(245, 245, 245));
	procurar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	procurar.setBounds(134, 532, 114, 32);
	procurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	getContentPane().add(procurar);

	foto = new JLabel("Foto de Perfil");
	foto.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
	foto.setBounds(136, 498, 150, 21);
	getContentPane().add(foto);

        /*
        Label para escrever o nome do ficheiro escolhido
        */
	nomeFich = new JLabel("Nenhum Ficheiro Escolhido");
	nomeFich.setToolTipText("Nome do Ficheiro");
	nomeFich.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
	nomeFich.setBounds(258, 532, 566, 32);
	getContentPane().add(nomeFich);

	/*
        Criação do Botão para efectuar o novo 
        */
        registar = new JButton("Registar");
	registar.setBorder(new EmptyBorder(0, 0, 0, 0));
	registar.setForeground(new Color(255, 255, 255));
	registar.setBackground(new Color(255, 12, 12, 250));
	registar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	//registar.addActionListener(this);
	registar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	registar.setBounds(685, 563, 139, 37);
	registar.setFocusable(false);
	getContentPane().add(registar);

        /*
        Mensagem de erro para caso um campo não for preenchido
        */
	error = new JLabel("This is required question !");
	error.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 0, 0)));
	error.setHorizontalAlignment(SwingConstants.LEFT);
	error.setForeground(new Color(255, 69, 0));
	error.setFont(new Font("Calibri", Font.PLAIN, 16));
	error.setVisible(false);
	error.setBounds(10, 90, 400, 26);
	getContentPane().add(error);}
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
