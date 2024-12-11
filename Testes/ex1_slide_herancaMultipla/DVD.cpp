#include "DVD.hpp"

DVD::DVD(string titulo, string autor, int duracao):
    Material(titulo, autor), duracao(duracao){};

void DVD::descricao()
{
    Material::descricao();
    cout << "Duração: " << this->duracao << endl;
}
