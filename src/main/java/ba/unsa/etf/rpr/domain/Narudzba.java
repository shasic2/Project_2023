package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Narudzba implements  Idable{

    private int narudzba_id;
    private int korisnik_id;
    private int racun;

    public Narudzba(int narudzba_id, int korisnik_id, int racun) {
        this.narudzba_id = narudzba_id;
        this.korisnik_id = korisnik_id;
        this.racun = racun;
    }

    public Narudzba() {}

    public int getNarudzba_id() {
        return narudzba_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public int getRacun() {
        return racun;
    }

    public void setNarudzba_id(int narudzba_id) {
        this.narudzba_id = narudzba_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

    @Override
    public String toString() {
        return "Narudzba{" +
                "narudzba_id=" + narudzba_id +
                ", korisnik_id=" + korisnik_id +
                ", racun=" + racun +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Narudzba narudzba = (Narudzba) o;
        return narudzba_id == narudzba.narudzba_id && korisnik_id == narudzba.korisnik_id && racun == narudzba.racun;
    }

    @Override
    public int hashCode() {
        return Objects.hash(narudzba_id, korisnik_id, racun);
    }
}
