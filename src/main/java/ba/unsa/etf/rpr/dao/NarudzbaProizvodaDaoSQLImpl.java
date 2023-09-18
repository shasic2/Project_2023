package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NarudzbaProizvodaDaoSQLImpl extends AbstractDao<NarudzbaProizvoda> implements NarudzbaProizvodaDao {

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
    public NarudzbaProizvoda row2object(ResultSet rs) throws HealthyShopException {
        try {
            NarudzbaProizvoda np = new NarudzbaProizvoda();
            np.setId(rs.getInt("id"));
            np.setProizvod_id(DaoFactory.proizvodiDao().getById(rs.getInt("proizvod_id")));
            np.setNarudzba_id(DaoFactory.narudzbaDao().getById(rs.getInt("narudzba_id")));
            return np;
        } catch (Exception e) {
            throw new HealthyShopException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(NarudzbaProizvoda object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("narudzba_id", object.getNarudzba_id().getId());
        item.put("proizvod_id", object.getProizvod_id().getId());
        return item;
    }

    @Override
    public List<NarudzbaProizvoda> dajPoKorisniku(int id_korisnik) throws HealthyShopException {
        return executeQuery("SELECT NarudzbaProizvod.*\n" +
                "FROM NarudzbaProizvod\n" +
                "INNER JOIN Narudzba ON NarudzbaProizvod.narudzba_id = Narudzba.id\n" +
                "WHERE Narudzba.korisnik_id = ?",new Object[]{id_korisnik});
    }
}
