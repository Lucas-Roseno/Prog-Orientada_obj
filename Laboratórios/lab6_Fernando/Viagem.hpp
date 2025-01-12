#pragma once
#include <string>
#include "Motorista.hpp"
#include "Veiculo.hpp"

class Viagem{
    protected:
        Motorista motorista;
        Veiculo veiculo;
        double _distancia;

    public:
        Viagem(Motorista motorista, Veiculo veiculo, double _distancia);
        Viagem();

        virtual std::string getDetalhes();
        double calcularCustoTotal();
        Motorista getMotorista();
        Veiculo getVeiculo();
};