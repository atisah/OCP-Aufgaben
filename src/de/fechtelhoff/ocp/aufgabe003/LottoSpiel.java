package de.fechtelhoff.ocp.aufgabe003;

import java.util.Arrays;
import java.util.Random;

public class LottoSpiel {

	private int anzahlKugeln;
	private int anzahlKugelnGesamt;
	private int[] lottoZahlen;

	public LottoSpiel(int anzahlKugeln, int anzahlKugelnGesamt) {
		this.anzahlKugeln = anzahlKugeln;
		this.anzahlKugelnGesamt = anzahlKugelnGesamt;
		lottoZahlen = new int[anzahlKugeln];
	}

	public int[] getLottoZahlen() {
		return lottoZahlen;
	}

	public String toString(String str) {
		return str + " " + anzahlKugeln + " aus " + anzahlKugelnGesamt + ": " + Arrays.toString(lottoZahlen) + "\n";
	}

	@Override
	public String toString() {
		return this.toString("Spiel");
	}

	public void ziehen() {
		int zahl;
		for (int i = 0; i < anzahlKugeln; i++) {
			Arrays.sort(lottoZahlen, 0, i);
			do {
				zahl = new Random().nextInt(anzahlKugelnGesamt) + 1;
			} while (Arrays.binarySearch(lottoZahlen, 0, i, zahl) >= 0);
			lottoZahlen[i] = zahl;
		}
		Arrays.sort(lottoZahlen);
	}

	public int richtige(LottoSpiel tipp) {
		int richtige = 0;
		for (int i : tipp.getLottoZahlen()) {
			if (Arrays.binarySearch(lottoZahlen, i) >= 0) {
				richtige++;
			}
		}
		return richtige;
	}

	public int gewinn(LottoSpiel tipp) {
		return (int) Math.pow(10, richtige(tipp) - 1);
	}
}
