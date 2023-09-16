package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Klasa za proizvode
 * @author Nejra
 */

public class Proizvodi implements  Idable{

    private int id;
    private String ime;

    private int kategorija_id;
    private String opis;
    private  int cijena;

    /**
     * Konstruktor sa svim parametrima
     * @param id
     * @param ime
     * @param kategorija_id
     * @param opis
     * @param cijena
     */

    public Proizvodi(int id, int kategorija_id, String ime, String opis, int cijena) {
        this.id = id;
        this.ime = ime;
        this.kategorija_id = kategorija_id;
        this.opis = opis;
        this.cijena = cijena;
    }

    /**
     * Konstruktor bez parametara
     */

    public Proizvodi() {}

    /**
     * Getter i setter
     * @return
     */


    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }


    public int getKategorija_id() {
        return kategorija_id;
    }

    public String getOpis() {
        return opis;
    }

    public int getCijena() {
        return cijena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }


    public void setKategorije_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }


    /**
     * Ispis određenog proizvoda
     * @return
     */
    @Override
    public String toString() {
        return "Proizvodi{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", kategorija_id=" + kategorija_id +
                ", opis='" + opis + '\'' +
                ", cijena=" + cijena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvodi proizvodi = (Proizvodi) o;
        return id == proizvodi.id  && kategorija_id == proizvodi.kategorija_id && cijena == proizvodi.cijena && Objects.equals(ime, proizvodi.ime) && Objects.equals(opis, proizvodi.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, kategorija_id, opis, cijena);
    }

    public void setKategorija_id(int categories_id) {
    }
}
