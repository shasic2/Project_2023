package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class NarudzbaProizvodaDaoSQLImpl extends  AbstractDao<NarudzbaProizvoda> implements  NarudzbaProizvodaDao {

    private static NarudzbaProizvodaDaoSQLImpl instance = null;
    public NarudzbaProizvodaDaoSQLImpl() {
        super("NarudzbaProizvoda");
    }

    public static NarudzbaProizvodaDaoSQLImpl getInstance()
    {
        if(instance == null)
            instance = new NarudzbaProizvodaDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance != null)
            instance = null;
    }

    @Override
    public NarudzbaProizvoda row2object(ResultSet rs) throws HealthyShopException, SQLException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(NarudzbaProizvoda object) {
        return null;
    }
}
