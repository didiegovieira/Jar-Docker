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
    private Integer id_componenteMaquina;
    private Integer fk_componente;
    private Integer fk_maquina;

    public ComponenteMaquina(Integer id_componenteMaquina, Integer fk_componente, Integer fk_maquina) {
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

    public Integer getId_componenteMaquina() {
        return id_componenteMaquina;
    }

    public void setId_componenteMaquina(Integer id_componenteMaquina) {
        this.id_componenteMaquina = id_componenteMaquina;
    }

    public Integer getFk_componente() {
        return fk_componente;
    }

    public void setFk_componente(Integer fk_componente) {
        this.fk_componente = fk_componente;
    }

    public Integer getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(Integer fk_maquina) {
        this.fk_maquina = fk_maquina;
    }
    
    
}
