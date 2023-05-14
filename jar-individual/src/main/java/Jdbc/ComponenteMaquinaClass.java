/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diegovieira
 */
public class ComponenteMaquinaClass {
    private String idComponente;
    private String idMaquina;
    private String idEmpresa;
    
    public ComponenteMaquinaClass(String idComponente, String idMaquina, String idEmpresa){
        this.idComponente = idComponente;
        this.idMaquina = idMaquina;
        this.idEmpresa = idEmpresa;
        
    }
    
    public ComponenteMaquinaClass(){
        
    }

    @Override
    public String toString() {
        return "ObjetoComponenteMaquina{" +
                "id_componente='" + idComponente + '\'' +
                "id_maquina='" + idMaquina + '\'' +
                "id_empresa='" + idEmpresa + '\'' +
                '}';
    }

    public String getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(String idComponente) {
        this.idComponente = idComponente;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    
}
