public class No {
    private String nome;
    private int prioridade;
    private No prox;

    public No(String nome, int prioridade, No prox) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.prox = prox;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    
}
