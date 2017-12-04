package br.edu.unoesc;

import java.util.Scanner;

public class TelaProduto {

	Scanner sc = new Scanner(System.in);
	
	public String nomeProduto() {
		System.out.println("Digite o nome do produto");
		return sc.next();
	}
	
	public int codigoProduto() {
		System.out.println("Digite o codigo do produto");
		return sc.nextInt();
	}
	public Double precoProduto() {
		System.out.println("Digite o preço do produto");
		return sc.nextDouble();
	}
	
	public void mensagemAdicionado() {
		System.out.println("Produto adicionado com sucesso ao banco");
	}
	
	public void mensagemProdutoExistente() {
		System.out.println("Produto já existe no banco");
	}
	
	/**
	public void cadastrar() {
		System.out.println("cadastrar");
		System.out.println("nome");
		sc.hasNextLine();
		String nome = sc.nextLine();
		System.out.println("preco");
		double p = sc.nextDouble();
		System.out.println("cod");
		int cod = sc.nextInt();
		Produto p = new Produto(nome,cod,p);
		Banco.produtos.add(p);
		sc.close();
	}
	*/
	
	
	public void listar() {
		System.out.println("Lista de produtos");
		for(Produto p : Banco.produtos) {
			System.out.println(p.getCodigo());
			System.out.println(p.getNome());
			System.out.println(p.getPreco());
		}
		
	}
	
	
	
	
	
	
	
}