package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.mengde.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element.Retur med null ved ikke-funn
		
		boolean funnet = false;
		T svar = null;
		/*
		 * Fyll ut
		 */
		int i = 0;
		while (funnet==false) {
			if (tab[i] == element) {
				svar = tab[i];
				tab[i] = tab[i+1];
				funnet = true;
			}
			i ++;
		}
		while ( i < antall-1) {
			tab[i] = tab[i + 1];
			i++;
		}
		tab[i] = null;
		antall = antall - 1;
		return svar;
	}
/* Lite effektiv!
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>)begge;
	}
	*/
	@Override
	
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();
			/*
		 * Fyll ut
		 * 	
		 */
		Iterator<T> teller = this.oppramser();
		while(teller.hasNext()) {
			begge.settInn(teller.next());
		}
		
		Iterator<T> teller2 = m2.oppramser();
		while(teller2.hasNext()) {
			begge.leggTil(teller.next());
		}
		return (MengdeADT<T>)begge;
	}//
	
	

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element= null;
		/*
		 * Fyll ut
		 */
		
		for (int soek = 0; soek < antall; soek ++) {
			element = tab[soek];
			if(m2.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		/*
		 * Fyll ut
		 
			if (!m2.inneholder(element))
				 ((TabellMengde<T>) differensM).settInn(element);
		*/
		Iterator<T> teller = this.oppramser();
		while(teller.hasNext()) {
			element = teller.next();
			if(!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		
		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;

		/*
		 * Fyll ut
		 */
		if(antall != m2.antall()) {
			likeMengder = false;
		} else {
			for ( int i = 0; i < antall; i++) {
				if (!m2.inneholder(tab[i])) {
					likeMengder = false;
				}
			}
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		if(m2.antall()>antall) { // Sjekker om m2 er stoerre en hovedmengden
			erUnderMengde = false; // Hvis den er vil m2 aldri vaere undermengde av tab
		}
		Iterator<T> teller = m2.oppramser();  // Itererer gjennom m2 slik at vi finner alle element i m2
		while((teller.hasNext())&&(erUnderMengde==true)) { // Saa lenge Iteratoren finner et nytt element og utrykket er sant
			boolean funnet = false; // Lager en lokal boolean verdi for å sjekke om m2.current finnes i tab
			Iterator<T> teller2 = this.oppramser(); // lager Iterator for tab
			while(teller2.hasNext()&&funnet==false) { // hvis iterator finner neste og den ikke er funnet enda
				if(teller.next()==teller2.next()) { // Hvis elemenetet i m2.current = tab.current
					funnet = true; // sier funnet for denne verdi av m2
				}
			}
			if (funnet==false) { // hvis ikke funnet i tab siden funnet ikke endres
				erUnderMengde = false; // er ikke undermengde siden ikke alle element er i tab
			}
		}
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}


}// class
