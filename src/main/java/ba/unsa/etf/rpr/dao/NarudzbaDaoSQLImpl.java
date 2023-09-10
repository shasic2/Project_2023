package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.Map;

public class NarudzbaDaoSQLImpl extends  AbstractDao<Narudzba> implements NarudzbaDao  {

    public NarudzbaDaoSQLImpl(String tableName) {
        super(tableName);
    }

    @Override
    public Narudzba row2object(ResultSet rs) throws HealthyShopException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Narudzba object) {
        return null;
    }
}
