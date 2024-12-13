#include "MontanhaRussa.hpp"
#include "Carrossel.hpp"

int main (){
    Atracao atracaoObj = Atracao("Bate-bate", 20);
    atracaoObj.info();
    MontanhaRussa montRussa = MontanhaRussa("Motanha da morte", 40, 200, "viking");
    montRussa.info();
    Carrossel carrosselObj = Carrossel("Top", 15, 20, "chiquititas");
    carrosselObj.info();
    return 0;
}