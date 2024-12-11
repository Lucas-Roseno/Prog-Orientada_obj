package ex1_slide_herancaMutlipla;

public class Material {
	protected String titulo_material;
	protected String autor_material;
	
	public Material(String titutlo, String autor) {
		this.titulo_material = titutlo;
		this.autor_material = autor;
	}

	public void descricao()
	{
		System.out.printf("\nTitulo: %s \nAutor: %s\n", this.titulo_material, this.autor_material);
	}
}
