package lab05_java;

public class Produto {
	protected String nome;
	protected double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void getDetalhes() {
		System.out.printf("\tNome produto: %s"
				+ "\n\tPreço: R$%.2f\n", nome, preco);
	}
	
}
