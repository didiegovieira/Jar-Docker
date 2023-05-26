/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class ConexaoBancoLocal {
    private JdbcTemplate connection;
    
    public  ConexaoBancoLocal() {
       BasicDataSource dataSource = new BasicDataSource();

       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://172.20.0.2:3306/banco1?useSSL=false");
       dataSource.setUsername("diego");
       dataSource.setPassword("urubu100");

       this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {
        return connection;

    }
}
