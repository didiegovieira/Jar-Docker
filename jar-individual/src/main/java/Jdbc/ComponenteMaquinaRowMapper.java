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
public class ComponenteMaquinaRowMapper implements RowMapper<ComponenteMaquinaClass>{
    public ComponenteMaquinaClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        ComponenteMaquinaClass componente = new ComponenteMaquinaClass();
        
        componente.setIdComponente(rs.getString("id_componente"));
        componente.setIdMaquina(rs.getString("id_maquina"));
        componente.setIdEmpresa(rs.getString("id_empresa"));
        
        return componente;
    }
}
