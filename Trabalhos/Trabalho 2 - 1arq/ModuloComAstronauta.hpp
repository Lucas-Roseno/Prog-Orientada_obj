#pragma once
#include "Modulo.hpp"

class ModuloComAstronauta : public Modulo
{

public:
    ModuloComAstronauta(char tipo);
    ModuloComAstronauta();

    bool podeAcessar() override;
};
