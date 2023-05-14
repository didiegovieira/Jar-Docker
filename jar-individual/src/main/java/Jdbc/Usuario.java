/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diegovieira
 */
public class Usuario {
    private String PID;
    private String email;
    private String senha;
    private String idEmpresa;
    
    public Usuario(String email, String senha, String idEmpresa, String PID){
        this.email = email;
        this.senha = senha;
        this.idEmpresa = idEmpresa;
        this.PID = PID;
    }
    
    public Usuario(){
        
    }

    @Override
    public String toString() {
        return "ObjetoUsuario{" +
                "PID='" + PID + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", id_empresa='" + idEmpresa + '\'' +
                '}';
    }

    public String getEmailUsuario() {
        return email;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getSenhaUsuario() {
        return senha;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
