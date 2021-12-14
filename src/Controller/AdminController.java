/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin.Admin;
import Model.Admin.AdminDAO;

/**
 *
 * @author eciom
 */
public class AdminController {
    Admin a;

    public AdminController() {
    }
    
    public String retornarNome(){
        AdminDAO ad = new AdminDAO();
    return ad.retornarNome();}
    
    public boolean verificarPassowrd(String email, String pass){
        AdminDAO ad = new AdminDAO();
        return ad.verificarPassowrd(email, pass);
    }
}
