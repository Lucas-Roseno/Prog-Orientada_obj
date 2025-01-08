package trabalho_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Sobrevivente> listaVazia = new ArrayList<>();
		Vault vault101 = new Vault(listaVazia);
		Sobrevivente sobreviventeTemp = null;
		
		
		int opcao;
		String nome, identificador, idProcurado, ultimoId, habVazia[] = new String[3];
		short idade;
		
		
		while(true)
		{
			System.out.print("========GENRENCIAMENTO VAULT 101========");
			System.out.print("\n1 - Cadastrar sobrevivente\n"
					+ "2 - Adicionar habilidade a um sobrevivente\n"
					+ "3 - Remover habilidade de um sobrevivente\n"
					+ "Opção: ");
			opcao = scanner.nextInt();
			
			
			switch (opcao) {
			case 1:
				scanner.nextLine();
				System.out.print("Nome do sobrevivente: ");
				nome = scanner.nextLine();
				System.out.print("Idade: ");
				idade = scanner.nextShort();
				scanner.nextLine();
				System.out.print("ID do sobrevivente: ");
				identificador = scanner.nextLine();
				
				sobreviventeTemp = new Sobrevivente(nome, idade, identificador, definirHabilidades(habVazia), definirStatus());
				vault101.listaSobreviventes.add(sobreviventeTemp);
				
				break;

			case 2:
				if (vault101.listaSobreviventes.isEmpty()) {
					System.out.print("Ainda não há sobreviventes cadastrados.\n\n");
					break;
				}
				scanner.nextLine();
				System.out.print("Digite o ID do sobrevivente: ");
				idProcurado = scanner.nextLine();
				
				
				for (Sobrevivente sobrevivente : vault101.listaSobreviventes) {
					if (!(sobrevivente.identificador.equals(idProcurado)) && sobrevivente.equals(vault101.listaSobreviventes.getLast())) {
						System.out.print("ID não encontrado!");
					}else if (sobrevivente.identificador.equals(idProcurado)) {
						System.out.printf("Sobrevivente: %s\n", sobrevivente.nome);
						sobrevivente.setHabilidades(definirHabilidades(sobrevivente.getHabilidades()));
					}
				}
				
				
				break;
			case 3:
				if (vault101.listaSobreviventes.isEmpty()) {
					System.out.print("Ainda não há sobreviventes cadastrados.\n\n");
					break;
				}
				scanner.nextLine();
				System.out.print("Digite o ID do sobrevivente: ");
				idProcurado = scanner.nextLine();
				
				
				for (Sobrevivente sobrevivente : vault101.listaSobreviventes) {
					if (!(sobrevivente.identificador.equals(idProcurado)) && sobrevivente.equals(vault101.listaSobreviventes.getLast())) {
						System.out.print("ID não encontrado!");
					}else if (sobrevivente.identificador.equals(idProcurado)) {
						System.out.printf("\nSobrevivente %s\n", sobrevivente.nome);
						removerHabilidade(sobrevivente.habilidades);
					}
				}
				
				
				break;
			default:
				System.out.print("Opção inválida!\n");
				break;
			}
			
		}

	}
	
	
	
	public static String [] definirHabilidades(String habJaExistentes[])
	{
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
				System.out.printf("\t1 - Engenharia (habilidade de construir e reparar máquinas).\n"
						+ "\t2 - Medicina (habilidade de tratar ferimentos e doenças).\n"
						+ "\t3 - Combate (habilidade de lutar com armas ou corpo a corpo).\n"
						+ "\t4 - Exploração (habilidade de navegar e mapear áreas desconhecidas).\n"
						+ "\t5 - Culinária (habilidade de preparar comida com recursos escassos).\n"
						+ "\t6 - Diplomacia (habilidade de negociar com outros grupos).\n"
						+ "\t7 - Hackeamento (habilidade de invadir sistemas de segurança).\n"
						+ "\t8 - Furtividade (habilidade de evitar detecção durante missões).\n"
						+ "\t0 - Sair\n"
						+ "\nHabilidade %d: ", i + 1);
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
					if(habJaExistentes[i].equals(habJaExistentes[j])) {
						System.out.print("\nHabilidade já escolhida para esse sobrevivente! Selecione outra:");
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
		String []statusDisponiveis = {"Ativo", "Doente", "Ferido", "Morto"};
		int opcao;
		
		do {
			System.out.print("\nSelecione os status do sobrevivente:\n"
					+ "\t1 - Ativo\n"
					+ "\t2 - Doente\n"
					+ "\t3 - Ferido\n"
					+ "\t4 - Morto\n"
					+ "Opção: ");
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
		
		System.out.printf("Habilidade %s removida com sucesso!\n\n", habJaExistentes[opcao -1]);
		
		habJaExistentes[opcao -1] = null;
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
}
