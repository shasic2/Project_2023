package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * Klasa za korisnika
 * @author Selma
 */


public class Korisnik implements  Idable{



    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;

    private String sifra;
    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param ime
     * @param prezime
     * @param email
     * @param adresa
     * @param sifra
     */


    public Korisnik(int id, String ime, String prezime, String email, String adresa, String sifra){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.sifra = sifra;
    }

    /**
     * Konstruktor bez parametara
     */
    public Korisnik(){}


    /**
     * Getter za id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter za ime
     * @return
     */
    public String getIme() {
        return ime;
    }
    /**
     * Getter za prezime
     * @return
     */

    public String getPrezime() {
        return prezime;
    }
    /**
     * Getter za email
     * @return
     */

    public String getEmail() {
        return email;
    }
    /**
     * Getter za adresu
     * @return
     */

    public String getAdresa() {
        return adresa;
    }
    /**
     * Getter za sifru
     * @return
     */


    public String getSifra() {
        return sifra;
    }

    /**
     * Setter za id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter za ime
     * @param ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Setter za prezime
     * @param prezime
     */

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    /**
     * Setter za email
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter za adresu
     * @param adresa
     */

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Setter za password
     * @param sifra
     */

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    /**
     * Ispis korisnika
     * @return
     */

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                ", sifra='" + sifra + '\'' +
                '}';
    }

    /**
     * Poređenje dva korisnika
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return id == korisnik.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, email, adresa,sifra);
    }
}
