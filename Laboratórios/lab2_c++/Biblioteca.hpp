#ifndef __BIBLIOTECA_HPP
#define __BIBLIOTECA_HPP
#include "Livro.hpp"

class Biblioteca
{
private:
    Livro livros[100] = {};
    int cont = 0;

public:
    Livro getLivros();
    void setLivros();

    void adicionarLivro(Livro livroTemp);
    Livro buscarLivro(string titulo, string nome);
};

#endif