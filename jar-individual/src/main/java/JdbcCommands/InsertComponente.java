/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.Componente;
import Jdbc.ComponenteMaquinaRowMapper;
import Jdbc.ComponenteRowMapper;
import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.Maquina;
import Jdbc.MaquinaRowMapper;
import Looca.ShowCPU;
import Looca.ShowDisco;
import Looca.ShowRede;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diego
 */
public class InsertComponente {
    private ConexaoBanco conexao = new ConexaoBanco();
    private JdbcTemplate con = conexao.getConnection();
    
    private ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    private JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    
    InsertComponenteMaquina inCompMaq = new InsertComponenteMaquina();
    
    public void inserirComponenteMaquina(String idEmpresa, String idMaquina) {
        ShowCPU cpu = new ShowCPU();
        ShowDisco disco = new ShowDisco();
        ShowRede rede = new ShowRede();

        List<Componente> maqCpu = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), cpu.nomeCpu());
        // Inserir componente CPU
        if (maqCpu.isEmpty()){
            System.out.println("Registrando CPU");
            con.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, ?, 'CPU', null, null, null)",
                    cpu.nomeCpu(), cpu.fabricanteCpu());
            conexaoLocal.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, ?, 'CPU', null, null, null)",
                    cpu.nomeCpu(), cpu.fabricanteCpu());
            List<Componente> verify = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), cpu.nomeCpu());
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina);
        } else {
            inCompMaq.cadastroComponenteExistente(maqCpu.get(0).getId_componente(), idMaquina);
        }
        
        List<Componente> maqDisco = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), disco.nomeDisco());
        //Inserir componente Disco
        if (maqDisco.isEmpty()){
            System.out.println("Registrando Disco");
            con.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, null, 'Disco', null, null, null)",
                disco.nomeDisco());
            conexaoLocal.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, null, 'Disco', null, null, null)",
                disco.nomeDisco());
            List<Componente> verify = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), disco.nomeDisco());
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina);
        }  else {
            inCompMaq.cadastroComponenteExistente(maqDisco.get(0).getId_componente(), idMaquina);
        }

        List<Componente> maqRede = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), rede.nomeRede());
        //Inserir componente Rede
        if (maqRede.isEmpty()){
            System.out.println("Registrando Rede");
            con.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, null, 'Rede', ?, null, ?)",
                rede.nomeRede(), rede.ipRede(), rede.driverRede());
            conexaoLocal.update("INSERT INTO Componente (nomeComponente, fabricante, tipo, ipComponente, modelo, driver) VALUES (?, null, 'Rede', ?, null, ?)",
                rede.nomeRede(), rede.ipRede(), rede.driverRede());
            List<Componente> verify = con.query("select * from Componente where nomeComponente = ?", new ComponenteRowMapper(), rede.nomeRede());
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina);
        }  else {
            inCompMaq.cadastroComponenteExistente(maqRede.get(0).getId_componente(), idMaquina);
        }
        
        List<Componente> maqRam = con.query("select * from Componente where nomeComponente = 'Ram'", new ComponenteRowMapper());
        //Inserir componente Ram
        if (maqRede.isEmpty()){
            System.out.println("Registrando Ram");
            con.update("INSERT INTO Componente (tipo) VALUES ('Ram')");
            conexaoLocal.update("INSERT INTO Componente (tipo) VALUES ('Ram')");
            List<Componente> verify = con.query("select * from Componente where nomeComponente = 'Ram'", new ComponenteRowMapper());
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina);
        }  else {
            inCompMaq.cadastroComponenteExistente(maqRam.get(0).getId_componente(), idMaquina);
        }
    }
}
