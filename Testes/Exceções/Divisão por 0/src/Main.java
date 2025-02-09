import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1;
        int number2;
        double result;
        Matematica mat = new Matematica();

        System.out.println("Digite 2 inteiros: ");

        while (true) {
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();

            if (number2 == 666)
                break;

            try {
                result = mat.quotient(number1, number2);
                System.out.println("Quociente: " + result);
            } catch (ExcecaoDivisaoPorZero ex) {
                System.out.println("Uma excecao ocorreu: " + ex.getMessage());
            }

            System.out.println("\nDigite 2 inteiros: ");
        }

        scanner.close();
        System.out.println();
    }
}
