package lab9_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciamentoEcommerce {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int opcao = 0, codigo, estoque;
		String descricao;
		double preco;
		
		while(true) {
		System.out.print("""
			1 - Cadastrar um novo produto
			2 - 
			Opçao: """);
		
		try {
			opcao = scanner.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Valor inválido!\n");
			scanner.nextLine();
			continue;
		}
		
		switch (opcao) {
			case 1 -> {
				System.out.print("Código do produto: ");
				codigo = scanner.nextInt();
				System.out.print("Descrição: ");
				descricao = scanner.nextLine();
				System.out.print("Preço: R$");
				preco = scanner.nextDouble();
				System.out.println("Estoque: ");
				estoque = scanner.nextInt();
				
				Produto novoProduto = new Produto(0, descricao, preco, estoque);
				
			}

		}
		
		

		}

	}
	
}
