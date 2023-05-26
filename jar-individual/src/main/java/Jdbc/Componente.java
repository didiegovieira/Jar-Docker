/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diego
 */
public class Componente {
    private Integer id_componente;
    private String nome;
    private String fabricante;
    private String tipo;
    private String modelo;

    public Componente(Integer id_componente, String nomeComponente, String fabricante, String tipo, String modelo) {
        this.id_componente = id_componente;
        this.nome = nomeComponente;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.modelo = modelo;
    }
    
    public Componente(){
        
    }
    
     @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_componente ='" + id_componente + '\'' +
                "nomeComponente ='" + nome + '\'' +
                "fabricante ='" + fabricante + '\'' +
                "tipo ='" + tipo + '\'' +
                "modelo ='" + modelo + '\'' +
                '}';
    }

    public Integer getId_componente() {
        return id_componente;
    }

    public void setId_componente(Integer id_componente) {
        this.id_componente = id_componente;
    }

    public String getNomeComponente() {
        return nome;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nome = nomeComponente;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
