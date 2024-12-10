/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Usuario;

/**
 *
 * @author Ramon Souza
 */
public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private String cep;
    private boolean isDonoVer;

    public Usuario(String nome, String senha, String email, String cep, boolean isDonoVer) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cep = cep;
        this.isDonoVer = isDonoVer;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isIsDonoVer() {
        return isDonoVer;
    }

    public void setIsDonoVer(boolean isDonoVer) {
        this.isDonoVer = isDonoVer;
    }
    
        

}
