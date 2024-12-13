package prova1_antiga_POO;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		Pedido pedido;
		
		while (true) {
			System.out.print("\n===============MENU============\n"
					+ "1 - Cadastrar pedido\n"
					+ "2 - Excluir pedido\n"
					+ "3 - Listar produto\n"
					+ "4 - Imprimir informações\n"
					+ "0 - sair\n"
					+ "Opção: ");
			opcao = scanner.nextInt();
			if (opcao == 0) {
				break;
			}
			
			switch (opcao) {
			case 1:
				pedido = cadastrarPedido();
				pedido.imprimirInfo();
				break;
				
			case 2:

			default:
				break;
			}
		}
	}


	public static Pedido cadastrarPedido()
	{
		Scanner scanner = new Scanner(System.in);
		int numPedido;
		String nomeCliente;
		String data;
		
		System.out.print("Número do pedido: ");
		numPedido = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Nome do cliente: ");
		nomeCliente = scanner.nextLine();
		
		System.out.print("Data da compra: ");
		data = scanner.nextLine();
		
		Pedido pedido;
		return pedido = new Pedido(numPedido, nomeCliente, data);
	}

}



