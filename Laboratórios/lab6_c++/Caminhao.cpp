#include "Caminhao.hpp"

Caminhao::Caminhao(string placa, string modelo, double capacidadeCarga): Veiculo::Veiculo(placa, modelo), 
    capacidadeCarga(capacidadeCarga){};

string Caminhao::getDetalhes(){
    return Veiculo::getDetalhes() + "\nCapacidade de carga: " + to_string(capacidadeCarga);
}

double Caminhao::calcularCusto(double distancia){
    return distancia*1;
}