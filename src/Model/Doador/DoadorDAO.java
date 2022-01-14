
package Model.Doador;


import Model.ValueObjects.Doador;
import JanelaComum.ConexaoBD;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class DoadorDAO {
    Connection con = ConexaoBD.getConexao();
    
    public int contarDoador(){
        int result = 0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from doador");
            rs.next();
            
            result = rs.getInt(1);
            rs.close();                       // Método para contar os doadores da base de dado e gerar um código
        }catch(Exception exp){
            exp.printStackTrace();}
	return result;}
    
    public void fecharConexao() throws SQLException{        //Método para fechar conexão
        con.close();}
    
    
    public int adicionarDoador(Doador d){
        int result=0;
	String query = 
                "INSERT INTO doador (nome, apelido, dataNascimento, genero, grupoSanguineo, peso, contacto, idade, bi, "
                + "endereco, numero, bairro, doenca, droga, nomeFamiliar, contactoFamiliar, email, password, fotoPerfil,"
                + "activacao, dataRegista)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
        try {
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString (1, d.getNome());
            pr.setString (2, d.getApelido());
            pr.setString (3, d.getDataNascimento());
            pr.setString (4, d.getGenero());
            pr.setString (5, d.getGrupoSanguineo());
            pr.setFloat (6, d.getPeso());
            pr.setInt (7, d.getContacto());
            pr.setInt (8, d.getIdade());
            pr.setString (9, d.getBi());
            pr.setString (10, d.getEndereco());
            pr.setInt (11, d.getNumero());
            pr.setString (12, d.getBairro());
            pr.setString (13, d.getDoenca());
            pr.setString (14, d.getDroga());
            pr.setString (15, d.getNomeF());
            pr.setInt (16, d.getContactoF());
            pr.setString(17, d.getEmail());
            pr.setString(18, d.getPass()); 
            pr.setBytes (19, d.getFotoPerfilBytes());
            pr.setBoolean(20, false);
            pr.setString(21, d.getDataRegista());
            
            result = pr.executeUpdate();
		
            pr.close();
            return result;
        }catch(Exception ex) {
            ex.printStackTrace();}
		
        return result;}
    
    
    public int atualizarDoador(Doador d){
        int result=0;
        String query = "UPDATE doador SET nome = ?, apelido=?, dataNascimento =?, genero =?, grupoSanguineo=?, "
                        + "peso = ?, contacto=?, idade=?, bi=?, endereco=?, numero=?, bairro=?, doenca=?, droga=?, nomeFamiliar=?,"
                        + "contactoFamiliar=?, email=?, password=?, fotoPerfil=?, activacao=?  WHERE idDoador=" + d.getIdNumero() ;
	
	
        try {
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString (1, d.getNome());
            pr.setString (2, d.getApelido());
            pr.setString (3, d.getDataNascimento());
            pr.setString (4, d.getGenero());
            pr.setString (5, d.getGrupoSanguineo());
            pr.setFloat (6, d.getPeso());
            pr.setInt (7, d.getContacto());
            pr.setInt (8, d.getIdade());
            pr.setString (9, d.getBi());
            pr.setString (10, d.getEndereco());
            pr.setInt (11, d.getNumero());
            pr.setString (12, d.getBairro());
            pr.setString (13, d.getDoenca());
            pr.setString (14, d.getDroga());
            pr.setString (15, d.getNomeF());
            pr.setInt (16, d.getContactoF());
            pr.setString(17, d.getEmail());
            pr.setString(18, d.getPass());
            pr.setBytes(19, d.getFotoPerfilBytes());
            pr.setBoolean(20, false);
            
            
            
            result = pr.executeUpdate();
		
            pr.close();
            return result;
        }catch(Exception ex) {
            ex.printStackTrace();}
		
        return result;}
    
    public int apagarRegisto(Doador d){
        int result = 0;
	String query = "delete from doador where idDoador = "+ d.separarId() ;
        try{
            PreparedStatement pr=con.prepareStatement(query);
            result = pr.executeUpdate();
            
        } catch(Exception exp){
            exp.printStackTrace();}
        return result;}
    

    /*
    Método para contabilizar todos os doadores existentes na base de dados
    */
    public int getTotalDoadores(){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from doador");
            while(rs.next()){
                totalstudent++;}
            
            rs.close();
            st.close();
	return totalstudent;
        
        }catch(Exception e){
            e.printStackTrace();}
        return totalstudent;}
    
    
    /*
    Método para contabilizar os doadores com base no seu nome
    */
    public int getTotalDoadores(String nome){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from doador where nome='" + nome + "'");
            while(rs.next()){
                totalstudent++;}
            
            rs.close();
            st.close();
	return totalstudent;
        
        }catch(Exception e){
            e.printStackTrace();}
        return totalstudent;}
    
    
    /*
    Método para contabilizar os doadores com base no seu grupo Sanguíneo
    */
    public int getTotalDoador(String grupo){
        int totalstudent=0;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from doador where grupoSanguineo='" + grupo + "'");
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
            String query = "select count(*) from doador where email='" + email + "' and password='" + password + "'";
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
    Método para verificar se o doador está logado ou não
    */
    public boolean isActivo(int iD){
        try{
            String query = "select activacao from doador where idDoador=" + iD;
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
    Método para atualizar se o doador está logado ou não
    */
    public int setActivo(boolean activacao,int iD){
        int result=0;
	try{
            String query = "update doador set activacao=" + activacao + " where idDoador=" + iD;
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
            String query = "select fotoPerfil from doador where idDoador =" + iD;
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
    Método para mudar a Password do Doador
    */
    public int mudarPassword(String iD,String password){
	try{
            String query = "update doador set password='"+ password +"' where idDoador ="+ iD;
            PreparedStatement pr = con.prepareStatement(query);
            return pr.executeUpdate();
        
        }catch(Exception exp){
            exp.printStackTrace();}
        return 0;}
    
    
    /*
    Método para retornar os iD's dos doadores com base no nome e no grupo Sanguíneo
    */
    public String[] getId(String nome, String grupo){
        String iD[] = null;
	int i = 0;
	String query="select idDoador from doador where nome='" + nome +"' and grupoSanguineo ='" + grupo + "' order by idDoador asc";
	
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            int num;
            iD = new String[this.getTotalDoadores(nome)+1];
            iD[i++] = "--- Selecione o iD ---";
            
	while(rs.next()){
            num = rs.getInt(1);
            iD[i++]= "DD-" + num;}
        
	return iD;
        
        }catch(Exception ex){
            ex.printStackTrace();}
        return iD;}
    
    
    
    /*
    Método para retornas todos os nomes dos doadores de um grupo Sanguíneo
    */
    public String[] getNomeDoador(String grupo){
        String [] nome = null;
        int i = 0;
        String query = "select nome, apelido from doador where grupoSanguineo='" + grupo + "'";
        
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            String nome_1, apelido;
            nome = new String[this.getTotalDoador(grupo) + 1];
            nome[i++] = "--- Selecione o Nome do Doador ---";
            
            while(rs.next()){
                nome_1 = rs.getString(1);
                apelido = rs.getString(2);
                nome[i++] = nome_1 + " " + apelido;}
            
            return nome;
            
        } catch (Exception ex){
            ex.printStackTrace();}
    return nome;}
    
    
    /*
    Método para retornar dados do doador através do nome, apelido e grupo Sanguíneo
    */
    public Doador getDoadorInfo (String grupo, String nome, String apelido){
        Doador d = new Doador();
	
	String query = " select * from doador where nome='" + nome +"' and grupoSanguineo='" + grupo + "' and apelido = '" + 
                apelido + "'";
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            d.setIdString("DD-" + rs.getInt(1));
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
            d.setDoenca(rs.getString(14));
            d.setDroga(rs.getString(15));
            d.setNomeF(rs.getString(16));
            d.setContactoF(rs.getInt(17));
            d.setEmail(rs.getString(18));
            d.setPass(rs.getString(19));
            d.setFotoPerfil(rs.getBytes(20));
            d.setActivo(rs.getBoolean(21));
            d.setDataRegista(rs.getString(22));

            return d;
        
        }catch(Exception e){
            e.printStackTrace();}
		return d;}
    
    
    /*
    Método para retornar dados do doador através do id
    */
    public Doador getDoadorInfo (int id){
        Doador d = new Doador();
	String query = " select * from doador where idDoador = " + id;
        
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            d.setIdString("DD-" + rs.getInt(1));
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
            d.setDoenca(rs.getString(14));
            d.setDroga(rs.getString(15));
            d.setNomeF(rs.getString(16));
            d.setContactoF(rs.getInt(17));
            d.setEmail(rs.getString(18));
            d.setPass(rs.getString(19));
            d.setFotoPerfil(rs.getBytes(20));
            d.setActivo(rs.getBoolean(21));
            d.setDataRegista(rs.getString(22));

            return d;
        
        }catch(Exception e){
            e.printStackTrace();}
		return d;}
    
    
    /*
    Método para retornar dados do doador através do email e password
    */
    public Doador getDoadorInfo (String email, String password){
        Doador d = new Doador();
	String query = " select * from doador where email = '" + email + "' and password = '" + password + "'";
        
	try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            
            d.setIdString("DD-" + rs.getInt(1));
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
            d.setDoenca(rs.getString(14));
            d.setDroga(rs.getString(15));
            d.setNomeF(rs.getString(16));
            d.setContactoF(rs.getInt(17));
            d.setEmail(rs.getString(18));
            d.setPass(rs.getString(19));
            d.setFotoPerfil(rs.getBytes(20));
            d.setActivo(rs.getBoolean(21));
            d.setDataRegista(rs.getString(22));

            return d;
        
        }catch(Exception e){
            e.printStackTrace();}
		return d;}
    
    /*
    Método para verificar se existe um doador com o contacto passado por parâmetro
    */
    public int verficarContacto(int contacto){
        int result = 0;
        String query = " select * from doador where contacto=" + contacto;
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
    Método para verificar se existe um doador com o BI passado por parâmetro
    */
    public int verificarBi(String bi){
        int result = 0;
        String query = " select * from doador where bi='" + bi +"'";
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
    Método para verificar se existe um doador com o email passado por parâmetro
    */
    public int verificarEmail(String email){
        int result=0;
        String query = " select * from doador where email='" + email +"'";
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
    
    
    public ResultSet getDoadorInfo(){
        ResultSet rs = null;
	String query = "select concat('DD-', idDoador) as 'iD' , concat(nome,' ',apelido) as 'Nome do Doador', dataNascimento as 'Data de Nascimento', "
                + "genero as 'Gênero', grupoSanguineo as 'Grupo Sanguíneo', bi as 'Bilhete de Identidade' from doador order by idDoador asc";
		
	try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        
        }catch(Exception e){
            e.printStackTrace();}
        return rs;
    }
    
    
    public ResultSet getDoadorInfo(String condition){
        ResultSet rs = null;
	String query = "select concat('DD-', idDoador) as 'iD' , concat(nome,' ',apelido) as 'Nome do Doador', dataNascimento as 'Data de Nascimento', "
                + "genero as 'Gênero', grupoSanguineo as 'Grupo Sanguíneo', bi as 'Bilhete de Identidade' from doador " + condition + " order by idDoador asc";
		
	try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        
        }catch(Exception e){
            e.printStackTrace();}
        return rs;
    }
    
    
    public String getNomeDoador(int id){
        String name = "";
	try{
            String query = "select concat(nome,' ',apelido) from doador where idDoador='"+id+"'";
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
