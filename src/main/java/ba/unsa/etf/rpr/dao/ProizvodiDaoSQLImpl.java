package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodiDaoSQLImpl extends AbstractDao<Proizvodi> implements ProizvodiDao  {

    private static ProizvodiDaoSQLImpl instance = null;
    public ProizvodiDaoSQLImpl() {
        super("Proizvodi");
    }

    public static ProizvodiDaoSQLImpl getInstance(){
        if (instance == null)
            instance = new ProizvodiDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if (instance != null)
            instance = null;
    }

    @Override
    public Proizvodi row2object(ResultSet rs) throws HealthyShopException, SQLException {
        try {
            Proizvodi proizvod = new Proizvodi();
            proizvod.setId(rs.getInt("id"));
            proizvod.setIme(rs.getString("ime"));
            proizvod.setOpis(rs.getString("opis"));
            proizvod.setKategorija_id((Integer) DaoFactory.KategorijeDao().getById(rs.getInt("categories_Id")));
            proizvod.setCijena(Integer.parseInt(rs.getString("cijena")));
            return proizvod;
        } catch (Exception e) {
            throw new HealthyShopException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvodi object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("ime", object.getIme());
        item.put("opis", object.getOpis());
        item.put("id_kategorija", object.getKategorija_id());
        item.put("cijena", object.getCijena());
        return item;
    }

    @Override
    public List<Proizvodi> pronadjiProizvodPoKategoriji(int id) throws HealthyShopException{
        return executeQuery("SELECT * from Proizvodi WHERE categories_Id = ?", new Object[]{id});
    }
}
