/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diegovieira
 */
public class MaquinaClass {
    private String idMaquina;
    private String idEmpresa;
    
    
    public MaquinaClass(String idMaquina, String idEmpresa){
        this.idMaquina = idMaquina;
        this.idEmpresa = idEmpresa;
        
    }
    
    public MaquinaClass(){
        
    }

    @Override
    public String toString() {
        return "ObjetoMaquina{" +
                "id_maquina='" + idMaquina + '\'' +
                "id_empresa='" + idEmpresa + '\'' +
                '}';
    }

    public String setIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    
    
}
