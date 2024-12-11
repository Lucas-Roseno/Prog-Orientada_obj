package ex2_slide_herancaMultipla;

public class Atracao {
	protected String nome;
	protected int capacidade;
	
	public Atracao(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}
	
	public void info()
	{
		System.out.print("Esta é uma atração");
	}
}
