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
        Scanner leitor2 = new Scanner(System.in);
        
        ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        JdbcTemplate conexao = conexaoBanco.getConnection();
        JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
        
        SelectUser select = new SelectUser();
        
        Integer escolha;
        
        ShowCPU cpu = new ShowCPU();
        ShowTemp temp = new ShowTemp();
        
        //System.out.println(cpu.clockCpu());
        //System.out.println(temp.showTemp());
        //System.out.println(cpu.usoCpu());
        
        do {
            System.out.println("1 SQL / 2 MySql");
            escolha = leitor.nextInt();
            
            switch (escolha) {
            case 1:
                System.out.println("-".repeat(30));
                System.out.println("Teste Sql pela Azure");

                System.out.println("email");
                String email = leitor2.nextLine();

                System.out.println("senha");
                String senha = leitor2.nextLine();

                select.selectAndInsert(email, senha);
                break;
                
            case 2:
                System.out.println("-".repeat(30));
                System.out.println("Teste Sql Local");

                System.out.println("email");
                String emailLocal = leitor2.nextLine();

                System.out.println("senha");
                String senhaLocal = leitor2.nextLine();

                //select.selectAndInsertLocal(emailLocal, senhaLocal);
                break;
                
            default:
                System.out.println("Opção inválida. Selecione 1 ou 2.");
                break;
                
            }   
        } while (escolha != 0);
        
    }
    
}
