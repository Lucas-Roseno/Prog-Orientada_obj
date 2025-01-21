package lab07_java;


public class FilaPedidos {
    private Pedido cabeca;
    private Pedido cauda;

    public FilaPedidos(){
        this.cabeca = null;
        this.cauda = null;
    }

	public FilaPedidos(Pedido novoPedido){
        this.cabeca = novoPedido;
        this.cauda = cabeca;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void enfileirar(Pedido novoPedido){
        if(estaVazia()){
            cabeca = novoPedido;
            cauda = cabeca;
            System.out.println("Pedido cadastrado!\n");
        }else{
            cauda.setProximo(novoPedido);
            cauda = novoPedido;
            System.out.println("Pedido cadastrado!\n");
        }
    }

    public Pedido desenfileirar() {
        if (estaVazia()) {
            System.out.print("Não tem nenhum pedido cadastrado no momento!\n\n");
            return null;
        } else {
            Pedido pedidoRemovido = cabeca;
            cabeca = cabeca.getProximo();
            if (cabeca == null) {
                cauda = null;
            }
            System.out.println("Pedido " + pedidoRemovido.getDescricaoPedido() + " foi preparado!\n");
            return pedidoRemovido;
        }
    }
    
    public void exibirPedidos(ListaClientes listaClientes) {
        Pedido aux = cabeca;
        Pessoa auxPessoa;
        System.out.println("\t=========== LISTA DE PEDIDOS ===========");
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
		return cabeca;
	}

	public void setCabeca(Pedido cabeca) {
		this.cabeca = cabeca;
	}

	public Pedido getCauda() {
		return cauda;
	}

	public void setCauda(Pedido cauda) {
		this.cauda = cauda;
	}
}



