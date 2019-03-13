package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.tabell.TabellKoe;

public class TabellKoeKlient {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Hei skriv inn ting eller ikke.");

    
    TabellKoe<Person> personKoe = new TabellKoe<Person>();


    for(int i = 0; i < 4; i++) {
      System.out.println("Skriv årstall for en person");
      int aar = Integer.parseInt(scanner.nextLine());
      System.out.println("Skriv fornavn for en person");
      String fNavn = scanner.nextLine();
      System.out.println("Skriv etternavn for en person");
      String eNavn = scanner.nextLine();
      Person person = new Person(aar, fNavn, eNavn);
      personKoe.innKoe(person);
    }
    scanner.close();

    
    System.out.println("Hvem er i køen? La oss se!");
    while (!personKoe.erTom()) {
      Person personUt =  personKoe.utKoe();
      System.out.println(personUt.getFoedselsaar() + " " + personUt.getFornavn() + " " + personUt.getEtternavn());
    }
    
  }

}
