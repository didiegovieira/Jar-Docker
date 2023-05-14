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
public class UsuarioRowMapper implements RowMapper<Usuario>{
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario objetoUsuario = new Usuario();
        
        objetoUsuario.setPID(rs.getString("PID"));
        objetoUsuario.setEmail(rs.getString("email"));
        objetoUsuario.setSenha(rs.getString("senha"));
        objetoUsuario.setIdEmpresa(rs.getString("id_empresa"));

        return objetoUsuario;
    }
}