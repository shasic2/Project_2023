package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;

public class DaoFactory {

    private DaoFactory(){}

    private static final KategorijeDao kategorijeDao = KategorijeDaoSQLImpl.getInstance();
    public static KategorijeDao kategorijeDao() { return kategorijeDao; }

    private static final KorisnikDao KorisnikDao = KorisnikDaoSQLImpl.getInstance();



    public static KorisnikDao KorisnikDao() {
        return KorisnikDao;
    }
}
