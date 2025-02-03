import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fila fila = new Fila();

        int opcao, prioridade;
        String nome;

        while (true) { 
            System.out.println("==========MENU==========");
            System.out.print("""
            1 - Enfileirar
            2 - Desenfileirar
            3 - Exibir pacientes
            4 - Verificar se a fila está vazia
            Opção:\t
            """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Prioridade: ");
                    prioridade = scanner.nextInt();
                    scanner.nextLine();
                    fila.enfileirar(nome, prioridade);
                    System.out.println("\nPaciente adiconado a fila com sucesso!\n");
                    break;
                }
                case 2 -> fila.desenfileirar();
                case 3 -> fila.exibirFila();
                case 4 -> {
                    if (fila.estaVazia()) {
                        System.out.println("\nFila vazia\n");
                    } else {
                        System.out.println("\nFila não está vazia\n");
                    }
                    break;
                }
                default -> {
                    System.out.println("Opção inválida");
                    break;
                }
            }

        }
    }
}

