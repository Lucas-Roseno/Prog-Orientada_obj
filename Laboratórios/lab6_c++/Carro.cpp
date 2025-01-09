#include "Carro.hpp"

Carro::Carro(string placa, string modelo, int assentos) : Veiculo(placa, modelo), assentos(assentos){}

string Carro::getDetalhes(){
    return Veiculo::getDetalhes() +  "\n\tAssentos: " + to_string(assentos) + "\n";
}

double Carro::calcularCusto(double distancia){
    return distancia*0.5;
}