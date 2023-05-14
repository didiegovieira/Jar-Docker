/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Individual;

import Looca.*;
import Jdbc.*;
import JdbcCommands.InsertMaquina;
import JdbcCommands.SelectUser;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class JarIndividual {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        JdbcTemplate conexao = conexaoBanco.getConnection();
        JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
        List<Usuario> listaObjetoUsuario; 
        
        SelectUser select = new SelectUser();
        
        System.out.println("-".repeat(30));
        System.out.println("teste sql na azure");
        
        System.out.println("login");
        String email = leitor.nextLine();
        
        System.out.println("senha");
        String senha = leitor.nextLine();
        
        select.selectAndInsert(email, senha);
        
        
//        listaObjetoUsuario = conexao.query("select * from Usuario where email = ? and senha = ?", 
//                new UsuarioRowMapper(), email, senha);
//
//        if (listaObjetoUsuario.stream().anyMatch(usuario ->
//                usuario.getEmailUsuario().equalsIgnoreCase(email)
//                        && usuario.getSenhaUsuario().equals(senha))) {
//            System.out.println("Login deu certo!");
//        } else {
//            System.out.println("Deu errado");
//        }
    }
    
}
