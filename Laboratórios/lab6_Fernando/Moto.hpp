#pragma once
#include "Veiculo.hpp"

class Moto : virtual public Veiculo{
    protected:
        int _cilindrada;

    public:
        Moto(std::string placa, std::string modelo, int _cilindrada);

        std::string getDetalhes() override;
        double calcularCusto(double distancia) override;
};