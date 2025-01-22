package lab8_java;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPacotes {
	private List<Pacote> historico;

	public HistoricoPacotes() {
		this.historico = new ArrayList<Pacote>();
	}

	public void adicionarAoHistorico(Pacote pacote) {
		historico.add(pacote);
		System.out.println("\nPacote " + pacote.getDescricao() + " adicionado ao histórico!\n");
	}
	
	public void exibirFila(List<Cliente> clientes) {
		if(historico.isEmpty()) {
			System.out.print("\nNenhum pacote no histórico!\n");
			return;
		}
		System.out.print("\n\tHISTÓRICO:");
		System.out.println("\n=============================");
		for (Pacote pacote : historico) {
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
	
	public List<Pacote> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Pacote> historico) {
		this.historico = historico;
	}
	
	
}
