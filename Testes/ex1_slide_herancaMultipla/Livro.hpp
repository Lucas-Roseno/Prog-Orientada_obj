#ifndef __LIVRO_HPP
#define __LIVRO_HPP

#include "Material.hpp"

class Livro : virtual public Material
{
protected:
    int numero_de_paginas;
public:
    Livro(string titulo, string autor, int numPags);
    void descricao() override;    
};



#endif