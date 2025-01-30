#pragma once
#include <string>
using namespace std;

class Astronauta
{
private:
    string nome;
    int nivelSaude;
    bool atendimentoUrgente;
    int x;
    int y;

public:
    Astronauta(string _nome, int _nivelSaude, bool _atendUrgente, int _x, int _y);
    Astronauta(string _nome, int _nivelSaude, bool _atendUrgente);
    bool isAtendimentoUrgente();
    string toString() const;

    // Getters
    int getX() const;
    int getY() const;
    string getNome() const;
    int getNivelSaude() const;

    // Setters
    void setX(int _x);
    void setY(int _y);
};