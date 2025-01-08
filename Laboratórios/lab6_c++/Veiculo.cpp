#include "Veiculo.hpp"

Veiculo::Veiculo(string placa, string modelo): placa(placa), modelo(modelo){}

double Veiculo:: calcularCusto(double distancia){
    return 0.0;
};

string Veiculo::getDetalhes(){
    return "Placa: " + placa + "\nModelo: " + modelo;
}