package no.hvl.dat102.mengde.hobby;

import java.util.Scanner;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private Datakontakt arkiv;
	public Meny() {
		tekstgr = new Tekstgrensesnitt();
		arkiv = new Datakontakt();
	}
	public void start() {
		System.out.println("Dette er et valg-meny program for å lagre personer med hobbyer og se om de har de samme hobbyene");
		boolean kjoerer = true;
		Medlem ny;
		int valg;
		String medlemsnavn;
		Scanner info = new Scanner(System.in);
		while (kjoerer == true) {
			System.out.println("Velg operasjonen du vil gjennomføre:");
			System.out.println("1. Legg til nytt medlem\n2. Skriv hobbyliste til et medlem, gitt navn\n3. Sjekke etter partner"
					+ ", gitt navn\n4. Tilbaksestilling av statusindeks på et medlem\n5. Skriv ut par med info angående hobby\n6. Slutt");
			valg = Integer.parseInt(info.nextLine());
			switch (valg) {
				case 1:
					ny = tekstgr.lesMedlem();
					arkiv.leggTilMedlem(ny);
					valg = Integer.parseInt(info.nextLine());
				case 2:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					ny = arkiv.getMedlem(arkiv.finnMedlemsIndeks(medlemsnavn));
					tekstgr.skrivHobbyListe(ny);
					valg = Integer.parseInt(info.nextLine());
				case 3:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					if (arkiv.finnPartnerFor(medlemsnavn)!=-1) {
						System.out.println(medlemsnavn + " har en partner med samme hobbyer");
					} else {
						System.out.println(medlemsnavn + " har enda ikke en person med samme hobbyer");
					}
					valg = Integer.parseInt(info.nextLine());
				case 4:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					arkiv.tilbakestillStatusIndeks(medlemsnavn);
					valg = Integer.parseInt(info.nextLine());
				case 5:
					tekstgr.skrivParListe(arkiv);
					valg = Integer.parseInt(info.nextLine());
				case 6:
					kjoerer = false;
					System.out.print("Ha en fin dag videre");
			}
		
		}
		info.close();
	}

}
