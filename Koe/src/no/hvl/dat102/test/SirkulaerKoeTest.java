package no.hvl.dat102.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.*;
import no.hvl.dat102.sirkulaer.*;

public class SirkulaerKoeTest {

	private String e0 = "a";
	private String e1 = "b";
	private String e2 = "c";
	private String e3 = "d";
	private KoeADT<String> koe;
	
	@Before
	public final void setup() {
		koe = new SirkulaerKoe<String>();
	}

	@Test
	public final void erKoeTom() {
		assertTrue(koe.erTom());
	}
	
	@Test
	public final void leggTilOgFjern() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e3, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e0, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("hente fra koen gikk ikke " + e.getMessage());
		}
	}
	
	@Test
	public final void leggTilOgFjernDuplikat() {
		koe.innKoe(e0);
		koe.innKoe(e0);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e3, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e0, koe.utKoe());
			assertEquals(e0, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("hente fra koen gikk ikke " + e.getMessage());
		}
	}
	
	@Test
	public final void leggTilOgSjekkFoerste() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertEquals(e2, koe.foerste());
	}
	
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		assertFalse(koe.erTom());
	}
}
