package no.hvl.dat102;
import java.util.Scanner;


public class OrdnetListePersoner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Hei skriv inn ting eller ikke.");

    KjedetOrdnetListe<Person> personListe = new KjedetOrdnetListe<Person>();

    Person person1 = new Person(20000, "hey", "yo");
    Person person2 = new Person(1999, "hey", "zz");
    
    System.out.println(person1.compareTo(person2));
    
    for(int i = 0; i < 4; i++) {
      System.out.println("Skriv årstall for en person");
      int aar = Integer.parseInt(scanner.nextLine());
      System.out.println("Skriv fornavn for en person");
      String fNavn = scanner.nextLine();
      System.out.println("Skriv etternavn for en person");
      String eNavn = scanner.nextLine();
      Person person = new Person(aar, fNavn, eNavn);
      personListe.leggTil(person);
    }
    scanner.close();
    
    System.out.println("Hvem er i listen? La oss se!");
    while (!personListe.erTom()) {
      Person personUt =  personListe.fjernSiste();
      System.out.println(personUt.getFoedselsaar() + " " + personUt.getFornavn() + " " + personUt.getEtternavn());
    }
  }

}
