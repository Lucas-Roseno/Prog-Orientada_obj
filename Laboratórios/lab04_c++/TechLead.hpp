#include "Gerente.hpp"
#include "Desenvolvedor.hpp"
#ifndef __TECH_LEAD
#define __TECH_LEAD

class TechLead: public Gerente, public Desenvolvedor
{
private:
    int projetos_em_andamentos;
public:
    void setProjetos_em_andamento(int projetos);
    int getProjetos_em_andamento();
    void descricao();
};

#endif