package lab2_java;

public class Biblioteca {
	private Livro[] livros = new Livro[100];
	private int cont = 0;
	
	public void adicionarLivro (Livro novoLivro)
	{
		livros[cont] = novoLivro;
		System.out.println(cont);
		cont++;
	}
	
	public void buscarLivro (String titulo, Biblioteca bibliotecaLivros)
	{	
		for(int i = 0; i < 100; i++)
		{
			if(livros[i] == null)
			{
				System.out.println("Livro não encotrado");
				break;
			}
			if(livros[i].getTitulo().equals(titulo))
			{
				
				System.out.println("\n=========================================");
				System.out.printf("Titulo: %s\n"
						+ "ISBN: %s\n"
						+ "Autor: %s\n"
						+ "Data nascimento do autor: %s\n",
						livros[i].getTitulo(), 
						livros[i].getISBN(),
						livros[i].getAutor().getNome(), 
						livros[i].getAutor().getDataNascimento());
				System.out.println("=========================================\n");
				break;
			}
		}	
	}
	
	public void mostrarLivros()
	{
		for(int i = 0; i < 100; i++)
		{
			if(livros[i] == null)
			{
				break;
			}
			System.out.println("=========================================");
			System.out.printf("\nTitulo: %s\n"
					+ "ISBN: %s\n"
					+ "Autor: %s\n"
					+ "Data nascimento do autor: %s\n\n",
					livros[i].getTitulo(),
					livros[i].getISBN(), 
					livros[i].getAutor().getNome(),
					livros[i].getAutor().getDataNascimento());
			System.out.println("=========================================");
		}
	}
}
