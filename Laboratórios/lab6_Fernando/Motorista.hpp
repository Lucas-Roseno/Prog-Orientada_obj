#pragma once
#include <vector>
#include <string>

class Motorista{
    protected:
        std::string _nome;
        std::string _cpf;
        std::string _cnh;

    public:
        Motorista(std::string nome, std::string cpf, std::string cnh);
        Motorista();

        virtual std::string getDetalhes();
        std::string getCpf();
        std::string getCnh();
};