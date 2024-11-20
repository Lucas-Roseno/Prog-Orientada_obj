#include <iostream>
#include "Autor.hpp"
using namespace std;
void Autor::setNome(string nome)
{
    this->nome = nome;
}
string Autor::getNome()
{
    return nome;
}

void Autor::setDataNascimento(string dataNascimento)
{
    this->dataNascimento = dataNascimento;
}
string Autor::getDataNascimento()
{
    return dataNascimento;
}


