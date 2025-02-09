public class No<T> {
    private T valor;
    private No<T> prox;

    public No(T val) {
        this.valor = val;
        this.prox = null;
    }

    

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }

}
