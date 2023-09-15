package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;
/**
 * DAO interfejs za objekat NarudzbaProizvod
 *
 * @author Selma
 */

public interface NarudzbaProizvodaDao extends Dao<NarudzbaProizvoda> {
    List<NarudzbaProizvoda> dajPoKorisniku(int id_korisnik) throws HealthyShopException;


}
