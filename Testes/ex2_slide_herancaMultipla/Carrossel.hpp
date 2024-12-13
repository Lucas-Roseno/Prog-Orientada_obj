#ifndef __CARROSSEL_HHP
#define __CARROSSEL_HHP
#include "Atracao.hpp"
#include "Mecanica.hpp"
#include "Tematica.hpp"

class Carrossel: virtual public Atracao, Mecanica, Tematica
{
private:
    /* data */
public:
    Carrossel(string nome, int capacidade, int velocidade, string tema);
    void info() override;
    
};

#endif