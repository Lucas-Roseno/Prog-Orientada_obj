

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String _nome, double _salario){
        this.nome = _nome;
        this.salario = _salario;
    }

    public void adicionarBonus(double bonus){
        salario += bonus;
        System.out.printf("\nBonus de R$%.2f adicionado ao salário:  R$%.2f\n\n", bonus, salario);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
