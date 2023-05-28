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
import Jdbc.Rede;
import Jdbc.RedeRowMapper;
import Looca.ShowCPU;
import Looca.ShowDisco;
import Looca.ShowMemoria;
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
    private JdbcTemplate conLocal = conexaoBancoLocal.getConnection();
    
    InsertComponenteMaquina inCompMaq = new InsertComponenteMaquina();
    
    public void inserirComponenteMaquina(Integer idEmpresa, Integer idMaquina) {
        ShowCPU cpu = new ShowCPU();
        ShowDisco disco = new ShowDisco();
        ShowRede rede = new ShowRede();
        ShowMemoria ram = new ShowMemoria();

        List<Componente> maqCpu = con.query("select * from componente where nome = ?", new ComponenteRowMapper(), cpu.nomeCpu());
        // Inserir componente CPU
        if (maqCpu.isEmpty()){
            System.out.println("Registrando CPU");
            con.update("INSERT INTO componente (nome, fabricante, tipo, modelo, total) VALUES (?, ?, 'CPU', ?, ?)",
                    cpu.nomeCpu(), cpu.fabricanteCpu(), cpu.modeloCpu(), cpu.clockCpu());
            
            List<Componente> verify = con.query("select * from componente where nome = ?", new ComponenteRowMapper(), cpu.nomeCpu());
            
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina, idEmpresa);
            
        } else {
            inCompMaq.cadastroComponenteExistente(maqCpu.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }
        
        List<Componente> maqDisco = con.query("select * from componente where nome = ? and total = ?", new ComponenteRowMapper(), disco.nomeDisco(), disco.showTotal());
        //Inserir componente Disco
        if (maqDisco.isEmpty()){
            System.out.println("Registrando Disco");
            con.update("INSERT INTO componente (nome, tipo, total) VALUES (?, 'Disco', ?)",
                disco.nomeDisco(), disco.showTotal());
            
            List<Componente> verify = con.query("select * from componente where nome = ?", new ComponenteRowMapper(), disco.nomeDisco());
            
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }  else {
            inCompMaq.cadastroComponenteExistente(maqDisco.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }

        List<Componente> maqRede = con.query("select * from componente where nome = ?", new ComponenteRowMapper(), rede.nomeRede());
        //Inserir componente Rede
        if (maqRede.isEmpty()){
            System.out.println("Registrando Rede");
//            con.update("INSERT INTO rede (ip, driver, nome, id_maquina, id_empresa) VALUES (?, ?, ?, ?, ?)",
//                rede.ipRede(), rede.driverRede(), rede.nomeRede(), idMaquina, idEmpresa);
            
            con.update("INSERT INTO rede (driver, nome, id_maquina, id_empresa) VALUES (?, ?, ?, ?)",
                rede.driverRede(), rede.nomeRede(), idMaquina, idEmpresa);
            
            con.update("INSERT INTO componente (nome, tipo) VALUES (?, 'Rede')",
                rede.nomeRede());
            
            List<Componente> verify = con.query("select * from componente where nome = ?", new ComponenteRowMapper(), rede.nomeRede());
           
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }  else {
            inCompMaq.cadastroComponenteExistente(maqRede.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }
        
        List<Componente> maqRam = con.query("select * from componente where nome = 'Ram' and total = ?", new ComponenteRowMapper(), ram.totalRam());
        //Inserir componente Ram
        if (maqRam.isEmpty()){
            System.out.println("Registrando Ram");
            con.update("INSERT INTO componente (nome, tipo, total) VALUES ('Ram', 'Ram', ?)", ram.totalRam());

            
            List<Componente> verify = con.query("select * from componente where nome = 'Ram' and total = ?", new ComponenteRowMapper(), ram.totalRam());
            
            inCompMaq.cadastroComponenteNovo(verify.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }  else {
            inCompMaq.cadastroComponenteExistente(maqRam.get(0).getId_componente(), idMaquina, idEmpresa);
            
        }
    }
}
