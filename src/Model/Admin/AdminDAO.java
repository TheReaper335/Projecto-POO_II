
package Model.Admin;

import JanelaComum.ConexaoBD;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author eciom
 */
public class AdminDAO {
    Connection con = ConexaoBD.getConexao();
    
    /*
    Método para verificar se um administrador está activo
    */
    public boolean isActivo(String nome){
        try{
            String query = "SELECT activacao FROM admin";
            java.sql.Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getBoolean(1);
        }catch(Exception exp){
            exp.printStackTrace();}
	return false;}
    
    
    public Admin getAdminInfo(){
        Admin a = new Admin();
	try { 
            String query = "SELECT * FROM admin ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            
            a.setNome(rs.getString(1));
            a.setMorada(rs.getString(2));
            a.setBairro(rs.getString(3));
            a.setBi(rs.getString(4));                   // Método para carregar dados do administrador da base de dados
            a.setPerfilFoto(rs.getBytes(5));
            a.setActivo(rs.getBoolean(6));
            a.setEmail(rs.getString(7));
            a.setPass(rs.getString(8));

            }catch(Exception exp){
                exp.printStackTrace();
            }
        return a;}
    
    
    public String retornarNome(){
        String txt = "";
        try{
            String query = "SELECT nome FROM admin";
            java.sql.Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);            // Método para carregar o nome do administrador
            rs.next();
            txt = rs.getString(1);
        }catch(Exception exp){
            exp.printStackTrace();}
	return txt;
    }
    
    /*
    Método para login, para verificar se o username e o password estão correctos
    */
    public boolean verificarPassowrd(String username_email, String password){
        Admin a = this.getAdminInfo();
	username_email = username_email.trim(); 
        
	if(a.getEmail().equals(username_email) && a.getPass().equals(password)){
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Email/Username ou Password Incorrecto","Error",JOptionPane.ERROR_MESSAGE);}
            return false;}
    
    
    public int setActivo(boolean status){
        int result = 0;
        try{
            String query = "update admin set activacao="+status;
            PreparedStatement ps = con.prepareStatement(query);
            result = ps.executeUpdate();
            ps.close();         // Método para mudar a informação que o administrador está activo ou não
        }catch(Exception exp){
            exp.printStackTrace();                      
        }
	return result;}
    
    public Image getFotoPerfil(){
        try{
            String query="select logo from admin";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            byte[] imagedata=rs.getBytes(1);                   //Método para carregar a foto do perfil do Administrador
            Image image=Toolkit.getDefaultToolkit().createImage(imagedata); 
            return image;                                 
        
        }catch(Exception exp){
            exp.printStackTrace();}
        return null;}
    
    
    public int atualizarPassword(Admin a){
        int result = 0;
	try{
            String query="UPDATE admin SET password = ?";
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString(1, a.getPass());
            result = pr.executeUpdate();                      // Método para atualizar password do administrador 
            
	}catch(Exception exp){
            exp.printStackTrace();}        
        return result;}
    
    public int atualizarAdminInfo(Admin a){	
        int result=0;
	try{
            String query = "UPDATE admin SET nome = ?, morada = ?, bairro = ?, bi=?, activacao = ?, email=?, password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getMorada());
            ps.setString(3, a.getBairro());             // Atualizar Dados do Admin na tabela
            ps.setString(4, a.getBi());
            ps.setBoolean(5, a.getActivo());
            ps.setString(6, a.getEmail());
            ps.setString(7, a.getPass());
            result = ps.executeUpdate();
        
        }catch(Exception exp){
            exp.printStackTrace();}
        return result;}
    
}
