/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Individual;

import Looca.*;
import Jdbc.*;
import JdbcCommands.SelectUser;
import Suport.LogGenerator;
import Suport.SlackApi;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class JarIndividual {
    public static void main(String[] args) throws IOException {
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
        ShowRede rede = new ShowRede();
        ShowMemoria mem = new ShowMemoria();
        ShowDisco disco = new ShowDisco();
        ShowSistema sis = new ShowSistema();
        
//        JSONObject json = new JSONObject();
//        LogGenerator log = new LogGenerator();
//        json.put("text", "O limite de 80% de uso de disco foi atingido!");
//        try {
//            SlackApi.sendMessage(json);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(JarIndividual.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        log.escreverArquivo(
//                            String.format(
//                                "Sistema Operacional: %s\n"
//                                + "Arquitetura: %s\n"
//                                + "Fabricante: %s\n\n", 
//                                sis.showSistema().getSistemaOperacional(),
//                                sis.showSistema().getArquitetura(),
//                                sis.showSistema().getFabricante()));

        
        
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
