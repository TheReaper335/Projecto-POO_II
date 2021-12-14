/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Doador;

import com.sun.imageio.plugins.common.ImageUtil;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.imageio.ImageIO;

/**
 *
 * @author eciom
 */
public class Doador {
    private String nome, apelido, dataNascimento, genero, grupoSanguineo, bi, endereco, bairro, doenca, droga, nomeF,
            email, pass, dataRegista,id;
    private float peso;
    private int contacto,contactoF, idade, numero;
    private Image fotoPerfil;
    private boolean activo = false;

    public String getNome() {
        return nome;}

    public void setNome(String nome) {
        this.nome = nome;}

    public String getApelido() {
        return apelido;}

    public void setApelido(String apelido) {
        this.apelido = apelido;}

    public String getDataNascimento() {
        return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;}

    public String getGenero() {
        return genero;}

    public void setGenero(String genero) {
        this.genero = genero;}

    public String getGrupoSanguineo() {
        return grupoSanguineo;}

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;}

    public String getBi() {
        return bi;}

    public void setBi(String bi) {
        this.bi = bi;}

    public String getEndereco() {
        return endereco;}

    public void setEndereco(String endereco) {
        this.endereco = endereco;}

    public String getBairro() {
        return bairro;}

    public void setBairro(String bairro) {
        this.bairro = bairro;}

    public String getDoenca() {
        return doenca;}

    public void setDoenca(String doenca) {
        this.doenca = doenca;}

    public String getDroga() {
        return droga;}

    public void setDroga(String droga) {
        this.droga = droga;}

    public String getNomeF() {
        return nomeF;}

    public void setNomeF(String nomeF) {
        this.nomeF = nomeF;}

    public float getPeso() {
        return peso;}

    public void setPeso(float peso) {
        this.peso = peso;}

    public int getContacto() {
        return contacto;}

    public void setContacto(int contacto) {
        this.contacto = contacto;}

    public int getContactoF() {
        return contactoF;}

    public void setContactoF(int contactoF) {
        this.contactoF = contactoF;}

    public int getIdade() {
        return idade;}

    public void setIdade(int idade) {
        this.idade = idade;}

    public int getNumero() {
        return numero;}

    public void setNumero(int numero) {
        this.numero = numero;}

    public String getIdString() {
        return id;}

    public void setIdString(String id) {
        this.id = id;}

    public String getEmail() {
        return email;}

    public void setEmail(String email) {
        this.email = email;}

    public String getPass() {
        return pass;}

    public void setPass(String pass) {
        this.pass = pass;}

    public String getDataRegista() {
        return dataRegista;}

    public void setDataRegista(String dataRegista) {
        this.dataRegista = dataRegista;}

    public Image getFotoPerfil() {
        return fotoPerfil;}

    public void setFotoPerfil(Image fotoPerfil) {
        this.fotoPerfil = fotoPerfil;}

    public boolean getActivo() {
        return activo;}

    public void setActivo(boolean activo) {
        this.activo = activo;}

    public String getId() {
        return id;}

    public void setId(String id) {
        this.id = id;}
    
    
    public void setFotoPerfil(byte[] imagedata){
		this.fotoPerfil=Toolkit.getDefaultToolkit().createImage(imagedata);}
    
    public Image getFotoPerfil(int width,int height){
		return fotoPerfil.getScaledInstance(width, height, Image.SCALE_SMOOTH);}
    
    public Date getDataNascimentoFormatado(){
        Date date=null;
	try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(this.dataNascimento);
	} catch (ParseException e) {
            e.printStackTrace();}
        return date;}
    
    
    public void criarDataRegista(){
        dataRegista = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());}
    
    public String gerarId(){
        return id = "DD-" + (new DoadorDAO().contarDoador() + 1);}
    
    public int idInt(){
        String [] txt = id.split("-");
        int cod = Integer.parseInt(txt[1]);
        return cod;}
    
    
    private static BufferedImage converterImagem(Image im){
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;}
    
    
    public byte[] getFotoPerfilBytes(){
        ByteArrayOutputStream imagedata=new ByteArrayOutputStream();
        BufferedImage bi = converterImagem(fotoPerfil);
	try {
            ImageIO.write(bi, "jpg", imagedata);
	
        } catch (Exception e) {
            e.printStackTrace();}
        
	return imagedata.toByteArray();}
    
    
}
