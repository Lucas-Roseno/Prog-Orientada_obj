#include "Pilha.hpp"

int main (){
    int opcao;
    string nome;

    Pilha historico;

    while (true)
    {
        cout << "==========MENU==========" <<
            "\n1 - Empilhar" << 
            "\n2 - Desempilhar" <<
            "\n3 - Mostar histórico" <<  
            "\n4 - Verificar se o histórico está vazio" <<
            "\n5 - Ver topo" << 
            "\nOpção: ";

            cin >> opcao;
            cin.ignore();

        switch (opcao)
        {
        case 1:
            cout << "Nome do site: ";
            getline(cin, nome);
            historico.empilhar(nome);
            break;
        case 2:
            historico.desempilhar();
            break;
        case 3:
            historico.exibirFila();
            break;
        case 4:
            if (historico.estaVazia())
            {
                cout << "\nHistórico vazio\n\n";
            }else{
                cout << "\nHistórico não está vazio\n\n";
            }
        case 5:
            historico.verTopo();
            break;
        default:
            break;
        }
    }
    
    
}