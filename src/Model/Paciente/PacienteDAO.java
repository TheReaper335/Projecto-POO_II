
package Model.Paciente;

import JanelaComum.ConexaoBD;
import Model.ValueObjects.Paciente;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class PacienteDAO {
    Connection con = ConexaoBD.getConexao();
    
    
    public String[] getNomePaciente(String grupo){
        String [] nome = null;
        int i = 0;
        String query = "select nome, apelido from paciente where grupoSanguineo='" + grupo + "'";
        
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            String nome_1, apelido;
            nome = new String[this.getTotalPaciente(grupo) + 1];
            nome[i++] = "--- Selecione o Nome do Paciente ---";
            
            while(rs.next()){
                nome_1 = rs.getString(1);
                apelido = rs.getString(2);
                nome[i++] = nome_1 + " " + apelido;}
            
            return nome;
            
        } catch (Exception ex){
            ex.printStackTrace();}
    return nome;}
    
    /*
    Método para contar os pacientes da base de dado e gerar um código
    */
    public int contarPaciente(){
        int result = 0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from paciente");
            rs.next();
            
            result = rs.getInt(1);
            rs.close();                       
        }catch(Exception exp){
            exp.printStackTrace();}
	return result;}
    
    
    /*
    Método para verificar se existe um paciente com o contacto passado por parâmetro
    */
    public int verficarContacto(int contacto){
        int result = 0;
        String query = " select * from paciente where contacto=" + contacto;
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                result++;}
            
            rs.close();
            st.close();
            return result;
        } catch(Exception e){
            e.printStackTrace();}
        
        return result;}
    
    
    /*
    Método para verificar se existe um paciente com o BI passado por parâmetro
    */
    public int verificarBi(String bi){
        int result = 0;
        String query = " select * from paciente where bi='" + bi +"'";
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                result++;}
            
            rs.close();
            st.close();
            return result;
        } catch(Exception e){
            e.printStackTrace();}
        
        return result;}
    
    
    /*
    Método para verificar se existe um paciente com o email passado por parâmetro
    */
    public int verificarEmail(String email){
        int result=0;
        String query = " select * from paciente where email='" + email +"'";
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next()){
                result++;}
            
            rs.close();
            st.close();
            return result;
        } catch(Exception e){
            e.printStackTrace();}
        
        return result;}

    /*
    Método para mudar a Password do Paciente
    */
    public int mudarPassword(String iD,String password){
	try{
            String query = "update paciente set password='"+ password +"' where idPaciente ="+ iD;
            PreparedStatement pr = con.prepareStatement(query);
            return pr.executeUpdate();
        
        }catch(Exception exp){
            exp.printStackTrace();}
        return 0;}
    
    
    /*
    Método para escrever os dados de um paciente na base de dados
    */
    public int adicionarPaciente(Paciente p){
        int result=0;
	String query = 
                "INSERT INTO paciente (nome, apelido, dataNascimento, genero, grupoSanguineo, peso, contacto, idade, bi, "
                + "endereco, numero, bairro, nomePai, contactoPai, nomeMae, contactoMae, email, password, fotoPerfil,"
                + "activacao, dataRegista)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
        try {
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString (1, p.getNome());
            pr.setString (2, p.getApelido());
            pr.setString (3, p.getDataNascimento());
            pr.setString (4, p.getGenero());
            pr.setString (5, p.getGrupoSanguineo());
            pr.setFloat (6, p.getPeso());
            pr.setInt (7, p.getContacto());
            pr.setInt (8, p.getIdade());
            pr.setString (9, p.getBi());
            pr.setString (10, p.getEndereco());
            pr.setInt (11, p.getNumero());
            pr.setString (12, p.getBairro());
            pr.setString (13, p.getNomePai());
            pr.setInt (14, p.getContactoPai());
            pr.setString (15, p.getNomeMae());
            pr.setInt (16, p.getContactoMae());
            pr.setString(17, p.getEmail());
            pr.setString(18, p.getPassword()); 
            pr.setBytes (19, p.getFotoPerfilBytes());
            pr.setBoolean(20, false);
            pr.setString(21, p.getDataRegista());
            
            result = pr.executeUpdate();
		
            pr.close();
            return result;
        }catch(Exception ex) {
            ex.printStackTrace();}
		
        return result;}
    
    
    /*
    Método para atualizar os dados do paciente na base de dados
    */
    public int atualizarPaciente(Paciente p){
        int result=0;
        String query = "UPDATE paciente SET nome = ?, apelido=?, dataNascimento =?, genero =?, grupoSanguineo=?, "
                        + "peso = ?, contacto=?, idade=?, bi=?, endereco=?, numero=?, bairro=?, nomePai=?, contactoPai=?, "
                        + "nomeMae=?, contactoMae=?, email=?, password=?, fotoPerfil=?, activacao=?  "
                        + "WHERE idPaciente=" + p.getIdNumero() ;
	
	
        try {
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString (1, p.getNome());
            pr.setString (2, p.getApelido());
            pr.setString (3, p.getDataNascimento());
            pr.setString (4, p.getGenero());
            pr.setString (5, p.getGrupoSanguineo());
            pr.setFloat (6, p.getPeso());
            pr.setInt (7, p.getContacto());
            pr.setInt (8, p.getIdade());
            pr.setString (9, p.getBi());
            pr.setString (10, p.getEndereco());
            pr.setInt (11, p.getNumero());
            pr.setString (12, p.getBairro());
            pr.setString (13, p.getNomePai());
            pr.setInt (14, p.getContactoPai());
            pr.setString (15, p.getNomeMae());
            pr.setInt (16, p.getContactoMae());
            pr.setString(17, p.getEmail());
            pr.setString(18, p.getPassword());
            pr.setBytes(19, p.getFotoPerfilBytes());
            pr.setBoolean(20, false);
            
            
            result = pr.executeUpdate();
		
            pr.close();
            return result;
        }catch(Exception ex) {
            ex.printStackTrace();}
		
        return result;}
    
    
    /*
    Método para contabilizar todos os pacientes existentes na base de dados
    */
    public int getTotalPacientes(){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from paciente");
            while(rs.next()){
                totalstudent++;}
            
            rs.close();
            st.close();
	return totalstudent;
        
        }catch(Exception e){
            e.printStackTrace();}
        return totalstudent;}
    
    
    /*
    Método para contabilizar os pacientes com base no seu grupo Sanguíneo
    */
    public int getTotalPaciente(String grupo){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from paciente where grupoSanguineo='" + grupo + "'");
            while(rs.next()){
                totalstudent++;}
            
            rs.close();
            st.close();
	return totalstudent;
        
        }catch(Exception e){
            e.printStackTrace();}
        return totalstudent;}
    
    
    /*
    Método para retornar dados do paciente através do nome, apelido e grupo Sanguíneo
    */
    public Paciente getPacienteInfo (String grupo, String nome, String apelido){
        Paciente p = new Paciente();
	
	String query = " select * from paciente where nome='" + nome +"' and grupoSanguineo='" + grupo + "' and apelido = '" + 
                apelido + "'";
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            p.setIdString("PCT-" + rs.getInt(1));
            p.setNome(rs.getString(2));
            p.setApelido(rs.getString(3));
            p.setDataNascimento(rs.getString(4));
            p.setGenero(rs.getString(5));
            p.setGrupoSanguineo(rs.getString(6));
            p.setPeso(rs.getFloat(7));
            p.setContacto(rs.getInt(8));
            p.setIdade(rs.getInt(9));
            p.setBi(rs.getString(10));
            p.setEndereco(rs.getString(11));
            p.setNumero(rs.getInt(12));
            p.setBairro(rs.getString(13));
            p.setNomePai(rs.getString(14));
            p.setContactoPai(rs.getInt(15));
            p.setNomeMae(rs.getString(16));
            p.setContactoMae(rs.getInt(17));
            p.setEmail(rs.getString(18));
            p.setPassword(rs.getString(19));
            p.setFotoPerfil(rs.getBytes(20));
            p.setActivo(rs.getBoolean(21));
            p.setDataRegista(rs.getString(22));

            return p;
        
        }catch(Exception e){
            e.printStackTrace();}
		return p;}
    
    /*
    Método para retornar dados do paciente através do email e password
    */
    public Paciente getPacienteInfo (String email, String password){
        Paciente p = new Paciente();
	
	String query = " select * from paciente where email='" + email +"' and password='" + password + "'";
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            p.setIdString("PCT-" + rs.getInt(1));
            p.setNome(rs.getString(2));
            p.setApelido(rs.getString(3));
            p.setDataNascimento(rs.getString(4));
            p.setGenero(rs.getString(5));
            p.setGrupoSanguineo(rs.getString(6));
            p.setPeso(rs.getFloat(7));
            p.setContacto(rs.getInt(8));
            p.setIdade(rs.getInt(9));
            p.setBi(rs.getString(10));
            p.setEndereco(rs.getString(11));
            p.setNumero(rs.getInt(12));
            p.setBairro(rs.getString(13));
            p.setNomePai(rs.getString(14));
            p.setContactoPai(rs.getInt(15));
            p.setNomeMae(rs.getString(16));
            p.setContactoMae(rs.getInt(17));
            p.setEmail(rs.getString(18));
            p.setPassword(rs.getString(19));
            p.setFotoPerfil(rs.getBytes(20));
            p.setActivo(rs.getBoolean(21));
            p.setDataRegista(rs.getString(22));

            return p;
        
        }catch(Exception e){
            e.printStackTrace();}
		return p;}
    
    public boolean isActivo(int iD){
        try{
            String query = "select activacao from paciente where idPaciente=" + iD;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            boolean active = rs.getBoolean(1);
            st.close();
            rs.close();
            return active;
                
	}catch(Exception exp){
            exp.printStackTrace();}
	return false;}
    
    /*
    Método para atualizar se o paciente está logado ou não
    */
    public int setActivo(boolean activacao,int iD){
        int result=0;
	try{
            String query = "update paciente set activacao=" + activacao + " where idPaciente=" + iD;
            PreparedStatement pr = con.prepareStatement(query);
            result = pr.executeUpdate();
            pr.close();
        
        }catch(Exception exp){
            exp.printStackTrace();}
        return result;}
    
    /*
    Método para carregar a foto de perfil da base de dados
    */
    public Image getFotoPerfil(int iD){
        Image image=null;
	try{
            String query = "select fotoPerfil from paciente where idPaciente =" + iD;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            byte[] imagedata = rs.getBytes(1);
            image = Toolkit.getDefaultToolkit().createImage(imagedata);
            rs.close();
            st.close();
        
	}catch(Exception exp){
            exp.printStackTrace();}
	return image;}
    
    /*
    Método para contabilizar os pacientes com base no seu nome
    */
    public int getTotalPacientes(String nome){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from paciente where nome='" + nome + "'");
            while(rs.next()){
                totalstudent++;}
            
            rs.close();
            st.close();
	return totalstudent;
        
        }catch(Exception e){
            e.printStackTrace();}
        return totalstudent;}
    /*
    Método para verificar username e password para login
    */
    public boolean verificarPassword (String email,String password){
        boolean result=false;
	try{
            String query = "select count(*) from paciente where email='" + email + "' and password='" + password + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            
            if(rs.getInt(1) == 1){
                result=true;
            }else{
                JOptionPane.showMessageDialog(null, "Email/Username ou Password Incorrecto","Error",JOptionPane.ERROR_MESSAGE);}	
			
	}catch(Exception exp){
            exp.printStackTrace();}
        return result;}
    
    
    
    /*
    Método para retornar dados do paciente através do id
    */
    public Paciente getPacienteInfo (int id){
        Paciente d = new Paciente();
	String query = " select * from paciente where idPaciente = " + id;
        
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            d.setIdString("PCT-" + rs.getInt(1));
            d.setNome(rs.getString(2));
            d.setApelido(rs.getString(3));
            d.setDataNascimento(rs.getString(4));
            d.setGenero(rs.getString(5));
            d.setGrupoSanguineo(rs.getString(6));
            d.setPeso(rs.getFloat(7));
            d.setContacto(rs.getInt(8));
            d.setIdade(rs.getInt(9));
            d.setBi(rs.getString(10));
            d.setEndereco(rs.getString(11));
            d.setNumero(rs.getInt(12));
            d.setBairro(rs.getString(13));
            d.setNomePai(rs.getString(14));
            d.setContactoPai(rs.getInt(15));
            d.setNomeMae(rs.getString(16));
            d.setContactoMae(rs.getInt(17));
            d.setEmail(rs.getString(18));
            d.setPassword(rs.getString(19));
            d.setFotoPerfil(rs.getBytes(20));
            d.setActivo(rs.getBoolean(21));
            d.setDataRegista(rs.getString(22));

            return d;
        
        }catch(Exception e){
            e.printStackTrace();}
		return d;}
    
    /*
    Método para retornar os iD's dos pacientes com base no nome e no grupo Sanguíneo
    */
    public String[] getId(String nome, String grupo){
        String iD[] = null;
	int i = 0;
	String query="select idPaciente from paciente where nome='" + nome +"' and grupoSanguineo ='" + grupo + "' order by idPaciente asc";
	
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int num;
            iD = new String[this.getTotalPacientes(nome)+1];
            iD[i++] = "--- Selecione o iD ---";
            
	while(rs.next()){
            num = rs.getInt(1);
            iD[i++]= "DD-" + num;}
        
	return iD;
        
        }catch(Exception ex){
            ex.printStackTrace();}
        return iD;}
    
    public int apagarRegisto(Paciente p){
        int result = 0;
	String query = "delete from paciente where idPaciente = "+ p.separarId() ;
        try{
            PreparedStatement pr=con.prepareStatement(query);
            result = pr.executeUpdate();
            
        } catch(Exception exp){
            exp.printStackTrace();}
        return result;}
    
    public ResultSet getPacienteInfo(){
        ResultSet rs = null;
	String query = "select concat('PCT-', idPaciente) as 'iD' , concat(nome,' ',apelido) as 'Nome do Paciente', dataNascimento as 'Data de Nascimento', "
                + "genero as 'Gênero', grupoSanguineo as 'Grupo Sanguíneo', bi as 'Bilhete de Identidade' from paciente order by idPaciente asc";
		
	try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        
        }catch(Exception e){
            e.printStackTrace();}
        return rs;}
    
     public ResultSet getPacienteInfo(String condition){
        ResultSet rs = null;
	String query = "select concat('PCT-', idPaciente) as 'iD' , concat(nome,' ',apelido) as 'Nome do Paciente', dataNascimento as 'Data de Nascimento', "
                + "genero as 'Gênero', grupoSanguineo as 'Grupo Sanguíneo', bi as 'Bilhete de Identidade' from paciente " + condition + " order by idPaciente asc";
		
	try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        
        }catch(Exception e){
            e.printStackTrace();}
        return rs;}
     
     
     public String getNomePaciente(int id){
        String name = "";
	try{
            String query = "select concat(nome,' ',apelido) from paciente where idPaciente='"+id+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            name = rs.getString(1);
            
            rs.close();
            st.close();
		
	} catch(Exception exp){
            exp.printStackTrace();}
        
        return name;}
}
