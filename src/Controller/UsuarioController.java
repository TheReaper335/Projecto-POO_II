
package Controller;

import Model.Usuario.UsuarioDAO;
import Model.ValueObjects.Doador;
import Model.ValueObjects.Paciente;
import Model.ValueObjects.Usuario;
import java.util.ArrayList;


public class UsuarioController {
    
    public ArrayList<Usuario> getUsuarioInfo (String condicao){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getUsuarioInfo(condicao);}
    
    public int adicionarTempoLoginPaciente(Paciente p){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.adicionarTempoLoginPaciente(p);}
    
    public int adicionarTempoLoginDoador(Doador d){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.adicionarTempoLoginDoador(d);}
    
    
}
