package trabalho_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Missao {
	private String nome, objetivo, local, status;
	Scanner scanner = new Scanner(System.in);

	private List<String> sobreviventesMissao;
	private List<Recurso> recursosMissao;
	
	public Missao(String nome, String objetivo, String local, String status, List<String> sobreviventesEscolhidos, 
			List<Recurso> listaRecursos) {
		this.nome = nome;
		this.objetivo = objetivo;
		this.local = local;
		this.status = status;
		this.sobreviventesMissao = sobreviventesEscolhidos;
		this.recursosMissao = definirRecursosColetados(listaRecursos);

	}
	
	//Outros métodos
	public List<Recurso> definirRecursosColetados(List <Recurso> listaRecursos){
		List<Recurso> recursosMissao = new ArrayList<>();
		recursosMissao.add(new Recurso("Água", 0));
		recursosMissao.add(new Recurso("Comida", 0));
		recursosMissao.add(new Recurso("Munição", 0));
		recursosMissao.add(new Recurso("Remédios", 0));
		recursosMissao.add(new Recurso("Partes Mecânicas", 0));
	    
	    for (Recurso recurso : recursosMissao) {
	    	do {
	    		System.out.printf("Quantidade coletada para o recurso [%s]: ", recurso.getNome());
				recurso.setQuantidade(scanner.nextInt());
			} while (recurso.getQuantidade() < 0);
	    	
	    	for (Recurso recursoSoma : listaRecursos) {
	    		if (recurso.getNome().equals(recursoSoma.getNome())) {
	    			recursoSoma.setQuantidade(recursoSoma.getQuantidade() + recurso.getQuantidade());	
				}
	    		
			}	
		}
	    return recursosMissao;
	}


	
	//Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<String> getSobreviventesMissao() {
		return sobreviventesMissao;
	}

	public void setSobreviventesMissao(List<String> sobreviventesMissao) {
		this.sobreviventesMissao = sobreviventesMissao;
	}

	public List<Recurso> getRecursosColetados() {
		return recursosMissao;
	}

	public void setRecursosColetados(List<Recurso> recursosColetados) {
		this.recursosMissao = recursosColetados;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
