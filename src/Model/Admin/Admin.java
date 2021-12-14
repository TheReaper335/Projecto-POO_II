/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Admin;

import com.sun.imageio.plugins.common.ImageUtil;
import java.awt.*;
import java.awt.image.*;
/**
 *
 * @author eciom
 */
public class Admin {
    private String nome, morada, bi, bairro, email, pass;
    private Image perfilFoto;
    private boolean activo=false;
    
    

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

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
    
    /*public BufferedImage getRoundedProfilePic(int width,int height,int radius){
        BufferedImage imagem =  ImageUtil.makeRoundedCorner(ImageUtil.toBufferedImage(perfilFoto.getScaledInstance(width, height, Image.SCALE_SMOOTH)), radius);
;
		return imagem;	}*/
    
    
}
