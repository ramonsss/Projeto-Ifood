/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Usuarios;

import java.util.ArrayList;

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

    // ArrayList estático para armazenar os usuários cadastrados
    private static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();

    public Usuario(String nome, String senha, String email, String cep, boolean isDonoVer) {
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        setCep(cep);
        this.isDonoVer = isDonoVer;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 5) {
            this.nome = nome;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() > 5) {
            this.senha = senha;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.length() > 5) {
            this.email = email;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if(cep.length() > 5) {
            this.cep = cep;
        }
    }

    public boolean isIsDonoVer() {
        return isDonoVer;
    }

    public void setIsDonoVer(boolean isDonoVer) {
        this.isDonoVer = isDonoVer;
    }

    // Método para adicionar usuário ao ArrayList
    public static void adicionarUsuarioAoArray(Usuario usuario) {
        usuariosCadastrados.add(usuario);
        System.out.println("Usuário adicionado ao ArrayList: " + usuario.getNome());
    }

    // Método para listar usuários cadastrados
    public static void listarUsuarios() {
        System.out.println("Lista de usuários cadastrados:");
        for (Usuario usuario : usuariosCadastrados) {
            System.out.println("Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail());
        }
    }

}
