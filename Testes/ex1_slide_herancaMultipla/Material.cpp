#include "Material.hpp"

Material::Material(string nome, string autor) : titulo_material(nome), autor_material(autor){}

void Material::descricao()
{
    cout << "\nTitulo: " << this->titulo_material
        << "\nAutor: " << this->autor_material << endl;
}
