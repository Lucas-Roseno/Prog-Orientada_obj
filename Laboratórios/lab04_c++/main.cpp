#include "Funcionario.hpp"
#include "Gerente.hpp"
#include "Desenvolvedor.hpp"
#include "TechLead.hpp"

int main()
{
    Gerente gerenteObj;
    Desenvolvedor devObj;
    TechLead techLeadObj;
    string nome, linguagem;
    float salario;
    int numEquipes, projAndamento;

    while (true)
    {
        int opcao;
        cout << "\n==========================MENU=========================="
             << "\n1 - Cadastrar gerente\n2 - Cadastrar desenvolvedor\n3 - Cadastrar TechLead"
             << "\n4 - Descrição gerente\n5 - Descrição desenvolvedor\n6 - Descrição TechLead"
             << "\n0 - sair\nOpção: ";
        cin >> opcao;
        cin.ignore();

        if (opcao == 0)
        {
            break;
        }
        else if (opcao == 1 || opcao == 2 || opcao == 3)
        {
            cout << "Digite o nome: ";
            getline(cin, nome);
            cout << "Salário: ";
            cin >> salario;
        }

        if (opcao == 1 || opcao == 3)
        {
            cout << "Número de equipes: ";
            cin >> numEquipes;
        }

        if (opcao == 2 || opcao == 3)
        {
            cin.ignore();
            cout << "Linguagem principal: ";
            getline(cin, linguagem);
        }

        switch (opcao)
        {
        case 1:
            gerenteObj.setNome(nome);
            gerenteObj.setSalario(salario);
            gerenteObj.setNumero_de_equipes(numEquipes);
            break;

        case 2:
            devObj.setNome(nome);
            devObj.setSalario(salario);
            devObj.setLinguagem_principal(linguagem);
            break;

        case 3:
            cout << "Projetos em andamento: ";
            cin >> projAndamento;

            techLeadObj.setNome(nome);
            techLeadObj.setSalario(salario);
            techLeadObj.setNumero_de_equipes(numEquipes);
            techLeadObj.setLinguagem_principal(linguagem);
            techLeadObj.setProjetos_em_andamento(projAndamento);
            break;

        case 4:
            gerenteObj.descricao();
            break;

        case 5:
            devObj.descricao();
            break;

        case 6:
            techLeadObj.descricao();
            break;
            
        default:
            break;
        }
    }

    return 0;
}