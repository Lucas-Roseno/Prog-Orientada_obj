#ifndef __LIVRO_HPP
#define __LIVRO_HPP
using namespace std;
#include <string>
#include "Autor.hpp"
class Livro
{
private:
    string titulo, isbn;
    Autor autor;

public:
    string getTitulo();
    void setTitulo(string titulo);
    string getIsbn();
    void setIsbn(string isbn);
    Autor getAutor();
    void setAutor(string nome, string dataNascimento);
};

#endif