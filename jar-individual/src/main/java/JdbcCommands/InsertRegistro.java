/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.Componente;
import Jdbc.ComponenteMaquina;
import Jdbc.ComponenteMaquinaRowMapper;
import Jdbc.ComponenteRowMapper;
import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.LogUso;
import Jdbc.LogUsoRowMapper;
import Jdbc.Rede;
import Jdbc.RedeRowMapper;
import Jdbc.Usuario;
import Jdbc.UsuarioRowMapper;
import Looca.ShowCPU;
import Looca.ShowDisco;
import Looca.ShowMemoria;
import Looca.ShowRede;
import Looca.ShowTemp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author diegovieira
 */
public class InsertRegistro {
    ConexaoBanco conexao = new ConexaoBanco();
    JdbcTemplate con = conexao.getConnection();
    
    ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    JdbcTemplate conLocal = conexaoBancoLocal.getConnection();
    
    ShowCPU cpu = new ShowCPU();
    ShowTemp temp = new ShowTemp();
    ShowDisco disco = new ShowDisco();
    ShowRede rede = new ShowRede();
    ShowMemoria ram = new ShowMemoria();
    
    public void insert(String email, String senha){
        List<Usuario> listaObjetoUsuario;
        listaObjetoUsuario = con.query(
                "select * from usuario where email = ? and senha = ?", 
                new UsuarioRowMapper(), email, senha);
        Usuario id = listaObjetoUsuario.get(0);

        List<LogUso> listaLogUso;
        listaLogUso = con.query(
                "select * from log_uso where id_usuario = ? and id_empresa = ?",
                new LogUsoRowMapper(), id.getId_usuario(), id.getFk_empresa());
        LogUso log = listaLogUso.get(0);
        
        List<ComponenteMaquina> listaCompMaq;
        listaCompMaq = con.query(
                "select * from componente_maquina where id_maquina = ?",
                new ComponenteMaquinaRowMapper(), log.getFk_maquina());
        ComponenteMaquina compmaq = listaCompMaq.get(0);
        
        List<Rede> listaRede;
        listaRede = con.query(
                "select * from rede where id_maquina = ?",
                new RedeRowMapper(), log.getFk_maquina());
        Rede red = listaRede.get(0);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //CPU
                List<Componente> listaComp;
                listaComp = con.query("select * from componente where nome = ?",
                    new ComponenteRowMapper(), cpu.nomeCpu());
                Componente lisComp = listaComp.get(0);

                List<ComponenteMaquina> listaCompMaq;
                listaCompMaq = con.query("select * from componente_maquina where id_componente = ?",
                        new ComponenteMaquinaRowMapper(), lisComp.getId_componente());
                ComponenteMaquina lis2 = listaCompMaq.get(0);

                con.update("insert into registro (clock_cpu, temp_cpu, uso_cpu, data_hora, id_componente_maquina, id_componente, id_maquina, id_empresa) values (?, ?, ?, current_timestamp, ?, ?, ?, ?)", 
                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu(), lis2.getId_componenteMaquina(), lis2.getFk_componente(), compmaq.getFk_maquina(), compmaq.getFk_empresa());

                conLocal.update("insert into registro (clock_cpu, temp_cpu, uso_cpu, data_hora) values (?, ?, ?, current_timestamp)", 
                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu());

                //REDE
                listaComp = con.query("select * from componente where nome = ?", 
                        new ComponenteRowMapper(),rede.nomeRede());
                lisComp = listaComp.get(0);

                listaCompMaq = con.query("select * from componente_maquina where id_componente = ?",
                        new ComponenteMaquinaRowMapper(), lisComp.getId_componente());
                lis2 = listaCompMaq.get(0);

                con.update("insert into registro (download_rede, upload_rede, data_hora, id_componente_maquina, id_componente, id_maquina, id_empresa) values (?, ?, current_timestamp, ?, ?, ?, ?)", 
                rede.showDownload(), rede.showUpload(), lis2.getId_componenteMaquina(), lis2.getFk_componente(), compmaq.getFk_maquina(), compmaq.getFk_empresa());

                conLocal.update("insert into registro (download_rede, upload_rede, data_hora) values (?, ?, current_timestamp)", 
                rede.showDownload(), rede.showUpload());

                //RAM
                listaComp = con.query("select * from componente where nome = 'Ram'", 
                        new ComponenteRowMapper());
                lisComp = listaComp.get(0);

                listaCompMaq = con.query("select * from componente_maquina where id_componente = ?",
                        new ComponenteMaquinaRowMapper(), lisComp.getId_componente());
                lis2 = listaCompMaq.get(0);

                con.update("insert into registro (uso, data_hora, id_componente_maquina, id_componente, id_maquina, id_empresa) values (?, current_timestamp, ?, ?, ?, ?)", 
                ram.usoRam(), lis2.getId_componenteMaquina(), lis2.getFk_componente(), compmaq.getFk_maquina(), compmaq.getFk_empresa());

                conLocal.update("insert into registro (uso, data_hora) values (?, current_timestamp)", 
                ram.usoRam());

                //DISCO
                listaComp = con.query("select * from componente where nome = ?", 
                        new ComponenteRowMapper(), disco.nomeDisco());
                lisComp = listaComp.get(0);

                listaCompMaq = con.query("select * from componente_maquina where id_componente = ?",
                        new ComponenteMaquinaRowMapper(), lisComp.getId_componente());
                lis2 = listaCompMaq.get(0);

                con.update("insert into registro (uso, data_hora, id_componente_maquina, id_componente, id_maquina, id_empresa) values (?, current_timestamp, ?, ?, ?, ?)", 
                disco.showUsado(), lis2.getId_componenteMaquina(), lis2.getFk_componente(), compmaq.getFk_maquina(), compmaq.getFk_empresa());

                conLocal.update("insert into registro (uso, data_hora) values (?, current_timestamp)", 
                disco.showUsado());

            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 10000); // Executa a cada 10 segundos (10000 milissegundos)
        
    }

    
    
}
