

public class Sobrevivente extends Pessoa{
    protected String habilidades[];
    protected String status;

    public Sobrevivente(String nome, short idade, String identificador, String habilidades[], String status) {
        super(nome, idade, identificador);
        this.habilidades = habilidades;
        this.status = status;
    }

    //Outros Métodos
    public void getDetalhes() {
        System.out.println("======================================");
        System.out.printf("%-15s: %s%n", "Nome", this.nome);
        System.out.printf("%-15s: %d%n", "Idade", this.idade);
        System.out.printf("%-15s: %s%n", "Identificador", this.identificador);
        System.out.printf("%-15s: %s%n", "Status", this.status);
        System.out.println("--------------------------------------");
        imprimirHabilidades();
        System.out.println("======================================");
    }

    public void imprimirHabilidades() {
        System.out.println("Habilidades:");
        System.out.println("--------------------------------------");
        for (int i = 0; i < habilidades.length; i++) {
            System.out.printf("%-3d - %s%n", (i + 1), this.habilidades[i]);
        }
        System.out.println("--------------------------------------");
    }

    //Getters e Setters
    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
