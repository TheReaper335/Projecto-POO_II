
package Model.Usuario;

import JanelaComum.ConexaoBD;
import Model.ValueObjects.Doador;
import Model.ValueObjects.Paciente;
import Model.ValueObjects.Usuario;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class UsuarioDAO {
    Connection con = ConexaoBD.getConexao();

    public int adicionarTempoLoginDoador(Doador d){
        int result = 0;
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
        java.util.Date loginTime = new java.util.Date();
        try{
            String query = "insert into usuario (idUsuario, loginTime, userPerfil) values(?,?,?)";
            PreparedStatement pr=con.prepareStatement(query);
            pr.setInt(1, d.getIdNumero());
            pr.setString(2, f.format(loginTime));
            pr.setString(3, "Doador");
            result = pr.executeUpdate();
				
	}catch(Exception exp) {
            exp.printStackTrace();}
        
        return result;}
    
    
    public int adicionarTempoLoginPaciente(Paciente p){
        int result = 0;
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
        java.util.Date loginTime = new java.util.Date();
        try{
            String query = "insert into usuario (idUsuario, loginTime, userPerfil) values(?,?,?)";
            PreparedStatement pr=con.prepareStatement(query);
            pr.setInt(1, p.getIdNumero());
            pr.setString(2, f.format(loginTime));
            pr.setString(3, "Paciente");
            result = pr.executeUpdate();
				
	}catch(Exception exp) {
            exp.printStackTrace();}
        
        return result;}
    
	
    public ArrayList<Usuario> getUsuarioInfo(String condicao){
        ArrayList <Usuario> lista = new ArrayList<Usuario>();
        try{
            String query = "select idUsuario as 'iD Usuario', loginTime as 'Tempo de Login', userPerfil as 'Perfil do Usuario' from usuario "+condicao+" order by idUsuario";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Usuario user = new Usuario();
                if(rs.getString(3).equals("Doador")){
                    user.setIdUsuario("DD-" + rs.getString(1));
                } else if(rs.getString(3).equals("Paciente")){
                    user.setIdUsuario("PCT-" + rs.getString(1));}
                
		user.setTempoLogin(rs.getString(2));
		user.setPerfilUsuario(rs.getString(3));
		lista.add(user);}
            
            }catch(Exception exp){
                exp.printStackTrace();}
        
        return lista;}
    
    
    
}
