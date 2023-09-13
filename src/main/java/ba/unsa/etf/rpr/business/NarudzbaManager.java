package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

public class NarudzbaManager {

    public void obrisiNarudzbu(int id) throws HealthyShopException {
        DaoFactory.NarudzbaDao().delete(id);
    }
}
