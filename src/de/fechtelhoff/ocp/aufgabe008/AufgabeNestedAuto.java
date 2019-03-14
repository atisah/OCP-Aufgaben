package de.fechtelhoff.ocp.aufgabe008;

class Rennwagen {
	private String name;
	private Motor motor;
	private Fahrer fahrer;

	class Motor {
		@Override
		public String toString() {
			return "Motor Type1 aus dem Rennwagen " + name;
		}
	}

	static class Fahrer {
		private String vorname;
		private String nachname;

		public Fahrer() {
		}

		public Fahrer(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
		}

		@Override
		public String toString() {
			return vorname + " " + nachname;
		}
	}

	public Rennwagen(String name) {
		this.name = name;
		motor = new Motor();
		fahrer = new Fahrer();
	}

	public void setFahrer(Fahrer fahrer) {
		this.fahrer = fahrer;
	}

	public Motor getMotor() {
		return motor;
	}

	@Override
	public String toString() {
		return "Rennwage " + name + ". Fahrer: " + fahrer;
	}
}

public class AufgabeNestedAuto {

	public static void main(String[] args) {
		Rennwagen rw = new Rennwagen("Mercedes");

		Rennwagen.Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
		rw.setFahrer(f);

		Rennwagen.Motor m = rw.getMotor();

		System.out.println(rw); // Zeile A -> Rennwagen Mercedes. Fahrer: M. Schuhmacher
		System.out.println(m); // Zeile B -> Motor Type1 aus dem Rennwagen Mercedes
	}
}
