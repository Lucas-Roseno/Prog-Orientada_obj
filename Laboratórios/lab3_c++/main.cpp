#include "Curso.hpp"
#include <iostream>
using namespace std;

int main()
{
    Curso objCurso;
    Professor profTemp;
    Aluno alunoTemp;
    Disciplina discTemp;
    string nome, endereco, titulacao, curso, nomeDisc;
    int opcao, matricula, ch;

    while (true)
    {
        cout << "===============================MENU===============================\n";
        cout << "1 - Cadastrar professor\n";
        cout << "2 - Cadastrar aluno\n";
        cout << "3 - Cadastrar disciplina\n";
        cout << "4 - Imprimir lista de professor\n";
        cout << "5 - Imprimir lista de aluno\n";
        cout << "6 - Imprimir lista de disciplina\n";
        cout << "0 - Sair\n";
        cout << "Opção: ";
        cin >> opcao;
        cin.ignore();

        if (opcao == 0)
        {
            cout << "\nPROGRAMA FINALIZADO\n";
            break;
        }

        if (opcao == 1 || opcao == 2)
        {
            cout << "\nNome: ";
            getline(cin, nome);

            cout << "Endereço: ";
            getline(cin, endereco);
            if (opcao == 1)
            {
                cout << "Titulação: ";
                getline(cin, titulacao);

                cout << "Curso: ";
                getline(cin, curso);
            }
        }

        switch (opcao)
        {
        case 1:
            profTemp.setNome(nome);
            profTemp.setEndereco(endereco);
            profTemp.setTitulacao(titulacao);
            profTemp.setCurso(curso);

            objCurso.cadastrarProfessor(profTemp);
            break;

        case 2:
            alunoTemp.setNome(nome);
            alunoTemp.setEndereco(endereco);

            cout << "Matrícula: ";
            cin >> matricula;
            cin.ignore();

            alunoTemp.setMatricula(matricula);
            objCurso.cadastrarAluno(alunoTemp);
            break;

        case 3:
            profTemp = objCurso.procurarProfessor();
            if (profTemp.getNome() == "")
            {
                break;
            }
            discTemp.setProfessor(profTemp);

            cout << "Nome da disciplina: ";
            getline(cin, nomeDisc);
            discTemp.setNome(nomeDisc);
            cout << "Carga horária: ";
            cin >> ch;
            discTemp.setCH(ch);

            objCurso.cadastrarDisciplina(discTemp);

            cin.ignore();
            break;

        case 4:
            objCurso.imprimirListaDeProfessor();
            break;
        case 5:
            objCurso.imprimirListaDeAlunos();
            break;
        case 6:
            objCurso.imprimirListaDeDisciplinas();
        default:
            break;
        }
    }

    return 0;
}