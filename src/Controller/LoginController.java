
package Controller;

import JanelaComum.ConexaoBD;


public class LoginController {
    public boolean verificarConexao(){
        return ConexaoBD.verificarConexao();
    }
}
