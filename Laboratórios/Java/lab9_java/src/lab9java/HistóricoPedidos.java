package lab9java;
import java.util.ArrayList;
import java.util.List;
public class HistóricoPedidos<T extends Pedido> {
    private List<T> historico;

    public HistóricoPedidos() {
        this.historico = new ArrayList<>();
    }

    public void adicionarAoHistorico(T pedido) {
        historico.add(pedido);
    }

    public void exibirHistorico() {
        System.out.println("HISTÓRICO DE PEDIDOS:");
        for (T pedido : historico) {
            pedido.exibirPedido();
            System.out.println("---------------------------");
        }
    }
    
    public List<T> getHistorico() {
        return historico;
    }

}
