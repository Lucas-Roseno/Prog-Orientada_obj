#include "Biblioteca.hpp"
#include <iostream>

Livro Biblioteca::getLivros()
{
    return livros[cont - 1];
}

void Biblioteca::adicionarLivro(Livro livroTemp)
{
    livros[cont] = livroTemp;
    cont++;
}

Livro Biblioteca::buscarLivro(string titulo, string nome)
{
    int cont;
    for (int i = 0; i < 100; i++)
    {
        if (livros[i].getTitulo() == titulo &&
        livros[i].getAutor().getNome() == nome)
        {
            cont = i;
            break;
        }
    }
    return livros[cont];
}

