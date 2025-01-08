package lab05_java;

public class Eletronico extends Produto {

	protected int garantia;
	
	public Eletronico(String nome, double preco, int garantia) {
		super(nome, preco);
		this.garantia = garantia;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	
	@Override
	public void getDetalhes() {
		super.getDetalhes();
		System.out.printf("\tTipo: eletrônico\n"
				+ "\tGarantia: %d\n", garantia);
		System.out.print("\t*********************\n");
	}

}
