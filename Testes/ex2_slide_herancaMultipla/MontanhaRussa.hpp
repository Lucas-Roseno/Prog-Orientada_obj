#ifndef __MONTANHARUSSA_HPP
#define __MONTANHARUSSA_HPP
#include "Atracao.hpp"
#include "Mecanica.hpp"
#include "Tematica.hpp"

class MontanhaRussa: virtual public Atracao, Mecanica, Tematica
{
private:
    
public:
    MontanhaRussa(string nome, int capacidade, int velocidade, string tema);
    void info() override;
};



#endif