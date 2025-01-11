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
    Viagem() = default;
    Viagem(Motorista motorista, Veiculo veiculo, double distancia); 

    double calcularCustoTotal();
    std::string getDetalhes();

    // Getters
    Motorista getMotorista();
    Veiculo getVeiculo(); 
    double getDistancia();

    // Setters
    void setMotorista(Motorista motorista);
    void setVeiculo(Veiculo veiculo); 
    void setDistancia(double distancia);
};