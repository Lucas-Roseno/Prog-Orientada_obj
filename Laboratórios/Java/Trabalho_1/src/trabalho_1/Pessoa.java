package trabalho_1;

public class Pessoa {
	protected String nome;
	protected short idade;
	protected String identificador;
	
	public Pessoa(String nome, short idade, String identificador) {
		this.nome = nome;
		this.idade = idade;
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public short getIdade() {
		return idade;
	}
	public void setIdade(short idade) {
		this.idade = idade;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
}
