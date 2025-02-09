#include "Pilha.hpp"

Pilha::Pilha(): topo(NULL){};



bool Pilha::estaVazia(){
    return (topo == NULL);
}

void Pilha::empilhar(string nomeSite){
    No *novoNo = new No(nomeSite);
    novoNo->setProx(topo);
    topo = novoNo;
    cout << "\nSite adicionado ao histórico!\n" << endl;
    
}

void Pilha::desempilhar(){
    if (estaVazia())
    {
        cout << "\nNenhum site no histórico\n" << endl;
        return;
    }else{
        No *noRemovido = topo;
        topo = topo->getProx();

        cout << "\nSite " << noRemovido->getNome() << " removido com sucesso\n\n";

        delete noRemovido;
    }
    
}

void Pilha::exibirFila(){
    No *noAtual = topo;
    if (topo == nullptr)
    {
        cout << "\nHistórico vazio!\n\n";
        return;
    }
    
    cout << "\n============HISTÓRICO============" << endl;
    while(noAtual != NULL){
        cout << "Site: " << noAtual->getNome() << endl << endl;
        noAtual = noAtual->getProx();
    }
}

void Pilha::verTopo(){
    if (topo == nullptr)
    {
        cout << "\nAinda não foi adicionado nada ao histórico!\n\n";
        return;
    }
    
    cout << "\nSite no topo: " << topo->getNome() << endl << endl;
}