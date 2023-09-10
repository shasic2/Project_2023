package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KorisnikDaoSQLImpl extends AbstractDao<Korisnik> implements KorisnikDao{
    private static  KorisnikDaoSQLImpl instance = null;

    public KorisnikDaoSQLImpl() {
        super("Korisnik");
    }
    public static KorisnikDaoSQLImpl getInstance(){
        if(instance == null)
            instance = new KorisnikDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance != null)
            instance = null;
    }

    @Override
    public Korisnik row2object(ResultSet rs) throws HealthyShopException {
        try{
            Korisnik korisnik = new Korisnik();
            korisnik.setId(rs.getInt("idKorisnik"));
            korisnik.setIme(rs.getString("Ime"));
            korisnik.setPrezime(rs.getString("Prezime"));
            korisnik.setEmail(rs.getString("Email"));
            korisnik.setSifra(rs.getString("Sifra"));
            return korisnik;
        } catch (SQLException e) {
            throw new HealthyShopException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Korisnik object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idKorisnik", object.getId());
        row.put("ime", object.getIme());
        row.put("prezime", object.getPrezime());
        row.put("Email", object.getEmail());
        row.put("adresa", object.getAdresa());
        row.put("sifra", object.getSifra());
        return row;
    }



    @Override
    public List<Korisnik> pronadjiKorisnikaPoEmailu(String email) throws HealthyShopException{
        return executeQuery("SELECT * FROM Korisnik WHERE Email = ?", new Object[]{email});
    }



}
