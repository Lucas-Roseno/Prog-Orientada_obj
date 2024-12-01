#include "Curso.hpp"

string Curso::getNome()
{
    return nome;
}
void Curso::setNome(string nome)
{
    this->nome = nome;
}

void Curso::cadastrarProfessor(Professor profTemp)
{
    professores[contProf] = profTemp;
    contProf++;
}

void Curso::cadastrarAluno(Aluno alunoTemp)
{
    alunos[contAluno] = alunoTemp;
    contAluno++;
}

void Curso::cadastrarDisciplina(Disciplina discTemp)
{
    disciplinas[contDisc] = discTemp;
    contDisc++;
}

void Curso::imprimirListaDeProfessor()
{
    if (contProf == 0)
    {
        cout << "\nNão há professores cadastrados!\n";
    }

    cout << "\n================================";
    for (int i = 0; i < contProf; i++)
    {
        cout << "\nProfessor: " + professores[i].getNome() + "\nTitulação: " + professores[i].getTitulacao();
        cout << "\n--------------------------------";
    }
    cout << "\n================================\n";
}

void Curso::imprimirListaDeAlunos()
{
    if (contAluno == 0)
    {
        cout << "\nNão há alunos cadastrados!\n";
        return;
    }

    cout << "\n================================";
    for (int i = 0; i < contAluno; i++)
    {
        cout << "\nAluno: " + alunos[i].getNome() + "\nMatrícula: ";
        cout << alunos[i].getMatricula();
        cout << "\n--------------------------------";
    }
    cout << "\n================================\n";
}

void Curso::imprimirListaDeDisciplinas()
{
    if (contDisc == 0)
    {
        cout << "\nNão há disicplinas cadastradas!\n";
        return;
    }
    cout << "\n================================";
    for (int i = 0; i < contDisc; i++)
    {
        cout << "\nDisciplina: " << disciplinas[i].getNome()
             << "\nProfessor: " << disciplinas[i].getProfessor().getNome()
             << "\nCarga horária: " << disciplinas[i].getCH()
             << "\n--------------------------------";
    }
    cout << "\n================================\n";
}

Professor Curso::procurarProfessor()
{
    if (contProf == 0)
    {
        Professor profVazio;
        cout << "É necessário cadastrar um professor antes de cadastrar uma disciplina!\n";
        return profVazio;
    }

    string nomeProf;
    do
    {
        cout << "Digite o nome do professor: ";
        getline(cin, nomeProf);
        for (int i = 0; i < contProf; i++)
        {
            if (nomeProf == professores[i].getNome())
            {
                return professores[i];
            }
            if (i == (contProf - 1) && nomeProf != professores[i].getNome())
            {
                cout << "\nProfessor não encontrado!\n";
            }
        }

    } while (true);
}