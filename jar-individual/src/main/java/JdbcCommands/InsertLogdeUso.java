/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertLogdeUso {
        ConexaoBanco conexao = new ConexaoBanco();
        JdbcTemplate con = conexao.getConnection();
        
        public void insertSql(Integer idMaquina, Integer idUsuario, Integer idEmpresa){
            
            con.update(String.format("insert into LogUso values (%d, %d, %d, null, null, null)", 
                idMaquina, idEmpresa, idUsuario));
            
        }
        
}
