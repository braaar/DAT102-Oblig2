package no.hvl.dat102.mengde.hobby;

import java.util.Scanner;

public class Meny {
	private Scanner info = KlientDatakontakt.info;
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
		String medlemsnavn;
			while (kjoerer == true) {
			System.out.println("Velg operasjonen du vil gjennomføre:");
			System.out.println("1. Legg til nytt medlem\n2. Skriv hobbyliste til et medlem, gitt navn\n3. Sjekke etter partner"
					+ ", gitt navn\n4. Tilbaksestilling av statusindeks på et medlem\n5. Skriv ut par med info angående hobby\n6. Slutt");
			switch (Integer.parseInt(info.nextLine())) {
				case 1:
					ny = tekstgr.lesMedlem();
					arkiv.leggTilMedlem(ny);
					break;
				case 2:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					ny = arkiv.getMedlem(arkiv.finnMedlemsIndeks(medlemsnavn));
					tekstgr.skrivHobbyListe(ny);
					break;
				case 3:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					if (arkiv.finnPartnerFor(medlemsnavn)!=-1) {
						System.out.println(medlemsnavn + " har en partner med samme hobbyer");
					} else {
						System.out.println(medlemsnavn + " har enda ikke en person med samme hobbyer");
					}

					break;
				case 4:
					System.out.println("Skriv inn navnet:");
					medlemsnavn = info.nextLine();
					arkiv.tilbakestillStatusIndeks(medlemsnavn);
					
					break;
				case 5:
					tekstgr.skrivParListe(arkiv);
					info.close();
					break;
				case 6:
					kjoerer = false;
					
					System.out.print("Ha en fin dag videre");
			}
		
		}
	}

}
