package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;

public abstract class KategorijeDao {
    public abstract Kategorije getById(int id);
}
