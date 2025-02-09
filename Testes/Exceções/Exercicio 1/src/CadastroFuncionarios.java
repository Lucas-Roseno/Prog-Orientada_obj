import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarios {
    private List<Funcionario> funcionarios;

    public CadastroFuncionarios(){
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(String nome, double salario){
        if (salario < 1340) {
            throw new IllegalArgumentException("Salário menor que o salário mínimo");
        }
        Funcionario novoFuncionario = new Funcionario(nome, salario);
        funcionarios.add(novoFuncionario);
        System.out.println("\nFuncionário cadastrado com sucesso!\n\n");
    }

    public void removerFuncionario(String nome){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void imprimirFuncionario(String nome) {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado ainda!\n\n");
            return;
        }
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                System.out.println("Nome: " + funcionario.getNome() + " - Salário: " + funcionario.getSalario());
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void adicionarBonus(String nome, double bonus){
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado ainda!\n\n");
            return;
        }

        if(bonus <= 0){
            throw new IllegalArgumentException("O bônus deve ser maior que 0!");
        }
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionario.setSalario(funcionario.getSalario() + bonus);
                System.out.println("Aumento concedido com sucesso!\nNovo salario: R$" + 
                funcionario.getSalario());
                return;
            }
        }
        throw new IllegalArgumentException("Funcionário não encontrado!");
    }

    public void aumentarSalario(String nome, double aumento){
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado ainda!\n\n");
            return;
        }

        if (aumento <= 0) {
            throw new IllegalArgumentException("Aumento deve ser maior que 0!");
        }
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionario.setSalario(funcionario.getSalario() + aumento);
                return;
            }
        }
        throw new IllegalArgumentException("Funcionário não encontrado!");
    }
}
