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
        con.update("insert into Registro (clockCPU, temperaturaCPU, usoCPU, fk_componente) values (?, ?, ?, ?)", 
                cpu.clockCpu(), temp.showTemp(), cpu.usoCpu(), idComponente);
    }
    
    public void insertSqlRede(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro (downloadRede, uploadRede, fk_componente) values (?, ?, ?)", 
                rede.showDownload(), rede.showUpload(), idComponente);
    }

    public void insertSqlRam(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro (usoRAM, disponivelRam, totalRam, fk_componente) values (?, ?, ?, ?)", 
                ram.usoRam(), ram.disponivelRam(), ram.totalRam(), idComponente);
    }
    
    public void insertSqlDisco(String idComponente, String idMaquina, String idEmpresa){
        con.update("insert into Registro (usadoDisco, totalDisco, disponivelDisco, fk_componente) values (?, ?, ?, ?)", 
                disco.showUsado(), disco.showTotal(), disco.showDisponivel(), idComponente);
    }
    
}
