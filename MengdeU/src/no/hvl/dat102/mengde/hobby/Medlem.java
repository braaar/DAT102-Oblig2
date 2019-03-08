package no.hvl.dat102.mengde.hobby;
import no.hvl.dat102.mengde.kjedet.*;

import java.util.*;

public class Medlem {

	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusindeks;
	
	public Medlem() {
		statusindeks = -1;
		navn = "";
	}
	
	public Medlem(String navn) {
		this.navn = navn;
		statusindeks = -1;
	}
	
	public Medlem(String navn, KjedetMengde<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		statusindeks = -1;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusindeks() {
		return statusindeks;
	}
	
	public String toString() {
		String svar = "<";
		Iterator<Hobby> leser = hobbyer.oppramser();
		int teller = 0;
		while(leser.hasNext() && teller<(hobbyer.antall()-1)) {
			svar = svar + leser.next().getHobbyNavn() + ", ";
			teller++;
		}
		svar = svar + leser.next() + ">";
		return svar;
	}

	public void setStatusindeks(int statusindeks) {
		this.statusindeks = statusindeks;
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = true;
		if(hobbyer.antall() == medlem2.hobbyer.antall()) {
			Iterator<Hobby> teller = hobbyer.oppramser();
			Hobby temp ;
			Hobby temp2 ;
			while (teller.hasNext()&&passer==true) {
				temp = teller.next();
				boolean funnet = false;
				Iterator<Hobby> teller2 = medlem2.hobbyer.oppramser();
				while (teller2.hasNext()&&funnet==false) {
					temp2 = teller2.next();
					if(temp.equals(temp2)) {
						funnet = true;
					}
				}
				if (funnet == false) {
					passer = false;
				}
			
			}
		}
		return passer;
	}
	
}
