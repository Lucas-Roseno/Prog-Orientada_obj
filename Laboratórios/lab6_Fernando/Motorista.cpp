#include "Motorista.hpp"
#include <vector>
#include <string>

Motorista::Motorista(std::string nome, std::string cpf, std::string cnh){
    this->_nome = nome;
    this->_nome[0] = std::toupper(this->_nome[0]);
    this->_cpf = cpf;
    this->_cnh = cnh;
    this->_cnh[0] = std::toupper(this->_cnh[0]);
}
Motorista::Motorista(){}

std::string Motorista::getDetalhes(){
    return "\nNome: " + _nome + "\nCPF: " + _cpf + "\nCNH: " + _cnh;
}
std::string Motorista::getCpf(){
    return _cpf;
}
std::string Motorista::getCnh(){
    return _cnh;
}