#pragma once
#include "Veiculo.hpp"

class Carro : public Veiculo
{
protected:
    int assentos;
public:
    Carro(string placa, string modelo, int assentos);
    string getDetalhes() override;
    double calcularCusto(double distancia) override;
};

