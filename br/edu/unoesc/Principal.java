package br.edu.unoesc;


public class Principal {

	public static void main(String[] args) {

		Produto p = new Produto();
		int continua = 1;
		
		TelaCarrinho tCar = new TelaCarrinho();
		TelaPrincipal tPri = new TelaPrincipal();
		TelaProduto tProd = new TelaProduto();
		TelaUsuario tUser = new TelaUsuario();
		
		while(continua == 1) {
			String nm =tProd.nomeProduto();
			int codigo = tProd.codigoProduto();
			Double preco = tProd.precoProduto();
			if(p.adicionarProduto(nm, codigo, preco)) {
				tProd.mensagemAdicionado();
			}else {
				tProd.mensagemProdutoExistente();
			}
			p.listar();
			continua = tPri.menuAdicionarProdutos();
		}
		
		String dt = tCar.data();
		
		String nome = tUser.nomeUsuario();
		String email = tUser.emailUsuario();
		String endereco = tUser.enderecoUsuario();
		Usuario user = new Usuario(nome,email,endereco);
		Banco.usuario.add(user);
		
		
		Carrinho c = new Carrinho();
		c.setData(dt);
		c.setUsuario(user);
	
		boolean sair = false;
		do {
			switch(tPri.menuCarrinho()) {
			case 1:{
				tPri.mensagemProdutosBanco();
				p.listar();
				if(c.produtosDoCarrinho().size() > 0) {
					tPri.mensagemProdutosCarrinho();
					tCar.mostrarProdutosDoCarrinho(c.produtosDoCarrinho(), c.quantidadeItensCarrinho());
				}else {
					tCar.carrinhoVazio();
				}
				int cod = tProd.codigoProduto();
				int q = tCar.quantidadeProduto();
				if(c.adicionarItemCarrinho(cod, q)) {
					tCar.mensagemAdicionado();
				}else {
					tCar.mensagemErro();
				}
				break;
			}
			case 2: {
				if(c.produtosDoCarrinho().size() > 0) {
					tPri.mensagemProdutosCarrinho();
					tCar.mostrarProdutosDoCarrinho(c.produtosDoCarrinho(), c.quantidadeItensCarrinho());
				}else {
					tCar.carrinhoVazio();
				}
				int cod = tProd.codigoProduto();
				if(c.removerItemCarrinho(cod)) {
					tCar.mensagemProdutoRemovido();
				}else {
					tCar.mensagemErroAoRemover();
				}
			}
				break;
			case 3:{
				if(c.finalizarCompra())	{
					tCar.mensagemFinalizarCompra(c);
					Banco.carrinho.add(c);
					sair = true;
					break;
				}else {
					tCar.mensagemErroAoFinalizar();
				}
			}
			default :
				tPri.MensagemErro();
			break;
			}
			
		}while(!sair);	
		tPri.fecharScan();
	}	
}
