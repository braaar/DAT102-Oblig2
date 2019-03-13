package no.hvl.dat102;

//-----------------------------------------
//
//Balansering av uttrykk med parenteser {},(),[]
//} ] ) kalles lukkete symboler (h�yre)
// { [ ( kalles for �pne symboler (venstre)
//...{... [...(...)...]...}... lovlig (balansert) utrykk
//...{...(...[...)...]...}...  ulovlig (ikke balansert) uttrykk
//algoritme balansering
//    Lag en tom stabel
//    s� lenge( ikke-slutt p� strengen og fortsatt balansert){
//      hvis symbolet er �pent 
//             stable det p�
//      ellers hvis  symbolet er lukket 
//           hvis stabelen er tom 
//              sett fortsatt = usann, feilmelding
//           ellers
//                stable av symbol (�pent symbol)
//                hvis det �pne symbolet ikke svarer til det sist leste
//                lukkete symbolet
//                    sett fortsatt = usann, feilmelding
//  }
//    hvis stabelen er ikke-tom s� feilmelding */

public class Parentesinfo{
 
 private int linjenr;
 private int posisjon;
 private char venstreparentes;
 
 public Parentesinfo(char c, int linjenr, int posisjon){
  this.linjenr  = linjenr;
  this.posisjon = posisjon;
  this.venstreparentes = c;
 }
 
 public void setLinjenr(int nyttLinjenr){
  linjenr = nyttLinjenr;
 }
 
 public void setPosisjon(int nyPosisjon){
  posisjon = nyPosisjon;
  
 }
 
 public void setVenstreparentes(char nyVenstreparentes){
  venstreparentes = nyVenstreparentes;
 }
 
 public int getLinjenr(){ return linjenr;}
 
 public int getPosisjon(){ return posisjon;}

 public char getVenstreparentes(){ return venstreparentes;}

 
}//class
