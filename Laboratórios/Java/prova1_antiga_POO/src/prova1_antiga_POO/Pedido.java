package prova1_antiga_POO;

public class Pedido {
	private int numPedido;
	private String nomeCliente;
	private String data;
	private Produto[] lista;
	private int cont = 0;
	
	public Pedido(int num, String nome, String data) {
		this.numPedido = num;
		this.nomeCliente = nome;
		this.data = data;
		this.lista = new Produto[5];
	}
	
	public void adicionarProduto(Produto produto) {
		if (cont > 4)
		{
			System.out.println("Não é possível adicionar");
			return;
		}
		
		lista[cont] = produto;
		cont++;	
	}
	
	public void listarProdutos()
	{
		for (int i = 0; i <= cont; i++) {
			System.out.printf("Nome: %s \nQuantidade: %d \n", lista[i].getNome(), lista[i].getQuant());
		}
	}
	
	public void imprimirInfo()
	{
		System.out.printf("\nNúmero pedido: %d \nNome cliente: %s \n"
				+ "Data da compra: %s\n",numPedido, nomeCliente, data);
	}
}
