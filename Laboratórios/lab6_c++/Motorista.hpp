#ifndef __MOTORISTA_HPP
#define __MOTORISTA_HPP
#include <iostream>
#include <string>
using namespace std;

class Motorista
{
protected:
    string nome;
    string cpf;
    string habilitacao;
    
public:
    Motorista(string _nome, string _cpf, string _habilitacao);
    string getDetalhes();
};



#endif 


