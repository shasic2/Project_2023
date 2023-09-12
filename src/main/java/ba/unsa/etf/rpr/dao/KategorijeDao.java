package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.util.List;


/**
 * DAO interfejs za objekat Kategorija
 *
 * @author Selma
 */
public interface KategorijeDao extends  Dao<Kategorije> {

    List<Kategorije> pronadjiKategorijuPoID(String ime) throws HealthyShopException;
}
