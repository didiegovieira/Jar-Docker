/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.Componente;
import Jdbc.ComponenteMaquina;
import Jdbc.ComponenteMaquinaRowMapper;
import Jdbc.ComponenteRowMapper;
import Jdbc.ConexaoBanco;
import Jdbc.UsuarioRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diego
 */
public class InsertComponenteMaquina {
    private ConexaoBanco conexao = new ConexaoBanco();
    private JdbcTemplate con = conexao.getConnection();
    private InsertRegistro inReg = new InsertRegistro();
    
    public void cadastroComponenteExistente(String idComponente, String idMaquina){
        List<ComponenteMaquina> compo = con.query(
                "select * from ComponenteMaquina where fk_componente = ? and fk_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
        
        if(compo.isEmpty()){
            con.update("insert into ComponenteMaquina (fk_componente, fk_maquina) VALUES (?, ?);", idComponente, idMaquina);
            
            compo = con.query(
                "select * from ComponenteMaquina where fk_componente = ? and fk_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
            
            inReg.insertSqlCpu(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlDisco(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRam(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRede(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);

        } else {
            inReg.insertSqlCpu(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlDisco(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRam(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRede(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
        }
    }
    
    public void cadastroComponenteNovo(String idComponente, String idMaquina){
        List<ComponenteMaquina> compo = con.query(
                "select * from ComponenteMaquina where fk_componente = ? and fk_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
        
        if(compo.isEmpty()){
            con.update("insert into ComponenteMaquina (fk_componente, fk_maquina) VALUES (?, ?);", idComponente, idMaquina);

            compo = con.query(
                "select * from ComponenteMaquina where fk_componente = ? and fk_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
            
            inReg.insertSqlCpu(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlDisco(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRam(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRede(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);

        } else {
            inReg.insertSqlCpu(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlDisco(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRam(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
            inReg.insertSqlRede(idComponente, compo.get(0).getId_componenteMaquina(), idMaquina);
        }
    }
}
