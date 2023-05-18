/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diego
 */
public class Maquina {
    private String id_maquina;
    private String sistemaOperacional;
    private String arquitetura;
    private String fabricante;
    private String fk_empresa;

    public Maquina(String id_maquina, String sistemaOperacional, String arquitetura, String fabricante, String fk_empresa) {
        this.id_maquina = id_maquina;
        this.sistemaOperacional = sistemaOperacional;
        this.arquitetura = arquitetura;
        this.fabricante = fabricante;
        this.fk_empresa = fk_empresa;
    }

    public Maquina(){
        
    }
    
     @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_maquina ='" + id_maquina + '\'' +
                "sistemaOperacional ='" + sistemaOperacional + '\'' +
                "arquitetura ='" + arquitetura + '\'' +
                "fabricante ='" + fabricante + '\'' +
                "fk_empresa ='" + fk_empresa + '\'' +
                '}';
    }

    public String getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(String id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(String fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
    
    
}
