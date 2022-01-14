
package Model.ValueObjects;

import Controller.PacienteController;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.imageio.ImageIO;


public class Paciente {
    private String nome, apelido, dataNascimento, genero, grupoSanguineo, bi, endereco, bairro, nomePai, nomeMae, email,
            password, dataRegista, id;
    private float peso;
    private int contacto,contactoPai, contactoMae, idade, numero, idNumero;
    private Image fotoPerfil;
    private long bytes;
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

    public String getNomePai() {
        return nomePai;}

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;}

    public String getNomeMae() {
        return nomeMae;}

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;}

    public String getEmail() {
        return email;}

    public void setEmail(String email) {
        this.email = email;}

    public String getPassword() {
        return password;}

    public void setPassword(String password) {
        this.password = password;}

    public String getDataRegista() {
        return dataRegista;}

    public void setDataRegista(String dataRegista) {
        this.dataRegista = dataRegista;}

    public String getIdString() {
        return id;}

    public void setIdString(String id) {
        this.id = id;}

    public float getPeso() {
        return peso;}

    public void setPeso(float peso) {
        this.peso = peso;}

    public int getContacto() {
        return contacto;}

    public void setContacto(int contacto) {
        this.contacto = contacto;}

    public int getContactoPai() {
        return contactoPai;}

    public void setContactoPai(int contactoPai) {
        this.contactoPai = contactoPai;}

    public int getContactoMae() {
        return contactoMae;}

    public void setContactoMae(int contactoMae) {
        this.contactoMae = contactoMae;}

    public int getIdade() {
        return idade;}

    public void setIdade(int idade) {
        this.idade = idade;}

    public int getNumero() {
        return numero;}

    public void setNumero(int numero) {
        this.numero = numero;}

    public int getIdNumero() {
        return idNumero;}

    public void setIdNumero(int idNumero) {
        this.idNumero = idNumero;}

    public Image getFotoPerfil() {
        return fotoPerfil;}

    public void setFotoPerfil(Image fotoPerfil) {
        this.fotoPerfil = fotoPerfil;}

    public long getBytes() {
        return bytes;}

    public void setBytes(long bytes) {
        this.bytes = bytes;}

    public boolean isActivo() {
        return activo;}

    public void setActivo(boolean activo) {
        this.activo = activo;}
    
    
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
        PacienteController pc = new PacienteController();
        idNumero = (pc.contarDoador() + 1);
        return id = "PCT-" + idNumero;}

   public int separarId(){
       String [] kk = new String[2];
       kk = id.split("-");
       int cod = Integer.parseInt(kk[1]);
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
