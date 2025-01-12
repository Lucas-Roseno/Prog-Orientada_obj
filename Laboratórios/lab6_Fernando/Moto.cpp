#include "Moto.hpp"

Moto::Moto(std::string placa, std::string modelo, int _cilindrada) : Veiculo(placa, modelo), _cilindrada(_cilindrada){}

std::string Moto::getDetalhes(){
    return Veiculo::getDetalhes() + "Número de cilindradas: " + std::to_string(_cilindrada) + "cc";
}
double Moto::calcularCusto(double distancia){
    return distancia * 0.2;
}