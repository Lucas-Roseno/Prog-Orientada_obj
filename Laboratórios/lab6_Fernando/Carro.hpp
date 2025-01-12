#pragma once
#include "Veiculo.hpp"

class Carro : virtual public Veiculo{
    protected:
        int _assentos;

    public:
        Carro(std::string placa, std::string modelo, int _assentos);

        std::string getDetalhes() override;
        double calcularCusto(double distancia) override;
};