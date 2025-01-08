#include "Viagem.hpp"

Viagem::Viagem(Motorista motorista, Veiculo veiculo, double distancia)
    : motorista(motorista), veiculo(veiculo), distancia(distancia) {};

double Viagem::calcularCustoTotal(){
    return veiculo.calcularCusto(distancia);
}

string Viagem::getDetalhes(){
    return "Motorista:\n" + motorista.getDetalhes() + "\nVeiculo: " + veiculo.getDetalhes()
        +"\nDistância: " + to_string(distancia);
}