package prova1_antiga_POO;

public class Produto {
	protected String nome;
	protected int quant;
	
	public Produto(String nome, int quant)
	{
		this.nome = nome;
		this.quant = quant;
	}
	
	public String toString()
	{
		return "Produto: " + nome + "\nQuantidade: " + quant;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
}
