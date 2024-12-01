#include<iostream> //biblioteca  
#include "Aluno.hpp"

int Aluno::getMatricula()
{
    return matricula;
}

void Aluno::setMatricula(int matricula)
{
    this->matricula = matricula;
}