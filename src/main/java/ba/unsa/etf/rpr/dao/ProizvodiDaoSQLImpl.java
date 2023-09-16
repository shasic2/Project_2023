package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static ba.unsa.etf.rpr.dao.DaoFactory.*;
import static ba.unsa.etf.rpr.dao.DaoFactory.kategorijeDao;

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
    public Proizvodi row2object(ResultSet rs) throws HealthyShopException {
        try{
            Proizvodi proizvodi = new Proizvodi();
            proizvodi.setId(rs.getInt("id"));
            proizvodi.setIme(rs.getString("ime"));
            proizvodi.setKategorije_id(rs.getInt("categories_Id"));
            proizvodi.setOpis(rs.getString("opis"));
            proizvodi.setCijena(rs.getInt("cijena"));
            return proizvodi;
        } catch (SQLException e) {
            throw new HealthyShopException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvodi object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("ime", object.getIme());
        item.put("categories_Id", object.getKategorija_id());
        item.put("opis", object.getOpis());
        item.put("cijena", object.getCijena());
        return item;
    }

    @Override
    public List<Proizvodi> pronadjiProizvodPoKategoriji(int id) throws HealthyShopException{
        return executeQuery("SELECT * from Proizvodi WHERE categories_Id = ?", new Object[]{id});
    }

    @Override
    public List<Proizvodi> pronadjiProizvod(String ime) throws HealthyShopException {
        return executeQuery("SELECT * FROM Proizvod WHERE ime LIKE concat('%', ?, '%')", new Object[]{ime});
    }
}
