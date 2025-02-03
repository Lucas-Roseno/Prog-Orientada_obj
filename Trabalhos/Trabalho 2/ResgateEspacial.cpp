#include "RoboDeResgate.hpp"
#include "EstacaoEspacial.hpp"
#include <fstream>
#include <iostream>
#include <string>

using namespace std;

int main()
{
    string caminhoDosArquivos = "arquivos_entrada/entrada1.txt";
    ifstream arqEntrada(caminhoDosArquivos.c_str());
    if (!arqEntrada)
    {
        cerr << "Não foi possível abrir o arquivo de entrada: " << caminhoDosArquivos << "\nSaindo do programa!";
        return -1;
    }

    int linhas, colunas, xRobo, yRobo;
    arqEntrada >> linhas >> colunas;
    EstacaoEspacial estacao = EstacaoEspacial(linhas, colunas);

    // lendo a matriz
    for (int i = 0; i < linhas; ++i)
    {
        for (int j = 0; j < colunas; ++j)
        {
            char tipo;
            arqEntrada >> tipo;
            estacao.adicionarModulo(i, j, tipo);
            if (tipo == 'S')
            {
                xRobo = i;
                yRobo = j;
            }
            
        }
    }

    // lendo os astronautas por linha
    string linha;
    while (getline(arqEntrada, linha))
    {
        if (linha.empty())
            continue;

        if (linha == "Posições dos astronautas na matriz:")
        {
            break;
        }

        string nome;
        int nivelSaude;
        bool atendimentoUrgente;

        size_t pos1 = linha.find(',');
        size_t pos2 = linha.find(',', pos1 + 1);

        if (pos1 == string::npos || pos2 == string::npos)
        {
            cerr << "Erro ao processar a linha: " << linha << endl;
            continue;
        }

        nome = linha.substr(0, pos1);
        try
        {
            nivelSaude = stoi(linha.substr(pos1 + 1, pos2 - pos1 - 1));
            atendimentoUrgente = stoi(linha.substr(pos2 + 1));
        }
        catch (const invalid_argument &e)
        {
            cerr << "Erro ao converter string para inteiro: " << e.what() << endl;
            continue;
        }
        catch (const out_of_range &e)
        {
            cerr << "Valor fora do intervalo ao converter string para inteiro: " << e.what() << endl;
            continue;
        }

        Astronauta astroTemp(nome, nivelSaude, atendimentoUrgente);
        estacao.adicionarAstronauta(astroTemp);
    }

    // pegando a posicao dos astronautas
    int cont = 0;
    while (getline(arqEntrada, linha))
    {
        int posX, posY;
        size_t pos1 = linha.find('(');
        size_t pos2 = linha.find(',');

        if (pos1 == string::npos || pos2 == string::npos)
        {
            cerr << "Erro ao processar a linha: " << linha << endl;
            continue;
        }

        posX = stoi(linha.substr(pos1 + 1, 1));
        posY = stoi(linha.substr(pos2 + 1, 1));

        estacao.setPosicoes(posX, posY, cont);
        cont++;
    }

    RoboDeResgate robo = RoboDeResgate(xRobo, yRobo, estacao);
    robo.printMatriz();

    arqEntrada.close();

    return 0;
}