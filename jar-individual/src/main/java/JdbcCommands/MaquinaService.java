/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.Maquina;
import Jdbc.MaquinaRowMapper;
import Looca.ShowSistema;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diego
 */
public class MaquinaService {
    private ConexaoBanco conexao = new ConexaoBanco();
    private JdbcTemplate con = conexao.getConnection();
    
    private ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    private JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    
    public void criarMaquinaELog(Integer idEmpresa, Integer idUser) {
        ShowSistema sis = new ShowSistema();
        String so = sis.showSistema().getSistemaOperacional();
        Integer arquitetura = sis.showSistema().getArquitetura();
        String fabricante = sis.showSistema().getFabricante();

        List<Maquina> maquinas = con.query("select * from maquina where id_empresa = ?", 
                new MaquinaRowMapper(), idEmpresa);

        if (maquinas.isEmpty()) {
            System.out.println("Registrando Maquina");

            con.update("insert into maquina values (?, ?, ?, ?)", 
                    so, arquitetura, fabricante, idEmpresa);
            
            Integer idMaquina = buscarUltimaMaquinaId();
            if (idMaquina != null) {
                inserirLogUso(idMaquina, idEmpresa, idUser);
            }
        } else {
            Integer idMaquina = maquinas.get(0).getId_maquina();
            inserirLogUso(idMaquina, idEmpresa, idUser);
        }
    }

    private Integer buscarUltimaMaquinaId() {
        List<Maquina> maquinas = con.query("select * from maquina", new MaquinaRowMapper());
        if (!maquinas.isEmpty()) {
            return maquinas.get(maquinas.size() - 1).getId_maquina();
        }
        return null;
    }

    private void inserirLogUso(Integer idMaquina, Integer idEmpresa, Integer idUser) {
        con.update("insert into log_uso (id_maquina, id_empresa, id_usuario) values (?, ?, ?)", 
                idMaquina, idEmpresa, idUser);
        
        conexaoLocal.update("insert into log_uso (id_maquina, id_empresa, id_usuario) values (?, ?, ?)",
                idMaquina, idEmpresa, idUser);

        InsertComponente comp = new InsertComponente();
        comp.inserirComponenteMaquina(idEmpresa, idMaquina);
    }

}

