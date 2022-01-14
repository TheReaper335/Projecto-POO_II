
package Controller;

import Model.ValueObjects.Admin;
import Model.Admin.AdminDAO;


public class AdminController {
    Admin a;

    
    public String retornarNome(){
        AdminDAO ad = new AdminDAO();
    return ad.retornarNome();}
    
    public boolean verificarPassowrd(String email, String pass){
        AdminDAO ad = new AdminDAO();
        return ad.verificarPassowrd(email, pass);}
    
    public Admin getAdminInfo(){
        AdminDAO ad = new AdminDAO();
        return ad.getAdminInfo();}
    
    public int atualizarAdminInfo(Admin aa){
        AdminDAO ad = new AdminDAO();
        return ad.atualizarAdminInfo(aa);}
    
    public int setActivo(boolean active){
        AdminDAO ad = new AdminDAO();
        return ad.setActivo(active);}
    
    
}
