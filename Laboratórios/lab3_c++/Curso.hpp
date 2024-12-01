#ifndef __CURSO__HPP
#define __CURSO_HPP
#include "Aluno.hpp"
#include "Professor.hpp"
#include "Disciplina.hpp"
#define TAM 25

class Curso
{
private:
    string nome;
    Aluno alunos[TAM];
    Professor professores[TAM];
    Disciplina disciplinas[TAM];

    int contProf = 0, contAluno = 0, contDisc = 0;

public:
    string getNome();
    void setNome(string);


    void cadastrarProfessor(Professor profTemp);
    void cadastrarAluno(Aluno alunoTemp);
    void cadastrarDisciplina(Disciplina discTemp);
    void imprimirListaDeProfessor();
    void imprimirListaDeAlunos();
    void imprimirListaDeDisciplinas();
    

    Professor procurarProfessor();
};
#endif