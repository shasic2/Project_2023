package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Proizvodi implements  Idable{

    private int proizvodi_id;
    private String ime;
    private int kolicina;
    private int kategorija_id;
    private String opis;
    private  int cijena;

    public Proizvodi(int proizvodi_id, String ime, int kolicina, int kategorija_id, String opis, int cijena) {
        this.proizvodi_id = proizvodi_id;
        this.ime = ime;
        this.kolicina = kolicina;
        this.kategorija_id = kategorija_id;
        this.opis = opis;
        this.cijena = cijena;
    }

    public Proizvodi() {}

    public int getProizvodi_id() {
        return proizvodi_id;
    }

    public String getIme() {
        return ime;
    }

    public int getKolicina() {
        return kolicina;
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

    public void setProizvodi_id(int proizvodi_id) {
        this.proizvodi_id = proizvodi_id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setKategorija_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return "Proizvodi{" +
                "proizvodi_id=" + proizvodi_id +
                ", ime='" + ime + '\'' +
                ", kolicina=" + kolicina +
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
        return proizvodi_id == proizvodi.proizvodi_id && kolicina == proizvodi.kolicina && kategorija_id == proizvodi.kategorija_id && cijena == proizvodi.cijena && Objects.equals(ime, proizvodi.ime) && Objects.equals(opis, proizvodi.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proizvodi_id, ime, kolicina, kategorija_id, opis, cijena);
    }
}
