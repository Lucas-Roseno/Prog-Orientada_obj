#include "RoboDeResgate.hpp"
#include <queue>

RoboDeResgate::RoboDeResgate(int posX, int posY, EstacaoEspacial _estacao) : posicaoInicialX(posX),
    posicaoInicialY(posY), estacao(_estacao){};

RoboDeResgate::RoboDeResgate(): posicaoInicialX(0), posicaoInicialY(0), passos(0){
    int linhas = estacao.getLinhas();
    int colunas = estacao.getColunas();
    visitado.resize(linhas, vector<bool>(colunas, false));
    distancias.resize(linhas, vector<int>(colunas, -1));
}

void RoboDeResgate::printMatriz(){
    auto& matriz = estacao.getMatriz();
    for (const auto& linha : matriz) {
        for (const auto& modulo : linha) {
            if (modulo != nullptr) {
                cout << '[' << modulo->getTipo() << "] ";
            } else {
                cout << "[ ] ";
            }
        }
        cout << endl;
    }
    cout << endl;
}

void RoboDeResgate::iniciarResgate(){
    queue<int> filaEmX;
    queue<int> filaEmY;
    
    visitado[posicaoInicialX][posicaoInicialY] = true;

    filaEmX.push(posicaoInicialX);
    filaEmY.push(posicaoInicialY);

    distancias[posicaoInicialX][posicaoInicialY] = 0;
    


}