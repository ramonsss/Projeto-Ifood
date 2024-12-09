/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Ramon Souza
 */
public class Produto {

    private String nome;
    private double preco;
    private String descricao;
    private String tempoPreparo;
    private byte[] imagem;

    // Construtor
    public Produto(String nome, double preco, String descricao, String tempoPreparo, byte[] imagem) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
        this.imagem = imagem;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
