
package JanelaComum;

import java.sql.*;


public class ConexaoBD {
    static Connection con = null;
    static final String url="jdbc:mysql://localhost:3306/banco_sangue_poo";
    static final String uNome = "root";
    static final String password="admin";
    
    public void encerarConexao(){
        try {
            con.close();                        //Método para encerrar a conexão da Base de Dados
	} catch (SQLException e) {
            e.printStackTrace();} }
    
    public static Connection getConexao(){
        if(con!=null){
            return con;
        } else{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");                 //Método para conectar a Base de Dados
		con = DriverManager.getConnection(url,uNome,password);
		return con;
		}catch(Exception e){
                    e.printStackTrace();
                    return con;} }  }
    
    public static boolean verificarConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");                       //     Método para vericar se a Conexão está ligada
            con = DriverManager.getConnection(url,uNome,password);       // nou desligada
            return true;                                                    
        
        }catch(Exception e){
            e.printStackTrace();
            return false;}  }
    	
    
}
