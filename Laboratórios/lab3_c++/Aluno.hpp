#ifndef __ALUNO_HPP
#define __ALUNO_HPP
#include<iostream>
#include "Pessoa.hpp"
#include <string.h>

class Aluno : public Pessoa
{
private:
    int matricula;
public:
    int getMatricula();
    void setMatricula(int matricula);
};



#endif