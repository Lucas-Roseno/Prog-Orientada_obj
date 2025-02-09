#pragma once
#include "No.hpp"

class Pilha
{
private:
    No* topo;
public:
    Pilha();
    void empilhar(string nomeSite);
    bool estaVazia();
    void desempilhar();
    void exibirFila();
    void verTopo();
};
