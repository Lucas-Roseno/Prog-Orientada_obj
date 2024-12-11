package ex1_slide_herancaMutlipla;

public class Livro extends Material {

	protected int numero_de_paginas;

	public Livro(String titutlo, String autor, int numPags) {
		super(titutlo, autor);
		this.numero_de_paginas = numPags;
	}

	public int getNumero_de_paginas() {
		return numero_de_paginas;
	}

	public void setNumero_de_paginas(int numero_de_paginas) {
		this.numero_de_paginas = numero_de_paginas;
	}

	@Override
	public void descricao() {
		super.descricao();
		System.out.printf("Número de páginas: %d\n", this.numero_de_paginas);
	}
	
	
	
}
