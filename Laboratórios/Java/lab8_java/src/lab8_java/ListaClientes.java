package lab8_java;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {
	private List<Cliente> listaDeClientes;

	public ListaClientes() {
		this.listaDeClientes = new ArrayList<>();
	}

	public void adicionarCliente(String nome, String cpf) {
		if (!cpfJaCadastrado(cpf)) {
			Cliente clienteTemp = new Cliente(nome, cpf);
			this.listaDeClientes.add(clienteTemp);	
			System.out.println("Cliente adicionado com sucesso!");
		}else {
			System.out.println("CPF já cadastrado!\n\n");
		}
		
	}
	
	public void exibirClientes() {
		if(listaDeClientes.isEmpty()) {
			System.out.println("\nNenhum cliente cadastrado!\n");
			return;
		}
		System.out.print("\n\tCLIENTES:");
		System.out.println("\n=============================");
		for (Cliente cliente : listaDeClientes) {
			System.out.println(cliente.toString());
			System.out.println("-----------------------------");
		}
		System.out.println("=============================");
	}
	
	public boolean cpfJaCadastrado(String cpf) { // true se existir na lista
		for (Cliente cliente : listaDeClientes) {
			if(cliente.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	
	
	
	
}
