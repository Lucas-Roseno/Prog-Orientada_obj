package ex1_slide_herancaMutlipla;

public class AudioLivro extends Livro{
	protected DVD dvd;
	protected String narrador;
	
	public AudioLivro(String titutlo, String autor, int numPags, int duracao, String narrador) {
		super(titutlo, autor, numPags);
		this.dvd = new DVD(titutlo, autor, duracao);
		this.narrador = narrador;
	}

	@Override
	public void descricao() {
		super.descricao();
		System.out.printf("Duração: %d min\nNarrador: %s", dvd.duracao, narrador );
	}
	
	

}
