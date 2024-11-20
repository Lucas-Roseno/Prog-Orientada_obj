#include "Livro.hpp"
#include <iostream>
using namespace std;

string Livro::getTitulo()
{
    return titulo;
}
void Livro::setTitulo(string titulo)
{
    this->titulo = titulo;
}

string Livro::getIsbn()
{
    return isbn;
}
void Livro::setIsbn(string isbn)
{
    this->isbn = isbn;
}

Autor Livro::getAutor()
{
    return autor;
}
void Livro::setAutor(string nome, string dataNascimento)
{
    this->autor.setNome(nome);
    this->autor.setDataNascimento(dataNascimento);
}