#include "Disciplina.hpp"

string Disciplina::getNome()
{
    return nome;
}
void Disciplina::setNome(string nome)
{
    this->nome = nome;
}

int Disciplina::getCH()
{
    return ch;
}
void Disciplina::setCH(int ch)
{
    this->ch = ch;
}

Professor Disciplina::getProfessor()
{
    return professor;
}
void Disciplina::setProfessor(Professor professor)
{
    this->professor = professor;
}