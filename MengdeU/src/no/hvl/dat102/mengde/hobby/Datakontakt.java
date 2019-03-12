package no.hvl.dat102.mengde.hobby;

public class Datakontakt {

	private Medlem[] medlemer;
	private int antallMedlemer;
	
	public Datakontakt() {
		antallMedlemer = 0;
		medlemer = new Medlem[20];
	}
	
	public Medlem getMedlem(int plass) {
		return medlemer[plass];
	}
	
	public int getAntallMedlemer() {
		return antallMedlemer;
	}
	
	public Medlem[] getMedlemer() {
		return medlemer;
	}
	
	public void leggTilMedlem(Medlem person) {
		if(erFull()) {
			utvid();
		}
		medlemer[antallMedlemer] = person;
		antallMedlemer = antallMedlemer + 1;
	}
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		for (int i = 0; i < antallMedlemer; i++) {
			if(medlemer[i].getNavn()==medlemsnavn) {
				return i;
			}
		}
		return -1;
	}
	
	public int finnPartnerFor(String medlemsnavn) {
		int pers = finnMedlemsIndeks(medlemsnavn);
		if(pers == -1 || medlemer[pers].getStatusindeks()!=-1) {
			return -1;
		} else {
			for (int i = 0; i < pers; i++) {
				if(medlemer[pers].passerTil(medlemer[i])) {
					if(medlemer[i].getStatusindeks()==-1) {
						medlemer[i].setStatusindeks(pers);
						medlemer[pers].setStatusindeks(i);
						return i;
					}
				}
			}
			for (int n = pers+1; n < antallMedlemer; n++) {
				if(medlemer[pers].passerTil(medlemer[n])) {
					if(medlemer[n].getStatusindeks()==-1) {
						medlemer[n].setStatusindeks(pers);
						medlemer[pers].setStatusindeks(n);
						return n;
					}
				}
			}
			return -1;
		}
	}
	
	public boolean tilbakestillStatusIndeks(String medlemsnavn) {
		int pers = finnMedlemsIndeks(medlemsnavn);
		if (pers==-1 || medlemer[pers].getStatusindeks() == -1) {
			return false;
		} else {
			int partner = medlemer[pers].getStatusindeks();
			if (medlemer[partner].getStatusindeks() == pers) {
				medlemer[partner].setStatusindeks(-1);
			}
			medlemer[pers].setStatusindeks(-1);
			return true ;
		}
	}
	
	public boolean erFull() {
		return medlemer.length==antallMedlemer;
	}
	private void utvid(){
		Medlem[] temp = new Medlem[medlemer.length*2];
		for(int i = 0; i < antallMedlemer; i++) {
			temp[i] = medlemer[i];
		}
		medlemer = temp;
	}
}
