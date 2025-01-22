package lab8_java;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListaClientes listaDeClientes = new ListaClientes();
        FilaEntradaPacotes fila = new FilaEntradaPacotes();
        FilaPrioridadePacotes filaPrioridade = new FilaPrioridadePacotes();
        HistoricoPacotes historico = new HistoricoPacotes();

        short opcao;
        String nome, cpf, descricao;
        int codPacote = 0, prioridade = 0;

        while (true){
            System.out.println("================== MENU ==================");
            System.out.print("""
                1 - Adicionar novo cliente
                2 - Registrar um novo pacote
                3 - Processar o próximo pacote
                4 - Exibir pacotes na fila de entrada
                5 - Exibir pacotes na fila de prioridade
                6 - Exibir o histórico de pacotes entregues
                7 - Exibir lista de cliente cadastrados.
                8 - Sair
                Opção:\t """);
            try {
                opcao = scanner.nextShort();
                scanner.nextLine();
                if(opcao == 8) {
                	break;
                }
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
							if (fila.codigoJaCadastrado(codPacote) || filaPrioridade.codigoJaCadastrado(codPacote)) {
								System.out.print("Código ja cadastrado!\nDigite novamente: ");
								continue;
							}
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
					
					Pacote pacote = new Pacote(codPacote, descricao, prioridade, cpf);
					if (prioridade == 1) {
						filaPrioridade.adicionarPacote(pacote);
					}else if(prioridade == 2) {
						fila.adicionarPacote(pacote);
					}
					
                } case 3 -> {                        	
                	if (!filaPrioridade.getFilaPrioridade().isEmpty()) {
						historico.adicionarAoHistorico(filaPrioridade.removerPacote());
						break;
					}else if (!fila.getFilaPacotes().isEmpty()) {
						historico.adicionarAoHistorico(fila.removerPacote());
						break;
					}else {
						System.out.println("\nNenhum pacote a ser processado!\n");
					}
                	
                	
                } case 4 -> {
                	fila.exibirFila(listaDeClientes.getListaDeClientes());
                } case 5 -> {
                	filaPrioridade.exibirFila(listaDeClientes.getListaDeClientes());
                } case 6 -> {
                	historico.exibirFila(listaDeClientes.getListaDeClientes());
                } case 7 -> {
                	listaDeClientes.exibirClientes();
                }
                
                default -> {
                }
            }

        }
    }
}
