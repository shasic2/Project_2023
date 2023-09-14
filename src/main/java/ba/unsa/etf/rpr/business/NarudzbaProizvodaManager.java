package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;
/**
 * Sloj biznis logike za upravljanje narucenim proizvodima
 *
 * @author Selma
 */

public class NarudzbaProizvodaManager {

    public NarudzbaProizvoda dodajNP(NarudzbaProizvoda np) throws HealthyShopException {
        return DaoFactory.narProDao().add(np);
    }
    public List<NarudzbaProizvoda> dajSveNP() throws HealthyShopException {
        return DaoFactory.narProDao().getAll();
    }
    public List<NarudzbaProizvoda> dajPoKorisniku(int id_korisnik) throws HealthyShopException {
        return DaoFactory.narProDao().dajPoKorisniku(id_korisnik);
    }
}
