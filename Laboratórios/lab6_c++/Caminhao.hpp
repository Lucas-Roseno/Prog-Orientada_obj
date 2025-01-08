#pragma once
#include "Veiculo.hpp"

class Caminhao : public Veiculo
{
protected:
    double capacidadeCarga;
public:
    Caminhao(string placa, string modelo, double capacidadeCarga);
    string getDetalhes() override;
    double calcularCusto(double distancia) override;
};

