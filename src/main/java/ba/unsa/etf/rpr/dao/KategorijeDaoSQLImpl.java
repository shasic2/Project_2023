package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        try {
            Kategorije kategorija = new Kategorije();
            kategorija.setId(rs.getInt("id"));
            kategorija.setIme(rs.getString("ime"));
            return kategorija;
        } catch (SQLException e) {
            throw new HealthyShopException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Kategorije object) {
        Map<String, Object> red = new TreeMap<>();
        red.put("id", object.getId());
        red.put("ime", object.getIme());
        return red;
    }

    /**
     * Metoda za pronalazak kategorije sa proslijedjenim imenom
     * @param ime
     * @return sve kategorije sa tim imenom
     * @throws HealthyShopException
     */
    @Override
    public List<Kategorije> pronadjiKategorijuPoID(String ime) throws HealthyShopException {
        return executeQuery("SELECT * FROM Kategorije WHERE ime = ?", new Object[]{ime});
    }


}

