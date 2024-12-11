/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.Produto.Produtos;
import java.util.ArrayList;

/**
 *
 * @author Ramon Souza
 */
public class CarrinhoCompras {

    public class CarrinhoDeCompras {

        private ArrayList<Produtos> produtos;

        public CarrinhoDeCompras() {
            produtos = new ArrayList<>();
        }

        // Método para adicionar um produto ao carrinho
        public void adicionarProduto(Produtos produto) {
            produtos.add(produto);
        }

        // Método para obter todos os produtos do carrinho
        public ArrayList<Produtos> getProdutos() {
            return produtos;
        }

        // Método para limpar o carrinho
        public void limparCarrinho() {
            produtos.clear();
        }
    }

}
