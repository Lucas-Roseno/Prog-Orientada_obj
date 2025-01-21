package lab07_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ListaClientes listaDeClientes = new ListaClientes();
        FilaPedidos filaDePedidos = new FilaPedidos();
        HistoricoPedido historicoPedidos = new HistoricoPedido();

        int opcao, codPedido, tempoEstimado;
        String nome, cpf, descricaoPedido;
        boolean podeCadastrar;
        
        Pessoa novoCliente, pAux;
        Pedido novoPedido, verificadorCod;
        
        while (true) { 
        	
            System.out.println("""
                =============MENU=============
                1 - Adicionar uma nova pesssoa à lista de clientes.
                2 - Adicionar um novo pedido à fila
                3 - Preparar o próximo pedido
                4 - Exibir os pedidos em espera
                5 - Exibir o histórico de pedidos concluídos
                6 - Exibir lista de pessoas cadastradas
                7 - sair
                Opção: """);
            try {
            	opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Opção inválida!\n");
				scanner.nextLine();
				continue;
			}
            
            if (opcao == 7) {
				break;
			}
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                	podeCadastrar = true;
                	
                    System.out.print("Digite o nome do cliente: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o CPF: ");
                    cpf = scanner.nextLine();
                    
                    pAux = listaDeClientes.getCabeca();
                    while(pAux != null) {
                    	if (cpf.equals(pAux.getCpf())) {
							System.out.print("CPF já cadastrado!\n\n");
							podeCadastrar = false;
							break;
						}
                    	pAux = pAux.getProximo();
                    }
                    
                    if(podeCadastrar) {
                    	novoCliente = new Pessoa(nome, cpf);
                        listaDeClientes.inserirNoFinal(novoCliente);
                    }

                }case 2 -> {
                    System.out.print("Digite o CPF do cliente que fará o pedido: ");
                    cpf = scanner.nextLine();
                    
                    if (listaDeClientes.buscarCliente(cpf)) {
                        System.out.print("Código do pedido: ");
                        codPedido = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Descrição do pedido: ");
                        descricaoPedido = scanner.nextLine();
                        System.out.print("Tempo estimado do preparo em minutos: ");
                        tempoEstimado = scanner.nextInt();

                        novoPedido = new Pedido(codPedido, descricaoPedido, tempoEstimado, cpf);
                        filaDePedidos.enfileirar(novoPedido);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }case 3 ->{
                    if (!filaDePedidos.estaVazia()) {
                        historicoPedidos.inserirNoFinal(filaDePedidos.desenfileirar());
                    }else{
                        System.out.println("Nenhum pedido para ser preparado!\n");
                    }
                }case 4 -> {
                	if (!filaDePedidos.estaVazia()) {
                		filaDePedidos.exibirPedidos(listaDeClientes);
					}else {
						System.out.println("Não há pedidos na fila!\n");
					}
                	
                } case 5 -> {
                	if(!historicoPedidos.estaVazia()) {
                		historicoPedidos.exibirPedidosAtendidos(listaDeClientes);
                	}else {
                		System.out.println("Nenhum pedido foi preparado ainda!\n");
                	}
                } case 6 -> {
                	if(!listaDeClientes.estaVazia()) {
                		listaDeClientes.exibirClientes();
                	}else {
                		System.out.println("Nenhum cliente cadastrado ainda! \n");
                	}
                }
                default -> {
                }
            }



        }
    }
}
