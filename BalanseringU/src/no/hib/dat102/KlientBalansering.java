package no.hib.dat102;
import no.hvl.dat102.*;
public class KlientBalansering{
     public static void main(String[] args){
        final String filnavn = "StabelADT.txt";
        //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
        
        final String filnavn2 = "test.txt";
        balansering.lesFraFil(filnavn2);
            
 }//main

}//class
