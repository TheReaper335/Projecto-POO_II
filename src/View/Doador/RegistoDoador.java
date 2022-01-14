package View.Doador;

import Controller.DoadorController;
import Model.ValueObjects.Doador;
import JanelaComum.TextFieldCriar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.time.Year;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.border.*;

public class RegistoDoador extends JDialog implements ActionListener, ItemListener{
    private final JPanel contentPanel;
    private final String [] resposta = {"Sim", "Não"},
        grupos = {"--- Selecione o seu Grupo Sanguineo ---","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}, 
        doenca = {"--- Selecione o a Doença que tem ---","Herpes Labial", "Herpes Genital", "Herpes Zoster", "Malária", "Febre Amarela", "Coronavírus",
                  "Hepatite A","Hepatite B ou C", "HIV/SIDA"},
        droga = {"--- Selecione o a Droga que consome ---","Cocaína","Heroína","Morfina","Crack","Ecstasy","Metanfetamina",
                "Maconha"};
    private JLabel cabecalho, textoDoenca, textoDroga, notaImagem, tamanhoImagem, fotoPerfil, foto, nomeFich, error, id;
    private TextFieldCriar pNome, uNome, contacto, peso, bi, endereco, bairro,nr, email, password, age, familiar, contacto_f;
    private JComboBox grupoSanguineo, genero, doencas, drogas;
    private JRadioButton [] resp, resp_1;
    private ButtonGroup group, group_2;
    private JSpinner dataNascimento;
    private JButton procurar, registar, atualizar;
    private DoadorAdmin da;
    private Doador doador;
    private String imagemP = null, infoDoencas, infoDrogas;
    private File file;
    private int indexResp1, indexResp2;

    public RegistoDoador() {
        super(new JFrame(), true);
        contentPanel = new JPanel();
        setResizable(false);
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
	getContentPane().setBackground(Color.WHITE);
        setBounds(300, 22, 850, 700);
	getContentPane().setLayout(null);
	contentPanel.setLayout(null);
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        group = new ButtonGroup();
        group_2 = new ButtonGroup();
        resp = new JRadioButton[2];
        resp_1 = new JRadioButton[2];
        infoDoencas = null;
        infoDrogas = null;
        
        
        /*
        Criação do Cabeçalho
        */
        cabecalho = new JLabel("Registar Novo Doador");
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
        dataNascimento.setBounds(170, 112, 240, 40);
        getContentPane().add(dataNascimento);
        
        
        Doador dd = new Doador();
        id = new JLabel("iD :  " + dd.gerarId());
        id.setForeground(Color.DARK_GRAY);
        id.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));                
	id.setBounds(720, 515, 160, 40);
	getContentPane().add(id);
        
        
        /*
        Criação do ComboBox do Gênero 
        */
        genero = new JComboBox<String>();
        genero.setToolTipText("Escolha o seu Gênero");
	genero.setModel(new DefaultComboBoxModel<String>(new String[] { "---Selecione o Gênero---", "Masculino", "Feminino" }));
	genero.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	genero.setBackground(Color.WHITE);
	genero.addActionListener(this);           
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
        grupoSanguineo.addActionListener(this);
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
        Criação do Label da pergunta se possui doença
        */
        textoDoenca = new JLabel("Possui Alguma Doença?");
	textoDoenca.setForeground(Color.DARK_GRAY);
	textoDoenca.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));                
	textoDoenca.setBounds(10, 295, 168, 40);
	getContentPane().add(textoDoenca);
        
        /*
        Criação do Label da pergunta acerca do consumo de drogas
        */
        textoDroga = new JLabel("Consome Alguma Droga?");
        textoDroga.setForeground(Color.DARK_GRAY);
	textoDroga.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));                
	textoDroga.setBounds(424, 295, 180, 40);
	getContentPane().add(textoDroga);
        
        /*
        Criação dos RadioButtons
        */
        int x= 192, y = 620;
        for (int i=0; i<2; i++){
            resp[i] = new JRadioButton();
            resp_1[i] = new JRadioButton();
            
            resp[i].addItemListener(this);
            resp_1[i].addItemListener(this);
            
            resp[i].setText(resposta[i]);
            resp_1[i].setText(resposta[i]);
            
            
            resp[i].setBackground(Color.WHITE);
            resp_1[i].setBackground(Color.WHITE);
            
            resp[i].setForeground(Color.DARK_GRAY);
            resp_1[i].setForeground(Color.DARK_GRAY);
            
            resp[i].setFocusable(false);
            resp_1[i].setFocusable(false);
            
            resp[i].setBounds(x, 297, 50, 40);
            resp_1[i].setBounds(y, 297, 50, 40);
            
            group.add(resp[i]);
            group_2.add(resp_1[i]);
            getContentPane().add(resp[i]);
            getContentPane().add(resp_1[i]);
            x += 50;
            y += 50;}
            
        
        /*
        Criação do ComboBox de doenças
        */
        doencas =  new JComboBox <String>();
        doencas.setToolTipText("Escolha a doença que tem");
	doencas.setModel(new DefaultComboBoxModel<String>(doenca));              
	doencas.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	doencas.setBackground(Color.WHITE);
        doencas.addActionListener(this);
        doencas.setBounds(10, 356, 400, 40);
        doencas.setFocusable(false);
        doencas.setVisible(false);
        getContentPane().add(doencas);
        
        /*
        Criação do ComboBox de drogas
        */
        drogas =  new JComboBox <String>();
        drogas.setToolTipText("Escolha a droga que consome");
	drogas.setModel(new DefaultComboBoxModel<String>(droga));              
	drogas.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	drogas.setBackground(Color.WHITE);
        drogas.addActionListener(this);
        drogas.setBounds(424, 356, 400, 40);
        drogas.setFocusable(false);
        drogas.setVisible(false);
        getContentPane().add(drogas);
        
        
        
        /*
        Criação do TextField para os dados do Familiar
        */
        familiar = new TextFieldCriar("Nome Familiar");
        familiar.setToolTipText("Introduza a nome de um familiar em caso de emergência");
        familiar.setForeground(Color.DARK_GRAY);
        familiar.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	familiar.addActionListener(this);
        familiar.setColumns(10);
        familiar.setBounds(10, 417, 400, 40);  
	getContentPane().add(familiar);     
        
        
        /*
        Criação do TextField para o contacto do familiar
        */
        contacto_f = new TextFieldCriar ("Contacto do Familiar");
        contacto_f.setToolTipText("Introduza o contacto do familiar para emergência");
        contacto_f.setForeground(Color.DARK_GRAY);
        contacto_f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	contacto_f.addActionListener(this);
        contacto_f.setColumns(10);
        contacto_f.setBounds(424, 417, 400, 40);  
	getContentPane().add(contacto_f);   
        
        /*
        Criação do TextField para o email
        */
        email = new TextFieldCriar ("Email de Login");
        email.setToolTipText("Introduza o Email para Login");
        email.setForeground(Color.DARK_GRAY);
        email.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));       
	email.addActionListener(this);
        email.setColumns(10);
        email.setBounds(10, 478, 400, 40);  
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
        password.setBounds(424, 478, 400, 40);  
	getContentPane().add(password);   

        /*
        Nota para o tamanho máximo da imagem
        */
        notaImagem = new JLabel("Tamanho da Imagem < 1024 KB");
	notaImagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	notaImagem.setBounds(134, 640, 545, 32); 
	getContentPane().add(notaImagem);

	tamanhoImagem = new JLabel("");
	tamanhoImagem.setToolTipText("Tamanho da Imagem");
	tamanhoImagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tamanhoImagem.setBounds(134, 620, 566, 32);
	getContentPane().add(tamanhoImagem);

	/*
        Label para a foto de perfil
        */
        fotoPerfil = new JLabel();
	fotoPerfil.setToolTipText("Foto do Perfil");
	fotoPerfil.setBorder(new LineBorder(new Color(0, 0, 0)));
	fotoPerfil.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	fotoPerfil.setBounds(10, 536, 100, 120);
	getContentPane().add(fotoPerfil);
	fotoPerfil.setIcon(new ImageIcon("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Perfil_Icon.jpg"));

	/*
        Botão para procurar imagem
        */
        procurar = new JButton("Procurar");
	procurar.addActionListener(this);
	procurar.setFocusable(false);
	procurar.setBackground(new Color(245, 245, 245));
	procurar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	procurar.setBounds(134, 582, 114, 32);
	procurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	getContentPane().add(procurar);

	foto = new JLabel("Foto de Perfil");
	foto.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
	foto.setBounds(136, 548, 150, 21);
	getContentPane().add(foto);

        /*
        Label para escrever o nome do ficheiro escolhido
        */
	nomeFich = new JLabel("Nenhum Ficheiro Escolhido");
	nomeFich.setToolTipText("Nome do Ficheiro");
	nomeFich.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
	nomeFich.setBounds(258, 582, 566, 32);
	getContentPane().add(nomeFich);

        
	/*
        Criação do Botão para efectuar o novo 
        */
        registar = new JButton("Registar");
	registar.setBorder(new EmptyBorder(0, 0, 0, 0));
	registar.setForeground(new Color(255, 255, 255));
	registar.setBackground(new Color(255, 12, 12, 250));
	registar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	registar.addActionListener(this);
	registar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	registar.setBounds(685, 613, 139, 37);
	registar.setFocusable(false);
	getContentPane().add(registar);

        /*
        Mensagem de erro para caso um campo não for preenchido
        */
	error = new JLabel("*Não pode deixar este campo em branco !");
	error.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 0, 0)));
	error.setHorizontalAlignment(SwingConstants.LEFT);
	error.setForeground(new Color(255, 69, 0));
	error.setFont(new Font("Calibri", Font.PLAIN, 16));
	error.setVisible(false);
	error.setBounds(10, 90, 400, 26);
	getContentPane().add(error);
    }
    
    public RegistoDoador(Doador d) {
        this();
	this.doador = d;
        registar.setVisible(false);
	pNome.setText(d.getNome());
	uNome.setText(d.getApelido());
	dataNascimento.setValue(d.getDataNascimentoFormatado());
        
        id.setText("iD :  " + d.getIdString());
        
        
	genero.setSelectedItem(d.getGenero());
        grupoSanguineo.setSelectedItem(d.getGrupoSanguineo());
	peso.setText(String.valueOf(d.getPeso()));
	contacto.setText(String.valueOf(d.getContacto()));
        age.setText(String.valueOf(d.getIdade()) + "");
        bi.setText(d.getBi());
        endereco.setText(d.getEndereco());
        nr.setText(String.valueOf(d.getNumero()));
        bairro.setText(d.getBairro());
        
        if(d.getIndexResp1() == 0){
            resp[0].setSelected(true);
        }else {
            resp[1].setSelected(true);}
        
        if(d.getIndexResp2() == 0){
            resp_1[0].setSelected(true);
        }else {
            resp_1[1].setSelected(true);}
        
        doencas.setSelectedItem(d.getDoenca());
        drogas.setSelectedItem(d.getDroga());
        familiar.setText(d.getNomeF());
        contacto_f.setText(String.valueOf(d.getContactoF()));
        email.setText(d.getEmail());
        password.setText(d.getPass());
	fotoPerfil.setIcon(new ImageIcon(d.getFotoPerfil(100, 120)));
	cabecalho.setText("Atualizar Dados do Doador");
        
        atualizar = new JButton("Atualizar Doador");
	atualizar.setBorder(new EmptyBorder(0, 0, 0, 0));
	atualizar.setForeground(new Color(255, 255, 255));
	atualizar.setBackground(new Color(255, 12, 12, 250));
	atualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
	atualizar.addActionListener(this);
	atualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	atualizar.setBounds(685, 613, 139, 37);
	atualizar.setFocusable(false);
	getContentPane().add(atualizar);

                
	genero.setEnabled(false);
	grupoSanguineo.setEnabled(false);
        dataNascimento.setEnabled(false);
        
        
                
	genero.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		super.paint(g);} });
		 
        grupoSanguineo.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
                setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		super.paint(g);} });
        
        bi.setEditable(false);
        bi.setForeground(Color.BLACK);
        bi.setBackground(Color.LIGHT_GRAY);
        
        
        
        email.setEditable(false);
        email.setForeground(Color.BLACK);
        email.setBackground(Color.LIGHT_GRAY);
      }

	
    
    public static void main(String[] args) {
        RegistoDoador rd = new RegistoDoador();
        rd.setLocationRelativeTo(null);
        rd.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        error.setVisible(false);
	error.setText("*Não pode deixar este campo em branco! ");
        
	if (e.getSource() == procurar){
            FileDialog fd = new FileDialog(this, "Escolha uma foto de perfil", FileDialog.LOAD);
            fd.setDirectory("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Fotos Doador");
            fd.setFile("*.jpeg;*.jpg;*.png;*.tiff;*.tif;*.gif;");
            fd.setLocationRelativeTo(null);
            fd.setVisible(true);
            String strfilename = fd.getFile();
            imagemP = fd.getDirectory() + strfilename;
		
            if(fd.getFile() != null){
                file = new File(imagemP);
		long bytes = file.length();
		if (bytes < 1048576){
                    try {
                        tamanhoImagem.setText(bytes / 1024 + " KB");
			notaImagem.setForeground(new Color(46, 139, 27));
			notaImagem.setText("Tamanho da Imagem < 1024 KB");
			Image image = ImageIO.read(file).getScaledInstance(100, 120, Image.SCALE_SMOOTH);
			fotoPerfil.setIcon(new ImageIcon(image));
			nomeFich.setText(file.getName());	

                    }catch (IOException ex) {
                        file = null;
			nomeFich.setText("Nenhum Ficheiro Escolhido");
			tamanhoImagem.setText("");
			notaImagem.setForeground(Color.red);
			notaImagem.setText("Imagem não suportada");
			ex.printStackTrace();}
                    
                    } else{
                        file = null;
			nomeFich.setText("Nenhum Ficheiro Escolhido");
			tamanhoImagem.setText("");
			notaImagem.setForeground(Color.red);
			notaImagem.setText("Tamanho da imagem é maior que 1 MB");}  } }
        
        
        /*
            Verificação se todos os TextField forão preenchidos e todos os 
        ComboxBox tem uma opção escolhida
        */
        if(e.getSource() == registar){
            DoadorController ddc = new DoadorController();
            validarDados();
            if(grupoSanguineo.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(grupoSanguineo.getX(), grupoSanguineo.getY() + grupoSanguineo.getHeight(),
                        400, 26);}
            
            else if(genero.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(genero.getX(), genero.getY() - genero.getHeight(),
                        400, 26);}
            
            else if(doencas.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(doencas.getX(), doencas.getY() - doencas.getHeight(),
                        400, 26);}
            
            else if(drogas.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(drogas.getX(), drogas.getY() - drogas.getHeight(),
                        400, 26);}
            
            
            else if(pNome.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(pNome.getX(), pNome.getY() - pNome.getHeight(),
                        400, 26);}
            
            else if(uNome.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(uNome.getX(), uNome.getY() - uNome.getHeight(),
                        400, 26);}
            
            else if(contacto.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(contacto.getX(), contacto.getY() + contacto.getHeight(),
                        400, 26);}
            
            else if(peso.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(peso.getX(), peso.getY() + peso.getHeight(),
                        400, 26);}
            
            
            else if(bi.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(bi.getX(), bi.getY() + bi.getHeight(),
                        400, 26);}
            
            
            else if(endereco.getText().isEmpty() || endereco.getText().equals("Endereço da Morada")){
                error.setVisible(true);
                error.setBounds(endereco.getX(), endereco.getY() + endereco.getHeight(),
                        400, 26);}
            
            else if(bairro.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(bairro.getX(), bairro.getY() + bairro.getHeight(),
                        400, 26);}
            
            else if(nr.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(nr.getX(), nr.getY() + nr.getHeight(),
                        400, 26);}
            
            else if(email.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(email.getX(), email.getY() + email.getHeight(),
                        400, 26);}
            
            else if(password.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(password.getX(), password.getY() + password.getHeight(),
                        400, 26);}
                
            else if(familiar.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(familiar.getX(), familiar.getY() + familiar.getHeight(),
                        400, 26);}
            
            else if(contacto_f.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(contacto_f.getX(), contacto_f.getY() + contacto_f.getHeight(),
                        400, 26);}
            
            
            
            else{
                try{
                    Doador d = new Doador();
                    
                    d.setNome(pNome.getText());
                    d.setApelido(uNome.getText());
                    
                    Date date = (Date) dataNascimento.getValue();
                    d.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").format(date));
                    
                    d.setGenero(genero.getSelectedItem() + "");
                    d.setGrupoSanguineo(grupoSanguineo.getSelectedItem() + "");
                    d.setPeso(Float.parseFloat(peso.getText()));
                    
                    int result_1 = 0;
                    result_1 = ddc.verficarContacto(Integer.parseInt(contacto.getText()));
                    if(result_1 != 0){
                        throw new ContactoExistsException();
                    } else{
                    d.setContacto(Integer.parseInt(contacto.getText()));}
                    
                    String age_1 = String.valueOf(dataNascimento.getValue()).trim();
                    String[] age_split = age_1.split(" ");
                    int idade = (Year.now().getValue() - Integer.parseInt(age_split[5]) );
                    age.setText(String.valueOf(idade));
                    
                    
                    d.setIdade(Integer.parseInt(age.getText()));
                    int result_2 = 0;
                    result_2 = ddc.verificarBi(bi.getText());
                    if(result_2 != 0){
                        throw new BiExistsException();
                    }else {
                        d.setBi(bi.getText());}
                    
                    
                    d.setEndereco(endereco.getText());
                    d.setNumero(Integer.parseInt(nr.getText()));
                    d.setBairro(bairro.getText());
                    d.setNomeF(familiar.getText());
                    d.setContactoF(Integer.parseInt(contacto_f.getText()));
                    
                    int result_3 = 0;
                    result_3 = ddc.verificarEmail(email.getText());
                    if(result_3 != 0){
                        throw new EmailExistsException();
                    }else {
                        d.setEmail(email.getText());}
                    
                    d.setIndexResp1(indexResp1);
                    d.setIndexResp2(indexResp2);
                    
                    if(infoDoencas.equals("")){
                        d.setDoenca("");
                    }else {
                        d.setDoenca(doencas.getSelectedItem() + "");}
                    
                    if(infoDrogas.equals("")){
                        d.setDroga("");
                    }else {
                        d.setDroga(drogas.getSelectedItem() + "");}
                    
                    d.setPass(password.getText().trim());
                    d.criarDataRegista();

                    
                    if(file != null){
                        d.setFotoPerfil(ImageIO.read(file));
                    
                    } else if(doador != null){
                        d.setFotoPerfil(doador.getFotoPerfil());
                    } else {
                        file = new File("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Perfil_Icon.jpg");
                        d.setFotoPerfil(ImageIO.read(file));}
                    
                    int result = 0;
                     result = ddc.adicionarDoador(d);
                    if(result != 0){
                        JOptionPane.showMessageDialog(null, "Registo feito com sucesso !", "Novo Registo"
                            , JOptionPane.INFORMATION_MESSAGE);
                        dispose();}
                    
                } catch (BiExistsException ex) {
                    error.setVisible(true);
                    error.setText("*Número de BI já existente na base de dados...!");
                    error.setBounds(bi.getX(), bi.getY() + bi.getHeight(),400, 26);
                    ex.printStackTrace();
                    
                } catch (ContactoExistsException ex){
                    error.setVisible(true);
                    error.setText("*Contacto já existente na base de dados...!");
                    error.setBounds(contacto.getX(), contacto.getY() + contacto.getHeight(),400, 26);
                    ex.printStackTrace();
                    
                } catch (EmailExistsException ex){
                    error.setVisible(true);
                    error.setText("*Conta email já existente na base de dados...!");
                    error.setBounds(email.getX(), email.getY() + email.getHeight(),400, 26);
                    ex.printStackTrace();
                
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        
        
        
        if(e.getSource() == atualizar){
            DoadorController ddc = new DoadorController();
            validarDados();
            if(grupoSanguineo.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(grupoSanguineo.getX(), grupoSanguineo.getY() + grupoSanguineo.getHeight(),
                        400, 26);}
            
            else if(genero.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(genero.getX(), genero.getY() - genero.getHeight(),
                        400, 26);}
            
            else if(doencas.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(doencas.getX(), doencas.getY() - doencas.getHeight(),
                        400, 26);}
            
            else if(drogas.getSelectedIndex() == 0){
                error.setVisible(true);
                error.setBounds(drogas.getX(), drogas.getY() - drogas.getHeight(),
                        400, 26);}
            
            
            else if(pNome.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(pNome.getX(), pNome.getY() - pNome.getHeight(),
                        400, 26);}
            
            else if(uNome.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(uNome.getX(), uNome.getY() - uNome.getHeight(),
                        400, 26);}
            
            else if(contacto.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(contacto.getX(), contacto.getY() + contacto.getHeight(),
                        400, 26);}
            
            else if(peso.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(peso.getX(), peso.getY() + peso.getHeight(),
                        400, 26);}
            
            
            else if(bi.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(bi.getX(), bi.getY() + bi.getHeight(),
                        400, 26);}
            
            
            else if(endereco.getText().isEmpty() || endereco.getText().equals("Endereço da Morada")){
                error.setVisible(true);
                error.setBounds(endereco.getX(), endereco.getY() + endereco.getHeight(),
                        400, 26);}
            
            else if(bairro.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(bairro.getX(), bairro.getY() + bairro.getHeight(),
                        400, 26);}
            
            else if(nr.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(nr.getX(), nr.getY() + nr.getHeight(),
                        400, 26);}
            
            else if(email.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(email.getX(), email.getY() + email.getHeight(),
                        400, 26);}
            
            else if(password.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(password.getX(), password.getY() + password.getHeight(),
                        400, 26);}
                
            else if(familiar.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(familiar.getX(), familiar.getY() + familiar.getHeight(),
                        400, 26);}
            
            else if(contacto_f.getText().isEmpty()){
                error.setVisible(true);
                error.setBounds(contacto_f.getX(), contacto_f.getY() + contacto_f.getHeight(),
                        400, 26);}
            
            
            else{
                try{
                    Doador d = new Doador();
                    String [] mm = id.getText().split(" ");
                    
                    d.setIdString(mm[3]);
                    String [] kk = new String[2];
                    kk = d.getIdString().split("-");
                    int cod = Integer.parseInt(kk[1]);
                    
                    d.setIdNumero(cod);
                    d.setNome(pNome.getText());
                    d.setApelido(uNome.getText());
                    
                    Date date = (Date) dataNascimento.getValue();
                    d.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").format(date));
                    
                    d.setGenero(genero.getSelectedItem() + "");
                    d.setGrupoSanguineo(grupoSanguineo.getSelectedItem() + "");
                    d.setPeso(Float.parseFloat(peso.getText()));
                    d.setContacto(Integer.parseInt(contacto.getText()));
                    
                    String age_1 = String.valueOf(dataNascimento.getValue()).trim();
                    String[] age_split = age_1.split(" ");
                    int idade = (Year.now().getValue() - Integer.parseInt(age_split[5]) );
                    age.setText(String.valueOf(idade));
                    
                    
                    d.setIdade(Integer.parseInt(age.getText()));
                    d.setBi(bi.getText());
                    d.setEndereco(endereco.getText());
                    d.setNumero(Integer.parseInt(nr.getText()));
                    d.setBairro(bairro.getText());
                    d.setNomeF(familiar.getText());
                    d.setContactoF(Integer.parseInt(contacto_f.getText()));
                    d.setEmail(email.getText());
                    d.setDoenca(doencas.getSelectedItem() + "");
                    d.setDroga(drogas.getSelectedItem() + "");
                    d.setPass(password.getText().trim());

                    
                    if(file != null){
                        d.setFotoPerfil(ImageIO.read(file));
                    
                    } else if(doador != null){
                        d.setFotoPerfil(doador.getFotoPerfil());
                    } else {
                        file = new File("C:/Users/eciom/Documents/NetBeansProjects/POO_II_Projecto/Icones/Perfil_Icon.jpg");
                        d.setFotoPerfil(ImageIO.read(file));}
                    
                    int result = 0;
                     result = ddc.atualizarDoador(d);
                    if(result != 0){
                        JOptionPane.showMessageDialog(null, "Atualização feita com sucesso !", "Atualizar Registo"
                            , JOptionPane.INFORMATION_MESSAGE);}
                    
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        
    }
  
    @Override
    public void itemStateChanged(ItemEvent e) {
        for(int i=0; i < resp.length; i++){
            if (e.getSource() == resp[0]){
                indexResp1 = 0;
                infoDoencas = "do";
                doencas.setSelectedIndex(0);
                doencas.setVisible(true);
            } else if(e.getSource() == resp[1]){
                indexResp1 = 1;
                doencas.setSelectedIndex(1);
                doencas.setVisible(false);
                infoDoencas = "";}
                
            if (e.getSource() == resp_1[0]){
                indexResp2 = 0;
                infoDrogas = "dr";
                drogas.setSelectedIndex(0);
                drogas.setVisible(true);
            } else if(e.getSource() == resp_1[1]){
                indexResp2 = 1;
                drogas.setSelectedIndex(1);
                drogas.setVisible(false);
                infoDrogas = "";} }
    }

    class BiExistsException extends Exception {
	public BiExistsException() {
		super("Este número de BI já existe");}}
    
    class EmailExistsException extends Exception{
        public EmailExistsException() {
            super("Já existe alguém com este email ");}}
    
    class ContactoExistsException extends Exception{
        public ContactoExistsException() {
            super("Já existe alguém com este contacto");}}
    
    
    private void validarDados(){
        if((Integer.parseInt(contacto.getText().trim())  > 879999999) || 
                    (Integer.parseInt(contacto.getText().trim())  < 820000000)){
                error.setText("*Contacto inválido!!!");
                error.setVisible(true);
                error.setBounds(contacto.getX(), contacto.getY() + contacto.getHeight(), 400, 26);}
            
        else if((Integer.parseInt(nr.getText().trim())  > 9999) || 
                    (Integer.parseInt(nr.getText().trim())  < 100)){
                error.setText("*Número de Casa fora do intervalo (100 - 9999)!!!");
                error.setVisible(true);
                error.setBounds(nr.getX(), nr.getY() + nr.getHeight(), 400, 26);}
        
        else if((Integer.parseInt(contacto_f.getText().trim())  > 879999999) || 
                    (Integer.parseInt(contacto_f.getText().trim())  < 820000000)){
                error.setText("*Contacto inválido!!!");
                error.setVisible(true);
                error.setBounds(contacto_f.getX(), contacto_f.getY() + contacto_f.getHeight(), 400, 26);}
        
        
        else if((bi.getText().trim().length() > 13)  || (bi.getText().trim().length() < 13)){
                error.setText("*Número de BI inválido!!!");
                error.setVisible(true);
                error.setBounds(bi.getX(), bi.getY() + bi.getHeight(), 400, 26);}
        
        else if(endereco.getText().trim().length() >= 45){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(endereco.getX(), endereco.getY() + endereco.getHeight(), 400, 26);}
        
        else if(bairro.getText().trim().length() >= 45){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(bairro.getX(), bairro.getY() + bairro.getHeight(), 400, 26);}
        
        else if(pNome.getText().trim().length() >= 30){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(pNome.getX(), pNome.getY() + pNome.getHeight(), 400, 26);}
        
        else if(uNome.getText().trim().length() >= 30){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(uNome.getX(), uNome.getY() + uNome.getHeight(), 400, 26);}
        
        else if(familiar.getText().trim().length() >= 60){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(familiar.getX(), familiar.getY() + familiar.getHeight(), 400, 26);}
        
        else if(email.getText().trim().length() >= 50){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(email.getX(), email.getY() + email.getHeight(), 400, 26);}
        
        else if(password.getText().trim().length() >= 50){
                error.setText("*Número máximo de caracteres ultrapassado!!!");
                error.setVisible(true);
                error.setBounds(password.getX(), password.getY() + password.getHeight(), 400, 26);}
        
    }
}
