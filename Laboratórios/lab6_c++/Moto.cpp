#include "Moto.hpp"

Moto::Moto(string placa, string modelo, int cilindradas): Veiculo(placa, modelo), cilindradas(cilindradas){};

string Moto::getDetalhes(){
    return Veiculo::getDetalhes() + "\nCilindradas: " + to_string(cilindradas);
}

double Moto::calcularCusto(double distancia){
    return distancia*0.2;
}