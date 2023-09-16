package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * Klasa za kategorije proizvoda
 * @author Selma
 */
public class Kategorije implements  Idable{
  private int id;
  private String ime;

    /**
     * Konstruktor sa jednim parametrom
     * @param id
     * @param ime
     */

    public Kategorije(int id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    /**
     * Konstruktor bez parametara
     */

    public Kategorije(){}

    /**
     * Vracanje id-a
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Vracanje imena kategorija
     * @return ime
     */

    public String getIme() {
        return ime;
    }
    /**
     * Postavljanje id-a
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }


    /**
     * Postavljanje imena kategorije
     * @param ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Ispis kategorije
     * @return string sa podacima kategorije
     */
    @Override
    public String toString() {
        return "Kategorije{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                '}';
    }

    /**
     * Poredjenje dvije kategorije
     * @param o - kategorija sa kojom se poredi
     * @return true ili false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorije that = (Kategorije) o;
        return id == that.id && Objects.equals(ime, that.ime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime);
    }
}
