#include "Veiculo.hpp"
#include "Motorista.hpp"
#include "Carro.hpp"
#include "Moto.hpp"
#include "Caminhao.hpp"
#include "Viagem.hpp"
#include <vector>

int main()
{
    vector<Motorista> motoristas;
    vector<Veiculo> veiculos;
    string nome, habilitacao, cpf, placa, modelo;
    int assentos, cilindradas;
    double capacidadeCarga;
    int opcao;
    

    while (true)
    {
        cout << "============GERENCIAMNETO ROADLINK============\n"
             << "1 - Cadastrar motorista\n"
             << "2 - Cadastrar veículo\n"
             << "3 - Registrar viagem\n"
             << "0 - Sair\n"
             << "Opção: ";
        cin >> opcao;
        cin.ignore();

        if (opcao == 0)
        {
            break;
        }

        switch (opcao)
        {
        case 1:
            cout << "Nome: ";
            getline(cin, nome);
            cout << "CPF: ";
            getline(cin, cpf);
            cout << "Habilitação: ";
            getline(cin, habilitacao);

            motoristas.emplace_back(nome, cpf, habilitacao);

            break;
        case 2:
            int opcao;
            cout << "\nQual veículo deseja cadastrar: "
                << "\n1 - Carro"
                << "\n2 - Moto"
                << "\n3 - Caminhão"
                << "\nOpção: ";
            cin >> opcao;

            cin.ignore();
            cout << "Placa: ";
            getline(cin, placa);
            cout << "Modelo: ";
            getline(cin, modelo);

            switch (opcao)
            {
            case 1:
                cout << "Assentos: ";
                cin >> assentos;
                veiculos.emplace_back(Carro(placa, modelo, assentos));
                break;
            case 2: 
                cout << "Cilindradas: ";
                cin >> cilindradas;
                veiculos.emplace_back(Moto(placa, modelo, cilindradas));
                break;
            case 3:
                cout << "Capacidade de carga: ";
                cin >> capacidadeCarga;
                veiculos.emplace_back(Caminhao(placa, modelo, capacidadeCarga));
            default:
                break;
            }
            cout << "Veículo adicionado com sucesso!\n\n";
            break;
        case 3:
            if (motoristas.empty())
            {
                cout << "Ainda não foi cadastrado nenhum motorista!\nCadastre e tente novamente.\n";
            }else if (veiculos.empty())
            {
                cout << "Ainda não foi cadastrado nenhum veículo!\nCadastre e tente novamente.\n";
            }
            
            
            break;
        default:
            break;
        }
    }
}   