#include "Funcionario.hpp"

void Funcionario::setNome(string nome)
{
    this->nome = nome;
}
string Funcionario::getNome()
{
    return this->nome;
}

void Funcionario::setSalario(float salario)
{
    this->salario = salario;
}
float Funcionario::getSalario()
{
    return this->salario;
}


void Funcionario::descricao()
{
    cout << "---------------------------\n";
    cout<<"Funcionário: " << nome;
    printf("\nSalário: R$%.2f", salario);
    cout << "\n---------------------------";
}

