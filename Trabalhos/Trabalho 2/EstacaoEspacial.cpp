#include "EstacaoEspacial.hpp"

EstacaoEspacial::EstacaoEspacial(int _linhas, int _colunas) : linhas(_linhas), colunas(_colunas)
{
    matriz.resize(linhas, vector<Modulo*>(colunas, nullptr));
}


void EstacaoEspacial::adicionarModulo(int _linha, int _coluna, char _tipo)
{
    if (_linha >= 0 && _linha < linhas && _coluna >= 0 && _coluna < colunas) {
        delete matriz[_linha][_coluna]; 
        if (_tipo == 'S') {
            matriz[_linha][_coluna] = new ModuloSeguranca(_tipo);
        } else if (_tipo == 'A') {
            matriz[_linha][_coluna] = new ModuloComAstronauta(_tipo);
        } else if (_tipo == '#') {
            matriz[_linha][_coluna] = new ModuloObstaculo(_tipo);
        } else if (_tipo == '~') {
            matriz[_linha][_coluna] = new ModuloVazio(_tipo);
        } else if (_tipo == 'F') {
            matriz[_linha][_coluna] = new ModuloComFogo(_tipo);
        } else if (_tipo == '.') {
            matriz[_linha][_coluna] = new ModuloNormal(_tipo);
        } else {
            cout << "\nValor da cédula inválido!" << endl;
        }
    } else {
        cout << "Posição inválida" << endl;
    }
}

void EstacaoEspacial::adicionarAstronauta(const Astronauta& _astronauta)
{
    astronautas.push_back(_astronauta);
}

const vector<vector<Modulo*>>& EstacaoEspacial::getMatriz() const
{
    return matriz;
}

const vector<Astronauta>& EstacaoEspacial::getAstronautas() const
{
    return astronautas;
}

int EstacaoEspacial::getLinhas() const {
    return linhas;
}

int EstacaoEspacial::getColunas() const {
    return colunas;
}

void EstacaoEspacial::setPosicoes(int _x, int _y, int cont){
    astronautas[cont].setX(_x);
    astronautas[cont].setY(_y);
}