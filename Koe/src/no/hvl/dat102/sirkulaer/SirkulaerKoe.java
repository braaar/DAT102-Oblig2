package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.kjedet.*;
import no.hvl.dat102.exception.*;
import no.hvl.dat102.adt.*;
public class SirkulaerKoe<T> implements KoeADT<T> {

	private int bak;
	private LinearNode<T> foerst;
	
	public SirkulaerKoe() {
		foerst = null;
		bak = 0;
	}
	@Override
	public void innKoe(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		if (erTom()) {
			foerst = node;
			bak = 1;
		}
		node.setNext(foerst);
		foerst = node;
		bak = bak +1;
	}

	@Override
	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		LinearNode<T> node = foerst;
		foerst = foerst.getNext();
		return node.getElement();
	}

	@Override
	public T foerste() {
		if(erTom()) {
			throw new EmptyCollectionException("koe");
		}
		return foerst.getElement();
	}

	@Override
	public boolean erTom() {
		return bak == 0;
	}

	@Override
	public int antall() {
		return bak;
	}

}
