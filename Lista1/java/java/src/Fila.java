public class Fila {
    private No cabeca;
    private No cauda;

    
    public Fila() {
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void enfileirar(String nome, int prioridade){
        No novoNo = new No(nome, prioridade, null);
        No noAux = cabeca;
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        }else{
            if(cabeca == cauda){
                cabeca.setProx(novoNo);
                cauda = novoNo;
            }else if (prioridade == 3) {
                cauda.setProx(novoNo);
                cauda = novoNo;
            } else if (prioridade == 2){
                while( noAux.getProx() != null && noAux.getProx().getPrioridade() < 3){
                    noAux = noAux.getProx();
                }
                novoNo.setProx(noAux.getProx());
                noAux.setProx((novoNo));
                if (novoNo.getProx() == null) {
                    cauda  = novoNo;
                }
            } else if (prioridade == 1){
                while(noAux.getProx() != null && noAux.getProx().getPrioridade() < 2){
                    noAux = noAux.getProx();
                }
                novoNo.setProx(noAux.getProx());
                noAux.setProx((novoNo));
                if (novoNo.getProx() == null) {
                    cauda  = novoNo;
                }
            }
        }
    }

    public void exibirFila(){
        if(estaVazia()){
            System.out.println("\nFila vazia!\n");
            return;
        }
        No noAux = cabeca;
        System.out.println("\n----FILA----");
        while(noAux != null){
            System.out.println("Nome : " + noAux.getNome());
            System.out.println("Prioridade : " + noAux.getPrioridade());
            System.out.println("----------------------------");
            noAux = noAux.getProx();
        }
    }

    public void desenfileirar(){
        if (estaVazia()) {
            System.out.println("\nFila vazia!\n");
            return;
        }
        

        System.out.printf("\nPaciente: %s\nPrioridade: %d\n", cabeca.getNome(), cabeca.getPrioridade());
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
        }else{
            cabeca = cabeca.getProx();
        }
        System.out.println("Paciente removido com sucesso!\n");
    }
    public No getCabeca() {
        return cabeca;
    }

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }

    public No getCauda() {
        return cauda;
    }

    public void setCauda(No cauda) {
        this.cauda = cauda;
    }
    
}
