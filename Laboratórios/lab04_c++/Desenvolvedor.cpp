#include "Desenvolvedor.hpp"

void Desenvolvedor::setLinguagem_principal(string linguagem)
{
    this->linguagem_principal = linguagem;
}
string Desenvolvedor::getLinguagem_principal()
{
    return this->linguagem_principal;
}

void Desenvolvedor::projetos_realizados()
{
    cout << "Projetos entregues na linguagem: " << linguagem_principal;
}