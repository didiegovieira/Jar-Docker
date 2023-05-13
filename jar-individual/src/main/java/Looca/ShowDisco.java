package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;

import java.util.List;

public class ShowDisco {
    Looca looca = new Looca();

    public Double showDisco() {
        Long qtdArmazenamentoBytes = null;
        //DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Volume> discos = looca.getGrupoDeDiscos().getVolumes();

        for (Volume discoVolume : discos) {
           qtdArmazenamentoBytes = discoVolume.getTotal();
        }
        
        Long valorReal = qtdArmazenamentoBytes / (1024 * 1024 * 1024);
        
        if (valorReal < 256){
            return 256.0;
        } else if (valorReal < 512) {
            return 512.0;
        } else {
            return 1024.0;
        }
    }
}
