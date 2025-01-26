#pragma once
#include <iostream>

class Modulo
{
protected:
    char tipo;
public:
    Modulo(char tipo);
    Modulo();

    char getTipo();
    virtual bool podeAcessar() = 0;
};