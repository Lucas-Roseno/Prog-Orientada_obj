#include "Caminhao.hpp"

Caminhao::Caminhao(std::string placa, std::string modelo, double capacidadeCarga) : Veiculo(placa, modelo), _capacidadeCarga(_capacidadeCarga){}

std::string Caminhao::getDetalhes(){
    return Veiculo::getDetalhes() + "Capacidade de carga: " + std::to_string(_capacidadeCarga) + "kg";
}
double Caminhao::calcularCusto(double distancia){
    return distancia * 1;
}