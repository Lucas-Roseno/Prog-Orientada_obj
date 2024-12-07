#if !defined(__FUNCIONARIO_HPP)
#define __FUNCIONARIO_HPP
#include <iostream>
#include <string>
using namespace std;

class Funcionario
{
    protected:
        string nome;
        float salario;
    public: 
        string getNome();
        void setNome(string nome);
        float getSalario();
        void setSalario(float salario);

        void descricao();
};
#endif
