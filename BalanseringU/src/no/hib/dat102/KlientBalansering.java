package no.hib.dat102;
import no.hvl.dat102.*;
public class KlientBalansering{
     public static void main(String[] args){
        final String filnavn = "StabelADT.java";
        //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
        
        final String filnavn2 = "ParforholdKlient.java";
        balansering.lesFraFil(filnavn2);
            
 }//main

}//class
