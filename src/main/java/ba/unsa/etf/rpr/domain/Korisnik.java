package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Korisnik implements  Idable{



    private int korisnik_id;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;
    private int  telefon;
    private String sifra;


    public Korisnik(int korisnik_id, String ime, String prezime, String email, String adresa, int telefon, String sifra){
        this.korisnik_id = korisnik_id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.telefon = telefon;
        this.sifra = sifra;
    }

    public Korisnik(){}


    public int getKorisnik_id() {
        return korisnik_id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getSifra() {
        return sifra;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnik_id=" + korisnik_id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon=" + telefon +
                ", sifra='" + sifra + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return korisnik_id == korisnik.korisnik_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnik_id, ime, prezime, email, adresa, telefon,sifra);
    }
}
