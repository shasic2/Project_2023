package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class NarudzbaProizvodaManager {

    public NarudzbaProizvoda dodajNP(NarudzbaProizvoda np) throws HealthyShopException {
        return DaoFactory.narProDao().add(np);
    }
    public List<NarudzbaProizvoda> dajSveNP() throws HealthyShopException {
        return DaoFactory.narProDao().getAll();
    }
}
