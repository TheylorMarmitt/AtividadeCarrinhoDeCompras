package br.edu.unoesc;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private String data; 
	private int quantidade;
	Usuario usuario;
	private List<Produto> produtos = new ArrayList<>();
	
	public Carrinho() {
		
	}
	public Carrinho(String data, int quantidade) {
		this.data = data;
		this.quantidade = quantidade;
	}
	
	// construtor
	public Carrinho(String data, int quantidade, Usuario usuario, List<Produto> produtos) {
		this.data = data;
		this.quantidade = quantidade;
		this.usuario = usuario;
		this.setProdutos(produtos);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	// trabalha com a quantidade de itens adicionados no carrinho
	List<Integer> qProd = new ArrayList<>();
	
	// prucura produtos
	public boolean verificaCarrinho(Produto p, int q) {
		boolean achou = false;
		for(int i = 0; i<getProdutos().size();i++) {
			if(p.equals(getProdutos().get(i))) { 
				achou= true;
				int acumulador = qProd.get(i) + q;
				qProd.set(i, acumulador);
				break;
			}
		}
		return achou;
	}
	
	
	// adicionar item no carrinho do Banco de produtos
	public boolean adicionarItemCarrinho(int cod, int quant) {
		boolean achou = false;
		int aux=0;  
		Produto prod = new Produto(cod);
		for(int i = 0; i< Banco.produtos.size();i++) {
			if(prod.equals(Banco.produtos.get(i))) {
				achou = true;
				if(!verificaCarrinho(prod, quant)) {
					getProdutos().add(aux,Banco.produtos.get(i));
					qProd.add(aux,quant);
					aux++;
					this.quantidade++;
					break;				
				}
			}
		}
		
		if(!achou) {		
			return false;
		}else {
			return true;
		}
	}
	
	// remover item no carrinho do Banco de produtos
	public boolean removerItemCarrinho(int cod) {
		boolean achou = false;
		Produto p = new Produto(cod);
		for (int i = 0; i < getProdutos().size(); i++) {
			if (p.equals(getProdutos().get(i))) {
				getProdutos().remove(getProdutos().get(i));
				qProd.remove(i);
				quantidade--;
				achou = true;
				break;
			}
		}	
		return achou;
	}
	
	// retorna valor total dos itens do carrinho
	public Double valorTotal() {
		Double valor = 0.0;
		for (int i = 0; i < getProdutos().size(); i++) {
			Produto p = getProdutos().get(i);
			valor = valor + (qProd.get(i) * p.getPreco()) ;
		}
		return valor;
	}
	
	
	public List<Produto> produtosDoCarrinho() {
		return getProdutos();
	}
	
	public List<Integer> quantidadeItensCarrinho() {
		return qProd;
	}
	
	// verifica produtos no carrinho para finalizar compra
	public boolean finalizarCompra() {
		if(getProdutos().size() <= 0) {
			return false;
		}else {
			return true;
		}
	
	}
}
