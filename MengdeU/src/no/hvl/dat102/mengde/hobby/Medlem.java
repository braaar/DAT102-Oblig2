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
	
	public Medlem(String navn, int statusindeks) {
		this.navn = navn;
		this.statusindeks = statusindeks;
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
