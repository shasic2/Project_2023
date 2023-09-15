package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;
/**
 * DAO interfejs za objekat Narudzba
 *
 * @author Selma
 */

public  interface NarudzbaDao extends Dao<Narudzba> {

    List<Narudzba> pronadjiPoID(int id) throws HealthyShopException;

    List<Narudzba> pronadjiNarudzbuPoKorisniku(int id) throws HealthyShopException;



}
