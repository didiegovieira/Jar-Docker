/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.Maquina;
import Jdbc.MaquinaRowMapper;
import Jdbc.Usuario;
import Jdbc.UsuarioRowMapper;
import Looca.ShowSistema;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertMaquina {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    
    InsertLogdeUso log = new InsertLogdeUso();
    
    ShowSistema sis = new ShowSistema();
    
    public void insertSql(Integer idEmpresa, Integer idUser){
        String so = sis.showSistema().getSistemaOperacional();
        Integer arquitetura = sis.showSistema().getArquitetura();
        String fabricante = sis.showSistema().getFabricante();

        List<Usuario> validation;
        validation = con.query("select fk_empresa from Maquina where fk_empresa = ?", 
                new UsuarioRowMapper(), idEmpresa);
        System.out.println(validation);
        if (validation.isEmpty()){
            System.out.println("Registrando Maquina");

            con.update("insert into Maquina values (?, ?, ?, ?)", 
                so, arquitetura, fabricante, idEmpresa);

            List<Maquina> maquina;
            maquina = con.query("select * from Maquina",
                new MaquinaRowMapper());
            Integer idMaquina = 0;
            for (int i = maquina.size() - 1; i >= 0; i--){
                idMaquina = maquina.get(i).getId_maquina();
                break;
            }

            log.insertSql(idMaquina, idEmpresa, idUser);

        } else {
            System.out.println("Algo deu errado");
        }
    }

   
}
