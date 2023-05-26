/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.Usuario;
import Jdbc.UsuarioRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class SelectUser {
    private Boolean loginValido = false;
        
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    JdbcTemplate conexao = conexaoBanco.getConnection();
    List<Usuario> listaObjetoUsuario;
    
    InsertLogdeUso inLogUso = new InsertLogdeUso();
    
    
    public void selectAndInsert(String email, String senha){
        
        //Select no Usuario
        listaObjetoUsuario = conexao.query(
                "select * from usuario where email = ? and senha = ?", 
                new UsuarioRowMapper(), email, senha);
        
        //Mensagem se login deu certo
        if (listaObjetoUsuario.stream().anyMatch(usuario ->
                usuario.getEmailUsuario().equalsIgnoreCase(email)
                        && usuario.getSenhaUsuario().equals(senha))) {
            
            loginValido = true;


        } else {
            //Mensagem se login deu errado
            
            loginValido = false;

        }
        
    }
    
    public Boolean isLoginValido() {
        return loginValido;
    }
    
                //Insert na tabela de Maquina
//            Usuario id = listaObjetoUsuario.get(0);
//            System.out.println(id);
//            Integer idUser = id.getId_usuario();
//            Integer idEmpresa = id.getFk_empresa();
//            inLogUso.validacao(idUser, idEmpresa);
}
