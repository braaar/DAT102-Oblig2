package no.hvl.dat102.mengde.hobby;

public class Hobby {

	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	public String toString() {
		String svar = ("<" + this.hobbyNavn + ">");
		return svar;
	}
	
	public boolean equals(Object hobby2) {
		 Hobby denAndre = (Hobby) hobby2;
		 return (hobbyNavn.equals(denAndre.getHobbyNavn()));
	}
}
