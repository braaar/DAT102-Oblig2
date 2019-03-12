package no.hvl.dat102.mengde.hobby;
import java.util.Scanner;
import no.hvl.dat102.mengde.kjedet.*;

public class Tekstgrensesnitt {
	private static Scanner info = KlientDatakontakt.info;
	public static Medlem lesMedlem() {
		String navn;
		Hobby temp;
		KjedetMengde<Hobby> hobbyer = new KjedetMengde<Hobby> ();
		int antall;
		System.out.println("Skriv navnet til medlemmet :");
		navn = info.nextLine();
		System.out.println("Skriv inn hvor mange hobbyer du har lyst å gi medlemmet:");
		antall = Integer.parseInt(info.nextLine());
		if (antall < 1) {
			antall = 1;
		}
		for(int i = 0; i < antall; i++) {
			System.out.println("Skriv inn navnet på hobbyen:");
			temp = new Hobby(info.nextLine());
			hobbyer.leggTil(temp);
		}
		Medlem pers = new Medlem(navn,hobbyer);
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
