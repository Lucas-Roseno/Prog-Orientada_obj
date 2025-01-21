import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vault {
    protected List<Sobrevivente> listaSobreviventes;
    protected List<Recurso> listaRecursos;
    protected List<Missao> listaMissoes;
    Scanner scanner = new Scanner(System.in);

    public Vault() {
        this.listaSobreviventes = new ArrayList<>();
        this.listaRecursos = new ArrayList<>();
        this.listaMissoes = new ArrayList<>();

        listaRecursos.add(new Recurso("Água", 0));
        listaRecursos.add(new Recurso("Comida", 0));
        listaRecursos.add(new Recurso("Munição", 0));
        listaRecursos.add(new Recurso("Remédios", 0));
        listaRecursos.add(new Recurso("Partes Mecânicas", 0));
    }

    public Vault(List<Sobrevivente> listaSobreviventes, List<Recurso> listaRecursos, List<Missao> listaMissoes) {
        this.listaSobreviventes = listaSobreviventes;
        this.listaRecursos = listaRecursos;
        this.listaMissoes = listaMissoes;
    }

    // Outros métodos
    public String escolherRecurso() {
        String[] recursosDisponiveis = {"Água", "Comida", "Munição", "Remédios", "Partes Mecânicas"};
        short opcao;
        do {
            System.out.print("""
                    Escolha o recurso: 
                    \t1 - Água (fundamental para hidratação)
                    \t2 - Comida (necessária para manter os sobreviventes ativos)
                    \t3 - Munição (usada para armas de defesa e combate)
                    \t4 - Remédios (usados para curar doenças e ferimentos)
                    \t5 - Partes Mecânicas (usadas para construir ou consertar itens no Vault)
                    Opção: """);
            opcao = scanner.nextShort();
        } while (opcao < 1 || opcao > 5);
        return recursosDisponiveis[opcao - 1];
    }

    public void adicionarRecurso() {
        String recursoSelecionado = escolherRecurso();
        int quant;

        for (Recurso recurso : listaRecursos) {
            if (recurso.getNome().equals(recursoSelecionado)) {
                System.out.println("Quantidade atual de " + recurso.getNome() + ": " + recurso.getQuantidade());
                do {
                    System.out.print("Adicionar mais quantos: ");
                    quant = scanner.nextInt();
                    if (quant < 0) {
                        System.out.println("Digite uma quantidade maior que 0!");
                    }
                } while (quant < 0);

                recurso.setQuantidade(recurso.getQuantidade() + quant);
                System.out.println("""
                        Recurso adicionado: 
                        \tNome: """ + recurso.getNome() + """
                        \n\tQuantidade: """ + recurso.getQuantidade());

                break;
            }
        }
    }

    public void consumirRecurso() {
        String recursoSelecionado = escolherRecurso();
        int quant;

        for (Recurso recurso : listaRecursos) {
            if (recurso.getNome().equals(recursoSelecionado)) {
                System.out.println("Quantidade atual: " + recurso.getQuantidade());
                if (recurso.getQuantidade() == 0) {
                    System.out.println("Não há recurso a ser consumido.\n");
                    return;
                }
                do {
                    System.out.print("Digite a quantidade a ser consumida: ");
                    quant = scanner.nextInt();
                    if ((recurso.getQuantidade() - quant) < 0) {
                        System.out.println("Não há tanto recurso para consumir essa quantidade! Tente novamente: ");
                    } else if (quant < 0) {
                        System.out.println("Quantidade a ser consumida deve ser positiva! Tente novamente: ");
                    }
                } while ((recurso.getQuantidade() - quant) < 0 || quant < 0);

                if (quant == 0) {
                    System.out.println("0 recursos consumidos");
                    return;
                }

                recurso.setQuantidade(recurso.getQuantidade() - quant);
                System.out.println("""
                        Recurso consumido:
                        \tNome: %s
                        \n\tQuantidade: %d
                        """.formatted(recurso.getNome(), recurso.getQuantidade()));
                break;
            }
        }
    }

    public void mostrarRecursos() {
        System.out.println("======================================");
        System.out.printf("%-20s %-10s%n", "Nome", "Quantidade");
        System.out.println("--------------------------------------");
        for (Recurso recurso : listaRecursos) {
            System.out.printf("%-20s %-10d%n", recurso.getNome(), recurso.getQuantidade());
        }
        System.out.println("======================================\n");
    }

    public void getDetalhesMissoes() {
        if (listaMissoes.isEmpty()) {
            System.out.println("Não há missões cadastradas no momento.");
            return;
        }

        System.out.println("\n======================================");
        System.out.println("Detalhes de Todas as Missões");
        System.out.println("======================================");

        for (Missao missao : listaMissoes) {
            System.out.println("--------------------------------------");
            System.out.printf("%-15s: %s%n", "Nome", missao.getNome());
            System.out.printf("%-15s: %s%n", "Objetivo", missao.getObjetivo());
            System.out.printf("%-15s: %s%n", "Local", missao.getLocal());
            System.out.printf("%-15s: %s%n", "Status", missao.getStatus());
            System.out.println("--------------------------------------");

            System.out.println("Sobreviventes na Missão:");
            int i = 1;
            for (String idSobrevivente : missao.getSobreviventesMissao()) {
                for (Sobrevivente sobrevivente : listaSobreviventes) {
                    if (idSobrevivente.equals(sobrevivente.getIdentificador())) {
                        System.out.printf("\t%d - %s\n", i, sobrevivente.getNome());
                    }
                }
            }


            System.out.println("--------------------------------------");

            System.out.println("Recursos Coletados:");
            List<Recurso> recursos = missao.getRecursosColetados();
            if (recursos.isEmpty()) {
                System.out.println("\tNenhum recurso coletado.");
            } else {
                for (Recurso recurso : recursos) {
                    System.out.printf("\t%-20s: %d%n", recurso.getNome(), recurso.getQuantidade());
                }
            }
            System.out.println("======================================\n");
        }
    }


    // Getters e Setters
    public List<Sobrevivente> getListaSobreviventes() {
        return listaSobreviventes;
    }

    public void setListaSobreviventes(List<Sobrevivente> listaSobreviventes) {
        this.listaSobreviventes = listaSobreviventes;
    }

    public List<Recurso> getListaRecursos() {
        return listaRecursos;
    }

    public void setListaRecursos(List<Recurso> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }

    public List<Missao> getListaMissoes() {
        return listaMissoes;
    }

    public void setListaMissoes(List<Missao> listaMissoes) {
        this.listaMissoes = listaMissoes;
    }
}
