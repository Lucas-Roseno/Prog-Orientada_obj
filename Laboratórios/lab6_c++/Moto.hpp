#pragma once
#include "Veiculo.hpp"

class Moto : public Veiculo 
{
protected:
    int cilindradas;

public:
    Moto(string placa, string modelo, int cilindradas);
    string getDetalhes() override;
    double calcularCusto(double distancia) override;
};