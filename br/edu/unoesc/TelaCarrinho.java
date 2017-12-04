package br.edu.unoesc;

import java.util.List;
import java.util.Scanner;

public class TelaCarrinho {
	
	Scanner sc = new Scanner(System.in);
	
	public String data() {
		System.out.println("Digite a data");
		return sc.next();
	}
	
	
	public int quantidadeProduto() {
		System.out.println("Digite a quantidade de produtos");
		return sc.nextInt();
	}
	
	public void mensagemAdicionado() {
		System.out.println("Item adicionado com succeso");
	}
	
	public void mensagemErro() {
		System.out.println("Erro: Item nao existe");
	}
	
	public void mensagemProdutoRemovido() {
		System.out.println("Item removido");
	}
	
	public void mensagemErroAoRemover() {
		System.out.println("Erro: Item não encontrado");
	}
	
	public void mensagemFinalizarCompra(Carrinho c) {  
		System.out.println("Nome do Usuario "+ c.getUsuario().getNome());
		System.out.println("data: "+ c.getData());
		System.out.println("Quantidades de itens no carrinho: "+ c.getQuantidade());
		System.out.println("Detalhes dos itens: ");
		for(int i = 0; i<c.getProdutos().size(); i++) {
			System.out.println("Nome: "+c.getProdutos().get(i).getNome()+
							  " Preço: "+ c.getProdutos().get(i).getPreco()+
							  " Quantidade: "+ c.qProd.get(i));
		}
		System.out.println("valor total da compra: " + c.valorTotal());
		
	}
	
	public void mostrarProdutosDoCarrinho(List<Produto> produtos, List<Integer> q) {
		for(int i= 0 ; i<produtos.size();i++) {
			System.out.println("Item --> Nome: "+ produtos.get(i).getNome()+
								" Cod: "+ produtos.get(i).getCodigo()+ 
								" Preço: "+ produtos.get(i).getPreco()+ 
								" Quantidade: "+ q);
		}
	}
	
	public void carrinhoVazio() {
		System.out.println("Carrinho vazio");
	}
	
	public void mensagemErroAoFinalizar() {
		System.out.println("Erro: carrinho vazio");
	}	
	
	public void listar() {
		for(Carrinho c : Banco.carrinho) {
			System.out.println("data"+ c.getData());
			System.out.println("data"+ c.getQuantidade());
			System.out.println("data"+ c.getUsuario());
			for(Produto produto : c.getProdutos()) {
				System.out.println("produto"+ produto.getNome());
			}
		}
	}
	
	/**
	
	// usarei somente nesta tela (private)
	private Usuario escolherUser() {
		System.out.println("informe o user");
		int count = 0;
		for(Usuario u : Banco.usuario) {
			System.out.println(count + " "+ u.getNome());
			count++;
		}
		int posicao = sc.nextInt();
		return Banco.usuario.get(posicao);
		
	}
	
	*/
	
	

}
