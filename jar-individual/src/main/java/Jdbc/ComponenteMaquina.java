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
    private Integer fk_empresa;
    private String total;

    public ComponenteMaquina(Integer id_componenteMaquina, Integer fk_componente, Integer fk_maquina, Integer fk_empresa, String total) {
        this.id_componenteMaquina = id_componenteMaquina;
        this.fk_componente = fk_componente;
        this.fk_maquina = fk_maquina;
        this.fk_empresa = fk_empresa;
        this.total = total;
    }
    
    public ComponenteMaquina(){
        
    }
    
     @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_componenteMaquina ='" + id_componenteMaquina + '\'' +
                "fk_componente ='" + fk_componente + '\'' +
                "fk_maquina ='" + fk_maquina + '\'' +
                "fk_empresa ='" + fk_empresa + '\'' +
                "total ='" + total + '\'' +
                '}';
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
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
