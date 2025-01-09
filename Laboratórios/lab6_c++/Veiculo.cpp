#include "Veiculo.hpp"

Veiculo::Veiculo(string placa, string modelo): placa(placa), modelo(modelo){}

double Veiculo::calcularCusto(double distancia){
    return 0.0;
}

string Veiculo::getDetalhes(){
    return "\tPlaca: " + placa + "\n\tModelo: " + modelo;
}

// Getters
string Veiculo::getPlaca() const {
    return placa;
}

string Veiculo::getModelo() const {
    return modelo;
}

// Setters
void Veiculo::setPlaca(const string& placa) {
    this->placa = placa;
}

void Veiculo::setModelo(const string& modelo) {
    this->modelo = modelo;
}