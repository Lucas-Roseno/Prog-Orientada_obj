package lab8_java;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class FilaEntradaPacotes {
	private Queue<Pacote> fila;

	public FilaEntradaPacotes() {
		this.fila = new LinkedList<>();
	}
	
	public void adicionarPacote(Pacote novoPacote) {
		this.fila.offer(novoPacote);
		System.out.println("\nPacote: " + novoPacote.getDescricao() + " adicionadoa fila de entrada\n");
	}

	public Pacote removerPacote() {
		return fila.poll();
	}
	
	public void exibirFila(List<Cliente> clientes) {
		if(fila.isEmpty()) {
			System.out.println("\nNenhum pacote na fila de entrada!\n");
			return;
		}
		System.out.print("\n\tFILA DE ENTRADA:");
		System.out.println("\n=============================");
		for (Pacote pacote : fila) {
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
		for (Pacote pacote : fila) {
			if(pacote.getCodigoPacote() == cod) {
				return true;
			}
		}
		return false;
	}
	
	public Queue<Pacote> getFilaPacotes() {
		return fila;
	}

	public void setFilaPacotes(Queue<Pacote> filaPacotes) {
		this.fila = filaPacotes;
	}
}
