
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        Lista<Integer> listaInteiros = new Lista<>();
        Lista<String> listaStrings = new Lista<>();
        
        int valorInteiro;
        String valorString;
        

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar inteiro");
            System.out.println("2. Adicionar string");
            System.out.println("3. Mostrar lista de inteiros");
            System.out.println("4. Mostrar lista de strings");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite um inteiro para adicionar à lista: ");
                    valorInteiro = scanner.nextInt();
                    listaInteiros.inserirFinal(valorInteiro);
                }
                case 2 -> {
                    System.out.print("Digite uma string para adicionar à lista: ");
                    valorString = scanner.nextLine();
                    listaStrings.inserirFinal(valorString);
                }
                case 3 -> {
                    System.out.println("Lista de Inteiros:");
                    listaInteiros.imprimir();
                }
                case 4 -> {
                    System.out.println("Lista de Strings:");
                    listaStrings.imprimir();
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Por favor, tente novamente.");
            }
            
        } while (opcao != 0);
    }
}
