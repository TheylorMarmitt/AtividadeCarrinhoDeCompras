package br.edu.unoesc;


public class Produto {

	private String nome; 
	private int codigo;
	private Double preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, int codigo, Double preco) {
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}
	
	public Produto(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	// adiciona produto
	public boolean adicionarProduto(String nome, int codigo, Double preco) {
		boolean achou = false;
		Produto p = new Produto(nome, codigo, preco);
		for (int i = 0; i < Banco.produtos.size(); i++) {
			if (p.equals(Banco.produtos.get(i))) {
				achou = true;
				break;
			}
		}
		if (!achou) {
			Banco.produtos.add(p);
			return true;
		}else {
			return false;			
		}
	}
	
	// remove produto
	public boolean removerProduto(int cod) {
		boolean achou = false;
		Produto p = new Produto(cod);
		for (int i = 0; i < Banco.produtos.size(); i++) {
			if (p.equals(Banco.produtos.get(i))) {
				achou = true;
				break;
			}
		}	
		if(achou) {
			Banco.produtos.remove(p);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	// lista produtos
	public void listar() {
		Banco.produtos.forEach(System.out::println);
	}

	@Override
	public String toString() {
		return " Produto: nome: " + nome + ", cod: " + codigo + ", preco: " + preco;
	}
	
	
}
