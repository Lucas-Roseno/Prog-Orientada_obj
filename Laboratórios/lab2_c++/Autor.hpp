#ifndef __AUTOR_HPP
#define __AUTOR_HPP
using namespace std;
#include <string>

class Autor
{
private:
    string nome, dataNascimento;

public:
    void setNome(string nome);
    string getNome();
    void setDataNascimento(string dataNascimento);
    string getDataNascimento();
};

#endif