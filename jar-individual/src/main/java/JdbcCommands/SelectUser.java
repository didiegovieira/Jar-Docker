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
    ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    JdbcTemplate conexao = conexaoBanco.getConnection();
    JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    List<Usuario> listaObjetoUsuario;
    
    InsertMaquina inMaquina = new InsertMaquina();
    InsertComponente inComp = new InsertComponente();
    InsertComponenteMaquina inCompMaq = new InsertComponenteMaquina();
    
    String emailSave = null;
    String senhaSave = null;
    
    public void selectAndInsert(String email, String senha){
        
        
        //Select no Usuario
        listaObjetoUsuario = conexao.query(
                "select * from Usuario where email = ? and senha = ?", 
                new UsuarioRowMapper(), email, senha);
        
        //Mensagem se login deu certo
        if (listaObjetoUsuario.stream().anyMatch(usuario ->
                usuario.getEmailUsuario().equalsIgnoreCase(email)
                        && usuario.getSenhaUsuario().equals(senha))) {
            System.out.println("Login deu certo!");
        } else {
            System.out.println("Deu errado");
        }
        
        //Insert na tabela de Maquina
        Usuario id = listaObjetoUsuario.get(0);
        Integer idEmpresa = Integer.valueOf(id.getIdEmpresa());
        Integer idUsuario = Integer.valueOf(id.getPID());
        
        this.emailSave = email;
        this.senhaSave = senha;
        
        inMaquina.insertSql(idEmpresa, idUsuario);
        
        //Insert na tabela de Componentes
        inComp.insertSql();
        
        
    }
        //Insert na tabela ComponenteMaquina
        public void componenteMaquina(Integer componente){
            inCompMaq.insertSql(componente);
        }
}
