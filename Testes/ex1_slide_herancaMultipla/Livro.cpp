#include "Livro.hpp"

Livro::Livro(string titulo, string autor, int numPags)
    :Material(titulo, autor), numero_de_paginas(numPags){}

void Livro::descricao()
{
    Material::descricao();
    cout<< "Número de páginas: " << numero_de_paginas << endl;
}