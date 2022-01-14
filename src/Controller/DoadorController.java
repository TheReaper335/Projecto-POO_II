
package Controller;


import Model.ValueObjects.Doador;
import Model.Doador.DoadorDAO;
import java.sql.ResultSet;


public class DoadorController {
    
    public boolean verificarPassword(String email, String pass){
        DoadorDAO dd = new DoadorDAO();
        return dd.verificarPassword(email, pass);}
    
    public String getNomeDoador(int cod){
        DoadorDAO dd = new DoadorDAO();
        return dd.getNomeDoador(cod);}
    
    public int totalDoadores(){
        DoadorDAO dd = new DoadorDAO();
        return dd.getTotalDoadores();}

    public Doador getDoadorInfo(String grupo, String nome, String apelido) {
        DoadorDAO dd = new DoadorDAO();
        return dd.getDoadorInfo(grupo, nome, apelido);}
    
    public Doador getDoadorInfo(int id){
        DoadorDAO dd = new DoadorDAO();
        return dd.getDoadorInfo(id);}
    
    public String[] getiD(String nomeD, String grupo){
        DoadorDAO dd = new DoadorDAO();
        return dd.getId(nomeD, grupo);}
    
    public int apagarRegisto(Doador d){
        DoadorDAO dd = new DoadorDAO();
        return dd.apagarRegisto(d);}
    
    public int adicionarDoador(Doador d){
        DoadorDAO dd = new DoadorDAO();
        return dd.adicionarDoador(d);}
    
    public int atualizarDoador(Doador d){
        DoadorDAO dd = new DoadorDAO();
        return dd.atualizarDoador(d);}
    
    public int verficarContacto(int contacto){
        DoadorDAO dd = new DoadorDAO();
        return dd.verficarContacto(contacto);}
    
    
    public int verificarBi(String bi){
        DoadorDAO dd = new DoadorDAO();
        return dd.verificarBi(bi);}
    
    
    public int verificarEmail(String email){
        DoadorDAO dd = new DoadorDAO();
        return dd.verificarEmail(email);}
    
    public String[] getNomeByGrupos(String grupo){
        DoadorDAO dd = new DoadorDAO();
        return dd.getNomeDoador(grupo);} 
    
    public ResultSet getDoadorInfo(){
        DoadorDAO dd = new DoadorDAO();
        return dd.getDoadorInfo();}
    
    public ResultSet getDoadorInfo(String condition){
        DoadorDAO dd = new DoadorDAO();
        return (ResultSet) dd.getDoadorInfo(condition);}
    
    public int contarDoador(){
        DoadorDAO dd = new DoadorDAO();
        return dd.contarDoador();}
    
    public Doador getDoadorInfo (String email, String pass){
        DoadorDAO dd = new DoadorDAO();
        return dd.getDoadorInfo(email, pass);}
} 
