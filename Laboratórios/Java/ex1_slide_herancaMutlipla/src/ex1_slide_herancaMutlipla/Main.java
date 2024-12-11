package ex1_slide_herancaMutlipla;

public class Main {

	public static void main(String[] args) {
		Material materialObj = new Material("Impressora 3d", "James");
		materialObj.descricao();
		Livro livroObj = new Livro("Cálculo 1", "James Stuart", 900);
		livroObj.descricao();
		DVD dvdObj = new DVD("Gigantes de Aço", "Shaw Dre", 120);
		dvdObj.descricao();
		AudioLivro audioBookObj = new AudioLivro("Dom Casmurro", "Machado de Assis", 500, 200, "Roberto");
		audioBookObj.descricao();

	}

}
