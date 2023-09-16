package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * Klasa za narudzbe
 * @author Selma
 */

public class Narudzba implements  Idable{

    private int id;
    private int korisnik_id;
    private int racun;
    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param korisnik_id
     * @param racun
     */

    public Narudzba(int id, int korisnik_id, int racun) {
        this.id = id;
        this.korisnik_id = korisnik_id;
        this.racun = racun;
    }
    /**
     * Konstruktor bez parametara
     */

    public Narudzba() {}

    /**
     * Getter i setter za id, korisnik_id i racun
     * @return
     */

    public int getId() {
        return id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public int getRacun() {
        return racun;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", korisnik_id=" + korisnik_id +
                ", racun=" + racun +
                '}';
    }

    /**
     * Ispis narudzbe
     * @return id naruzbe. korisnika koji je narucio i racun narudzbe
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Narudzba narudzba = (Narudzba) o;
        return id == narudzba.id && korisnik_id == narudzba.korisnik_id && racun == narudzba.racun;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, korisnik_id, racun);
    }

    public void setKorisnik_id(Korisnik id_korisnik) {
    }
}
