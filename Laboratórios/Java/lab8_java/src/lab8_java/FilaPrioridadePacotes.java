package lab8_java;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPrioridadePacotes {
	private Queue<Pacote> filaPrioridade;
	
	public FilaPrioridadePacotes() {
		this.filaPrioridade = new LinkedList<Pacote>();
	}

	public Queue<Pacote> getFilaPrioridade() {
		return filaPrioridade;
	}

	public void setFilaPrioridade(Queue<Pacote> filaPrioridade) {
		this.filaPrioridade = filaPrioridade;
	}
}
