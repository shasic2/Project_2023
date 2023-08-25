package ba.unsa.etf.rpr.domain;

public class NarudzbaProizvoda implements  Idable {

    private int narudzbaProizvoda_id;
    private Proizvodi proizvod_id;
    private Narudzba narudzba_id;


    public int getNarudzbaProizvoda_id() {
        return narudzbaProizvoda_id;
    }

    public Proizvodi getProizvod_id() {
        return proizvod_id;
    }

    public Narudzba getNarudzba_id() {
        return narudzba_id;
    }

    public void setNarudzbaProizvoda_id(int narudzbaProizvoda_id) {
        this.narudzbaProizvoda_id = narudzbaProizvoda_id;
    }

    public void setProizvod_id(Proizvodi proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public void setNarudzba_id(Narudzba narudzba_id) {
        this.narudzba_id = narudzba_id;
    }
}
