package no.hvl.dat102;
import no.hvl.dat102.adt.*;
/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;
		if(!erTom()) {
		  svar = foerste.getElement();
	    foerste = foerste.getNeste();
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		LinearNode<T> node = foerste;
		if(antall > 1) {
		  for(int i = 1; i < antall-1; i++) {
	      node = node.getNeste();
	    }
		  svar = node.getNeste().getElement();
		  node.setNeste(null);
		  siste = node;
		  antall--;
		}
		else if (antall == 1) {
		  svar = foerste.getElement();
		  foerste = null;
		  siste = null;
		  antall = 0;
		}
		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
	  LinearNode<T> node = new LinearNode<T>(element);
	  
	  //Hvis listen er tom
	  if (erTom()) {
	    foerste = node;
      siste = node;
      antall++;
      return;
	  }
	  //Sjekker den første noden
	  else if (node.getElement().compareTo(foerste.getElement()) == -1){
	      node.setNeste(foerste);
	      foerste = node;
	      antall++;
	      return;
	  }
	  
	  else {
	    //Går gjennom og sjekker alle "i midten"
	    for(LinearNode<T> nodeI = foerste; nodeI.getNeste() != null; nodeI = nodeI.getNeste()) {
	      
	      if(node.getElement().compareTo(nodeI.getNeste().getElement()) == -1) {
	        //sett inn foran neste (få nodeI til å peke på den vi setter inn og den vi setter inn til å peke på neste)
	        node.setNeste(nodeI.getNeste());
	        nodeI.setNeste(node);
	        antall++;
	        return;
	      }
	    }
	    siste.setNeste(node);
      siste = node;
      antall++;
	  }  
	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
