package lab05_java;

public class Vestuario extends Produto{
	
	protected String tamanho;
	
	public Vestuario(String nome, double preco, String tam) {
		super(nome, preco);
		this.tamanho = tam;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public void getDetalhes() {
		super.getDetalhes();
		System.out.printf("\tTipo: vestuário\n"
				+ "\tTamanho: %s\n", tamanho);
		System.out.print("\t*********************\n");
	}
	
	
}
