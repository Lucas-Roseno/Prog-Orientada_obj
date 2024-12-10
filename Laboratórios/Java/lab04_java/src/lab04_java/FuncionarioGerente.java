package lab04_java;

public class FuncionarioGerente extends Funcionario implements Gerente{

	protected int numero_de_equipes;
		
	public FuncionarioGerente(String nome, float salario, int numEquipes) {
		super(nome, salario);
		this.numero_de_equipes = numEquipes;
	}
	
	@Override
	public int getNumero_de_Equipes() {
		return numero_de_equipes;
	}
	
	@Override
	public void setNumero_de_equipes(int numero_de_equipes) {
		this.numero_de_equipes = numero_de_equipes;
	}
	
	@Override
	public float bonus(float numEquipes)
	{
		return numEquipes * 500;
	}
}
