#include "RoboDeResgate.hpp"
#include "EstacaoEspacial.hpp"
#include <fstream>
#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

void processarArquivo(const string &nomeArquivo)
{
    try
    {
        ifstream arqEntrada(nomeArquivo.c_str());
        if (!arqEntrada)
        {
            throw runtime_error("Arquivo não encontrado: " + nomeArquivo);
        }

        int linhasDeclaradas, colunasDeclaradas;
        if (!(arqEntrada >> linhasDeclaradas >> colunasDeclaradas))
        {
            throw runtime_error("Erro ao ler dimensões da matriz");
        }

        if (linhasDeclaradas <= 0 || colunasDeclaradas <= 0)
        {
            throw runtime_error("Dimensões inválidas da matriz: " + to_string(linhasDeclaradas) + "x" + to_string(colunasDeclaradas));
        }

        string primeiraLinha;
        getline(arqEntrada >> ws, primeiraLinha);
        int colunasReais = primeiraLinha.length();

        if (colunasReais != colunasDeclaradas)
        {
            throw runtime_error("Número de colunas declarado (" +
                                to_string(colunasDeclaradas) +
                                ") não corresponde ao número real de colunas (" +
                                to_string(colunasReais) + ")");
        }

        // Validar número de linhas e consistência das colunas
        vector<string> linhasMatriz;
        linhasMatriz.push_back(primeiraLinha);

        string linha;

        while (linhasMatriz.size() < linhasDeclaradas && getline(arqEntrada, linha))
        {
            if (linha.length() != colunasReais)
            {
                throw runtime_error("Inconsistência no número de colunas na linha " +
                                    to_string(linhasMatriz.size() + 1));
            }
            linhasMatriz.push_back(linha);
        }

        if (linhasMatriz.size() != linhasDeclaradas)
        {
            throw runtime_error("Número de linhas declarado (" +
                                to_string(linhasDeclaradas) +
                                ") não corresponde ao número real de linhas (" +
                                to_string(linhasMatriz.size()) + ")");
        }

        EstacaoEspacial estacao = EstacaoEspacial(linhasDeclaradas, colunasDeclaradas);
        bool encontrouS = false, encontrouA = false;

        int xRobo = -1, yRobo = -1;

        // Arrumando o ponteiro do arquivo
        arqEntrada.clear();
        arqEntrada.seekg(0);
        getline(arqEntrada, linha);

        size_t contAstro = 0;
        // Lendo a matriz
        vector<pair<int, int>> posicaoDosAstronautas;
        for (int i = 0; i < linhasDeclaradas; ++i)
        {
            for (int j = 0; j < colunasDeclaradas; ++j)
            {
                char tipo;
                if (!(arqEntrada >> tipo))
                {
                    throw runtime_error("Erro ao ler caractere da matriz na posição (" +
                                        to_string(i) + "," + to_string(j) + ")");
                }

                if (tipo != 'S' && tipo != 'A' && tipo != '#' && tipo != '~' &&
                    tipo != 'F' && tipo != '.')
                {
                    throw runtime_error("Caractere inválido '" + string(1, tipo) +
                                        "' na posição (" + to_string(i) + "," + to_string(j) + ")");
                }

                if (tipo == 'S')
                {
                    if (encontrouS)
                    {
                        throw runtime_error("Múltiplos pontos de partida encontrados");
                    }
                    encontrouS = true;
                    xRobo = i;
                    yRobo = j;
                }

                if (tipo == 'A')
                {
                    contAstro++;
                    encontrouA = true;
                    posicaoDosAstronautas.push_back({i, j});
                }
                estacao.adicionarModulo(i, j, tipo);
            }
        }

        if (!encontrouS)
        {
            throw runtime_error("Ponto de partida (S) não encontrado");
        }

        if (!encontrouA)
        {
            throw runtime_error("Nenhum astronauta para ser resgatado");
        }

        // lendo os astronautas por linha
        while (getline(arqEntrada, linha))
        {
            if (linha.empty() || linha == "Astronautas:")
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
                throw runtime_error("Erro ao processar a linha: " + linha +
                                    "\nA linha deve estar fora dos padrões estabelecidos no exemplo do exercício.\n");
            }

            nome = linha.substr(0, pos1);
            try
            {
                nivelSaude = stoi(linha.substr(pos1 + 1, pos2 - pos1 - 1));
                atendimentoUrgente = stoi(linha.substr(pos2 + 1));
            }
            catch (const invalid_argument &e)
            {
                throw runtime_error("Erro ao converter string para inteiro: " + string(e.what()));
            }
            catch (const out_of_range &e)
            {
                throw runtime_error("Valor fora do intervalo ao converter string para inteiro: " + string(e.what()));
            }

            Astronauta astroTemp(nome, nivelSaude, atendimentoUrgente);
            estacao.adicionarAstronauta(astroTemp);
        }

        if (estacao.getAstronautas().size() != contAstro)
        {
            throw runtime_error("Número de astronautas na matriz: " + to_string(contAstro) + " é difirente do número de astronautas na descrição: " + to_string(estacao.getAstronautas().size()));
        }

        // pegando a posicao dos astronautas
        int cont = 0;
        while (getline(arqEntrada, linha))
        {
            int posX, posY;
            size_t pos1 = linha.find('(');
            size_t pos2 = linha.find(',');
            size_t pos3 = linha.find(')');

            if (pos1 == string::npos || pos2 == string::npos || pos3 == string::npos)
            {
                throw runtime_error("Erro ao processar a linha: " + linha +
                                    "\nA linha deve estar fora dos padrões estabelecidos no exemplo do exercício.\n");
            }

            string strX = linha.substr(pos1 + 1, pos2 - pos1 - 1);
            string strY = linha.substr(pos2 + 1, pos3 - pos2 - 1);

            // Remove espaços em branco
            strX.erase(remove_if(strX.begin(), strX.end(), ::isspace), strX.end());
            strY.erase(remove_if(strY.begin(), strY.end(), ::isspace), strY.end());

            posX = stoi(strX);
            posY = stoi(strY);

            bool posicaoValida = false;
            for (int i = 0; i < contAstro; i++)
            {
                if (posicaoDosAstronautas[i] == pair{posX, posY})
                {
                    posicaoValida = true;
                }
            }

            if (!posicaoValida)
            {
                throw runtime_error("Posição dos astrounautas na matriz, não condiz com a posição na descrição.");
            }

            estacao.setPosicoes(posX, posY, cont);
            cont++;
        }

        // Processar astronautas e realizar resgate
        RoboDeResgate robo(xRobo, yRobo, estacao);
        robo.iniciarResgate(xRobo, yRobo, false);
        robo.gerarRelatorio(nomeArquivo);

        arqEntrada.close();
    }
    catch (const exception &e)
    {
        cerr << "Erro ao processar arquivo " << nomeArquivo << ": " << e.what() << endl;
    }
}

int main()
{

    for (int i = 1; i <= 10; ++i)
    {
        string nomeArquivo = "arquivos_entrada/entrada" + to_string(i) + ".txt";
        processarArquivo(nomeArquivo);
    }

    return 0;
}