/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

/**
 *
 * @author diegovieira
 */
public class ShowSistema {
    Looca looca = new Looca();

    Sistema sistema = looca.getSistema();

    public Sistema showSistema(){
        return sistema;
    }
    
    
}
