package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.*;
/**
 * Klasa za pohranjivanje trenutnog stanja aplikacije
 *
 * @author Selma
 */

public class Model {
    private static Model instance;
    private Kategorije kategorije;
    private Korisnik korisnik;
    private Narudzba narudzba;
    private Proizvodi proizvodi;
    private NarudzbaProizvoda narudzbaProizvoda;

    public Model() {
    }

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    public Kategorije getKategorije() {
        return kategorije;
    }

    public void setKategorija(Kategorije kategorije) {
        this.kategorije = kategorije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }

    public Proizvodi getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Proizvodi proizvodi) {
        this.proizvodi = proizvodi;
    }

    public NarudzbaProizvoda getNarudzbaProizvoda() {
        return narudzbaProizvoda;
    }

    public void setNarudzbaProizvoda(NarudzbaProizvoda narudzbaProizvoda) {
        this.narudzbaProizvoda = narudzbaProizvoda;
    }
}
