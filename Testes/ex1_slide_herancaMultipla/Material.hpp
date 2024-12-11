#ifndef __MATERIAL_HPP
#define __MATERIAL_HPP
#include <iostream>
#include <string>
using namespace std;

class Material
{
protected:
    string titulo_material;
    string autor_material;
public:
    Material(string nome, string autor);
    virtual void descricao();
};





#endif