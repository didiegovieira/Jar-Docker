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
public class RedeRowMapper implements RowMapper<Rede>{
    public Rede mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rede objetoRede = new Rede();
        
        objetoRede.setId_rede(rs.getInt("id_rede"));
        objetoRede.setIp(rs.getString("ip"));
        objetoRede.setDriver(rs.getString("driver"));
        objetoRede.setNome(rs.getString("nome"));
        objetoRede.setId_maquina(rs.getInt("id_maquina"));
        objetoRede.setId_empresa(rs.getInt("id_empresa"));

        return objetoRede;
    }
}
