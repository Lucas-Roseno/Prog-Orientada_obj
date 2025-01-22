package lab8_java;

public class Pacote {
	private int codigoPacote;
	private String descricao;
	private int prioridade;
	private String cpf;
	
	public Pacote(int codigoPacote, String descricao, int prioridade, String cpf) {
		super();
		this.codigoPacote = codigoPacote;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.cpf = cpf;
	}
	
	public String toString() {
		return "Código do pacote: " + codigoPacote + "\nDescrição: " + descricao + "\nPrioridade: "
				+ prioridade + "\nCPF do cliente: " + cpf;
	}
	public int getCodigoPacote() {
		return codigoPacote;
	}
	public void setCodigoPacote(int codigoPacote) {
		this.codigoPacote = codigoPacote;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
