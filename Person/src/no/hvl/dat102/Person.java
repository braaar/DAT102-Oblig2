package no.hvl.dat102;

public class Person implements Comparable<Person> {
  private int foedselsaar;
  private String fornavn;
  private String etternavn;
  
  public Person() {
    this(1994, "Brage", "Sekse Aarset");
  }
  public Person(int foedselsaar, String fornavn, String etternavn) {
    this.foedselsaar = foedselsaar;
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    
  }
  public int getFoedselsaar() {
    return foedselsaar;
  }


  public String getFornavn() {
    return fornavn;
  }


  public String getEtternavn() {
    return etternavn;
  }


  public void setFoedselsaar(int foedselsaar) {
    this.foedselsaar = foedselsaar;
  }


  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }


  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }


  @Override
  public int compareTo(Person other) {
    if (foedselsaar < other.getFoedselsaar())
      return -1;
    else if (foedselsaar > other.getFoedselsaar()) {
      return 1;
    }
    else {
        if(compareName(etternavn, other.getEtternavn()) != 0) {
          return compareName(etternavn, other.getEtternavn());     
        }
        else if (compareName(fornavn, other.getFornavn()) != 0) {
          return compareName(fornavn, other.getFornavn());
        }
    }
    return 0;
  }
  
  private int compareName(String myName, String theirName) {
    if(theirName.length() > myName.length()) {
      //de har lengst navn
      for(int i = 0; i < myName.length(); i++) {
        if(((int)myName.charAt(i)-(int)theirName.charAt(i)) != 0) {
        return ((int)myName.charAt(i)-(int)theirName.charAt(i))
        /Math.abs((((int)myName.charAt(i)-(int)theirName.charAt(i))));
        }
      }
      
    }
    else {
      //jeg har lengst navn
      for(int i = 0; i < theirName.length(); i++) {
        if(((int)myName.charAt(i)-(int)theirName.charAt(i)) != 0) {
          return ((int)myName.charAt(i)-(int)theirName.charAt(i))
          /Math.abs((((int)myName.charAt(i)-(int)theirName.charAt(i))));
          }
      }
    }  
    return 0;
  }
}
