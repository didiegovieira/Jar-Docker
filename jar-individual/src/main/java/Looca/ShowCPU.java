package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;

public class ShowCPU {
    Looca looca = new Looca();

    Processador processador = looca.getProcessador();

    public Processador showCpu(){
        return processador;
    }
}
