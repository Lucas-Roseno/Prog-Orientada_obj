package lab9java;
import java.util.ArrayList;
import java.util.List;

public class ListaProdutos<T extends Produto>{
	private List<T> produtos;

	public ListaProdutos() {
		this.produtos = new ArrayList<>();
	}
	
	public void adicionarProduto(T produto) {
		produtos.add(produto);
	}
	
	public T buscarProduto(int codigo) {		
		for (T t : produtos) {
			if(t.getCodigo() == codigo) {
				return t;
			}
		}
		return null;
	}

	public void reduzirEstoque(int quantidade, int codigo){
		for(T t : produtos){
			if(t.getCodigo() == codigo){
				t.reduzirEstoque(quantidade);
			}
		}
	}
	
	public void exibirProdutos() {
		System.out.println("\n-----LISTA DE PRODUTOS-----");
		for (T t : produtos) {
			System.out.println(t.toString());
		}
	}

	public List<T> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<T> produtos) {
		this.produtos = produtos;
	}

}
