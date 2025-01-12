#include "Veiculo.hpp"

Veiculo::Veiculo(std::string placa, std::string modelo) : _placa(placa), _modelo(modelo){}
Veiculo::Veiculo(){}

std::string Veiculo::getDetalhes(){
    return "\nPlaca: " + _placa + "\nModelo: " + _modelo;
}
double Veiculo::calcularCusto(double distancia){
    return distancia * 0.5;
}
std::string Veiculo::getPlaca(){
    return _placa;
}
std::string Veiculo::getModelo(){
    return _modelo;
}