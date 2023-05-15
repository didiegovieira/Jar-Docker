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
        
        System.out.println("1 SQL / 2 MySql");
        Integer escolha = leitor.nextInt();
        String email = "";
        String senha = "";
        
        switch (escolha) {
            case 1:
                System.out.println("-".repeat(30));
                System.out.println("Teste Sql pela Azure");

                System.out.println("email");
                email = leitor.nextLine();

                System.out.println("senha");
                senha = leitor.nextLine();

                select.selectAndInsert(email, senha);
                break;
                
            case 2:
                System.out.println("-".repeat(30));
                System.out.println("Teste Sql Local");

                System.out.println("email");
                email = leitor.nextLine();

                System.out.println("senha");
                senha = leitor.nextLine();

                select.selectAndInsertLocal(email, senha);
                break;
                
            default:
                System.out.println("Opção inválida. Selecione 1 ou 2.");
                break;
                
        }
        
        
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
