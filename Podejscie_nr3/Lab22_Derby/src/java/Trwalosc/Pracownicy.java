package Trwalosc;
// Generated 2022-04-07 23:12:37 by Hibernate Tools 4.3.1



/**
 * Pracownicy generated by hbm2java
 */
public class Pracownicy  implements java.io.Serializable {


     private int id;
     private String imie;
     private String nazwisko;

    public Pracownicy() {
    }

    public Pracownicy(int id, String imie, String nazwisko) {
       this.id = id;
       this.imie = imie;
       this.nazwisko = nazwisko;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getImie() {
        return this.imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return this.nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }




}


