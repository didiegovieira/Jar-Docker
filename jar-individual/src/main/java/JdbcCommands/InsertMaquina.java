/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.MaquinaClass;
import Jdbc.MaquinaRowMapper;
import Jdbc.Usuario;
import Jdbc.UsuarioRowMapper;
import Looca.ShowSistema;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertMaquina {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    InsertLogdeUso log = new InsertLogdeUso();
    
    ShowSistema sis = new ShowSistema();
    
    public void insertSql(String id, String user){
        String so = sis.showSistema().getSistemaOperacional();
        Integer arquitetura = sis.showSistema().getArquitetura();
        String fabricante = sis.showSistema().getFabricante();
        
//        List<Usuario> validation;
//        validation = con.query("select id_empresa from Maquina where id_empresa = ?", 
//                new UsuarioRowMapper(), id);
        
//        if (validation.stream().anyMatch(usuario ->
//                usuario.getIdEmpresa().equalsIgnoreCase(id))) {
//            
//            System.out.println("Maquina ja Existe");
//            
//            List<MaquinaClass> maq = con.query("select * from Maquina where id_empresa = ?", 
//                new MaquinaRowMapper(), id);
//            log.insertSql(maq.get(0).getIdMaquina(), 
//                    user, id);
//            
//            
//            
//        } else {
            System.out.println("Registrando Maquina");
            
            con.update("insert into Maquina values (?, null, ?, ?, ?)", 
                so, arquitetura, fabricante, id);

//            List<MaquinaClass> maq = con.query("select * from Maquina max(id)", 
//                new BeanPropertyRowMapper(MaquinaClass.class));
//            log.insertSql(maq.get(0).getIdMaquina(), 
//                    user, id);
            
            
            
        //}
        
    }
    
    public void insertMysql(){
        String so = sis.showSistema().getSistemaOperacional();
        Integer arquitetura = sis.showSistema().getArquitetura();
        String fabricante = sis.showSistema().getFabricante();
        
        con.update("insert into Maquina values (null, ?, ?, ?)", 
                so, arquitetura, fabricante);
        
    }
}
