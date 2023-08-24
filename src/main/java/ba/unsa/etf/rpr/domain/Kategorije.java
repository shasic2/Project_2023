package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Kategorije implements  Idable{
  private int kategorija_id;
  private String ime;

    public Kategorije(int kategorija_id, String ime) {
        this.kategorija_id = kategorija_id;
        this.ime = ime;
    }

    public Kategorije(){}

    public int getKategorija_id() {
        return kategorija_id;
    }

    public String getIme() {
        return ime;
    }

    public void setKategorija_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return "Kategorije{" +
                "kategorija_id=" + kategorija_id +
                ", ime='" + ime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorije that = (Kategorije) o;
        return kategorija_id == that.kategorija_id && Objects.equals(ime, that.ime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kategorija_id, ime);
    }
}
