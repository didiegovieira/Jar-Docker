package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

public class ShowRede {
    Looca looca = new Looca();
    Rede rede = looca.getRede();

    // Lista de dados da rede
    public List showRede(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();

        return lista;
    }
    
    //Nome da Rede
    public String nomeRede(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        String nome = null;
        
        for (RedeInterface redeInterface : lista) {
            nome = redeInterface.getNome();
        }

        return nome;
    }
    
    //IPV4 da rede
    public String ipRede(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        String nome = null;
        
        for (RedeInterface redeInterface : lista) {
            nome = redeInterface.getEnderecoIpv4().get(0);
        }

        return nome;
    }
    
    //Driver da rede
    public String driverRede(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        String nome = null;
        
        for (RedeInterface redeInterface : lista) {
            nome = redeInterface.getNomeExibicao();
        }

        return nome;
    }
        
    // Download de rede acumulativo
    public Long showDownload(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        Long download = null;
        
        for (RedeInterface redeInterface : lista) {
            download = redeInterface.getBytesRecebidos();
        }

        
        return  download;
    }
    
    // Upload da rede acumulativo
    public Long showUpload(){
        List<RedeInterface> lista = rede.getGrupoDeInterfaces().getInterfaces();
        
        Long upload = null;
        
        for (RedeInterface redeInterface : lista) {
            upload = redeInterface.getBytesEnviados();
        }

        return upload;
    }
    
    
}
