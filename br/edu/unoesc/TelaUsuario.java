package br.edu.unoesc;

import java.util.Scanner;

public class TelaUsuario {
	
	Scanner sc = new Scanner(System.in);
	
	public String nomeUsuario() {
		System.out.println("Digite o nome do usuario");
		String nome = sc.next();
		return nome;
	}
	
	public String emailUsuario() {
		System.out.println("Digite o email do usuario");
		String email = sc.next();
		return email;
	}
	
	public String enderecoUsuario() {
		System.out.println("Digite o endereço");
		sc.nextLine();
		String endereco = sc.next();
		return endereco;
	}
	
	
	
	public void cadastrar() {
		System.out.println("cadastrar");
		System.out.println("nome");
		sc.hasNextLine();
		String nome = sc.nextLine();
		System.out.println("email");
		sc.hasNextLine();
		String email = sc.nextLine();
		System.out.println("endereco");
		sc.hasNextLine();
		String endereco = sc.nextLine();
		Usuario c = new Usuario(nome,email,endereco);
		Banco.usuario.add(c);
		sc.close();
	}

	
	
	public void listar() {
		System.out.println("Lista de user");
		for(Usuario c : Banco.usuario) {
			System.out.println(c.getNome());
			System.out.println(c.getEmail());
			System.out.println(c.getEndereco());
		}
		
	}
	
}
