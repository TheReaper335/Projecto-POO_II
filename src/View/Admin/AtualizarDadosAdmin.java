
package View.Admin;

import Controller.AdminController;
import Model.ValueObjects.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public class AtualizarDadosAdmin extends JDialog implements ActionListener{
    private static AtualizarDadosAdmin dialog;
    private final JPanel contentPanel = new JPanel();
    private JTextField nomeField, usernameField, contactoField, enderecoField, biField, bairroField;
    private JPasswordField passwordField;
    private File file; private char z;
    private String imagepath = null;
    private JButton btAtualizar, procurar;
    private JLabel Errorlabel;
    public Admin a;
    public AdminView av;
    private AdminController ac;

    public AtualizarDadosAdmin(Admin a, AdminView av) {
        super(dialog, "", Dialog.ModalityType.APPLICATION_MODAL);
	this.av = av;
	this.a = a;
        ac = new AdminController();
        
	setResizable(false);
	setSize(570, 695);
	getContentPane().setLayout(new BorderLayout());
        
	contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	contentPanel.setBackground(new Color(255, 255, 255));
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);

	JLabel cabecalho = new JLabel("Editar Perfil do Administrador");
	cabecalho.setOpaque(true);
	cabecalho.setForeground(new Color(255, 255, 255));
	cabecalho.setBackground(new Color(255, 12, 12, 250));
	cabecalho.setFont(new Font("Segoe UI", Font.BOLD, 25));
	cabecalho.setHorizontalAlignment(SwingConstants.CENTER);
	cabecalho.setBounds(0, 0, 564, 58);
	contentPanel.add(cabecalho);

	JLabel adminNome = new JLabel("Nome do Admin   :");
	adminNome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminNome.setHorizontalAlignment(SwingConstants.RIGHT);
	adminNome.setBounds(10, 90, 146, 35);
	contentPanel.add(adminNome);

	nomeField = new JTextField(a.getNome());
	nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	nomeField.setBounds(166, 88, 388, 38);
	contentPanel.add(nomeField);
	nomeField.setColumns(10);

	JLabel adminBI = new JLabel("Nº BI  :");
	adminBI.setHorizontalAlignment(SwingConstants.RIGHT);
	adminBI.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminBI.setBounds(10, 147, 146, 35);
	contentPanel.add(adminBI);

	biField = new JTextField(a.getBi());
	biField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	biField.setColumns(10);
	biField.setBounds(166, 145, 388, 38);
	contentPanel.add(biField);

	JLabel adminContacto = new JLabel("Contacto  :");
	adminContacto.setHorizontalAlignment(SwingConstants.RIGHT);
	adminContacto.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminContacto.setBounds(10, 208, 146, 35);
	contentPanel.add(adminContacto);

	contactoField = new JTextField(String.valueOf(a.getContacto()));
	contactoField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	contactoField.setColumns(10);
	contactoField.setBounds(166, 205, 388, 38);
	contentPanel.add(contactoField);

	JLabel adminEmail = new JLabel("Email/Username  :");
	adminEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	adminEmail.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminEmail.setBounds(10, 268, 146, 35);
	contentPanel.add(adminEmail);

	usernameField = new JTextField(a.getEmail());
	usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	usernameField.setColumns(10);
	usernameField.setBounds(166, 265, 388, 38);
	contentPanel.add(usernameField);

	JLabel adminPass = new JLabel("Password  :");
	adminPass.setHorizontalAlignment(SwingConstants.RIGHT);
	adminPass.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminPass.setBounds(10, 327, 146, 35);
	contentPanel.add(adminPass);

	passwordField = new JPasswordField(a.getPass());
	passwordField.setBorder(new LineBorder(Color.GRAY));
	passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	passwordField.setBounds(166, 328, 313, 38);
        contentPanel.add(passwordField);
        z = passwordField.getEchoChar();

        
	JButton btShow = new JButton("Show");
	btShow.setForeground(new Color(255, 255, 255));
	btShow.setBorder(new EmptyBorder(0, 0, 0, 0));
	btShow.setFocusable(false);
	btShow.setFocusPainted(false);
	btShow.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btShow.setBackground(new Color(255, 12, 12, 250));
	btShow.setBounds(483, 328, 71, 38);
        
	btShow.addActionListener(e -> {
            if (btShow.getText().equals("Show")) {
                passwordField.setEchoChar((char)0);
		btShow.setText("Hide");
            } else {
		passwordField.setEchoChar(z);
		btShow.setText("show");}  });
	contentPanel.add(btShow);

	JLabel adminEndereco = new JLabel("Endereço  :");
	adminEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
	adminEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminEndereco.setBounds(10, 383, 146, 35);
	contentPanel.add(adminEndereco);

	
	enderecoField = new JTextField(a.getMorada());
	enderecoField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	enderecoField.setColumns(10);
	enderecoField.setBounds(166, 387, 388, 38);
	contentPanel.add(enderecoField);
        
        JLabel adminBairro = new JLabel ("Bairro   :");
        adminBairro.setHorizontalAlignment(SwingConstants.RIGHT);
	adminBairro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	adminBairro.setBounds(10, 448, 146, 35);
	contentPanel.add(adminBairro);
        
        
        bairroField = new JTextField(a.getBairro());
	bairroField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	bairroField.setColumns(10);
	bairroField.setBounds(166, 448, 388, 38);
	contentPanel.add(bairroField);
	
        JLabel fotoPerfilLabel = new JLabel("");
	fotoPerfilLabel.setToolTipText("Foto Petfil");
	fotoPerfilLabel.setBorder(new LineBorder(Color.GRAY));
	fotoPerfilLabel.setIcon(new ImageIcon(a.getPerfilFoto(120, 120)));
	fotoPerfilLabel.setHorizontalAlignment(SwingConstants.CENTER);
	fotoPerfilLabel.setBounds(21, 500, 120, 120);
	contentPanel.add(fotoPerfilLabel);

	JLabel lblLogo = new JLabel("Foto de Perfil");
	lblLogo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	lblLogo.setBounds(166, 500, 111, 24);
	contentPanel.add(lblLogo);

	JLabel tamanhoFoto = new JLabel("");
	tamanhoFoto.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tamanhoFoto.setBounds(269, 500, 232, 24);
	contentPanel.add(tamanhoFoto);

	procurar = new JButton("Pesquisar");
	procurar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	procurar.setForeground(Color.BLACK);
	procurar.addActionListener(this);
	procurar.setFocusable(false);
	procurar.setBackground(new Color(245, 245, 245));
	procurar.setBounds(166, 540, 137, 35);
	procurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	contentPanel.add(procurar);

	JLabel nomeFich = new JLabel("Nenhum Ficheiro Escolhido");
	nomeFich.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	nomeFich.setBounds(308, 545, 246, 24);
	contentPanel.add(nomeFich);

	JLabel notaImagem = new JLabel("Tamanho da Imagem < 1024 KB");
	notaImagem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
	notaImagem.setBounds(166, 586, 250, 24);
	contentPanel.add(notaImagem);

	btAtualizar = new JButton("Atualizar Dados");
	btAtualizar.setFocusPainted(false);
	btAtualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btAtualizar.setBorder(new EmptyBorder(0, 0, 0, 0));
	btAtualizar.setForeground(new Color(255, 255, 255));
	btAtualizar.setBackground(new Color(255, 12, 12, 250));
	btAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
	btAtualizar.setBounds(417, 620, 139, 37);
	btAtualizar.addActionListener(this);
	contentPanel.add(btAtualizar);

	Errorlabel = new JLabel("*Não pode deixar este campo em branco !");
	Errorlabel.setVisible(false);
	Errorlabel.setForeground(Color.RED);
	Errorlabel.setFont(new Font("Arial", Font.PLAIN, 14));
	Errorlabel.setBounds(233, 45, 225, 17);
	contentPanel.add(Errorlabel);

	procurar.addActionListener(e -> {
            FileDialog fd = new FileDialog(this, "Escolha a Foto", FileDialog.LOAD);
            fd.setDirectory("C:\\Downloads");
            fd.setFile("*.jpeg;*.jpg;*.png;*.tiff;*.tif;*.gif;");
            fd.setLocationRelativeTo(null);
            fd.setVisible(true);
            String ficheiroNome = fd.getFile();
            imagepath = fd.getDirectory() + ficheiroNome;
            
            if (!imagepath.isEmpty()) {
                 file = new File(imagepath);}

            if (ficheiroNome != null) {
                long bytes = file.length();
		if (bytes < 1048576) {
                    try {
                        tamanhoFoto.setText(bytes / 1024 + " KB");
			notaImagem.setForeground(new Color(46, 139, 27));
			notaImagem.setText("Tamanho da Imagem < 1024 KB");
			Image image = ImageIO.read(file);
			fotoPerfilLabel.setIcon(new ImageIcon(image.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
                            
                    } catch (IOException ex) {
                        file = null;
			nomeFich.setText("Nenhum Ficheiro Escolhido");
			tamanhoFoto.setText("");
			notaImagem.setForeground(Color.red);
			notaImagem.setText("Imagem não suportada");
			ex.printStackTrace();}
                            
                    nomeFich.setText(file.getName());
                    } else {
                    
                    file = null;
                    nomeFich.setText("Nenhum Ficheiro Escolhido");
                    tamanhoFoto.setText("");
                    notaImagem.setForeground(Color.red);
                    notaImagem.setText("Tamanho da imagem é maior que 1 MB");} }    });
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAtualizar) {
            if (nomeField.getText().isEmpty()) {
                mostrarError(nomeField);
            
            } else if (usernameField.getText().isEmpty()) {
                mostrarError(usernameField);
                
            } else if (contactoField.getText().isEmpty()) {
		mostrarError(contactoField);
		
            } else if (enderecoField.getText().isEmpty()) {
		mostrarError(enderecoField);
		
            } else if (passwordField.getPassword().toString().isEmpty()) {
		mostrarError(passwordField);
		
            } else if (biField.getText().isEmpty()) {
		mostrarError(biField);
		
            } else {
                Admin ad = new Admin();
		ad.setNome(nomeField.getText().trim());
		ad.setEmail(usernameField.getText().trim());
		ad.setContacto(Integer.parseInt(contactoField.getText().trim()));
		ad.setMorada(enderecoField.getText().trim());
                ad.setBairro(bairroField.getText().trim());
		ad.setPass(String.valueOf(passwordField.getPassword()).trim());
		ad.setBi(biField.getText());
                
                if(file!=null) {
                    try {
                        ad.setPerfilFoto(ImageIO.read(file));
                        
                    } catch (Exception exp) {
                        exp.printStackTrace();}
                    
                    } else {
                        ad.setPerfilFoto(a.getPerfilFoto());}
                
                int result = 0;
                result = ac.atualizarAdminInfo(ad);
                
		if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Atualização de dados feita com sucesso !", "Atualização de Dados"
                            , JOptionPane.INFORMATION_MESSAGE);
                    
                    av.app.setVisible(false);
                    av.app = new AdminPerfilPainel(av);
                    av.app.setLocation(250, 0);
                    av.app.setVisible(true);
                    av.contentPane.add(av.app);
                    //av.setCollageDetails();
                    this.dispose();}  }
		}
        
    }
    
    public void mostrarError(JComponent tf) {
        Errorlabel.setVisible(true);
	Errorlabel.setText("*Não pode deixar este campo em branco !");
	Errorlabel.setBounds(tf.getX(), tf.getY() + tf.getHeight() - 5, 400, 26);}
    
    
}
