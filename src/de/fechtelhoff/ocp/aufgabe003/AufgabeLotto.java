package de.fechtelhoff.ocp.aufgabe003;

public class AufgabeLotto {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		System.out.println("===== Einmalige Ausführung! =====\n");

		int anzahlKugeln = 7;
		int anzahlKugelnGesamt = 49;

		LottoSpiel lotto = new LottoSpiel(anzahlKugeln, anzahlKugelnGesamt);
		lotto.ziehen();
		System.out.println(lotto);

		LottoTipp tipp = new LottoTipp(anzahlKugeln, anzahlKugelnGesamt);
		tipp.abgeben();
		System.out.println(tipp);

		System.out.println("Richtige = " + lotto.richtige(tipp) + " / Gewinn = " + lotto.gewinn(tipp) + ",- €\n");

		System.out.println("===== Mehrmalige Ausführung =====\n");

		int gewinn = 0;
		int anzahlSpiele = 100_000;

		tipp.abgeben();
		System.out.println(tipp);

		for (int i = 0; i < anzahlSpiele; i++) {
			lotto.ziehen();
			gewinn += lotto.gewinn(tipp) - 1;
		}

		System.out.printf("Gewinn bei %,d Spielen ist %,d,- € %n", anzahlSpiele, gewinn);

		System.out.println("\n...that's it!\n");
	}
}
