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
    private Integer id_usuario;
    private String email;
    private String senha;
    private Integer fk_empresa;
    
    public Usuario(String email, String senha, Integer fk_empresa, Integer id_usuario){
        this.id_usuario = id_usuario;
        this.email = email;
        this.senha = senha;
        this.fk_empresa = fk_empresa;
    }
    
    public Usuario(){
        
    }

    @Override
    public String toString() {
        return "ObjetoUsuario{" +
                "id_usuario ='" + id_usuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", fk_empresa ='" + fk_empresa + '\'' +
                '}';
    }

    public String getEmailUsuario() {
        return email;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenhaUsuario() {
        return senha;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
}
