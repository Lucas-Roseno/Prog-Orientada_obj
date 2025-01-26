#pragma once
#include "Modulo.hpp"

class ModuloVazio : public Modulo
{
public:
    ModuloVazio(char tipo);
    bool podeAcessar() override;
};