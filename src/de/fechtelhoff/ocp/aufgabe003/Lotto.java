package de.fechtelhoff.ocp.aufgabe003;

import java.util.Arrays;

public abstract class Lotto {

	private int anzahlKugelnGesamt;
	private int[] lottoZahlen;

	public Lotto(int anzahlKugeln, int anzahlKugelnGesamt) {
		this.anzahlKugelnGesamt = anzahlKugelnGesamt;
		lottoZahlen = new int[anzahlKugeln];
	}

	public int getAnzahlKugelnGesamt() {
		return anzahlKugelnGesamt;
	}

	public int[] getLottoZahlen() {
		return lottoZahlen.clone();
	}

	public void lottoZahlenErzeugen() {
		ArrayUtil.initializeArrayWithRandom(lottoZahlen, anzahlKugelnGesamt);
	}

	public String toString(String str) {
		return str + " " + lottoZahlen.length + " aus " + anzahlKugelnGesamt + ": " + Arrays.toString(lottoZahlen) + "\n";
	}
}
