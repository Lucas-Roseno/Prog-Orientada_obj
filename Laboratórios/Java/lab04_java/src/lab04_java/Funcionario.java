package lab04_java;

public class Funcionario {
	protected String nomeFuncionario;
	protected float salario_base;
	
	public Funcionario(String nome, float salario)
	{
		this.nomeFuncionario = nome;
		this.salario_base = salario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public float getSalario_base() {
		return salario_base;
	}
	public void setSalario_base(float salario_base) {
		this.salario_base = salario_base;
	}

	public void descricao()
	{
		System.out.print("\n---------------------------------------");
		System.out.print("\nFuncionario: " + this.nomeFuncionario + "\nSalário base: " + 
				this.salario_base + "\n");
		System.out.println("---------------------------------------");
	}
}
