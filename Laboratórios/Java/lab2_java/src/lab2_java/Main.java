package lab2_java;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Biblioteca bibliotecaLivros = new Biblioteca();
		
		
		int opcao;
		String dataNascimento, nome, titulo, ISBN;
		
		System.out.println("============================================");
		System.out.println("\tBIBLIOTECA DO LUCÃO");
		System.out.println("============================================");
		
		
		do
		{
			System.out.printf("\n1 - Adicionar livro a biblioteca:\n"
					+ "2 - Procurar um livro\n"
					+ "3 - Mostrar todos os livros da biblioteca\n"
					+ "Digite a opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			if(opcao == 1)
			{
				Livro novoLivro = new Livro();
				Autor novoAutor = new Autor();
				
				System.out.print("Nome do autor: ");
				nome = scanner.nextLine();
				System.out.print("Qual a data de nascimento do autor: ");
				dataNascimento = scanner.nextLine();
				System.out.print("Título do livro: ");
				titulo = scanner.nextLine();
				System.out.print("ISBN: ");
				ISBN = scanner.nextLine();
				
				novoAutor.setDataNascimento(dataNascimento);
				novoAutor.setNome(nome);
				novoLivro.setAutor(novoAutor);
				novoLivro.setTitulo(titulo);
				novoLivro.setISBN(ISBN);
				
				bibliotecaLivros.adicionarLivro(novoLivro);
				
			}else if (opcao == 2)
			{
				System.out.print("Digite o título do livro: ");
				titulo = scanner.nextLine();
				bibliotecaLivros.buscarLivro(titulo, bibliotecaLivros);
			
			}else if(opcao == 3)
			{
				bibliotecaLivros.mostrarLivros();
			}
			
			
		}while(opcao >= 1 && opcao <= 3);
		

		System.out.println("\nFIM");
	}

}
