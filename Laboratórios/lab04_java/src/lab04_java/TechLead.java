package lab04_java;

public class TechLead extends Funcionario implements Gerente, Desenvolvedor{
	
	protected String linguagem_principal;
	protected int numero_de_equipes, projetos_em_andamento;
	
	
	public TechLead(String nome, float salario, String linguagem, int numEquipes, int projetos) {
		super(nome, salario);
		this.linguagem_principal = linguagem;
		this.numero_de_equipes = numEquipes;
		this.projetos_em_andamento = projetos;
	}
	
	public int getProjetos_em_andamento() {
		return projetos_em_andamento;
	}

	public void setProjetos_em_andamento(int projetos_em_andamento) {
		this.projetos_em_andamento = projetos_em_andamento;
	}

	
//=======================================================================
	@Override
	public String getLinguagem_principal() {
		return this.linguagem_principal;
	}

	@Override
	public void setLinguagem_principal(String linguagemPrin) {
		this.linguagem_principal = linguagemPrin;
	}

	@Override
	public String projetos_realizados(String linguagemPrin) {
		return "\nProjetos entregues na linguagem: " + linguagemPrin;
	}

	@Override
	public int getNumero_de_Equipes() {
		return this.numero_de_equipes;
	}

	@Override
	public void setNumero_de_equipes(int numero_de_equipes) {
		this.numero_de_equipes = numero_de_equipes;
	}

	@Override
	public float bonus(float numEquipes) {
		return this.numero_de_equipes * 500;
	}
	
	@Override
	public void descricao()
	{
		System.out.print("\n---------------------------------------");
		System.out.printf("\nNome: %s \nSalário base: R$%.2f \nNúmero de equipes: %d \nBônus: R$%.2f \nLinguagem principal: %s"
				+ "\nProjetos em andamento: %d", this.nomeFuncionario, this.salario_base, this.numero_de_equipes,
				this.bonus(this.numero_de_equipes), this.linguagem_principal, this.projetos_em_andamento);
		System.out.println("\n---------------------------------------");
	}
}
