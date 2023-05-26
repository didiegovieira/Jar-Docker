/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ComponenteMaquina;
import Jdbc.ComponenteMaquinaRowMapper;
import Jdbc.ConexaoBanco;
import Jdbc.ConexaoBancoLocal;
import Jdbc.LogUso;
import Jdbc.LogUsoRowMapper;
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
    
    private ConexaoBancoLocal conexaoBancoLocal = new ConexaoBancoLocal();
    private JdbcTemplate conexaoLocal = conexaoBancoLocal.getConnection();
    
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
        
        
        System.out.println(listaCompMaq);
        
    }
    
    public void insertSqlCpu(Integer idComponente, Integer idComponenteMaquina, Integer idMaquina){
        con.update("insert into Registro (clockCPU, temperaturaCPU, usoCPU, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?, ?, current_timestamp)", 
                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu(), idComponente, idComponenteMaquina, idMaquina);
        
//        int fkComponente = Integer.parseInt(idComponente);
//        int fkComponenteMaquina = Integer.parseInt(idComponenteMaquina);
//        int fkMaquina = Integer.parseInt(idMaquina);
//        conexaoLocal.update("insert into Registro (clockCPU, temperaturaCPU, usoCPU, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?, ?)", 
//                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu(), fkComponente, fkComponenteMaquina, fkMaquina);
    }
    
    public void insertSqlRede(Integer idComponente, Integer idComponenteMaquina, Integer idMaquina){
        con.update("insert into Registro (downloadRede, uploadRede, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?)", 
                rede.showDownload(), rede.showUpload(), idComponente, idComponenteMaquina, idMaquina);
        
//        int fkComponente = Integer.parseInt(idComponente);
//        int fkComponenteMaquina = Integer.parseInt(idComponenteMaquina);
//        int fkMaquina = Integer.parseInt(idMaquina);
//        conexaoLocal.update("insert into Registro (downloadRede, uploadRede, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?)", 
//                rede.showDownload(), rede.showUpload(), fkComponente, fkComponenteMaquina, fkMaquina);
    }

    public void insertSqlRam(Integer idComponente, Integer idComponenteMaquina, Integer idMaquina){
        con.update("insert into Registro (usoRAM, disponivelRam, totalRam, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ? ,?)", 
                ram.usoRam(), ram.disponivelRam(), ram.totalRam(), idComponente, idComponenteMaquina, idMaquina);
        
//        int fkComponente = Integer.parseInt(idComponente);
//        int fkComponenteMaquina = Integer.parseInt(idComponenteMaquina);
//        int fkMaquina = Integer.parseInt(idMaquina);
//        conexaoLocal.update("insert into Registro (usoRAM, disponivelRam, totalRam, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ? ,?)", 
//                ram.usoRam(), ram.disponivelRam(), ram.totalRam(), fkComponente, fkComponenteMaquina, fkMaquina);
    }
    
    public void insertSqlDisco(Integer idComponente, Integer idComponenteMaquina, Integer idMaquina){
        con.update("insert into Registro (usadoDisco, totalDisco, disponivelDisco, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?, ?)", 
                disco.showUsado(), disco.showTotal(), disco.showDisponivel(), idComponente, idComponenteMaquina, idMaquina);
        
//        int fkComponente = Integer.parseInt(idComponente);
//        int fkComponenteMaquina = Integer.parseInt(idComponenteMaquina);
//        int fkMaquina = Integer.parseInt(idMaquina);
//        conexaoLocal.update("insert into Registro (usadoDisco, totalDisco, disponivelDisco, fk_componente, fk_componenteMaquina, fk_maquina) values (?, ?, ?, ?, ?, ?)", 
//                disco.showUsado(), disco.showTotal(), disco.showDisponivel(), fkComponente, fkComponenteMaquina, fkMaquina);
    }
    
}
