package de.fechtelhoff.ocp.aufgabe008;

class Rennwagen {
	private String hersteller;
	private Motor motor;
	private Fahrer fahrer;

	class Motor {
		private String type;

		public Motor() {
			this("Type1");
		}

		public Motor(String type) {
			this.type = type;
		}

		public void setMotor(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "Motor " + type + " aus dem Rennwagen " + hersteller;
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

	public Rennwagen(String hersteller) {
		this.hersteller = hersteller;
		this.motor = this.new Motor();
	}

	public void setFahrer(Fahrer fahrer) {
		this.fahrer = fahrer;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(String type) {
		motor.setMotor(type);
	}

	@Override
	public String toString() {
		return "Rennwage " + hersteller + ". Fahrer: " + fahrer;
	}
}

public class AufgabeNestedAuto {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		Rennwagen rw = new Rennwagen("Mercedes");

		Rennwagen.Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
		rw.setFahrer(f);

		Rennwagen.Motor m = rw.getMotor();

		System.out.println(rw); // Zeile A -> Rennwagen Mercedes. Fahrer: M. Schuhmacher
		System.out.println(m); // Zeile B -> Motor Type1 aus dem Rennwagen Mercedes

		System.out.println("\n...that's it!\n");
	}
}
