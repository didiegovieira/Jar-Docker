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
 * @author diego
 */
public class MaquinaService {
    private ConexaoBanco conexao = new ConexaoBanco();
    private JdbcTemplate con = conexao.getConnection();
    
    private ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    private JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    
    public void criarMaquinaELog(String idEmpresa, String idUser) {
        ShowSistema sis = new ShowSistema();
        String so = sis.showSistema().getSistemaOperacional();
        Integer arquitetura = sis.showSistema().getArquitetura();
        String fabricante = sis.showSistema().getFabricante();

        List<Maquina> maquinas = con.query("select * from Maquina where fk_empresa = ?", 
                new MaquinaRowMapper(), idEmpresa);

        if (maquinas.isEmpty()) {
            System.out.println("Registrando Maquina");

            con.update("insert into Maquina values (?, ?, ?, ?)", 
                    so, arquitetura, fabricante, idEmpresa);
            
            //conexaoLocal.update("insert into Maquina values (?, ?, ?, ?)", 
            //        so, arquitetura, fabricante, idEmpresa);

            String idMaquina = buscarUltimaMaquinaId();
            if (idMaquina != null) {
                inserirLogUso(idMaquina, idEmpresa, idUser);
            }
        } else {
            String idMaquina = maquinas.get(0).getId_maquina();
            inserirLogUso(idMaquina, idEmpresa, idUser);
        }
    }

    private String buscarUltimaMaquinaId() {
        List<Maquina> maquinas = con.query("select * from Maquina", new MaquinaRowMapper());
        if (!maquinas.isEmpty()) {
            return maquinas.get(maquinas.size() - 1).getId_maquina();
        }
        return null;
    }

    private void inserirLogUso(String idMaquina, String idEmpresa, String idUser) {
        con.update("insert into LogUso values (?, ?, ?, null, null, null)", idMaquina, idEmpresa, idUser);
        //conexaoLocal.update("insert into LogUso values (?, ?, ?, null, null, null)", idMaquina, idEmpresa, idUser);

        InsertComponente comp = new InsertComponente();
        comp.inserirComponenteMaquina(idEmpresa, idMaquina);
    }

}

