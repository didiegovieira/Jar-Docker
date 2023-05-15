/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ComponenteClass;
import Jdbc.ComponenteRowMapper;
import Jdbc.ConexaoBanco;
import Looca.ShowCPU;
import Looca.ShowDisco;
import Looca.ShowRede;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertComponente {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    ShowDisco disco = new ShowDisco();
    ShowCPU cpu = new ShowCPU();
    ShowRede rede = new ShowRede();
    
    SelectUser user = new SelectUser();
    
    public void insertSql(){
        //Validação da CPU
        List<ComponenteClass> validation;
        validation = con.query("select nomeComponente from Componente where nomeComponente = ?", 
                new ComponenteRowMapper(), cpu.nomeCpu());
        
        
            System.out.println("Registrando Cpu");
            con.update(
                    "insert into Componente values (?, ?, 'Cpu', ?, null, ?, null)", 
                cpu.nomeCpu(), cpu.fabricanteCpu(), cpu.frequenciaCpu(), cpu.modeloCpu());
            
            //Insert ComponenteMaquina:
            List<ComponenteClass> maq = con.query("select * from Componente max(id)", 
                new BeanPropertyRowMapper(ComponenteClass.class));
            user.componenteMaquina(maq.get(0).getId_componente());
            
        
        //Validation do DISCO
        validation = con.query("select nomeComponente from Componente where nomeComponente = ?", 
                new ComponenteRowMapper(), disco.nomeDisco());
        
            System.out.println("Registrando Disco");
            con.update(
                    "insert into Componente values (?, null, 'Disco', null, null, null, null)", 
                disco.nomeDisco());
           
             //Insert ComponenteMaquina:
                maq = con.query("select * from Componente max(id)", 
                new BeanPropertyRowMapper(ComponenteClass.class));
            user.componenteMaquina(maq.get(0).getId_componente());
            
        
        //Validation da Rede
        validation = con.query("select nomeComponente from Componente where nomeComponente = ?", 
                new ComponenteRowMapper(), rede.nomeRede());
        
            System.out.println("Registrando Rede");
            con.update(
                    "insert into Componente values (?, null, 'Rede', null, ?, null, ?)", 
                rede.nomeRede(),rede.ipRede(), rede.driverRede());

             //Insert ComponenteMaquina:
                maq = con.query("select * from Componente max(id)", 
                new BeanPropertyRowMapper(ComponenteClass.class));
            user.componenteMaquina(maq.get(0).getId_componente());
            
        
        
    }
    
    public void insertMysql(){
        
        
       
        
    }
}
