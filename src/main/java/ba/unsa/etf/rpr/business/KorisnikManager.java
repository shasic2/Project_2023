package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class KorisnikManager {


    public static List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws HealthyShopException {
        return DaoFactory.KorisnikDao().pronadjiKorisnikaPoEmailu(email);
    }
}
