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
    private String email;
    private String senha;
    
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(){
        
    }

    @Override
    public String toString() {
        return "ObjetoUsuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getEmailUsuario() {
        return email;
    }

    public String getSenhaUsuario() {
        return senha;
    }

   

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
