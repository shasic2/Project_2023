package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.Collections;
import java.util.List;
/**
 * Sloj biznis logike za upravljanje narudzbama
 *
 * @author Selma
 */

public class NarudzbaManager {

    public void obrisiNarudzbu(int id) throws HealthyShopException {
        DaoFactory.narudzbaDao().delete(id);
    }

    public void dodajNarudbu(Narudzba narudzba) throws HealthyShopException {
        DaoFactory.narudzbaDao().add(narudzba);
    }


    public void azurirajNarudzbu(Narudzba narudzba) throws HealthyShopException {
        DaoFactory.narudzbaDao().update(narudzba);
    }

    public List<Object> dajSveNarudzbe() throws HealthyShopException {
        return Collections.singletonList(DaoFactory.narudzbaDao().getAll());
    }
}
