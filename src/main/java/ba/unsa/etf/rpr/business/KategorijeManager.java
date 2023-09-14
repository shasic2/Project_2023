package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;
/**
 * Sloj biznis logike za upravljanje kategorijama
 *
 * @author Selma
 */
public class KategorijeManager {
    public void obrisiKategoriju(int id) throws HealthyShopException {
        DaoFactory.kategorijeDao().delete(id);
    }
    public void azurirajKategoriju(Kategorije kategorije) throws HealthyShopException {
        DaoFactory.kategorijeDao().update(kategorije);
    }
    public void dodajKategoriju(Kategorije kategorije) throws HealthyShopException {
        DaoFactory.kategorijeDao().add(kategorije);
    }

    public List<Kategorije> dajSveKategorije() throws HealthyShopException{
        return DaoFactory.kategorijeDao().getAll();

    }


}
