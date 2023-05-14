/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diegovieira
 */
public class ComponenteClass {
    private String id_componente;
    private String nomeComponente;
    
    
    public ComponenteClass(String nome, String id_componente){
        this.nomeComponente = nome;
        this.id_componente = id_componente;
        
    }
    
    public ComponenteClass(){
        
    }

    @Override
    public String toString() {
        return "ObjetoComponente{" +
                "id_componente='" + id_componente + '\'' +
                "nomeComponente='" + nomeComponente + '\'' +
                '}';
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getId_componente() {
        return id_componente;
    }

    public void setId_componente(String id_componente) {
        this.id_componente = id_componente;
    }

    
}
