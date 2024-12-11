#ifndef __DVD_HPP
#define __DVD_HPP

#include "Material.hpp"

class DVD : virtual public Material
{
protected:
    int duracao;
public:
    DVD(string titutlo, string autor, int duracao);
    void descricao() override;
};
#endif