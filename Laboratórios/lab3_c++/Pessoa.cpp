#include "Pessoa.hpp"
#include <iostream>
using namespace std;

string Pessoa::getNome()
{
    return nome;
}
void Pessoa::setNome(string nome)
{
    this->nome = nome;
}

string Pessoa::getEndereco()
{
    return endereco;
}
void Pessoa::setEndereco(string endereco)
{
    this->endereco = endereco;
}