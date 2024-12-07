#include "TechLead.hpp"

void TechLead::setProjetos_em_andamento(int projetos)
{
    this->projetos_em_andamentos = projetos;
}
int TechLead::getProjetos_em_andamento()
{
    return this->projetos_em_andamentos;
}

void TechLead::descricao()
{
    cout << "-----------------------------------------------";
    cout << "\nFuncionário: " << nome;
    printf("\nSalário: R$%.2f", salario);
    cout << "\nNúmero de equipes sob supervisão: " << numero_de_equipes
        << "\nLinguagem principal: " << linguagem_principal
        << "\nProjetos em andamento: " << projetos_em_andamentos;
    cout << "\n-----------------------------------------------";
}