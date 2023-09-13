package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

public class KategorijaManager {

    public void obrisiKategoriju(int id) throws HealthyShopException{
        DaoFactory.kategorijeDao().delete(id);
    }
    public void azurirajKategoriju(Kategorije kategorije) throws HealthyShopException {
        DaoFactory.kategorijeDao().update(kategorije);
    }
}
