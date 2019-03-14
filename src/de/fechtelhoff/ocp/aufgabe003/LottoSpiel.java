package de.fechtelhoff.ocp.aufgabe003;

public class LottoSpiel extends Lotto {

	public LottoSpiel(int anzahlKugeln, int anzahlKugelnGesamt) {
		super(anzahlKugeln, anzahlKugelnGesamt);
	}

	@Override
	public String toString() {
		return this.toString("Spiel");
	}

	public void ziehen() {
		lottoZahlenErzeugen();
	}

	public int richtige(Lotto tipp) {
		return ArrayUtil.countNumberOfMatches(this.getLottoZahlen(), tipp.getLottoZahlen());
	}

	public int gewinn(Lotto tipp) {
		return (int) Math.pow(10, richtige(tipp) - 1);
	}
}
