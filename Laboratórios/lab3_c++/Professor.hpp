#ifndef __PROFESSOR_HPP
#define __PROFESSOR_HPP
#include "Pessoa.hpp"

class Professor : public Pessoa
{
private:
    string titulacao;
    string curso;
public:
    string getTitulacao();
    void setTitulacao (string titulacao);
    string getCurso();
    void setCurso(string curso);
};

#endif