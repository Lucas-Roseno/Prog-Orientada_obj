#include "Motorista.hpp"

Motorista::Motorista(string _nome, string _cpf, string _habilitacao):
    nome(_nome), cpf(_cpf), habilitacao(_habilitacao){};

string Motorista::getDetalhes(){
    return "\nNome: "  + nome + "\nCPF: " + cpf + "\nHabilitação: " + habilitacao;
}