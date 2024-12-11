#include "Material.hpp"
#include "Livro.hpp"
#include "DVD.hpp"
#include "AudioLivro.hpp"

int main () 
{
    Material materialObjb = Material("Flauta", "Jhon");
    materialObjb.descricao();
    Livro livroObj = Livro("Dom casmurro", "Machado de Assis", 500);
    livroObj.descricao();
    DVD dvdObj = DVD("Gigantes de Aço", "Shaw Dre", 120);
    dvdObj.descricao();
    AudioLivro audioBook = AudioLivro("Guitarra", "Metal", "Robertim", 150, 40);
    audioBook.descricao();



    return 0;
}