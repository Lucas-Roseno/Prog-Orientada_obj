#include "Atracao.hpp"

Atracao::Atracao(string nome, int capacidade){
    this->nome = nome;
    this->capacidade = capacidade;
}

void Atracao::info(){
    cout << "Está é uma atração.\n";
}