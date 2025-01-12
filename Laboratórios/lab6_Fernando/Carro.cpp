#include "Carro.hpp"

Carro::Carro(std::string placa, std::string modelo, int _assentos) : Veiculo(placa, modelo), _assentos(_assentos){}

std::string Carro::getDetalhes(){
    return Veiculo::getDetalhes() + "Número de assentos: " + std::to_string(_assentos);
}
double Carro::calcularCusto(double distancia){
    return distancia * 0.5;
}