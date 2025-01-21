package lab07_java;

public class Pessoa {

    private String nome;
    private String cpf;
    private Pessoa proximo = null;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void getDetalhes(){
        System.out.println("\tNome: " + nome
		+ "\n\tCPF: " + cpf + "\n");
    }
    
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Pessoa getProximo() {
		return this.proximo;
	}

	public void setProximo(Pessoa proximo) {
		this.proximo = proximo;
	}    
}
	