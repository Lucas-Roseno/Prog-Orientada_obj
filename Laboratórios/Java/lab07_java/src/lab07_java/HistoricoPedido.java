package lab07_java;

public class HistoricoPedido{
    private Pedido cabeca;
    private Pedido cauda;

    public HistoricoPedido(){
        cabeca = null;
        cauda = null;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void inserirNoInicio(Pedido pedidoAtendido){
        if (estaVazia()) {
            cabeca = pedidoAtendido;
            cauda = pedidoAtendido;
            System.out.println("Pedido " + pedidoAtendido.getCodigoPedido() + " adicionando ao histórico!\n");
        }else{
            pedidoAtendido.setProximo(cabeca);
            cabeca = pedidoAtendido;
            System.out.println("Pedido " + pedidoAtendido.getCodigoPedido() + " adicionando ao histórico!\n");
        }
    }

    public void inserirNoFinal(Pedido pedidoAtendido){
        if (estaVazia()) {
            inserirNoInicio(pedidoAtendido);
        }else{
            cauda.setProximo(pedidoAtendido);
            cauda = pedidoAtendido;
            cauda.setProximo(null);
            System.out.println("Pedido " + pedidoAtendido.getCodigoPedido() + " adicionando ao histórico!\n");
        }
    }
    
    public void exibirPedidosAtendidos(ListaClientes listaClientes) {
        Pedido aux = cabeca;
        Pessoa auxPessoa;
        System.out.println("=========== PEDIDOS CONCLUÍDOS ===========");
        while (aux != null) {
            System.out.println(String.format("\t%-20s: %s", "Código do Pedido", aux.getCodigoPedido()));
            System.out.println(String.format("\t%-20s: %s", "Descrição do Pedido", aux.getDescricaoPedido()));
            System.out.println(String.format("\t%-20s: %d minutos", "Tempo Estimado", aux.getTempoEstimado()));

            auxPessoa = listaClientes.getCabeca();
            while (auxPessoa != null) {
                if (auxPessoa.getCpf().equals(aux.getCpf())) {
                    System.out.println(String.format("\t%-20s: %s", "Cliente", auxPessoa.getNome()));
                    System.out.println(String.format("\t%-20s: %s", "CPF", auxPessoa.getCpf()));
                    break;
                }
                auxPessoa = auxPessoa.getProximo();
            }
            System.out.println("----------------------------------------");
            aux = aux.getProximo();
        }
        System.out.println("========================================\n");
    }

    public Pedido getCabeca() {
      return this.cabeca;
    }
    public void setCabeca(Pedido value) {
      this.cabeca = value;
    }

    public Pedido getCauda() {
      return this.cauda;
    }
    public void setCauda(Pedido value) {
      this.cauda = value;
    }
}