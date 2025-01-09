#include "Motorista.hpp"

Motorista::Motorista(string _nome, string _cpf, string _habilitacao):
    nome(_nome), cpf(_cpf), habilitacao(_habilitacao){}

string Motorista::getDetalhes(){
    return "\tNome: "  + nome + "\n\tCPF: " + cpf + "\n\tHabilitação: " + habilitacao + "\n";
}

// Getters
string Motorista::getNome() const {
    return nome;
}

string Motorista::getCpf() const {
    return cpf;
}

string Motorista::getHabilitacao() const {
    return habilitacao;
}

// Setters
void Motorista::setNome(const string& _nome) {
    nome = _nome;
}

void Motorista::setCpf(const string& _cpf) {
    cpf = _cpf;
}

void Motorista::setHabilitacao(const string& _habilitacao) {
    habilitacao = _habilitacao;
}

