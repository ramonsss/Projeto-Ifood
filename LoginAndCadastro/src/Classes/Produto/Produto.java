/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Produto;

import java.util.ArrayList;

/**
 *
 * @author Ramon Souza
 */
public class Produto {

    private String nome;
    private double preco;
    private String descricao;
    private String tempoPreparo;

    private static ArrayList<Produto> produtos = new ArrayList<>();

    // Construtor
    public Produto(String nome, double preco, String descricao, String tempoPreparo) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.tempoPreparo = tempoPreparo;
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

    // Método para adicionar um produto ao ArrayList
    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    // Método para listar todos os produtos cadastrados
    public static void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Tempo de preparo: " + produto.getTempoPreparo());
            System.out.println("----------------------------------------------");
        }
    }

}
