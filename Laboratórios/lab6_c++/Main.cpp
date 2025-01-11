#include <iostream>
#include <vector>
#include <string>
#include <algorithm> 
#include <cctype>    
#include <memory>    
#include "Motorista.hpp"
#include "Veiculo.hpp"
#include "Carro.hpp"
#include "Moto.hpp"
#include "Caminhao.hpp"
#include "Viagem.hpp"

using namespace std;

Motorista encontrarMotorista(string cpf, vector<Motorista> motoristas)
{
    for (Motorista motorista : motoristas)
    {
        if (motorista.getCpf() == cpf)
        {
            return motorista;
        }
    }
    cout << "Motorista não encontrado!\n";
    return Motorista();
}

shared_ptr<Veiculo> encontrarVeiculo(string placa, vector<shared_ptr<Veiculo>> veiculos)
{
    for (const auto &veiculo : veiculos)
    {
        if (veiculo->getPlaca() == placa)
        {
            return veiculo;
        }
    }
    cout << "Veículo não encontrado!\n";
    return nullptr;
}

bool podeDirigir(shared_ptr<Veiculo> veiculoTemp, Motorista motoristaTemp)
{
    if (dynamic_cast<Carro *>(veiculoTemp.get()))
    {
        return motoristaTemp.getHabilitacao() == "B" || motoristaTemp.getHabilitacao() == "C" || motoristaTemp.getHabilitacao() == "D" || motoristaTemp.getHabilitacao() == "E";
    }
    else if (dynamic_cast<Moto *>(veiculoTemp.get()))
    {
        return motoristaTemp.getHabilitacao() == "A";
    }
    else if (dynamic_cast<Caminhao *>(veiculoTemp.get()))
    {
        return motoristaTemp.getHabilitacao() == "C" || motoristaTemp.getHabilitacao() == "D" || motoristaTemp.getHabilitacao() == "E";
    }
    return false;
}

int main()
{
    vector<Motorista> motoristas;
    vector<shared_ptr<Veiculo>> veiculos;
    vector<Viagem> viagens;

    Motorista motoristaTemp;
    shared_ptr<Veiculo> veiculoTemp = nullptr;

    string nome, habilitacao, cpf, placa, modelo;
    int assentos, cilindradas;
    double capacidadeCarga, distancia;
    int opcao;

    bool achouViagem = false, achouMotorista = false, achouVeiculo = false;

    while (true)
    {
        cout << "============GERENCIAMNETO ROADLINK============\n"
             << "1 - Cadastrar motorista\n"
             << "2 - Cadastrar veículo\n"
             << "3 - Registrar viagem\n"
             << "4 - Exibir detalhes de uma viagem\n"
             << "5 - Excluir motorista\n"
             << "6 - Excluir veículo\n"
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
                veiculos.emplace_back(make_shared<Carro>(placa, modelo, assentos));
                break;
            case 2:
                cout << "Cilindradas: ";
                cin >> cilindradas;
                veiculos.emplace_back(make_shared<Moto>(placa, modelo, cilindradas));
                break;
            case 3:
                cout << "Capacidade de carga: ";
                cin >> capacidadeCarga;
                veiculos.emplace_back(make_shared<Caminhao>(placa, modelo, capacidadeCarga));
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
                cout << "Motorista encontrado.\n"
                     << motoristaTemp.getDetalhes();

                cout << "Digite a placa do veículo: ";
                getline(cin, placa);
                veiculoTemp = encontrarVeiculo(placa, veiculos);

                if (veiculoTemp != nullptr)
                {
                    cout << "Veículo encontrado:\n"
                         << veiculoTemp->getDetalhes();

                    if (podeDirigir(veiculoTemp, motoristaTemp))
                    {
                        cout << "Motorista pode dirigir o veículo!\n";
                        cout << "Digite a distância da viagem: ";
                        cin >> distancia;

                        viagens.emplace_back(motoristaTemp, *veiculoTemp, distancia);
                        cout << "Viagem registrada com sucesso!\n";
                    }
                }
            }
            break;
        case 4:
            if (viagens.empty())
            {
                cout << "Ainda não foi cadastrada nenhuma viagem!\n";
                break;
            }

            cout << "Digite o CPF do motorista: ";
            getline(cin, cpf);
            cout << "Digite a placa do veículo: ";
            getline(cin, placa);

            for (Viagem viagem : viagens)
            {
                if (cpf == viagem.getMotorista().getCpf() && placa == viagem.getVeiculo().getPlaca())
                {
                    cout << viagem.getDetalhes() << endl;
                    achouViagem = true;
                    break;
                }
            }
            if (!achouViagem)
            {
                cout << "Não há viagem com esse motorista e veículo!\n";
            }
            break;

        case 5:
            cout << "Digite o CPF do motorista: ";
            getline(cin, cpf);
            for (auto it = motoristas.begin(); it != motoristas.end(); ++it)
            {
                if (it->getCpf() == cpf)
                {
                    motoristas.erase(it);
                    cout << "Motorista removido com sucesso!\n";
                    achouMotorista = true;
                    break;
                }
            }

            if (!achouMotorista)
            {
                cout << "Motorista não encontrado!\n";
            }
            break;

        case 6:
            cout << "Digite a placa do veículo: ";
            getline(cin, placa);
            for (auto it = veiculos.begin(); it != veiculos.end(); ++it)
            {
                if ((*it)->getPlaca() == placa)
                {
                    veiculos.erase(it);
                    cout << "Veículo removido com sucesso!\n";
                    achouVeiculo = true;
                    break;
                }
            }
            if (!achouVeiculo)
            {
                cout << "Veículo não encontrado!\n";
            }
            break;

        default:
            break;
        }
    }

    return 0;
}