/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diego
 */
public class Rede {
    private Integer id_rede;
    private String ip;
    private String driver;
    private String nome;
    private Integer id_maquina;
    private Integer id_empresa;

    public Rede(Integer id_rede, String ip, String driver, String nome, Integer id_maquina, Integer id_empresa) {
        this.id_rede = id_rede;
        this.ip = ip;
        this.driver = driver;
        this.nome = nome;
        this.id_maquina = id_maquina;
        this.id_empresa = id_empresa;
    }
    
    public Rede(){
        
    }
    
    @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_rede ='" + id_rede + '\'' +
                "ip ='" + ip + '\'' +
                "driver ='" + driver + '\'' +
                "nome ='" + nome + '\'' +
                "id_maquina ='" + id_maquina + '\'' +
                "id_empresa ='" + id_empresa + '\'' +
                '}';
    }

    public Integer getId_rede() {
        return id_rede;
    }

    public void setId_rede(Integer id_rede) {
        this.id_rede = id_rede;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }
    
    
}
