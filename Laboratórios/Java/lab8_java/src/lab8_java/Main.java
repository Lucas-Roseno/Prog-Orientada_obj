package lab8_java;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListaClientes listaDeClientes = new ListaClientes();

        short opcao;
        String nome, cpf, descricao;
        int codPacote, prioridade = 0;

        while (true){
            System.out.println("================== MENU ==================");
            System.out.print("""
                1 - Adicionar novo cliente
                2 - Registrar um novo pacote
                Opção:\t """);
            try {
                opcao = scanner.nextShort();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, tente novamente.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do cliente: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();
                    
                    listaDeClientes.adicionarCliente(nome, cpf);
              
                    
                } case 2 -> {
                	if (listaDeClientes.getListaDeClientes().isEmpty()) {
						System.out.println("Cadastre um cliente antes de cadastrar o pacote!\n");
						break;
					}
                	
                	//cpf
                	System.out.print("Digite o CPF do cliente: ");
                	do {
                		cpf = scanner.nextLine();
                		if(!listaDeClientes.cpfJaCadastrado(cpf)) {
                			System.out.print("CPF não cadastrado! Digite um válido: ");
                		}
                	}while(!listaDeClientes.cpfJaCadastrado(cpf));
                	
                	//codigo
                	boolean codValido = false;
					System.out.print("Digite o código do pacote: ");
					while (!codValido) { 
						try {
							codPacote = scanner.nextInt();
							codValido = true;
						} catch (InputMismatchException e) {
							System.out.print("O código dever ser apenas numérico!\nDigite novamente: ");
							scanner.nextLine();
						}	
					}
					
					scanner.nextLine();
					System.out.print("Descrição: ");
					descricao = scanner.nextLine();
					
					//prioridade
					boolean prioridadeValida = false;
					System.out.print("Prioridade [1 = urgente, 2 = normal]: ");
					while ((!prioridadeValida) || (prioridade < 1 || prioridade > 2)) {
						try {
							prioridade = scanner.nextInt();
							prioridadeValida = true;
							if(prioridade < 1 || prioridade > 2) {
								System.out.print("A prioridade deve ser igual a 1 ou 2!\nTente novamente: ");	
							}
						} catch (InputMismatchException e) {
							System.out.print("Entrada inválida!\nDigite novamente: ");
							scanner.nextLine();
						}
					}

                	
                	
                }
                default -> {
                }
            }

        }
    }
}
