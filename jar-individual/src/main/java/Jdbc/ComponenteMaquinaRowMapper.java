/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author diego
 */
public class ComponenteMaquinaRowMapper implements RowMapper<ComponenteMaquina>{
    public ComponenteMaquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        ComponenteMaquina objetoComponenteMaquina = new ComponenteMaquina();
        
        objetoComponenteMaquina.setId_componenteMaquina(rs.getInt("id_componenteMaquina"));
        objetoComponenteMaquina.setFk_componente(rs.getInt("fk_componente"));
        objetoComponenteMaquina.setFk_maquina(rs.getInt("fk_maquina"));

        return objetoComponenteMaquina;
    }
}
