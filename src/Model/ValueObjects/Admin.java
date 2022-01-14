
package Model.ValueObjects;

import com.sun.imageio.plugins.common.ImageUtil;
import java.awt.*;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Admin {
    private String nome, morada, bi, bairro, email, pass, lastLogin;
    private int contacto;
    private Image perfilFoto;
    private boolean activo=false;
    
    

    public String getBairro() {
        return bairro;}

    public void setBairro(String bairro) {
        this.bairro = bairro;}

    public String getNome() {
        return nome;}

    public void setNome(String nome) {
        this.nome = nome;}

    public String getMorada() {
        return morada;}

    public void setMorada(String morada) {
        this.morada = morada;}

    public String getBi() {
        return bi;}

    public void setBi(String bi) {
        this.bi = bi;}

    public boolean getActivo() {
        return activo;}

    public void setActivo(boolean activo) {
        this.activo = activo;}

    public Image getPerfilFoto() {
        return perfilFoto;}
    
    public Image getPerfilFoto(int width,int height){
        return perfilFoto.getScaledInstance(width, height, Image.SCALE_SMOOTH);}

    public void setPerfilFoto(Image perfilFoto) {
        this.perfilFoto = perfilFoto;}

    public void setPerfilFoto(byte[] imagedata){
        this.perfilFoto = Toolkit.getDefaultToolkit().createImage(imagedata);}

    public String getEmail() {
        return email;}

    public void setEmail(String email) {
        this.email = email;}

    public String getPass() {
        return pass;}

    public void setPass(String pass) {
        this.pass = pass;}

    public String getLastLogin() {
        return lastLogin;}

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;}

    public int getContacto() {
        return contacto;}

    public void setContacto(int contacto) {
        this.contacto = contacto;}
    
    private static BufferedImage converterImagem(Image im){
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;}
    
    
    public byte[] getFotoPerfilBytes(){
        ByteArrayOutputStream imagedata = new ByteArrayOutputStream();
        BufferedImage bi = converterImagem(perfilFoto);
	try {
            ImageIO.write(bi, "jpg", imagedata);
	
        } catch (Exception e) {
            e.printStackTrace();}
        
	return imagedata.toByteArray();}
    
    /*public BufferedImage getRoundedProfilePic(int width,int height,int radius){
        return ImageUtil.makeRoundedCorner(ImageUtil.toBufferedImage(perfilFoto.getScaledInstance(width, height, Image.SCALE_SMOOTH)), radius);}
    */
    
}
