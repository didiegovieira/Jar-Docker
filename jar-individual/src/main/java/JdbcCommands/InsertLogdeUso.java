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
        
        public void insertSql(String idMaquina, String idUsuario, String idEmpresa){
            
            
            
            con.update("insert into LogUso values (?, ?, ?, null, null, null)", 
                idMaquina, idEmpresa, idUsuario);
            
        }
        
}
