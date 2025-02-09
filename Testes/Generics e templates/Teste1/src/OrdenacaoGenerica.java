import java.util.Arrays;

public class OrdenacaoGenerica {

    // Método genérico para imprimir um array
    public static <T> void printArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    // Método genérico para ordenar um array usando Bubble Sort
    public static <T extends Comparable<T>> void ordenaArray(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Troca os elementos
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        printArray(array);
    }

    public static void main(String[] args) {
        // Arrays de diferentes tipos
        Integer[] numeros = {10, 2, 3, 5, 6};
        Character[] caracteres = {'z', 'a', 'j', 'e', 'k'};

        // Ordenando e imprimindo os arrays
        ordenaArray(numeros);
        ordenaArray(caracteres);
    }
}
