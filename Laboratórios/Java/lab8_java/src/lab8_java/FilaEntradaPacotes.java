package lab8_java;
import java.util.LinkedList;
import java.util.Queue;

public class FilaEntradaPacotes {
	private Queue<Pacote> fila;

	public FilaEntradaPacotes() {
		this.fila = new LinkedList<>();
	}

	public Queue<Pacote> getFilaPacotes() {
		return fila;
	}

	public void setFilaPacotes(Queue<Pacote> filaPacotes) {
		this.fila = filaPacotes;
	}
}
