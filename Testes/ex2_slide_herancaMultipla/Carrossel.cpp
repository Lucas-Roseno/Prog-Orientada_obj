#include "Carrossel.hpp"

Carrossel::Carrossel(string nome, int capacidade, int velocidade, string tema):
    Atracao(nome, capacidade), Mecanica(velocidade), Tematica(tema){};

void Carrossel::info()
{
        cout << "\nEste Carrossel tem o tema de " << tema 
        << " e move-se a " << velocidade << " km/h\n";
}