package ex2_slide_herancaMultipla;

public class Carrosel extends Atracao implements Mecanica, Tematica{
	protected int velocidade;
	protected String tema;
	
	public Carrosel(String nome, int capacidade, int velocidade, String tema) {
		super(nome, capacidade);
		this.velocidade = velocidade;
		this.tema = tema;
	}

	@Override
	public int getVelocidade() {
		return velocidade;
	}

	@Override
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	@Override
	public String getTema() {
		return tema;
	}

	@Override
	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public void info()
	{
		System.out.printf("\nEste carrossel tem o tema %s e move-se a %d km/h", tema, velocidade);
	}
}
