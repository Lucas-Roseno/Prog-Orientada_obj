#pragma once
#include "Modulo.hpp"
#include <vector>
using namespace std;

class EstacaoEspacial
{
private:
    vector<Modulo*> matriz;
public:
    EstacaoEspacial(int linhas, int colunas);
    ~EstacaoEspacial();

    void setModulo(int linha, int coluna, Modulo* modulo);
    Modulo* getModulo(int linha, int coluna) const;
};
