#include "Veiculo.hpp"
#include "Motorista.hpp"
#include "Carro.hpp"
#include "Moto.hpp"
#include "Caminhao.hpp"
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
            cout << "Qual veículo deseja cadastrar: "
                << "\n1 - Carro"
                << "\n2 - Moto"
                << "\n3 - Caminhão";
            cin >> opcao;

            cout << "Placa: ";
            getline(cin, placa);
            cout << "Modelo: ";
            getline(cin, modelo);

            switch (opcao)
            {
            case 1:
                
                cout << "Assentos: ";
                cin >> assentos;
                veiculos.emplace_back(placa, modelo, assentos);

                break;
            
            default:
                break;
            }
            break;
        default:
            break;
        }
    }
}   