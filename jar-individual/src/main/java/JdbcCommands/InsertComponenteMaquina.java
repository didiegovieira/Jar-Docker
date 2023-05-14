/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.MaquinaClass;
import Jdbc.Usuario;
import Jdbc.UsuarioRowMapper;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertComponenteMaquina {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    List<MaquinaClass> maq;
    InsertRegistro reg = new InsertRegistro();

    public void insertSql(Integer idComponente){
        List<MaquinaClass> maq = con.query("select * from Maquina max(id)", 
                new BeanPropertyRowMapper(MaquinaClass.class));
        
        Integer idMaquina = Integer.parseInt(maq.get(0).getIdMaquina());
        Integer idEmpresa = Integer.parseInt(maq.get(0).getIdEmpresa());
        
        con.update("insert into ComponenteMaquina values (?, ?, ?)", 
            idComponente, idMaquina, idEmpresa);
        
        reg.insertSqlCpu(idComponente, idMaquina, idEmpresa);
        reg.insertSqlDisco(idComponente, idMaquina, idEmpresa);
        reg.insertSqlRede(idComponente, idMaquina, idEmpresa);
        reg.insertSqlRam(idComponente, idMaquina, idEmpresa);
    }
}
