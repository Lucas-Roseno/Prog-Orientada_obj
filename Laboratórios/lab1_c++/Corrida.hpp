#ifndef __CORRIDA_HPP
#define __CORRIDA_HPP
#include <string>
using namespace std;

class Corrida
{
private:
    string modelo;
    string motorizacao;
    string fabricante;
    string nomeMotorista;
    float kmInicial;
    float kmFinal;

public:
    void setModelo(string modelo);
    string getModelo();

    void setMotorizacao(string motorizacao);
    string getMotorizacao();

    void setFabricante(string fabricante);
    string getFabricante();

    void setNomeMotorista(string nomeMotorista);
    string getNomeMotorista();

    void setKmInicial(float kmInicial);
    float getKmInicial();

    void setKmFinal(float kmFinal);
    float getKmFinal();
//===================================================================
    float calcularQuilometragemPercorrida(float kmInicial, float kmFinal);
    float valorFinal(float kmRodado);



};
#endif