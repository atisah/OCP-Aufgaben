package de.fechtelhoff.ocp.aufgabe003;

public class LottoTipp extends Lotto {

	public LottoTipp(int anzahlKugeln, int anzahlKugelnGesamt) {
		super(anzahlKugeln, anzahlKugelnGesamt);
	}

	public void abgeben() {
		ArrayUtil.initializeArrayWithRandom(lottoZahlen, anzahlKugelnGesamt);
	}

	@Override
	public String toString() {
		return super.toString("Tipp");
	}
}
