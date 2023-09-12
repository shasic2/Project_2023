package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Object> item = new TreeMap<>();
        item.put("idNarudzba", object.getId());
        item.put("racun", object.getRacun());
        item.put("idKorisnik", object.getKorisnik_id());
        return item;
    }

    @Override
    public List<Narudzba> pronadjiPoID(int id) throws HealthyShopException {
        return executeQuery("SELECT * from Narudzba WHERE idNarudzba = ?", new Object[]{id});
    }

    @Override
    public List<Narudzba> pronadjiNarudzbuPoKorisniku(int id) throws HealthyShopException{
        return executeQuery("SELECT * from Narudzba WHERE korisnik_id = ?", new Object[]{id});
    }
}




