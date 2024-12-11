    #ifndef __AUDIOLIVRO_HPP
    #define __AUDIOLIVRO_HPP

    #include "Livro.hpp"
    #include "DVD.hpp"

    class AudioLivro: virtual public Livro, DVD
    {
    protected:
        string narrador;
    public:
        AudioLivro(string titulo, string autor, string narrador, int numPags, int duracao);
        void descricao() override;

    };

    #endif