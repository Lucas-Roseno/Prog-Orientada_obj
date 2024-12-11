package ex1_slide_herancaMutlipla;

public class DVD extends Material {
	protected int duracao;
	
	public DVD(String titutlo, String autor, int duracao) {
		super(titutlo, autor);
		this.duracao = duracao;
	}

	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public void descricao() {
		super.descricao();
		System.out.printf("Duração: %d minutos\n", duracao);
	}

	
}
