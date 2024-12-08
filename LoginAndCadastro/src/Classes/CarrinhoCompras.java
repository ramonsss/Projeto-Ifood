/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Ramon Souza
 */
public class CarrinhoCompras {

    public class CarrinhoDeCompras {

        private ArrayList<Produto> produtos;

        public CarrinhoDeCompras() {
            produtos = new ArrayList<>();
        }

        // Método para adicionar um produto ao carrinho
        public void adicionarProduto(Produto produto) {
            produtos.add(produto);
        }

        // Método para obter todos os produtos do carrinho
        public ArrayList<Produto> getProdutos() {
            return produtos;
        }

        // Método para limpar o carrinho
        public void limparCarrinho() {
            produtos.clear();
        }
    }

}
