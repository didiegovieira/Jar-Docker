/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcCommands;

import Jdbc.ConexaoBanco;
import Looca.ShowCPU;
import Looca.ShowDisco;
import Looca.ShowMemoria;
import Looca.ShowRede;
import Looca.ShowTemp;
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
    
    ShowCPU cpu = new ShowCPU();
    ShowTemp temp = new ShowTemp();
    ShowDisco disco = new ShowDisco();
    ShowRede rede = new ShowRede();
    ShowMemoria ram = new ShowMemoria();
    
    public void insertSqlCpu(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro values (?, ?, ?, null, null, null, null, null, null, null, null, ?, ?, ?)", 
                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu(), idEmpresa, idComponente, idMaquina);
    }
    
    public void insertSqlRede(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro values (null, null, null, ?, ?, null, null, null, null, null, null, ?, ?, ?)", 
                rede.showDownload(), rede.showUpload(), idEmpresa, idComponente, idMaquina);
    }

    public void insertSqlRam(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro values (null, null, null, null, null, ?, ?, ?, null, null, null, ?, ?, ?)", 
                ram.usoRam(), ram.disponivelRam(), ram.totalRam(), idEmpresa, idComponente, idMaquina);
    }
    
    public void insertSqlDisco(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro values (null, null, null, null, null, null, null, null, ?, ?, ?, ?, ?, ?)", 
                disco.showUsado(), disco.showTotal(), disco.showDisponivel(), idEmpresa, idComponente, idMaquina);
    }
    
}
