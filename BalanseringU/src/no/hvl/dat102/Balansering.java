package no.hvl.dat102;
import no.hib.dat102.kjedet.*;
import no.hvl.dat102.Parentesinfo;
import java.io.*;

public class Balansering {
	KjedetStabel<Parentesinfo> stabel = new KjedetStabel<Parentesinfo>();
	

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {
	}

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}
		System.out.println("Feilsøker fil " + filnavn);
		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
			  for (int i = 0; i < linje.length(); i++){
			    char c = linje.charAt(i);        
			    if(isParan(c)) {
			      switch(leftOrRightParan(c)) {
			      case -1:
			        stabel.push(new Parentesinfo(c, linjenr, i));
			        break;
			      case 1:
			        Parentesinfo par = new Parentesinfo(c, linjenr, i);
			        if(!checkErrorTwo(par))
			          if(!checkErrorOne(par))
			            stabel.pop();
			        break;
			      } 			    
			    }
			  }
			  linje = tekstLeser.readLine();
			  linjenr++;
			} 
			checkErrorThree();
			System.out.println("Feilsøking fullført av fil " + filnavn);
			System.out.println();
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}

	public boolean isParan(char c) {
	  return (c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']');
	}
	
	//Identifisere om det er høyre eller vesntreparentes.
	public int leftOrRightParan(char c) {
	  int i = 0;
	  if (c == '(' || c == '{' || c == '[')
	    i = -1;
    else if (c == ')' || c == '}' || c == ']')
      i = 1;
    return i;
  }
	
	//Sjekke feil av type 1
	public boolean checkErrorOne(Parentesinfo par) {
	  boolean errorstatus = false;
	  if (!par.equals(stabel.peek())) {
	    if(!passer( stabel.peek().getVenstreparentes(), par.getVenstreparentes())) {
	      errorstatus = true;
        System.out.println("Feil ved linje " + par.getLinjenr() + " posisjon " + par.getPosisjon() + " ved parantes " + par.getVenstreparentes());
        System.out.println("Feil type parantes. Forrige var av type " + stabel.peek().getVenstreparentes());
        System.out.println();
        stabel.pop();
	    }
	  }
	  return errorstatus;
	}
	//Sjekke feil av type 2
	public boolean checkErrorTwo(Parentesinfo par) {
	  boolean errorstatus = false;
	  if(stabel.erTom()) {
	    errorstatus = true;
	    System.out.println("Feil ved linje " + par.getLinjenr() + " posisjon " + par.getPosisjon() + " ved parantes " + par.getVenstreparentes());
	    System.out.println("Finnes ingen venstreparantes til å samsvare med denne.");
	    System.out.println();
	  }
	  return errorstatus;
	}
	//Sjekke feil av type 3
	public boolean checkErrorThree() {
	  boolean errorstatus = false;
	  if(!stabel.erTom()) {
	    errorstatus=true;
	    System.out.println("Stabelen var ikke tom ved slutten av dokumentet. Dokumentet mangler lukkeparanteser for følgende paranteser:");
	    for(int i = 0; i <= stabel.antall(); i++) {
	      Parentesinfo par = stabel.pop();
	      System.out.println("Ved linje " + par.getLinjenr() + " posisjon " +  par.getPosisjon() +  " parantes " + par.getVenstreparentes());
	    }
	  }
	    
	  return errorstatus;
	}
}
