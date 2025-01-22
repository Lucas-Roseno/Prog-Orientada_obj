package lab8_java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class FilaPrioridadePacotes {
	private Queue<Pacote> filaPrioridade;
	
	public FilaPrioridadePacotes() {
		this.filaPrioridade = new LinkedList<Pacote>();
	}
	
	public void adicionarPacote(Pacote novoPacote) {
		this.filaPrioridade.offer(novoPacote);
		System.out.println("\nPacote " + novoPacote.getDescricao() + " adicionado fila de prioridade\n");
	}
	
	public Pacote removerPacote() {
		return filaPrioridade.poll();
	}
	public void exibirFila(List<Cliente> clientes) {
		if(filaPrioridade.isEmpty()) {
			System.out.print("\nNenhum pacote na fila de prioridade!\n");
			return;
		}
		System.out.print("\n\tFILA DE PRIORIDADE:");
		System.out.println("\n=============================");
		for (Pacote pacote : filaPrioridade) {
			System.out.println(pacote.toString());
			for (Cliente cliente : clientes) {
				if(pacote.getCpf().equals(cliente.getCpf())) {
					System.out.println("Nome cliente: " + cliente.getNome());
				}
			}
			System.out.println("-----------------------------");
		}
		System.out.println("=============================");
	}
	
	public boolean codigoJaCadastrado(int cod) {
		for (Pacote pacote : filaPrioridade) {
			if(pacote.getCodigoPacote() == cod) {
				return true;
			}
		}
		return false;
	}

	public Queue<Pacote> getFilaPrioridade() {
		return filaPrioridade;
	}

	public void setFilaPrioridade(Queue<Pacote> filaPrioridade) {
		this.filaPrioridade = filaPrioridade;
	}
}
