package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;
/**
 * Sloj biznis logike za upravljanje korisnicima
 *
 * @author Selma
 */

public class KorisnikManager {


    public static List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws HealthyShopException {
        return DaoFactory.korisnikDao().pronadjiKorisnikaPoEmailu(email);
    }

    public void obrisiKorisnika(int id) throws HealthyShopException {
        DaoFactory.korisnikDao().delete(id);
    }



    public void azurirajKorisnika(Korisnik korisnik) throws HealthyShopException {
        DaoFactory.korisnikDao().update(korisnik);
    }

    public static Korisnik dodajKorisnika(Korisnik korisnik) throws HealthyShopException {
        return DaoFactory.korisnikDao().add(korisnik);
    }

    public static List<Korisnik> dajSveKorisnike() throws HealthyShopException {
        return DaoFactory.korisnikDao().getAll();
    }

    public void validacijaImena(String ime) throws HealthyShopException {
        if (ime == null  || !ime.matches("^[a-zA-Z]+$"))
            throw new HealthyShopException("Ime mora sadržavati samo slova");

    }
    public void validacijaPrezimena(String prezime) throws HealthyShopException {
        if (prezime == null  || !prezime.matches("^[a-zA-Z]+$")) {
            throw new HealthyShopException("Prezime mora sadržavati samo slova");
        }
    }



}
