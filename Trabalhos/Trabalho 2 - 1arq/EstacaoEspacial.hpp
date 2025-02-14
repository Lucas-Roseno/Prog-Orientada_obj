#pragma once
#include "Modulo.hpp"
#include "ModuloComAstronauta.hpp"
#include "ModuloComFogo.hpp"
#include "ModuloNormal.hpp"
#include "ModuloObstaculo.hpp"
#include "ModuloSeguranca.hpp"
#include "ModuloVazio.hpp"
#include "Astronauta.hpp"
#include <vector>
using namespace std;

class EstacaoEspacial
{
private:
    vector<vector<Modulo*>> matriz; 
    vector<Astronauta> astronautas; 
    int linhas;
    int colunas;
public:
    EstacaoEspacial(int _linhas, int _colunas);
    EstacaoEspacial();
    void adicionarModulo(int _linha, int _coluna, char _tipo);
    void adicionarAstronauta(const Astronauta& _astronauta);
    Astronauta getAstroPorPosicao(int x, int y);

    const vector<vector<Modulo*>>& getMatriz() const;
    const vector<Astronauta>& getAstronautas() const;
    int getLinhas() const;
    int getColunas() const;

    void setPosicoes(int _x, int _y, int cont);
};