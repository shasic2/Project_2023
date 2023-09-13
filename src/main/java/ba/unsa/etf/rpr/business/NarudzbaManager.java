package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class NarudzbaManager {

    public void obrisiNarudzbu(int id) throws HealthyShopException {
        DaoFactory.NarudzbaDao().delete(id);
    }

    public void dodajNarudbu(Narudzba narudzba) throws HealthyShopException {
        DaoFactory.NarudzbaDao().add(narudzba);
    }


    public void azurirajNarudzbu(Narudzba narudzba) throws HealthyShopException {
        DaoFactory.NarudzbaDao().update(narudzba);
    }

    public List<Object> dajSveNarudzbe() throws HealthyShopException {
        return DaoFactory.NarudzbaDao().getAll();
    }
}
