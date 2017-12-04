package br.edu.unoesc;

import java.util.Scanner;

public class TelaPrincipal {

	Scanner sc = new Scanner(System.in);

	public int menuCarrinho() {
		System.out.println("Para adicionar item.....1");
		System.out.println("Para remover item.......2");
		System.out.println("Para finalizar compra...3");
		return sc.nextInt();
	}
	
	public int menuAdicionarProdutos() {
		System.out.println("Para adicionar mais produtos...1");
		System.out.println("Para ir para o carrinho........2");
		return sc.nextInt();
	}
	
	public void fecharScan() {
		sc.close();
	}
	
	public void MensagemErro() {
		System.out.println("Erro: opcao invalida");
	}
	
	public void mensagemProdutosBanco() {
		System.out.println("Produtos no banco:");
	}
	
	public void mensagemProdutosCarrinho() {
		System.out.println("Produtos no carrinho:");	
	}
	
	
}
