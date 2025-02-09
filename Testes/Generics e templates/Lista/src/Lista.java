public class Lista<T> {
    private No<T> cabeca;
    private No<T> cauda;

    public Lista(){
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean estaVazia(){
        return (cabeca == null);
    }

    public void inserirInicio(T valor){
        No<T> novoNo = new No<>(valor);
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        }else{
            novoNo.setProx(cabeca);
            cabeca = novoNo;
        }
    }

    public void inserirFinal(T valor){
        if (estaVazia()) {
            inserirInicio(valor);
        }else{
            No<T> novoNo = new No<>(valor);
            if (cabeca == cauda) {
                cabeca.setProx(novoNo);
                cauda = novoNo;
            }else {
                cauda.setProx(novoNo);
                cauda = novoNo;
            }
        }
    }

    public void imprimir(){
        if (estaVazia()) {
            System.out.println("\nLista está vazia!\n");
            return;
        }

        int cont = 1;
        No<T> aux = cabeca;
        while (aux != null) {
            System.out.println(cont + " - " + aux.getValor());
            aux = aux.getProx();
            cont++;
        }
    }
}
