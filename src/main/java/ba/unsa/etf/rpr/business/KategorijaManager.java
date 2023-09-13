package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

public class KategorijaManager {

    public void obrisiKategoriju(int id) throws HealthyShopException{
        DaoFactory.kategorijeDao().delete(id);
    }
}
