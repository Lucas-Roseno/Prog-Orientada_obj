#pragma once
#include <iostream>
#include <string>

using namespace std;

class No {
private: 
    string nome;
    No *prox;

public: 
    No(string nome);

    string getNome();
    No* getProx();
    void setProx(No* p);

};
