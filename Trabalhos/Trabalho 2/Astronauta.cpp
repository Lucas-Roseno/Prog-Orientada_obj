#include "Astrounauta.hpp"
#include <sstream>

Astrounauta::Astrounauta(string _nome, int _nivelSaude, bool _atendUrgente, int _x, int _y)
    : nome(_nome), nivelSaude(_nivelSaude), atendimentoUrgente(_atendUrgente), x(_x), y(_y) {}

bool Astrounauta::isAtendimentoUrgente(){
    return atendimentoUrgente;
}

string Astrounauta::toString() const {
    ostringstream oss;
    oss << "Astronauta: " << nome << "\n"
        << "Nível de Saúde: " << nivelSaude << "\n"
        << "Atendimento Urgente: " << (atendimentoUrgente ? "Sim" : "Não") << "\n"
        << "Posição: (" << x << ", " << y << ")";
    return oss.str();
}

// Getters
int Astrounauta::getX() const {
    return x;
}

int Astrounauta::getY() const {
    return y;
}

string Astrounauta::getNome() const {
    return nome;
}

int Astrounauta::getNivelSaude() const {
    return nivelSaude;
}

// Setters
void Astrounauta::setX(int _x) {
    x = _x;
}

void Astrounauta::setY(int _y) {
    y = _y;
}