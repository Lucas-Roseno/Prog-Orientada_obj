package trabalho_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vault vault101 = new Vault();

        Sobrevivente sobreviventeTemp = null;
        Missao missaoTemp;
        String habVazia[];
        String statusMissaoDisponiveis[] = {"Em andamento", "Sucesso	", "Fracasso"};

        int opcao;
        String nome, identificador, idProcurado, nomeMissao, objetivo, local, statusMissao;
        short idade;
        boolean sobreviventeValido = false, nomeMissaoValido, idJaExiste;

        List<String> sobreviventesEscolhidos;

        while (true) {
            habVazia = new String[3];
            sobreviventesEscolhidos = new ArrayList<>();

            System.out.print("========GENRENCIAMENTO VAULT 101========");
            System.out.print("""
					\n1 - Cadastrar sobrevivente
					2 - Adicionar habilidade a um sobrevivente
					3 - Remover habilidade de um sobrevivente
					4 - Adicionar recurso ao Vault
					5 - Consumir recurso
					6 - Registrar missão
					7 - Adicionar sobrevivente a uma missão
					8 - Exibir sobreviventes do Vault
					9 - Exibir recursos do Vault
					10 - Exibir missões realizadas
					11 - Sair
					Opção: """);
            opcao = scanner.nextInt();
            if (opcao == 11) {
                System.out.println("PROGRAMA FINALIZADO!");
                break;
            }

            switch (opcao) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Nome do sobrevivente: ");
                    nome = scanner.nextLine();

                    do {
                        System.out.print("Idade: ");
                        idade = scanner.nextShort();
                        scanner.nextLine();
                    } while (idade < 1 || idade > 116);

                    do {
                        idJaExiste = false;

                        System.out.print("ID do sobrevivente: ");
                        identificador = scanner.nextLine();

                        for (Sobrevivente sobrevivente : vault101.getListaSobreviventes()) {
                            if (sobrevivente.getIdentificador().equals(identificador)) {
                                System.out.print("Identificador já cadastrado! Tente novamente\n");
                                idJaExiste = true;
                            }
                        }
                    } while (idJaExiste);

                    sobreviventeTemp = new Sobrevivente(nome, idade, identificador, definirHabilidades(habVazia), definirStatus());

                    if (sobreviventeTemp.getStatus().equals("Ativo") || sobreviventeTemp.getStatus().equals("Ferido")) {
                        sobreviventeValido = true;
                    }

                    vault101.listaSobreviventes.add(sobreviventeTemp);
                }
                case 2 -> {
                    if (vault101.listaSobreviventes.isEmpty()) {
                        System.out.print("Ainda não há sobreviventes cadastrados.\n\n");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Digite o ID do sobrevivente: ");
                    idProcurado = scanner.nextLine();

                    for (int i = 0; i < vault101.listaSobreviventes.size(); i++) {
                        Sobrevivente sobrevivente = vault101.listaSobreviventes.get(i);
                        if (!(sobrevivente.identificador.equals(idProcurado)) && i == vault101.listaSobreviventes.size() - 1) {
                            System.out.print("ID não encontrado!");
                        } else if (sobrevivente.identificador.equals(idProcurado)) {
                            System.out.printf("Sobrevivente: %s\n", sobrevivente.nome);
                            sobrevivente.setHabilidades(definirHabilidades(sobrevivente.getHabilidades()));
                        }
                    }
                }
                case 3 -> {
                    if (vault101.listaSobreviventes.isEmpty()) {
                        System.out.print("Ainda não há sobreviventes cadastrados.\n\n");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Digite o ID do sobrevivente: ");
                    idProcurado = scanner.nextLine();

                    for (int i = 0; i < vault101.listaSobreviventes.size(); i++) {
                        Sobrevivente sobrevivente = vault101.listaSobreviventes.get(i);
                        if (!(sobrevivente.identificador.equals(idProcurado)) && i == vault101.listaSobreviventes.size() - 1) {
                            System.out.print("ID não encontrado!");
                        } else if (sobrevivente.identificador.equals(idProcurado)) {
                            System.out.printf("Sobrevivente: %s\n", sobrevivente.nome);
                            sobrevivente.setHabilidades(definirHabilidades(sobrevivente.getHabilidades()));
                        }
                    }
                }
                case 4 ->
                    vault101.adicionarRecurso();
                case 5 ->
                    vault101.consumirRecurso();
                case 6 -> {
                    if (!sobreviventeValido) {
                        System.out.print("Ainda não foi cadastrado nenhum sobreviente apto para realizar missões!\n");
                        break;
                    }
                    scanner.nextLine();
                    do {
                        nomeMissaoValido = false;
                        System.out.print("Nome da missão: ");
                        nomeMissao = scanner.nextLine();
                        for (Missao missao : vault101.getListaMissoes()) {
                            if (missao.getNome().equals(nomeMissao)) {
                                System.out.print("\nJá existe uma missão com esse nome.Tente novamente: \n");
                                nomeMissaoValido = true;
                            }
                        }
                    } while (nomeMissaoValido);

                    System.out.print("Objetivo: ");
                    objetivo = scanner.nextLine();
                    System.out.print("Local: ");
                    local = scanner.nextLine();
                    do {
                        System.out.print("""
								Status da missão:
									1 - Em andamento (ainda não concluída)
									2 - Sucesso (concluída com êxito)
									3 - Fracasso (falhou por algum motivo, como falta de recursos ou mortes)
								Opção: """);
                        opcao = scanner.nextInt();
                    } while (opcao < 1 || opcao > 3);
                    statusMissao = statusMissaoDisponiveis[opcao - 1];

                    missaoTemp = new Missao(nomeMissao, objetivo, local, statusMissao, definirSobrevMissao(vault101.getListaSobreviventes(), sobreviventesEscolhidos),
                            vault101.getListaRecursos());
                    System.out.println("Missão cadastrada com sucesso!\n");
                    vault101.listaMissoes.add(missaoTemp);
                }
                case 7 -> {
                    if (vault101.listaMissoes.isEmpty()) {
                        System.out.println("Ainda não foi cadastrada nenhuma missão!");
                        break;
                    } else if (vault101.listaSobreviventes.isEmpty()) {
                        System.out.println("Ainda não foi cadastrado nenhum sobrevivente");
                        break;
                    }
                    scanner.nextLine();

                    System.out.print("Digite o nome da missão: ");
                    nomeMissao = scanner.nextLine();
                    for (Missao missao : vault101.getListaMissoes()) {
                        if (nomeMissao.equals(missao.getNome())) {
                            missao.setSobreviventesMissao(definirSobrevMissao(vault101.getListaSobreviventes(), missao.getSobreviventesMissao()));
                        }
                    }
                }
                case 8 -> {
                    if (vault101.getListaSobreviventes().isEmpty()) {
                        System.out.println("Nenhum sobrevivente cadastrado!");
                    }
                    System.out.println("\nSobreviventes do Vault 101: ");
                    for (Sobrevivente sobrevivente : vault101.getListaSobreviventes()) {
                        sobrevivente.getDetalhes();
                    }
                }
                case 9 -> {
                    System.out.println("\nRecursos do Vault 101: ");
                    vault101.mostrarRecursos();
                }
                case 10 ->
                    vault101.getDetalhesMissoes();
                default ->
                    System.out.print("Opção inválida!\n");
            }

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Outros métodos
	public static String[] definirHabilidades(String habJaExistentes[]) {
        if (habilidadesEstaCheia(habJaExistentes)) {
            System.out.print("Sobrevivente já tem o máximo de habilidades permitido!\n");
            return habJaExistentes;
        }
        Scanner scanner = new Scanner(System.in);

        String habilidadesDisponiveis[] = {"Engenharia", "Medicina", "Combate", "Exploração",
            "Culinária", "Diplomacia", "Hackeamento", "Furtividade"};
        int opcao;

        for (int i = 0; i < 3; i++) {
            if (habJaExistentes[i] == null) {
                System.out.print("\nDefina as habilidades do sobrevivente, máximo de 3.\n");
                System.out.printf("""
					\t1 - Engenharia (habilidade de construir e reparar máquinas).
					\t2 - Medicina (habilidade de tratar ferimentos e doenças).
					\t3 - Combate (habilidade de lutar com armas ou corpo a corpo).
					\t4 - Exploração (habilidade de navegar e mapear áreas desconhecidas).
					\t5 - Culinária (habilidade de preparar comida com recursos escassos).
					\t6 - Diplomacia (habilidade de negociar com outros grupos).
					\t7 - Hackeamento (habilidade de invadir sistemas de segurança).
					\t8 - Furtividade (habilidade de evitar detecção durante missões).
					\t0 - Sair
					\nHabilidade %d: """, i + 1);
                opcao = scanner.nextInt();

                if (opcao == 0) {
                    break;
                }

                if (opcao < 1 || opcao > 8) {
                    System.out.print("\nOpção inválida! Tente novamente: ");
                    i--;
                    continue;
                }

                habJaExistentes[i] = habilidadesDisponiveis[opcao - 1];

                for (int j = 0; j < i; j++) {
                    if (habJaExistentes[i].equals(habJaExistentes[j])) {
                        System.out.print("\nHabilidade já escolhida para esse sobrevivente! Selecione outra:");
                        habJaExistentes[i] = null;
                        i--;
                        break;
                    }
                }
            }
        }

        return habJaExistentes;
    }

    public static String definirStatus() {

        Scanner scanner = new Scanner(System.in);
        String[] statusDisponiveis = {"Ativo", "Doente", "Ferido", "Morto"};
        int opcao;

        do {
            System.out.print("""
				\nSelecione os status do sobrevivente:
				\t1 - Ativo
				\t2 - Doente
				\t3 - Ferido
				\t4 - Morto
				Opção: """);
            opcao = scanner.nextInt();
            if (opcao < 1 || opcao > 4) {
                System.out.print("Inválido! Tente novamente: \n");
            }
        } while (opcao < 1 || opcao > 4);

        return statusDisponiveis[opcao - 1];
    }

    public static String[] removerHabilidade(String habJaExistentes[]) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        if (habilidadesEstaVazia(habJaExistentes)) {
            System.out.print("Sobrevivente não tem habilidades cadastradas!\n");
            return habJaExistentes;
        }

        for (int i = 0; i < habJaExistentes.length; i++) {
            System.out.printf("Habilidade %d: %s\n", i + 1, habJaExistentes[i]);
        }

        do {
            System.out.print("Digite o número da habilidade a ser removida: ");
            opcao = scanner.nextInt();

            if (opcao < 1 || opcao > habJaExistentes.length || habJaExistentes[opcao - 1] == null) {
                System.out.print("Opção inválida! Tente novamente.\n\n");
            }
        } while (opcao < 1 || opcao > habJaExistentes.length || habJaExistentes[opcao - 1] == null);

        System.out.printf("Habilidade %s removida com sucesso!\n\n", habJaExistentes[opcao - 1]);

        habJaExistentes[opcao - 1] = null;
        return habJaExistentes;
    }

    public static boolean habilidadesEstaVazia(String habilidades[]) {
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean habilidadesEstaCheia(String habilidades[]) {
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] == null) {
                return false;
            }
        }
        return true;
    }

    public static List<String> definirSobrevMissao(List<Sobrevivente> listaSobreviventes, List<String> sobreviventesEscolhidos) {
        Scanner scanner = new Scanner(System.in);
        String idTemp;
        boolean idExiste, idJAcadastrado;
        int i = 0;

        if (!sobreviventesEscolhidos.isEmpty()) { //coloca o contador na posição certa
            System.out.println("Sobreviventes já cadastrados: ");
            for (Sobrevivente sobrevivente : listaSobreviventes) {
                for (String sobrevDaMissao : sobreviventesEscolhidos) {
                    if (sobrevivente.getIdentificador().equals(sobrevDaMissao)) {
                        sobrevivente.getDetalhes();
                        i++;
                    }
                }
            }
        }

        System.out.println("Definição dos sobreviventes da missão: ");
        for (; i < 5; i++) {
            idExiste = idJAcadastrado = false;

            System.out.printf("\tDigite o identificador do sobrevivente %d[0 para sair]: ", i + 1);
            idTemp = scanner.nextLine();

            if (idTemp.equals("0") && i != 0) {
                if (!sobreviventesEscolhidos.isEmpty()) {
                    System.out.println("Sobreviventes da missão definidos!");
                }
                break;

            } else if (i == 0 && idTemp.equals("0")) {
                System.out.print("Missão deve conter no minímo um sobrevivente!\n");
                i--;
                continue;
            }

            for (Sobrevivente sobrevivente : listaSobreviventes) {

                if (sobrevivente.getIdentificador().equals(idTemp)
                        && (sobrevivente.getStatus().equals("Ativo") || sobrevivente.getStatus().equals("Ferido"))) {
                    idExiste = true;

                    for (String idJaCadastrado : sobreviventesEscolhidos) {
                        if (idJaCadastrado.equals(sobrevivente.getIdentificador())) {
                            System.out.println("\tSobrevivente já cadastrado!Tente novamente: \n");
                            i--;
                            idJAcadastrado = true;
                            break;
                        }
                    }

                    if (idJAcadastrado) {
                        break;
                    }

                    System.out.println("\tSobrevivente cadastrado para a missão!");
                    sobreviventesEscolhidos.add(idTemp);
                    break;

                } else if (sobrevivente.getIdentificador().equals(idTemp)
                        && (sobrevivente.getStatus().equals("Doente") || sobrevivente.getStatus().equals("Morto"))) {
                    System.out.println("\tDevido ao status: [" + sobrevivente.getStatus() + "] o sobrevivente não pode participar.\n"
                            + "\n\tTente novamente:");
                    idExiste = true;
                    i--;
                    break;
                }
            }

            if (!idExiste) {
                System.out.println("\n\tSobrevivente não cadastrado! Tente novamente:");
                i--;
            }
        }
        return sobreviventesEscolhidos;
    }
}
