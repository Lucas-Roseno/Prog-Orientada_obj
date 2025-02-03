#pragma once
#include "No.hpp"

class Pilha
{
private:
    No* topo;
public:
    Pilha();
    Pilha(string nomeSite);
    void empilhar(string nomeSite);
    bool estaVazia();
    void desempilhar();
    void exibirFila();
    void verTopo();
};
