package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public interface  KorisnikDao extends Dao<Korisnik>{

    List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws HealthyShopException;
}
