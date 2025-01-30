package lab9_java;

import java.util.List;

public class Pedido {
	private int codigoPedido;
	private String clienteNome;
	private List<Produto> itens;
	private double total;
	
	public Pedido(int codigoPedido, String clienteNome) {
		this.codigoPedido = codigoPedido;
		this.clienteNome = clienteNome;
	}
	
	
	
	
}
