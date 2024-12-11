package ex2_slide_herancaMultipla;

public class Main {

	public static void main(String[] args) {
		Atracao atracaoObj = new Atracao("Bate-Bate", 10);
		atracaoObj.info();
		MontanhaRussa montanhaRussaObj = new MontanhaRussa("top", 40, 200, "fantasma");
		montanhaRussaObj.info();
		Carrosel carroselObj = new Carrosel("Chiquititas", 20, 10, "medieval");
		carroselObj.info();

	}

}
