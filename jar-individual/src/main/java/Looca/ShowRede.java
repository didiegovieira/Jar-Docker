package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.Rede;

public class ShowRede {
    Looca looca = new Looca();
    Rede rede = looca.getRede();

    public void showRede(){
        System.out.println(rede.getGrupoDeInterfaces().getInterfaces());

    }
        
    
}
