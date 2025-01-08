package trabalho_1;

import java.util.ArrayList;
import java.util.List;

public class Vault {
	List<Sobrevivente> listaSobreviventes = new ArrayList<>();



	
	
	public Vault(List<Sobrevivente> listaSobreviventes) {
		this.listaSobreviventes = listaSobreviventes;
	}

	public List<Sobrevivente> getListaSobreviventes() {
		return listaSobreviventes;
	}

	public void setListaSobreviventes(List<Sobrevivente> listaSobreviventes) {
		this.listaSobreviventes = listaSobreviventes;
	}
}
