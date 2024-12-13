#include "MontanhaRussa.hpp"

MontanhaRussa::MontanhaRussa(string nome, int capacidade, int velocidade, string tema): 
    Atracao(nome, capacidade), Mecanica(velocidade), Tematica(tema){};

void MontanhaRussa::info()
{
    cout << "\nEstá MontanhataRussa é temática de " << tema 
        << " e atinge velocidade de " << velocidade << " km/h\n";
}