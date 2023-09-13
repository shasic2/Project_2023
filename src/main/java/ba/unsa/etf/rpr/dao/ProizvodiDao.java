package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public interface ProizvodiDao extends Dao<Proizvodi>{
    List<Proizvodi> pronadjiProizvodPoKategoriji(int id) throws HealthyShopException;

    List<Proizvodi> pronadjiProizvod(String ime) throws HealthyShopException;
}
