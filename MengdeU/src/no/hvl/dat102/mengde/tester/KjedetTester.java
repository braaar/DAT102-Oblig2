package no.hvl.dat102.mengde.tester;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.adt.*;

public class KjedetTester {
	
	private KjedetMengde<String> mengde1;
	private KjedetMengde<String> mengde2;
	
	private String e0 = "J";
	private String e1 = "O";
	private String e2 = "R";
	private String e3 = "G";
	private String e4 = "E";
	private String e5 = "N";
	
	@Before
	public final void setup() throws Exception {
		mengde1 = new KjedetMengde<String>();
		mengde2 = new KjedetMengde<String>();
		mengde1.leggTil(e0);
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);
		mengde1.leggTil(e3);
		mengde1.leggTil(e4);
		mengde2.leggTil(e5);
		mengde2.leggTil(e1);
		mengde2.leggTil(e2);
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		
		
	}
	
	@Test
	public final void union() {
		
		
		KjedetMengde<String> fasit = new KjedetMengde<String>();
		
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		fasit.leggTil(e5);
		
		KjedetMengde<String> union = (KjedetMengde<String>)mengde1.union(mengde2);
		
		assertEquals(fasit.antall(),union.antall());
 	}
	
	@Test
	public final void snitt() {
		
		KjedetMengde<String> fasit = new KjedetMengde<String> ();
		
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		
		assertEquals(fasit.antall(),mengde1.snitt(mengde2).antall());
	}
	
	@Test
	public final void differens() {
		
		KjedetMengde<String> fasit = new KjedetMengde<String> ();
		
		fasit.leggTil(e0);
		
		assertEquals(fasit,(KjedetMengde<String>)mengde1.differens(mengde2));
	}
}
