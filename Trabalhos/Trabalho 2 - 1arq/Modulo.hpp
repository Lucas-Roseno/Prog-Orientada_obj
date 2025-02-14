#pragma once
#include <iostream>

class Modulo
{
protected:
    char tipo;
public:
    Modulo(char tipo);
    Modulo();

    char getTipo() const;
    virtual bool podeAcessar();
    void setTipo(char ch);
};