package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public interface NarudzbaProizvodaDao {
    List<NarudzbaProizvoda> dajPoKorisniku(int id_korisnik) throws HealthyShopException;
}
