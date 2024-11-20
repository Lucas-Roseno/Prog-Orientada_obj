#include <iostream>
#include <string>
#include "Biblioteca.hpp"
#include "Livro.hpp"
using namespace std;

int main()
{
    int opcao, cont = 0;
    Biblioteca bibliotecaLivros;
    Livro livroTemp;
    string nome, dataNascimento, titulo, isbn;

    while (true)
    {
        cout << "\n=============BIBLIOTECA MENU============="
        "\n0 - Sair"
        "\n1 - Adicionar livro"
        "\n2 - Procurar livro"
        "\n3 - Mostrar todos os livros"
        "\nOpção: ";
        cin>>opcao;
        cin.ignore();

        switch (opcao)
        {
        case 1:

            cout<<"Nome do autor: ";
            getline(cin, nome);
            cout<<"Data nascimento do autor: ";
            getline(cin, dataNascimento);
            cout<<("Titulo do livro: ");
            getline(cin, titulo);
            cout<<("ISBN: ");
            getline(cin, isbn);

            livroTemp.setAutor(nome, dataNascimento);
            livroTemp.setTitulo(titulo);
            livroTemp.setIsbn(isbn);

            bibliotecaLivros.adicionarLivro(livroTemp);

            cout << "\nNovo livro adicionado:";
            cout << "\nAutor: " + bibliotecaLivros.getLivros().getAutor().getNome();
            cout << "\nData nascimento: " + bibliotecaLivros.getLivros().getAutor().getDataNascimento();
            cout << "\nTítulo: " + bibliotecaLivros.getLivros().getTitulo();
            cout << "\nISBN: " + bibliotecaLivros.getLivros().getIsbn() + "\n";

            break;
        
        case 2:
            cout << "Título do livro: ";
            getline(cin, titulo);
            cout << "Nome do autor: ";
            getline(cin, nome);

            livroTemp = bibliotecaLivros.buscarLivro(titulo, nome);

            cout << "\nTítulo: " + livroTemp.getTitulo();
            cout << "\nISBN: " + livroTemp.getIsbn();
            cout << "\nAutor: " + livroTemp.getAutor().getNome();
            cout << "\nData nascimento: " + livroTemp.getAutor().getDataNascimento() + "\n";


            break;
        default:
            break;
        }

        if (opcao == 0)
        {
            cout << "PROGRAMA FINALIZADO\n\n";
            break;
        }
        
    }
}