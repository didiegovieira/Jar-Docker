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
import Jdbc.ConexaoBancoLocal;
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
    
    private ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    private JdbcTemplate conLocal = conexaoBancoLocal.getConnection();
    
    private InsertRegistro inReg = new InsertRegistro();
    
    public void cadastroComponenteExistente(Integer idComponente, Integer idMaquina, Integer idEmpresa){
        List<ComponenteMaquina> compo = con.query(
                "select * from componente_maquina where id_componente = ? and id_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
        
        if(compo.isEmpty()){
            con.update(
                    "insert into componente_maquina (id_componente, id_maquina, id_empresa) VALUES (?, ?, ?);", 
                    idComponente, idMaquina, idEmpresa);
            
            compo = con.query(
                "select * from componente_maquina where id_componente = ? and id_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
            
            

        } else {
            
        }
    }
    
    public void cadastroComponenteNovo(Integer idComponente, Integer idMaquina, Integer idEmpresa){
        List<ComponenteMaquina> compo = con.query(
                "select * from componente_maquina where id_componente = ? and id_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
        
        if(compo.isEmpty()){
            con.update(
                "insert into componente_maquina (id_componente, id_maquina, id_empresa) VALUES (?, ?, ?);", 
                idComponente, idMaquina, idEmpresa);
            
            compo = con.query(
                "select * from componente_maquina where id_componente = ? and id_maquina = ?", 
                new ComponenteMaquinaRowMapper(), idComponente, idMaquina);
            

        } else {

        }
    }
}
