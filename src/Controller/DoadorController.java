/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Doador.Doador;
import Model.Doador.DoadorDAO;

/**
 *
 * @author eciom
 */
public class DoadorController {

    public Doador getDoadorInfo(String grupo, String nome, String apelido) {
        DoadorDAO dd = new DoadorDAO();
        return dd.getDoadorInfo(grupo, nome, apelido);}
    
    public String[] getiD(String nomeD, String grupo){
        DoadorDAO dd = new DoadorDAO();
        return dd.getId(nomeD, grupo);}
    
    public int apagarRegisto(Doador d){
        DoadorDAO dd = new DoadorDAO();
        return dd.apagarRegisto(d);}
    
    public int adicionarDoador(Doador d){
        DoadorDAO dd = new DoadorDAO();
        return dd.adicionarDoador(d);}
    
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
    
} 
