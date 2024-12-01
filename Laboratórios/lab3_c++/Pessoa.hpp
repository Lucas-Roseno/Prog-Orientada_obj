#ifndef __PESSOA_HPP
#define __PESSOA_HPP
#include <string.h>
#include<iostream>
using namespace std;

class Pessoa
{
protected:
    string nome;
    string endereco;
public:
    string getNome();
    void setNome(string nome);
    
    string getEndereco();
    void setEndereco(string endereco);
};





#endif