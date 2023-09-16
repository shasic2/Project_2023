package ba.unsa.etf.rpr.domain;

/**
 * Klasa za narudzbuProizvoda
 * @author Selma
 */

public class NarudzbaProizvoda implements  Idable {

    private int id;
    private Proizvodi proizvod_id;
    private Narudzba narudzba_id;





    public int getId() {
        return id;
    }

    public Proizvodi getProizvod_id() {
        return proizvod_id;
    }

    public Narudzba getNarudzba_id() {
        return narudzba_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProizvod_id(Proizvodi proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public void setNarudzba_id(Narudzba narudzba_id) {
        this.narudzba_id = narudzba_id;
    }
}
