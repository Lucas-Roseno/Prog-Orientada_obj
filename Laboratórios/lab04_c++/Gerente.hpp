#include "Funcionario.hpp"
#ifndef __GERENTE_HPP
#define __GERENTE_HPP

class Gerente: virtual public Funcionario
{
protected:
    int numero_de_equipes;
public:
    void setNumero_de_equipes(int num_equipes);
    int getNumero_de_equipes();

    int bonus();
};
#endif
