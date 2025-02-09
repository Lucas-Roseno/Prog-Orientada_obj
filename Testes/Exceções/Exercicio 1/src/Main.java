import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    CadastroFuncionarios cadastro = new CadastroFuncionarios();
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar funcionário");
            System.out.println("2 - Remover funcionário");
            System.out.println("3 - Imprimir funcionário");
            System.out.println("4 - Adicionar bônus");
            System.out.println("5 - Aumentar salário");
            System.out.println("6 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do funcionário: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o salário do funcionário: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine();
                        cadastro.cadastrarFuncionario(nome, salario);
                        break;
                    case 2:
                        System.out.print("Digite o nome do funcionário para remover: ");
                        nome = scanner.nextLine();
                        cadastro.removerFuncionario(nome);
                        break;
                    case 3:
                        System.out.print("Digite o nome do funcionário para imprimir: ");
                        nome = scanner.nextLine();
                        cadastro.imprimirFuncionario(nome);
                        break;
                    case 4:
                        System.out.print("Digite o nome do funcionário para adicionar bônus: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite o valor do bônus: ");
                        double bonus = scanner.nextDouble();
                        scanner.nextLine();
                        cadastro.adicionarBonus(nome, bonus);
                        break;
                    case 5:
                        System.out.print("Digite o nome do funcionário para aumentar o salário: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite o valor do aumento: ");
                        double aumento = scanner.nextDouble();
                        scanner.nextLine();
                        cadastro.aumentarSalario(nome, aumento);
                        break;
                    case 6:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }
}
