#include "Viagem.hpp"

Viagem::Viagem(Motorista motorista, Veiculo veiculo, double _distancia): motorista(motorista), veiculo(veiculo), _distancia(_distancia){}
Viagem::Viagem(){}

std::string Viagem::getDetalhes(){
    return "\n- - - Dados do motorista: - - -\n" + motorista.getDetalhes() + "\n\n- - - Dados do veículo: - - -\n" + veiculo.getDetalhes() + "\n\n- - - Distância percorrida: - - -\n\n" + std::to_string(_distancia) + "km" + "\n\n- - - Custo total: - - -\n\n" + "R$" + std::to_string(calcularCustoTotal());
}
double Viagem::calcularCustoTotal(){
    return veiculo.calcularCusto(_distancia);
}
Motorista Viagem::getMotorista(){ 
    return motorista;
}
Veiculo Viagem::getVeiculo(){
    return veiculo;
}