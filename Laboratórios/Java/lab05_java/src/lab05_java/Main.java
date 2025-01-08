package lab05_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Cliente> listaClientes = new ArrayList<>();
		int opcao, garantia;
		String nome, cpf, nomeProd = null;
		double preco = 0;
		String cpfProcurado, ultimoCpf, tamanhoRoupa;
		
		while (true) {
			System.out.print("===============MENU===============\n"
					+ "1 - Cadastrar cliente\n"
					+ "2 - Adicionar produto a um cliente\n"
					+ "3 - Exibir detalhes de um cliente\n"
					+ "4 - Sair\n"
					+ "Opção: ");
			opcao = scanner.nextInt();
			
			if (opcao == 4) {
				System.out.print("\nPROGRAMA FINALIZADO\n");
			}
			
			switch (opcao) {
			case 1:
					scanner.nextLine();
					System.out.print("Nome do cliente: ");
					nome = scanner.nextLine();
					System.out.print("CPF: ");
					cpf = scanner.nextLine();
					
					Cliente clienteTemp = new Cliente(nome, cpf);
					listaClientes.add(clienteTemp);
					
				break;
				
			case 2:
				scanner.nextLine();
				System.out.print("CPF do cliente: ");
				cpfProcurado = scanner.nextLine();
				
				ultimoCpf = listaClientes.get(listaClientes.size() - 1).getCPF();
				for (Cliente cliente : listaClientes) {
					if(cliente.CPF.equals(cpfProcurado)) {
						
						do {
							System.out.print("\n1 - Eletrônico"
									+ "\n2 - Vestuário"
									+ "\n0 - sair"
									+ "\nOpção: ");
							opcao = scanner.nextInt();
							
							if (opcao == 1 || opcao == 2) {
								scanner.nextLine();
								System.out.print("Nome produto: ");
								nomeProd = scanner.nextLine();
								System.out.print("Preço: R$ ");
								preco = scanner.nextDouble();
							}
							
							switch (opcao) {
							case 1:
								System.out.print("Garantia do produto: ");
								garantia = scanner.nextInt();
								
								Eletronico eletronicoTemp = new Eletronico(nomeProd, preco, garantia);
								cliente.adicionaCompra(eletronicoTemp);
								
								break;
								
							case 2:
								scanner.nextLine();
								System.out.print("Tamanho da roupa: ");
								tamanhoRoupa = scanner.nextLine();
								
								Vestuario vestuarioTemp = new Vestuario(nomeProd, preco, tamanhoRoupa);
								cliente.adicionaCompra(vestuarioTemp);
								
								break;
							default:
								break;
							}
							
						} while (opcao != 0);
						
					}else if(!(cliente.CPF.equals(cpfProcurado)) && cliente.CPF.equals(ultimoCpf)) {
						System.out.print("\nCliente não encontrado!\n");
					}
				}
				break;
				
			case 3:
				scanner.nextLine();
				System.out.print("Digite o CPF: ");
				cpfProcurado = scanner.nextLine();
				ultimoCpf = listaClientes.get(listaClientes.size() - 1).getCPF();
				
				for (Cliente cliente : listaClientes) {
					if (cliente.CPF.equals(cpfProcurado)) {
						cliente.getDetalhes();
					}
				}
				
				break;

			default:
				break;
			}
		}
	}

}
