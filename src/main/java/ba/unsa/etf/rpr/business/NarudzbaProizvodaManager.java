package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

public class NarudzbaProizvodaManager {

    public NarudzbaProizvoda dodajNP(NarudzbaProizvoda np) throws HealthyShopException {
        return (NarudzbaProizvoda) DaoFactory.NarudzbaDao().add(np);
    }
}
