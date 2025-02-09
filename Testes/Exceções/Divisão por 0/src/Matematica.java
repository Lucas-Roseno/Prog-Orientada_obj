public class Matematica {
    public double quotient(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ExcecaoDivisaoPorZero();
        }
        return (double) numerador / denominador;
    }
}