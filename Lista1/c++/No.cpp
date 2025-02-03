#include "No.hpp"

No::No(string nome): nome(nome){};

No* No::getProx(){
    return prox;
}

void No::setProx(No* p){
    prox = p;
}

string No::getNome(){
    return nome;
}
