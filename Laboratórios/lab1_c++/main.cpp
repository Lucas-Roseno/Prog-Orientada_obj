#include <iostream>
#include "Corrida.hpp"

int main()
{
    string modelo;
    string motorizacao;
    string fabricante;
    string nomeMotorista;
    float kmInicial;
    float kmFinal;
    
    Corrida objetoCorrida;
    
    cout << "Digite o modelo do carro: " ;
    getline(cin, modelo);
    objetoCorrida.setModelo(modelo);
    
    cout << "Motorização do carro: ";
    getline(cin, motorizacao);
    objetoCorrida.setMotorizacao(motorizacao);

    cout << "Fabricante: ";
    getline(cin, fabricante);
    objetoCorrida.setFabricante(fabricante);

    cout << "Nome do motorista: ";
    getline(cin, nomeMotorista);
    objetoCorrida.setNomeMotorista(nomeMotorista);

    cout << "Quilometragem inicial: ";
    cin >> kmInicial;
    objetoCorrida.setKmInicial(kmInicial);

    cout << "Quilometragem final: ";
    cin >> kmFinal;
    objetoCorrida.setKmFinal(kmFinal);

    float kmRodado = objetoCorrida.calcularQuilometragemPercorrida(kmInicial, kmFinal);
    printf("\nO total ficou em R$%.2f\n\n",objetoCorrida.valorFinal(kmRodado));

}