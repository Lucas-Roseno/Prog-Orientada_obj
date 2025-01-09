#ifndef __MOTORISTA_HPP
#define __MOTORISTA_HPP
#include <iostream>
#include <string>
using namespace std;

class Motorista
{
protected:
    string nome;
    string cpf;
    string habilitacao;
    
public:
    Motorista() = default;
    Motorista(string _nome, string _cpf, string _habilitacao);
    string getDetalhes();
    
    // Getters
    string getNome() const;
    string getCpf() const;
    string getHabilitacao() const;

    // Setters
    void setNome(const string& _nome);
    void setCpf(const string& _cpf);
    void setHabilitacao(const string& _habilitacao);

};

#endif