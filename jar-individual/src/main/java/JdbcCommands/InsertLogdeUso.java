/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.LogUso;
import Jdbc.LogUsoRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertLogdeUso {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();

    MaquinaService inMaq = new MaquinaService();
    InsertComponente comp = new InsertComponente();

    List<LogUso> listaLogUso;

    public void validacao(Integer idUser, Integer idEmpresa) {
        listaLogUso = con.query(
                "select * from LogUso where fk_usuario = ? and fk_empresa = ?",
                new LogUsoRowMapper(), idUser, idEmpresa);

        if (listaLogUso.isEmpty()) {
            System.out.println("Indo criar a maquina");
            inMaq.criarMaquinaELog(idEmpresa, idUser);
            
            
        } else {
            con.update("insert into LogUso values (?, ?, ?, null, null, null)",
                    listaLogUso.get(0).getFk_maquina(), idEmpresa, idUser);
            
            conexaoLocal.update(
                "insert into LogUso(fk_maquina, fk_empresa, fk_usuario) values (?, ?, ?)",
                listaLogUso.get(0).getFk_maquina(), idEmpresa, idUser);
            
            InsertComponente comp = new InsertComponente();
            comp.inserirComponenteMaquina(idEmpresa, listaLogUso.get(0).getFk_maquina());
        }
    }

    public void insertSql(Integer idMaquina, Integer idEmpresa, Integer idUser) {
        con.update("insert into LogUso(fk_maquina, fk_empresa, fk_usuario) values (?, ?, ?, null, null, null)",
                idMaquina, idEmpresa, idUser);

        conexaoLocal.query(
            "insert into LogUso(fk_maquina, fk_empresa, fk_usuario) values (?, ?, ?)",
            new LogUsoRowMapper(), idMaquina, idEmpresa, idUser);
        
    }
}

