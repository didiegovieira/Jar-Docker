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
 * @author diegovieira
 */
public class ComponenteRowMapper implements RowMapper<ComponenteClass>{
    public ComponenteClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        ComponenteClass componente = new ComponenteClass();
        
        componente.setNomeComponente(rs.getString("nomeComponente"));
        componente.setId_componente(rs.getString("id_componente"));
        
        return componente;
    }
}
