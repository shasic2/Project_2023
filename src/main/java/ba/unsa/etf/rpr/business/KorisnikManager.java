package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class KorisnikManager {


    public static List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws HealthyShopException {
        return DaoFactory.korisnikDao().pronadjiKorisnikaPoEmailu(email);
    }

    public void obrisiKorisnika(int id) throws HealthyShopException {
        DaoFactory.korisnikDao().delete(id);
    }

    public Korisnik pronadjiKorisnikaPoID(int id) throws HealthyShopException {
        return DaoFactory.korisnikDao().getById(id);
    }

    public void azurirajKorisnika(Korisnik korisnik) throws HealthyShopException {
        DaoFactory.korisnikDao().update(korisnik);
    }

    public static Korisnik dodajKorisnika(Korisnik korisnik) throws HealthyShopException {
        return DaoFactory.korisnikDao().add(korisnik);
    }

    public List<Korisnik> dajSveKorisnike() throws HealthyShopException {
        return DaoFactory.korisnikDao().getAll();
    }


}
