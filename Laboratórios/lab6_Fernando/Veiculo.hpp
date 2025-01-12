#pragma once
#include <string>
#include <vector>

class Veiculo{
    protected:
        std::string _placa;
        std::string _modelo;

    public:
        Veiculo(std::string placa, std::string modelo);
        Veiculo();

        virtual std::string getDetalhes();
        virtual double calcularCusto(double distancia);
        std::string getPlaca();
        std::string getModelo();
};