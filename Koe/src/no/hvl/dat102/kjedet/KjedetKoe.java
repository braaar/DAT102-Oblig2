package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T> {
	
	private int bak; //peker p� neste plass
	private LinearNode<T> koe;
	private LinearNode<T> node;
	private LinearNode<T> start;
	

	@Override
	public void innKoe(T element) {
		if (erTom()) {
			start.setElement(element);
			koe.setNext(start);
			bak = 1;
		}
		node.setElement(element); // initierer elementet til en node
		koe.setNext(node); // setter den neste i koen til � v�re noden
		bak = bak + 1;  // �ker lengden p� koen med 1
		node.setElement(null); // returnerer noden som tok h�nd om elementet til null
	}

	@Override
	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("koe"); // sjekker om koen er tom
		}
		node = start; // setter noden til � peker p� starten av koen som da vil v�re foerste person
		start.getNext(); // start noden henter neste person i koen som blir neste foerste person
		return node.getElement(); // returnerer personene som er i starten av koen
	}

	@Override
	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		return start.getElement(); // returnerer elementet som er i foerste posisjon
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
