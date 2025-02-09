public class App {

    public static <T extends Comparable<T>> T retornarMaior(T x, T y){
        if (x.compareTo(y) > 0) {
            return x;
        }else {
            return y;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println( "O maior é: " + retornarMaior('a', 'z'));
    }
}
