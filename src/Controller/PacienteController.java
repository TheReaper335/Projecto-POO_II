
package Controller;

import Model.Paciente.PacienteDAO;
import Model.ValueObjects.Paciente;
import java.sql.ResultSet;


public class PacienteController {
    
    public String getNomePaciente(int cod){
        PacienteDAO pd = new PacienteDAO();
        return pd.getNomePaciente(cod);}
    
    public int contarDoador(){
        PacienteDAO pd = new PacienteDAO();
        return pd.contarPaciente();}
    
    public int getTotalPacientes(){
        PacienteDAO pd = new PacienteDAO();
        return pd.getTotalPacientes();}
    
    public int verficarContacto(int contacto){
        PacienteDAO pd = new PacienteDAO();
        return pd.verficarContacto(contacto);}
    
    public int verificarBi(String bi){
        PacienteDAO pd = new PacienteDAO();
        return pd.verificarBi(bi);}
    
    
    public int verificarEmail(String email){
        PacienteDAO pd = new PacienteDAO();
        return pd.verificarEmail(email);}
    
    public int adicionarPaciente(Paciente p){
        PacienteDAO pd = new PacienteDAO();
        return pd.adicionarPaciente(p);}
    
    public int atualizarPaciente(Paciente p){
        PacienteDAO pd = new PacienteDAO();
        return pd.atualizarPaciente(p);}
    
    public Paciente getPacienteInfo(String grupo, String nome, String apelido) {
        PacienteDAO pd = new PacienteDAO();
        return pd.getPacienteInfo(grupo, nome, apelido);}
    
    public String[] getNomeByGrupos(String grupo){
        PacienteDAO pd = new PacienteDAO();
        return pd.getNomePaciente(grupo);} 
    
    public int apagarRegisto(Paciente p){
        PacienteDAO pd = new PacienteDAO();
        return pd.apagarRegisto(p);}
    
    public Paciente getPacienteInfo(int id){
        PacienteDAO pd = new PacienteDAO();
        return pd.getPacienteInfo(id);}
    
    public ResultSet getPacienteInfo(){
        PacienteDAO pd = new PacienteDAO();
        return pd.getPacienteInfo();}
    
    public ResultSet getPacienteInfo(String condition){
        PacienteDAO pd = new PacienteDAO();
        return pd.getPacienteInfo(condition);}
    
    public boolean verificarPassword(String email, String pass){
        PacienteDAO pd = new PacienteDAO();
        return pd.verificarPassword(email, pass);}
    
    public Paciente getPacienteInfo (String email, String password){
        PacienteDAO pd = new PacienteDAO();
        return pd.getPacienteInfo(email, password);}
    
    
}
