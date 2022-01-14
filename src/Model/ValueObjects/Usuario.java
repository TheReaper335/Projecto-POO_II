
package Model.ValueObjects;

import Controller.*;
import java.text.*;

import java.util.*;


public class Usuario {
    private String dataLogin;
    private String tempoLogin;
    private String idUsuario;
    private String perfilUsuario;
    private DoadorController dc;
    private PacienteController pc;

    public Usuario() {
        dc = new DoadorController();
        pc = new PacienteController();}
    
    

    public String getDataLogin() {
        if(getDataAtual().equals(dataLogin)){
            return "Hoje";}
        
        return dataLogin;}

    public void setDataLogin(String dataLogin) {
        this.dataLogin = dataLogin;}

    public String getTempoLogin() {
        return tempoLogin;}

    public void setTempoLogin(String tempoLogin) {
        SimpleDateFormat tempoFormat = new SimpleDateFormat("hh:mm aaa");
	SimpleDateFormat dataFormat =new SimpleDateFormat("dd-MMM,yyyy");
	SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
	Date data;
	try {
            data = format.parse(tempoLogin);
            this.tempoLogin = tempoFormat.format(data);
            this.dataLogin = dataFormat.format(data);
	} catch (ParseException e) {
            e.printStackTrace();}
        }

    public String getIdUsuario() {
        return idUsuario;}

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;}

    public String getPerfilUsuario() {
        return perfilUsuario;}

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;}
    
    public String getDataAtual(){
        Date data = new Date();
	SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MMM,yyyy");
	String date = dataFormat.format(data);
	return date;}
    
    public String getNome() {
        if(getPerfilUsuario().equals("Doador")){
            String [] kk = new String[2];
            kk = idUsuario.split("-");
            int cod = Integer.parseInt(kk[1]);
            
            return dc.getNomeDoador(cod);}
		
        else if(getPerfilUsuario().equals("Paciente")){
            String [] kk = new String[2];
            kk = idUsuario.split("-");
            int cod = Integer.parseInt(kk[1]);
            
            return pc.getNomePaciente(cod);}
        return "-";}
    
    public int separarId(){
        int cod=0;
        if(getPerfilUsuario().equals("Doador")){
            String [] kk = new String[2];
            kk = idUsuario.split("-");
            cod = Integer.parseInt(kk[1]);}
		
        else if(getPerfilUsuario().equals("Paciente")){
            String [] kk = new String[2];
            kk = idUsuario.split("-");
            cod = Integer.parseInt(kk[1]);}
   return cod;}
}
