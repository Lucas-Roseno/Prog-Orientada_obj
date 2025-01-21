package lab07_java;

public class Pedido{
    private int codigoPedido;
    private String descricaoPedido;
    private int tempoEstimado;
    private String cpf;
    private Pedido proximo;

	public Pedido() {
        this.codigoPedido = 0;
        this.descricaoPedido = "";
        this.tempoEstimado = 0;
        this.cpf = "";
        this.proximo = null;
    }
	
    public Pedido(int codigoPedido, String descricaoPedido, int tempoEstimado, String cpf){
        this.codigoPedido = codigoPedido;
        this.descricaoPedido = descricaoPedido;
        this.tempoEstimado = tempoEstimado;
        this.cpf = cpf;
		this.proximo = null;
    }

	public int getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getDescricaoPedido() {
		return this.descricaoPedido;
	}

	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}

	public int getTempoEstimado() {
		return this.tempoEstimado;
	}

	public void setTempoEstimado(int tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


    public Pedido getProximo() {
      return this.proximo;
    }
    public void setProximo(Pedido value) {
      this.proximo = value;
    }
}