#include <iostream>
#include <string>
#include "Viagem.hpp"
#include "Motorista.hpp"
#include "Veiculo.hpp"
#include "Carro.hpp"
#include "Moto.hpp"
#include "Caminhao.hpp"

int main(){
    Motorista motorista;
    Veiculo veiculo;
    Viagem viagem;
    std::vector<std::string> _cpfs;
    std::vector<Motorista> _motoristas;
    std::vector<std::string> _placas;
    std::vector<Veiculo> _veiculos;
    std::vector<Viagem> _viagens;
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;

    int opcao;

    while(true){
        std::cout << "\nMenu:" << std::endl;
        std::cout << "\n1. Registrar um motorista" << std::endl;
        std::cout << "2. Registrar um veículo" << std::endl;
        std::cout << "3. Registrar uma viagem" << std::endl;
        std::cout << "4. Imprimir detalhes de uma viagem" << std::endl;
        std::cout << "5. Excluir um motorista" << std::endl;
        std::cout << "6. Excluir um veículo" << std::endl;
        std::cout << "7. Sair" << std::endl;
        std::cout << "\nSelecione uma opção: ";
        std::cin >> opcao;
        std::cin.ignore(); 

        switch(opcao){
            case 1:{
                std::string nome;
                std::string cpf;
                std::string cnh;
                int cont = 0;
                bool cpfExistente = false;

                std::cout << "\nDigite o nome do motorista: ";
                std::getline(std::cin, nome);
                nome[0] = std::toupper(nome[0]);
                while(cont == 0){
                    std::cout << "Digite o cpf de " << nome << ": ";
                    std::getline(std::cin, cpf);
                    for(int i = 0; i < _cpfs.size(); i++){
                        if(_cpfs[i] == cpf){
                            cpfExistente = true;
                            std::cout << "CPF já cadastrado. Por favor, tente novamente.\n";
                            break;
                        }
                    }
                    if(!cpfExistente){
                        cont++;
                    }
                }
                while(cnh != "A" && cnh != "B" && cnh != "C" && cnh != "a" && cnh != "b" && cnh != "c"){
                    std::cout << "Agora, digite a categoria da cnh de " << nome << "('A', 'B' ou 'C'): ";
                    std::getline(std::cin, cnh);
                    if(cnh != "A" && cnh != "B" && cnh != "C" && cnh != "a" && cnh != "b" && cnh != "c"){
                        std::cout << "Categoria inválida. Por favor, tente novamente.\n";
                    }
                }
                cont1++;

                Motorista motorista(nome, cpf, cnh);
                std::cout << "Motorista registrado com sucesso!\n";
                _motoristas.push_back(motorista);
                _cpfs.push_back(cpf); 
                break;
            }
            case 2:{
                std::string placa;
                std::string modelo;

                std::cout << "\nInforme a placa do veículo: ";
                std::getline(std::cin, placa);
                while(modelo != "carro" && modelo != "moto" && modelo != "caminhao" && modelo != "Carro" && modelo != "Moto" && modelo != "Caminhao"){
                    std::cout << "Agora, digite o modelo do veículo('carro', 'moto' ou 'caminhao'): ";
                    std::getline(std::cin, modelo);
                    if(modelo == "carro" || modelo == "Carro"){
                        int assentos;

                        std::cout << "Por fim, digite o número de assentos do carro: ";
                        std::cin >> assentos;
                        std::cin.ignore();
                        cont2++;

                        Veiculo veiculo = Carro(placa, modelo, assentos);
                        std::cout << "Carro registrado com sucesso!\n";
                        _veiculos.push_back(veiculo);
                        _placas.push_back(placa);
                    }
                    else if(modelo == "moto" || modelo == "Moto"){
                        int cilindros;

                        std::cout << "Por fim, digite o número de cilindros da moto: ";
                        std::cin >> cilindros;
                        std::cin.ignore();
                        cont2++;

                        Veiculo veiculo = Moto(placa, modelo, cilindros);
                        std::cout << "Moto registrada com sucesso!\n";
                        _veiculos.push_back(veiculo);
                        _placas.push_back(placa);
                    }
                    else if(modelo == "caminhao" || modelo == "Caminhao"){
                        double capacidadeCarga;

                        std::cout << "Por fim, digite a capacidade de carga(em kg) do caminhão: ";
                        std::cin >> capacidadeCarga;
                        std::cin.ignore();
                        cont2++;

                        Veiculo veiculo = Caminhao(placa, modelo, capacidadeCarga);
                        std::cout << "Caminhão registrado com sucesso!\n";
                        _veiculos.push_back(veiculo);
                        _placas.push_back(placa);
                    }
                    else{
                        std::cout << "Modelo inválido. Por favor, tente novamente.\n" << std::endl;
                    }
                }
                break;
            }
            case 3:{
                std::string cpf;
                std::string veiculoViagem;
                double dist;
                int cont = 0;
                Motorista motorista1; 
                Veiculo veiculo1; 
                bool verifica = false;

                if(cont1 != 0 && cont2 != 0){
                    while(cont == 0){
                        cont = 0;

                        std::cout << "\nDigite o cpf do motorista: ";
                        std::getline(std::cin, cpf);
                        for(int i = 0; i < _cpfs.size(); i++){
                            if(cpf == _cpfs[i]){
                                motorista1 = _motoristas[i];
                                if(i < _viagens.size() && cpf == _viagens[i].getMotorista().getCpf()){
                                    std::cout << "Motorista já cadastrado em uma viagem. Por favor, tente novamente." << std::endl;
                                    verifica = true;
                                    break;
                                }
                                else{
                                    cont++;
                                }
                            }
                        }
                        if(cont == 0 && !verifica){
                            std::cout << "Motorista inexistente. Por favor, tente novamente." << std::endl;
                        }
                    }
                    cont = 0;
                    while(cont == 0){
                        std::cout << "Agora, informe a placa do veículo que será utilizado na viagem: ";
                        std::getline(std::cin, veiculoViagem);
                        for(int i = 0; i < _placas.size(); i++){
                            if(veiculoViagem == _placas[i]){
                                veiculo1 = _veiculos[i];
                                if(_viagens.size() > 0 && veiculoViagem == _viagens[i].getVeiculo().getPlaca()){
                                    std::cout << "Veículo já cadastrado em uma viagem. Por favor, tente novamente." << std::endl;
                                    verifica = true;
                                    break;
                                }
                                else if((veiculo1.getModelo() == "carro" || veiculo1.getModelo() == "Carro") && (motorista1.getCnh() != "A" && motorista1.getCnh() != "a")){
                                    std::cout << "Motorista não possui CNH compatível com o veículo. Por favor, tente novamente." << std::endl;
                                    verifica = true;
                                    break;
                                }
                                else if((veiculo1.getModelo() == "moto" || veiculo1.getModelo() == "Moto") && (motorista1.getCnh() != "B" && motorista1.getCnh() != "b")){
                                    std::cout << "Motorista não possui CNH compatível com o veículo. Por favor, tente novamente." << std::endl;
                                    verifica = true;
                                    break;
                                }
                                else if((veiculo1.getModelo() == "caminhao" || veiculo1.getModelo() == "Caminhao") && (motorista1.getCnh() != "C" && motorista1.getCnh() != "c")){
                                    std::cout << "Motorista não possui CNH compatível com o veículo. Por favor, tente novamente." << std::endl;
                                    verifica = true;
                                    break;
                                }
                                else{
                                    cont++;
                                }
                            }
                        }
                        if(cont == 0 && !verifica){
                            std::cout << "Veículo inexistente. Por favor, tente novamente." << std::endl;
                        }
                    }
                    while(true){
                        std::cout << "Por fim, digite a distância total(em km) que será percorrida na viagem: ";
                        std::cin >> dist;
                        std::cin.ignore();
                        if(dist > 0){
                            Viagem viagem = Viagem(motorista1, veiculo1, dist);
                            std::cout << "Viagem registrada com sucesso!\n";
                            _viagens.push_back(viagem);
                            cont3++;
                            break;
                        }
                        else{
                            std::cout << "Distância inválida. Por favor, tente novamente.";
                        }
                    }
                }
                else{
                    std::cout << "\nNenhum motorista ou veículo registrado ainda." << std::endl;
                }
                break;
            }
            case 4:
                if(cont3 != 0){
                    std::string cpf;
                    int cont = 0;

                    while(cont == 0){
                        std::cout << "\nDigite o cpf do motorista da viagem: ";
                        std::getline(std::cin, cpf);
                        for(int i = 0; i < _viagens.size(); i++){
                            if(cpf == _viagens[i].getMotorista().getCpf()){
                                Viagem viagem = _viagens[i];
                                std::cout << viagem.getDetalhes() << std::endl;
                                cont++;
                            }
                        }
                        if(cont == 0){
                            std::cout << "Motorista inexistente. Por favor, tente novamente." << std::endl;
                        }
                    }
                } 
                else{
                    std::cout << "\nNenhuma viagem registrada no momento." << std::endl;
                }
                break;
            case 5:
                if(cont1 != 0){
                    std::string cpf;
                    int cont = 0;

                    while(cont == 0){
                        std::cout << "\nDigite o cpf do motorista: ";
                        std::getline(std::cin, cpf);
                        for(int i = 0; i < _cpfs.size(); i++){
                            if(cpf == _cpfs[i]){
                                _cpfs.erase(_cpfs.begin() + i);
                                _motoristas.erase(_motoristas.begin() + i);
                                cont1--;
                                std::cout << "\nMotorista excluído com sucesso.\n";
                                cont++;
                            }
                        }
                        if(cont == 0){
                            std::cout << "Motorista inexistente. Por favor, tente novamente." << std::endl;
                        }
                    }
                } 
                else{
                    std::cout << "\nNenhum motorista registrado no momento." << std::endl;
                }
                break;
            case 6:
                if(cont2 != 0){
                    std::string veiculoViagem;
                    int cont = 0;

                    while(cont == 0){
                        std::cout << "\nDigite a placa do veículo: ";
                        std::getline(std::cin, veiculoViagem);
                        for(int i = 0; i < _placas.size(); i++){
                            if(_placas[i] == veiculoViagem){
                                _placas.erase(_placas.begin() + i);
                                _veiculos.erase(_veiculos.begin() + i);
                                cont2--;
                                cont++;
                                std::cout << "\nVeículo excluído com sucesso.\n";
                            }
                        }
                        if(cont == 0){
                            std::cout << "Veiculo inexistente. Por favor, tente novamente." << std::endl;
                        }
                    }
                } 
                else{
                    std::cout << "\nNenhum veículo registrado no momento." << std::endl;
                }
                break;
            case 7:
                return 0;
            default:
                std::cout << "\nOpção inválida! Por favor, tente novamente." << std::endl;
        }
    }
    return 0;
}
