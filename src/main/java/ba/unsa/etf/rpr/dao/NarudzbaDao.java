package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;

public  interface NarudzbaDao {

    List<Narudzba> pronadjiPoID(int id) throws HealthyShopException;

    List<Narudzba> pronadjiNarudzbuPoKorisniku(int id) throws HealthyShopException;
}
