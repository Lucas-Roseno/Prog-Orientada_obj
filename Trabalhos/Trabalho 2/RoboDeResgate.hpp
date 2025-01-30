#pragma once

#include "EstacaoEspacial.hpp"
#include "Astronauta.hpp"

class RoboDeResgate
{
private:
    int posicaoInicialX;
    int posicaoInicialY;
    EstacaoEspacial estacao;
    vector<Astronauta> resgatados;
    vector<Astronauta> naoResgatados;
    int passos;
    vector<vector<bool>> visitado;
    vector<vector<int>> distancias;
public:
    RoboDeResgate(int posX, int posY, EstacaoEspacial _estacao);
    
};
