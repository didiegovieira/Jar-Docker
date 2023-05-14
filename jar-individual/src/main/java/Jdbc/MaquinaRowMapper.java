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
public class MaquinaRowMapper implements RowMapper<MaquinaClass>{
    public MaquinaClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        MaquinaClass maquina = new MaquinaClass();
        
        maquina.setIdMaquina(rs.getString("id_maquina"));
        maquina.setIdEmpresa(rs.getString("id_empresa"));

        return maquina;
    }
}
