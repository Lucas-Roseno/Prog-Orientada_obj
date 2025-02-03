package lab9java;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int codigoPedido;
	private String clienteNome;
	private List<Produto> itens;
	private double total;

	public Pedido(int codigoPedido, String clienteNome) {
		this.codigoPedido = codigoPedido;
		this.clienteNome = clienteNome;
		this.itens = new ArrayList<>();
		this.total = 0;
	}

	public void adicionarProduto(Produto produtoOriginal, int quantidade){
		Produto produtoNoPedido = new Produto(produtoOriginal.getCodigo(), 
		produtoOriginal.getDescricao(), produtoOriginal.getPreco(), quantidade);

		//considerei que o estoque no pedido do cliente é a quantidade que ele comprou do estoque original
		
		somarAoTotal(produtoNoPedido.getPreco() * quantidade);
		itens.add(produtoNoPedido); 
	}

	public void somarAoTotal(double valor){
		total += valor;
	}
	
	
	public void exibirPedido(){
		System.out.printf("""
				\nCodigo: %d
				Nome do cliente: %s
				Total: R$%.2f
				""", codigoPedido, clienteNome, total);
		System.out.println("ITENS DO PEDIDO: ");

		for(Produto produto : itens){
			System.out.println(produto.toString());
			System.out.println("---------------------------");
		}
	}
	
	
	public List<Produto> getItens() {
		return itens;
	}
	
	
	public int getCodigo() {
		return codigoPedido;
	}
	
}
