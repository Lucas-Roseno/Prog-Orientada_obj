#include <iostream>
#include <vector>
#include <string>
#include <algorithm> // Para std::transform
#include <cctype>    // Para std::toupper
#include <memory>    // Para std::unique_ptr
#include "Motorista.hpp"
#include "Veiculo.hpp"
#include "Carro.hpp"
#include "Moto.hpp"
#include "Caminhao.hpp"

using namespace std;

Motorista encontrarMotorista(const string& cpf, const vector<Motorista>& motoristas)
{
    for (const auto& motorista : motoristas)
    {
        if (motorista.getCpf() == cpf)
        {
            return motorista;
        }
    }
    cout << "Motorista não encontrado!\n";
    return Motorista();
}

Veiculo* encontrarVeiculo(const string& placa, const vector<unique_ptr<Veiculo>>& veiculos)
{
    for (const auto& veiculo : veiculos)
    {
        if (veiculo->getPlaca() == placa)
        {
            return veiculo.get();
        }
    }
    cout << "Veículo não encontrado!\n";
    return nullptr;
}

int main()
{
    vector<Motorista> motoristas;
    vector<unique_ptr<Veiculo>> veiculos; // Lista de ponteiros para Veiculo
    Motorista motoristaTemp;
    Veiculo* veiculoTemp = nullptr;
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
            do
            {
                cout << "Habilitação: ";
                getline(cin, habilitacao);
                transform(habilitacao.begin(), habilitacao.end(), habilitacao.begin(), ::toupper);
                if (habilitacao != "A" && habilitacao != "B" && habilitacao != "C" && habilitacao != "D" && habilitacao != "E")
                {
                    cout << "\nHabilitação inválida!Digite uma habilitação válida.\n";
                }
            } while (habilitacao != "A" && habilitacao != "B" && habilitacao != "C" && habilitacao != "D" && habilitacao != "E");

            motoristas.emplace_back(nome, cpf, habilitacao);
            break;
        case 2:
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
                veiculos.emplace_back(make_unique<Carro>(placa, modelo, assentos));
                break;
            case 2:
                cout << "Cilindradas: ";
                cin >> cilindradas;
                veiculos.emplace_back(make_unique<Moto>(placa, modelo, cilindradas));
                break;
            case 3:
                cout << "Capacidade de carga: ";
                cin >> capacidadeCarga;
                veiculos.emplace_back(make_unique<Caminhao>(placa, modelo, capacidadeCarga));
                break;
            default:
                cout << "Opção inválida!" << endl;
                break;
            }
            break;
        case 3:
            if (motoristas.empty())
            {
                cout << "Ainda não foi cadastrado nenhum motorista!\nCadastre e tente novamente.\n";
                break;
            }
            else if (veiculos.empty())
            {
                cout << "Ainda não foi cadastrado nenhum veículo!\nCadastre e tente novamente.\n";
                break;
            }

            cout << "Digite o CPF do motorista: ";
            getline(cin, cpf);
            motoristaTemp = encontrarMotorista(cpf, motoristas);
            
            if (motoristaTemp.getNome() != "")
            {
                cout << "Motorista encontrado.\n" << motoristaTemp.getDetalhes() ;

                cout << "Digite a placa do veículo: ";
                getline(cin, placa);
                veiculoTemp = encontrarVeiculo(placa, veiculos);

                if (veiculoTemp != nullptr)
                {
                    cout << "Veículo encontrado:\n" << veiculoTemp->getDetalhes();
                }
                
            }
            

            break;
        default:
            break;
        }
    }

    return 0;
}
