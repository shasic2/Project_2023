package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class ProizvodiManager {
    public List<Proizvodi> dajSveProizvode() throws HealthyShopException {
        return DaoFactory.proizvodDao().getAll();
    }
}
