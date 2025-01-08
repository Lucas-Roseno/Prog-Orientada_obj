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
    Veiculo(string placa, string modelo);
    virtual string getDetalhes();
    virtual double calcularCusto(double distancia);

};

#endif // !__PESSOA_HPP
