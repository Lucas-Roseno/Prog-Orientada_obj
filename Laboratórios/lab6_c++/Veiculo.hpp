#ifndef __PESSOA_HPP
#define __PESSOA_HPP
#include <iostream>
#include <string>
using namespace std;

class Veiculo
{
protected:
    string placa;
    string modelo;
public:
    Veiculo() = default;
    Veiculo(string placa, string modelo);
    virtual string getDetalhes();
    virtual double calcularCusto(double distancia);

    // Getters
    string getPlaca() const;
    string getModelo() const;

    // Setters
    void setPlaca(const string& placa);
    void setModelo(const string& modelo);
};

#endif 