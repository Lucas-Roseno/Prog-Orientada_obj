package trabalho_1;

public class Sobrevivente extends Pessoa{
	protected String habilidades[];
	protected String status;
	
	public Sobrevivente(String nome, short idade, String identificador, String habilidades[], String status) {
		super(nome, idade, identificador);
		this.habilidades = habilidades;
		this.status = status;
	}

	public String[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
		

}
