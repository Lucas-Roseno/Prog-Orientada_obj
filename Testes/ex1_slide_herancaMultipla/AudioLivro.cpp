#include "AudioLivro.hpp"

AudioLivro::AudioLivro(string titulo, string autor, string narrador, int numPags, int duracao)
    :Material(titulo, autor), Livro(titulo, autor, numPags), DVD(titulo, autor, duracao), narrador(narrador){};

void AudioLivro::descricao()
{
    Material::descricao();
    cout << "Número de páginas: " << numero_de_paginas
    <<"\nDuração: " << duracao << "min"
    << "\nNarrador: " << this->narrador <<  endl;
}