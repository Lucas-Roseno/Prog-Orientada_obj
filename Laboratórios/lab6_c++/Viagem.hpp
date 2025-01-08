#pragma once
#include "Motorista.hpp"
#include "Veiculo.hpp"

class Viagem
{
protected:
    Motorista motorista;
    Veiculo veiculo;
    double distancia;

public:
    Viagem(Motorista motorista, Veiculo veiculo, double distania);
    double calcularCustoTotal();
    string getDetalhes();
    
};


