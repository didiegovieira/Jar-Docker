/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author dusda
 */
public class LogGenerator {
    
    // procura o tmp do so (pasta temporaria)
    private String tmp = System.getProperty("java.io.tmpdir") + "/logs/";
    
    private String lerArquivo(String caminho) throws IOException{
        //ler todo o conteudo dentro do arquivo :)
        byte[] arquivoEmByte = Files.readAllBytes(Path.of(caminho));
        return new String(arquivoEmByte,StandardCharsets.UTF_8);
    }
    
    // validando se aquele diretorio existe, caso não exista criamos.
    private FileWriter criarArquivo(String nome)throws IOException{
        Path logs = Path.of(tmp);
        if(!(Files.exists(logs) && Files.isDirectory(logs))){
            Files.createDirectory(Path.of(tmp));
        }
        return new FileWriter(tmp + nome);
    }
    
    // verifica se o arquivo existe, se existe adiciona mais uma linha.
    public void escreverArquivo(String texto){
       try{
           // gera um arquivo por dia :)
           String arquivo = LocalDate.now().toString() + "_GeneratedData.txt";
           if(new File(Paths.get(tmp + arquivo).toString()).exists()){
               texto = String.format("%s\n%s - %s",lerArquivo(Paths.get(tmp + arquivo).toString()),LocalDateTime.now().toString(),texto);
           }else{
               texto = String.format("%s - %s",LocalDateTime.now().toString(),texto);
           }
           FileWriter novoArquivo = criarArquivo(arquivo);
           novoArquivo.write(texto);
           novoArquivo.close();
       }catch(IOException e){
           System.out.println(e);
       }
    }
}
