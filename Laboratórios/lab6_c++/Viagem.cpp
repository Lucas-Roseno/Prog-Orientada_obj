#include "Viagem.hpp"
#include <iomanip> 
#include <sstream> 

Viagem::Viagem(Motorista motorista, Veiculo veiculo, double distancia)
    : motorista(motorista), veiculo(veiculo), distancia(distancia) {}

double Viagem::calcularCustoTotal() {
    return veiculo.calcularCusto(distancia);
}

std::string Viagem::getDetalhes() {
    std::ostringstream oss;
    oss << std::fixed << std::setprecision(2) << distancia;
    return "Motorista:\n" + motorista.getDetalhes() + "\nVeiculo: \n" + veiculo.getDetalhes()
        +"\n\tDistância: " + oss.str() + " km\n";
}

// Getters
Motorista Viagem::getMotorista(){
    return motorista;
}

Veiculo Viagem::getVeiculo() { 
    return veiculo;
}

double Viagem::getDistancia(){
    return distancia;
}

// Setters
void Viagem::setMotorista(Motorista motorista) {
    this->motorista = motorista;
}

void Viagem::setVeiculo(Veiculo veiculo) {
    this->veiculo = veiculo;
}

void Viagem::setDistancia(double distancia) {
    this->distancia = distancia;
}