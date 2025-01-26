#include "Modulo.hpp"

Modulo::Modulo(char tipo) : tipo(tipo) {}

Modulo::Modulo() : tipo(' ') {}

char Modulo::getTipo() {
    return tipo;
}