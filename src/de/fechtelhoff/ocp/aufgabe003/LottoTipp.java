package de.fechtelhoff.ocp.aufgabe003;

public class LottoTipp extends LottoSpiel{

	public LottoTipp(int anzahlKugeln, int anzahlKugelnGesamt) {
		super(anzahlKugeln, anzahlKugelnGesamt);
	}

	public void abgeben() {
		super.ziehen();
	}
	
	@Override
	public String toString() {
		return super.toString("Tipp");
	}
	
}
