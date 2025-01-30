package lab9_java;

public class Produto {
	private int codigo;
	private String descricao;
	private double preco;
	private int estoque;
	
	public Produto(int codigo, String descricao, double preco, int estoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public Produto(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	
	
	
	
}
