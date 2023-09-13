package ba.unsa.etf.rpr.dao;


public class DaoFactory {

    private DaoFactory(){}

    private static final KategorijeDao kategorijeDao = KategorijeDaoSQLImpl.getInstance();
    public static KategorijeDao kategorijeDao() { return kategorijeDao; }

    private static final KorisnikDao korisnikDao = KorisnikDaoSQLImpl.getInstance();
    public static KorisnikDao korisnikDao() {
        return korisnikDao;
    }

    private static final NarudzbaDao narudzbaDao = NarudzbaDaoSQLImpl.getInstance();
    public static NarudzbaDao narudzbaDao() {
        return narudzbaDao;
    }

    private static final ProizvodiDao proizvodiDao = ProizvodiDaoSQLImpl.getInstance();
    public static ProizvodiDao proizvodiDao() { return proizvodiDao; }

    private static final NarudzbaProizvodaDao narProDao = NarudzbaProizvodaDaoSQLImpl.getInstance();
    public static NarudzbaProizvodaDao narProDao() { return narProDao; }




}
