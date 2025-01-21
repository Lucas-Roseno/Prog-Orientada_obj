package lab07_java;

public class ListaClientes{
    private Pessoa cabeca;
    private Pessoa cauda;

    public ListaClientes(){
        this.cabeca = null;
        this.cauda = null;
    }

    public ListaClientes(Pessoa pessoa){
        this.cabeca = pessoa;
        this.cauda = cabeca;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void inserirNoInicio(Pessoa novaPessoa){
        if(estaVazia()){
            cabeca = novaPessoa;
            cauda = cabeca;
        }else{
            novaPessoa.setProximo(cabeca);
            cabeca = novaPessoa;
        }
        System.out.println("Cliente " + novaPessoa.getNome() + " inserido com sucesso!");
    }

    public void inserirNoFinal(Pessoa novaPessoa){
        if(estaVazia()){
            inserirNoInicio(novaPessoa);
        }else{
            cauda.setProximo(novaPessoa);
            cauda = novaPessoa;
            System.out.println("Cliente " + novaPessoa.getNome() + " inserido com sucesso!");
        }
    }

    public boolean buscarCliente(String cpfProcurado){
        if(estaVazia()){
            System.out.println("Ainda não foi cadastrado nenhum cliente!");
            return false;
        }

        Pessoa pessoaAtual = cabeca;
        while(pessoaAtual != null){
            if(pessoaAtual.getCpf().equals(cpfProcurado)){
                System.out.println("Cliente encontrado: ");
                pessoaAtual.getDetalhes(); 
                return true;
            }
            pessoaAtual = pessoaAtual.getProximo();
        }
        System.out.println("CPF: " + cpfProcurado + " não foi cadastrado!\n");
        return false;
    }
    
    public void exibirClientes() {
        Pessoa aux = cabeca;
        System.out.println("=========== LISTA DE CLIENTES ===========");
        while (aux != null) {
            System.out.println(String.format("\t%-6s: %s", "Nome ", aux.getNome()));
            System.out.println(String.format("\t%-6s: %s", "CPF ", aux.getCpf()));
          
        System.out.println("----------------------------------------");
            aux = aux.getProximo();
        }
        System.out.println("========================================\n");
    }



    //Getters e setters
	public Pessoa getCabeca() {
		return this.cabeca;
	}

	public void setCabeca(Pessoa cabeca) {
		this.cabeca = cabeca;
	}

	public Pessoa getCauda() {
		return this.cauda;
	}

	public void setCauda(Pessoa cauda) {
		this.cauda = cauda;
	}
}