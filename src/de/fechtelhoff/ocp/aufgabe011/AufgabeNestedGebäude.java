package de.fechtelhoff.ocp.aufgabe011;

class Gebaeude {
	private final String strasse;
	private final int hausnummer;
	private final Stockwerk[] stockwerk;

	public class Stockwerk {
		private final int nummer;
		private final Raum[] raum;

		public class Raum {
			private final int nummer;

			public Raum(int nummer) {
				this.nummer = nummer;
			}

			@Override
			public String toString() {
				return String.format("Raum %d.%d / %s %s", Stockwerk.this.nummer, nummer, Gebaeude.this.strasse, Gebaeude.this.hausnummer);
			}
		}

		public Stockwerk(int nummer, int anzahlRaeume) {
			this.nummer = nummer;
			raum = new Raum[anzahlRaeume];
			for (int i = 0; i < anzahlRaeume; i++) {
				raum[i] = new Raum(i);
			}
		}

		public Raum getRaum(int raumNummer) {
			return raum[raumNummer];
		}
	}

	public Gebaeude(String strasse, int hausnummer, int anzahlStockwerke, int anzahlRaeume) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		stockwerk = new Stockwerk[anzahlStockwerke];
		for (int i = 0; i < anzahlStockwerke; i++) {
			stockwerk[i] = new Stockwerk(i, anzahlRaeume);
		}
	}

	public Stockwerk getStockwerk(int stockwerkNummer) {
		return this.stockwerk[stockwerkNummer];
	}

	public Object getRaum(int stockwerkNummer, int raumNummer) {
		return getStockwerk(stockwerkNummer).getRaum(raumNummer);
	}
}

public class AufgabeNestedGebäude {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		Gebaeude gebaeude = new Gebaeude("Hauptstraße", 45, 3, 10);

		System.out.println(gebaeude.getRaum(0, 2));

		System.out.println("\n...that's it!\n");
	}
}
