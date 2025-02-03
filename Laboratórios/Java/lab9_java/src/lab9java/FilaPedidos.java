package lab9java;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos <T extends Pedido> {
    private Queue<T> fila;

    public FilaPedidos() {
        this.fila = new LinkedList<>();
    }

    public void adicionarPedido(T pedido) {
        fila.add(pedido);
    }

    public void exibirFila() {
        System.out.println("------FILA PEDIDOS PENDENTES------");
        for (T pedido : fila) {
            pedido.exibirPedido();
            System.out.println("---------------------------");
        }
    }
    
    public Queue<T> getFila() {
        return fila;
    }

    public T buscarPedido(int codigo) {		
		for (T t : fila) {
			if(t.getCodigo() == codigo) {
				return t;	
			}
		}
		return null;
	}

}
