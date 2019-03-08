package no.hvl.dat102.mengde.tester;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import no.hvl.dat102.mengde.tabell.*;

public class TabellTester {
	
	private TabellMengde<Integer> tab1;
	private TabellMengde<Integer> tab2;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	
	@Before
	public final void setup() throws Exception {
		tab1 = new TabellMengde<Integer>(8);
		tab2 = new TabellMengde<Integer>(8);
		tab1.leggTil(e0);
		tab1.leggTil(e1);
		tab1.leggTil(e2);
		tab1.leggTil(e3);
		tab2.leggTil(e2);
		tab2.leggTil(e3);
		tab2.leggTil(e4);
		tab2.leggTil(e5);
	}
	
	@Test
	public final void union() {
		TabellMengde<Integer> fasit = new TabellMengde<Integer> (8);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		
		assertEquals(fasit.antall(),tab1.union(tab2).antall());
	}
}
