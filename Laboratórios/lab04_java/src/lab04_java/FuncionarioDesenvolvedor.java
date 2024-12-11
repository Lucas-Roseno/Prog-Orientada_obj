package lab04_java;

public class FuncionarioDesenvolvedor extends Funcionario implements Desenvolvedor {
	
	protected String linguagem_principal;
	
	public FuncionarioDesenvolvedor(String nome, float salario, String linguagem) {
		super(nome, salario);
		this.linguagem_principal = linguagem;
	}	
	
	@Override
	public void setLinguagem_principal(String linguagemPrin){
		this.linguagem_principal = linguagemPrin;
		
	}

	@Override
	public String getLinguagem_principal() {
		return this.linguagem_principal;
	}
	

	@Override
	public String projetos_realizados(String linguagemPrin) {
		return "Projetos entregues na linguagem: " + linguagemPrin;
	}
	
}
