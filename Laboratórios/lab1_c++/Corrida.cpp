#include <iostream>
#include "Corrida.hpp"
using namespace std;

//============== Getters e setters ===============================
void Corrida::setModelo(string modelo)
{
    this->modelo = modelo;
}
string Corrida::getModelo()
{
    return modelo;
}

void Corrida::setMotorizacao(string motorizacao)
{
    this->motorizacao = motorizacao;
}
string Corrida::getMotorizacao()
{
    return motorizacao;
}

void Corrida::setFabricante(string fabricante)
{
    this->fabricante = fabricante;
}
string Corrida::getFabricante()
{
    return fabricante;
}

void Corrida::setNomeMotorista(string nome)
{
    this->nomeMotorista = nome;
}
string Corrida::getNomeMotorista()
{
    return nomeMotorista;
}

void Corrida::setKmInicial(float kmInicial)
{
    this->kmInicial = kmInicial;
}
float Corrida::getKmInicial()
{
    return kmInicial;
}

void Corrida::setKmFinal(float kmFinal)
{
    this->kmFinal = kmFinal;
}
float Corrida::getKmFinal()
{
    return kmFinal;
}

//======================= outros métodos ==================================
float Corrida::calcularQuilometragemPercorrida(float kmInicial, float kmFinal)
{
    return kmFinal - kmInicial;
}

float Corrida::valorFinal(float kmRodado)
{
    return kmRodado * 3.75f;
}