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
