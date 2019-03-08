package no.hvl.dat102.mengde.hobby;
import java.util.*;
import java.util.Scanner;
import no.hvl.dat102.mengde.kjedet.*;

public class Tekstgrensesnitt {
	public static Medlem lesMedlem() {
		String navn;
		Hobby temp;
		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby> ();
		int antall;
		Scanner leser = new Scanner(System.in);
		System.out.println("Skriv navnet til medlemmet :");
		navn = leser.nextLine();
		System.out.println("Skriv inn hvor mange hobbyer du har lyst � gi medlemmet:");
		antall = Integer.parseInt(leser.nextLine());
		for(int i = 0; i < antall; i++) {
			System.out.println("Skriv inn navnet p� hobbyen:");
			temp = new Hobby(leser.nextLine());
			hobbyer.leggTil(temp);
		}
		Medlem pers = new Medlem(navn,hobbyer);
		leser.close();
		return pers;
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene");
		System.out.println(medlem.toString());
	}
	
	public static void skrivParListe(Datakontakt arkiv) {
		System.out.println("PARNAVN                        HOBBYER");
		System.out.println();
		Medlem navn, navn2;
		Medlem[] temp = arkiv.getMedlemer();
		int par = 0;
		int antall = arkiv.getAntallMedlemer();
		for (int i = 0; i < antall; i++) {
			 if (temp[i].getStatusindeks()!=-1) {
					 navn = temp[i];
					 navn2 = temp[navn.getStatusindeks()];
					 temp[navn.getStatusindeks()].setStatusindeks(-1);
					 System.out.println(navn.getNavn() + " og " + navn2.getNavn() + "             " + navn.toString());
					 par ++;
			 }
		}
		System.out.println("Totalt antall par: " + par);
	}
}
