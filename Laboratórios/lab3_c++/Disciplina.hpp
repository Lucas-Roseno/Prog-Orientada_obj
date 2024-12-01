#ifndef __DISCIPLINA_HPP
#define __DISCIPLINA_HPP
#include "Professor.hpp"

class Disciplina
{
private:
    string nome;
    int ch;
    Professor professor;
public:
    string getNome();
    void setNome(string nome);
    int getCH();
    void setCH(int ch);
    Professor getProfessor();
    void setProfessor(Professor professor);
};

#endif