package lab05_java;

public class Cliente {
	protected String nome;
	protected String CPF;
	protected Produto[] compras;
	protected int cont = 0;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.CPF = cpf;
		this.compras = new Produto[100];
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Produto[] getCompras() {
		return compras;
	}
	public void setCompras(Produto[] compras) {
		this.compras = compras;
	}
	
	
	public void adicionaCompra(Produto p) {
		this.compras[cont] = p;
		cont++;
	}
	
	public double calculaTotal() {
		double total = 0;
		for (int i = 0; i < cont; i++) {
			total += compras[i].preco;
		}
		return total;
	}
	
	public void getDetalhes() {
		System.out.print("-------------------------------\n");
		System.out.printf("Nome cliente: %s"
				+ "\nCPF: %s"
				+ "\nTotal da compra: %.2f"
				+ "\nItens comprados:\n", nome, CPF, calculaTotal());
		for (int i = 0; i < cont; i++) {
			compras[i].getDetalhes();
		}
		System.out.print("-------------------------------\n");
	}
	
	
}
