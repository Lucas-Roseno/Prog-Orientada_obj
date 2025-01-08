#include "Carro.hpp"

Carro::Carro(string placa, string modelo, int assentos) : Veiculo(placa, modelo), assentos(assentos){}

string Carro::getDetalhes(){
    return Veiculo::getDetalhes() +  "\nAssentos: " + to_string(assentos);
}

double Carro::calcularCusto(double distancia){
    return distancia*0.5;
}