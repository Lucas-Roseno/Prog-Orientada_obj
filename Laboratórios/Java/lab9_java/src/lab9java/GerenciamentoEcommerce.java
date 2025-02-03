package lab9java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciamentoEcommerce {
	private final Scanner scanner;

	public GerenciamentoEcommerce() {
		this.scanner = new Scanner(System.in);
	}

	private int lerInteiro(String msg) {
		while (true) { 
			try {
				System.out.print(msg);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Entrada inválida! Tente novamente:");
				scanner.nextLine();
			}
		}
	}

	private double lerDouble(String msg){
		while (true) { 
			try {
				System.out.print(msg);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.print("Entrada inválida! Tente novamente:");
				scanner.nextLine();
			}
		}
	}

	private String lerString(String msg){
		while (true) { 
			try {
				System.out.print(msg);
				return scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.print("Entrada inválida! Tente novamente:");
				scanner.nextLine();
			}
		}
	}

    public static void main(String[] args) {
        GerenciamentoEcommerce gerenciamento = new GerenciamentoEcommerce();
		gerenciamento.executar();
    }

	public void executar(){


        ListaProdutos<Produto> lista = new ListaProdutos<>();
		FilaPedidos<Pedido> fila = new FilaPedidos<>();
		Pedido novoPedido;
		Produto produtoProcurado = new Produto(0, null);
		HistóricoPedidos<Pedido> historico = new HistóricoPedidos<>();

        int opcao, codigo, estoque, codPedido, codProdutosInt, quantProduto;
        String descricao, nomeCliente, codigoDosProdutos;
        double preco;

        while (true) {
            System.out.print("""
			1 - Cadastrar um novo produto
			2 - Registrar pedido
			3 - Processar o proximo pedido
			4 - Exibir produtos cadastrados
			5 - Exibir pedidos pendentes
			6 - Exibir histórico de pedidos concluídos
			7 - Sair
			Opçao:\t """);

            opcao = lerInteiro("");

			if (opcao == 7) {
				break;
			}

            switch (opcao) {
                case 1 -> {
                    codigo = lerInteiro("Código do produto: ");

                    if (lista.buscarProduto(codigo) != null) {
                        System.out.println("Produto já cadastrado!");
                        break;
                    }

					scanner.nextLine();
                    descricao = lerString("Descrição: ");
                    preco = lerDouble("Preço: R$");
                    estoque = lerInteiro("Estoque: ");

                    lista.adicionarProduto(new Produto(codigo, descricao, preco, estoque));

                    System.out.println("\nProduto cadastrado com sucesso!\n");

                }
                case 2 -> {
                    if (lista.getProdutos().isEmpty()) {
                        System.out.println("\nNenhum produto cadastrado ainda! Tente novamente\n");
                        break;
                    }

                    codPedido = lerInteiro("Código do pedido: ");
					scanner.nextLine();

                    if (fila.buscarPedido(codPedido) != null) {
                        System.out.println("\nPedido já cadastrado!\n");
                        break;
                    }

                    nomeCliente = lerString("Nome do cliente: ");
                    novoPedido = new Pedido(codPedido, nomeCliente);

                    do {
                        codigoDosProdutos = lerString("Código do produto ['q' para sair]: ");

                        if (codigoDosProdutos.equals("q")) {
                            break;
                        }

                        try {
                            codProdutosInt = Integer.parseInt(codigoDosProdutos);
                        } catch (NumberFormatException e) {
                            System.out.println("\nCódigo de produto inválido! Insira um número.");
                            continue;
                        }

                        produtoProcurado = lista.buscarProduto(codProdutosInt);
                        if (produtoProcurado == null) {
                            System.out.println("\nProduto não encontrado! Tente novamente: ");
                            continue;
                        } else if (produtoProcurado.getEstoque() == 0) {
                            System.out.println("\nProduto fora de estoque! Tente outro: ");
                            continue;
                        }

                        do {
                            System.out.print("Digite a quantidade do produto: ");
                            quantProduto = lerInteiro("");
							scanner.nextLine();
                            if (quantProduto < 0) {
                                System.out.println("\nDigite uma quantidade maior que 0!");
                            } else if (quantProduto > produtoProcurado.getEstoque()) {
                                System.out.println("\nDigite uma quantidade menor ou igual a " + produtoProcurado.getEstoque());
							}
						} while (quantProduto < 0 || quantProduto > produtoProcurado.getEstoque());

						novoPedido.adicionarProduto(produtoProcurado, quantProduto);

						lista.reduzirEstoque(quantProduto, produtoProcurado.getCodigo());

					} while (!codigoDosProdutos.equals("q"));
					
					if (novoPedido.getItens().isEmpty()) {
						System.out.println("\nPedido cancelado porque nenhum produto foi adicionado!\n");
					}else {
						fila.adicionarPedido(novoPedido);
						System.out.println("\nPedido adicionado com sucesso!\n");
					}

				} case 3 -> {
					if (fila.getFila().isEmpty()) {
						System.out.println("\nFila de pedidos vazia! Tente novamente\n");
						break;
					}

					Pedido pedidoProcessado = fila.getFila().remove();
					historico.adicionarAoHistorico(pedidoProcessado);
					System.out.println("\nPedido processado com sucesso!\n");
				} case 4 -> {
					if (lista.getProdutos().isEmpty()) {
						System.out.println("\nNenhum produto cadastrado ainda! Tente novamente\n");
						break;
					}
					lista.exibirProdutos();
				} case 5 -> {
					if (fila.getFila().isEmpty()) {
						System.out.println("\nFila de pedidos vazia! Tente novamente\n");
						break;
					}
					fila.exibirFila();
				} case 6 -> {
					if (historico.getHistorico().isEmpty()) {
						System.out.println("\nHistórico de pedidos vazio! Tente novamente\n");
						break;
					}
					historico.exibirHistorico();
				}

            }

        }
	}
}
