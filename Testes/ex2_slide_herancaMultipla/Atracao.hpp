#ifndef __ATRACAO_HPP
#define __ATRACAO_HPP
#include <iostream>
#include <string>
using namespace std;

class Atracao
{
protected:
    string nome;
    int capacidade;
public:
    Atracao(string nome, int capacidade);
    virtual void info();
};

#endif