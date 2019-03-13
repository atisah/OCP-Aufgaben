package de.fechtelhoff.ocp.aufgabe003;

import java.util.Arrays;

public abstract class Lotto {

	protected int anzahlKugelnGesamt;
	protected int[] lottoZahlen;

	public Lotto(int anzahlKugeln, int anzahlKugelnGesamt) {
		this.anzahlKugelnGesamt = anzahlKugelnGesamt;
		lottoZahlen = new int[anzahlKugeln];
	}

	public int[] getLottoZahlen() {
		return lottoZahlen;
	}

	public String toString(String str) {
		return str + " " + lottoZahlen.length + " aus " + anzahlKugelnGesamt + ": " + Arrays.toString(lottoZahlen) + "\n";
	}
}
