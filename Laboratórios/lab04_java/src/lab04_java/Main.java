package lab04_java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FuncionarioGerente gerenteObj = null;
		FuncionarioDesenvolvedor devObj = null;
		TechLead techLeadObj = null;
		int opcao, numEquipes = 0, projetos;
		float salario = 0;
		String nome = "", linguagem = "";

		while (true) {
			System.out.println("=============================MENU=============================");
			System.out.print("1 - Cadastrar gerente" + "\n2 - Cadastrar desenvolvedor" + "\n3 - Cadastrar TechLead"
					+ "\n4 - Descrição gerente" + "\n5 - Descrição desnvolvedor" + "\n6 - Descrição techLead"
					+ "\n0 - sair" + "\nOpção: ");
			opcao = scanner.nextInt();

			if (opcao == 0) {
				break;
			}

			if (opcao == 1 || opcao == 2 || opcao == 3) {
				scanner.nextLine();

				System.out.print("Nome: ");
				nome = scanner.nextLine();

				System.out.print("Salário: ");
				salario = scanner.nextFloat();
			}

			if (opcao == 1 || opcao == 3) {
				System.out.print("Número de equipes: ");
				numEquipes = scanner.nextInt();
			}

			if (opcao == 2 || opcao == 3) {
				scanner.nextLine();
				System.out.print("Linguagem principal: ");
				linguagem = scanner.nextLine();
			}
			switch (opcao) {
			case 1: {

				gerenteObj = new FuncionarioGerente(nome, salario, numEquipes);

				break;
			}
			case 2: {
				devObj = new FuncionarioDesenvolvedor(nome, salario, linguagem);

				break;
			}
			case 3:
				System.out.print("Número de projetos em andamentos: ");
				projetos = scanner.nextInt();

				techLeadObj = new TechLead(nome, salario, linguagem, numEquipes, projetos);
				techLeadObj.descricao();
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}
	}
}