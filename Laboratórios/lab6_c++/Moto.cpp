#include "Moto.hpp"

Moto::Moto(string placa, string modelo, int cilindradas): Veiculo(placa, modelo), cilindradas(cilindradas){};

string Moto::getDetalhes(){
    return Veiculo::getDetalhes() + "\n\tCilindradas: " + to_string(cilindradas) + "\n";
}

double Moto::calcularCusto(double distancia){
    return distancia*0.2;
}