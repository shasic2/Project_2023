package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public class ProizvodiManager {
    public List<Proizvodi> dajSveProizvode() throws HealthyShopException {
        return DaoFactory.proizvodiDao().getAll();
    }
    public void azurirajProizvod(Proizvodi proizvod) throws HealthyShopException {
        DaoFactory.proizvodiDao().update(proizvod);
    }

    public List<Proizvodi> pronadjiProizvod(String ime) throws HealthyShopException {
        return DaoFactory.proizvodiDao().pronadjiProizvod(ime);
    }

    public void obrisiProizvod(int id) throws HealthyShopException {
        DaoFactory.proizvodiDao().delete(id);
    }
    public Proizvodi dajProizvodPoID(int id) throws HealthyShopException {
        return DaoFactory.proizvodiDao().getById(id);
    }

}
