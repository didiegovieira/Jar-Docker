package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class ShowMemoria {
    Looca looca = new Looca();

    Memoria memoria = looca.getMemoria();

    public Memoria showMemoria(){
        return memoria;
    }
}
