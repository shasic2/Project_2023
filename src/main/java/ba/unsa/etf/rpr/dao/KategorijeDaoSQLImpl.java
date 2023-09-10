package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.Map;

public class KategorijeDaoSQLImpl extends AbstractDao<Kategorije> implements KategorijeDao {

    private static KategorijeDaoSQLImpl instance = null;

    private KategorijeDaoSQLImpl(){ super("Kategorije");}

   public static KategorijeDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new KategorijeDaoSQLImpl();
        return instance;
   }

    public static void removeInstance() {
        if (instance != null)
            instance = null;
    }



    @Override
    public Kategorije row2object(ResultSet rs) throws HealthyShopException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Kategorije object) {
        return null;
    }


}

