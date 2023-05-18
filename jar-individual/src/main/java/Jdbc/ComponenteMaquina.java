/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diego
 */
public class ComponenteMaquina {
    private String id_componenteMaquina;
    private String fk_componente;
    private String fk_maquina;

    public ComponenteMaquina(String id_componenteMaquina, String fk_componente, String fk_maquina) {
        this.id_componenteMaquina = id_componenteMaquina;
        this.fk_componente = fk_componente;
        this.fk_maquina = fk_maquina;
    }
    
    public ComponenteMaquina(){
        
    }
    
     @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_componenteMaquina ='" + id_componenteMaquina + '\'' +
                "fk_componente ='" + fk_componente + '\'' +
                "fk_maquina ='" + fk_maquina + '\'' +
                '}';
    }

    public String getId_componenteMaquina() {
        return id_componenteMaquina;
    }

    public void setId_componenteMaquina(String id_componenteMaquina) {
        this.id_componenteMaquina = id_componenteMaquina;
    }

    public String getFk_componente() {
        return fk_componente;
    }

    public void setFk_componente(String fk_componente) {
        this.fk_componente = fk_componente;
    }

    public String getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(String fk_maquina) {
        this.fk_maquina = fk_maquina;
    }
    
    
}
