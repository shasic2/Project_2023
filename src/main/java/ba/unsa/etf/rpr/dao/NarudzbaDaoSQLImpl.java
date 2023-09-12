package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.Map;

public class NarudzbaDaoSQLImpl extends  AbstractDao<Narudzba> implements NarudzbaDao  {

    private static NarudzbaDaoSQLImpl instance = null;

    public NarudzbaDaoSQLImpl() {
        super("Narudzba");
    }

    public static NarudzbaDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new NarudzbaDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance != null)
            instance = null;
    }

    @Override
    public Narudzba row2object(ResultSet rs) throws HealthyShopException {
        try {
            Narudzba narudzba = new Narudzba();
            narudzba.setId(rs.getInt("id"));
            narudzba.setRacun(Integer.parseInt(rs.getString("racun")));
            narudzba.setKorisnik_id((Integer) DaoFactory.korisnikDao().getById(rs.getInt("id_korisnik")));
            return narudzba;
        } catch (Exception e) {
            throw new HealthyShopException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Narudzba object) {
        return null;
    }
}
