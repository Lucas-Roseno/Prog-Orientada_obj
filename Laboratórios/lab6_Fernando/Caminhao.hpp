#pragma once
#include "Veiculo.hpp"

class Caminhao : virtual public Veiculo{
    protected:
        double _capacidadeCarga;

    public:
        Caminhao(std::string placa, std::string modelo, double _capacidadeCarga);

        std::string getDetalhes() override;
        double calcularCusto(double distancia) override;
};