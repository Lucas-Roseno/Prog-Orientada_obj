#include "Astronauta.hpp"
#include <sstream>

Astronauta::Astronauta(string _nome, int _nivelSaude, bool _atendUrgente, int _x, int _y)
    : nome(_nome), nivelSaude(_nivelSaude), atendimentoUrgente(_atendUrgente), x(_x), y(_y) {}

Astronauta::Astronauta(string _nome, int _nivelSaude, bool _atendUrgente):
    nome(_nome), nivelSaude(_nivelSaude), atendimentoUrgente(_atendUrgente){};

bool Astronauta::isAtendimentoUrgente(){
    return atendimentoUrgente;
}

string Astronauta::toString() const {
    ostringstream oss;
    oss << "Astronauta: " << nome << "\n"
        << "Nível de Saúde: " << nivelSaude << "\n"
        << "Atendimento Urgente: " << (atendimentoUrgente ? "Sim" : "Não") << "\n"
        << "Posição: (" << x << ", " << y << ")";
    return oss.str();
}

// Getters
int Astronauta::getX() const {
    return x;
}

int Astronauta::getY() const {
    return y;
}

string Astronauta::getNome() const {
    return nome;
}

int Astronauta::getNivelSaude() const {
    return nivelSaude;
}

// Setters
void Astronauta::setX(int _x) {
    x = _x;
}

void Astronauta::setY(int _y) {
    y = _y;
}