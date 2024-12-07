#include "Funcionario.hpp"
#ifndef __DESENVOLVEDOR_HPP
#define __DESENVOLVEDOR_HPP

class Desenvolvedor: virtual public Funcionario
{
protected:
    string linguagem_principal;
public:
    void setLinguagem_principal(string linguagem);
    string getLinguagem_principal();
    
    void projetos_realizados();

};
#endif