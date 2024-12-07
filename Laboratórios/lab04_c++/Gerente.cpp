#include "Gerente.hpp"

void Gerente::setNumero_de_equipes(int numEquipes)
{
    this->numero_de_equipes = numEquipes;
}
int Gerente:: getNumero_de_equipes()
{
    return this->numero_de_equipes;
}


int Gerente::bonus()
{
    return numero_de_equipes * 500;
}