package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;

import java.sql.Connection;
import java.sql.DriverManager;

public class KorisnikDaoSQLImpl extends KorisnikDao {
    private Connection konekcija;

    public KorisnikDaoSQLImpl(){
        try{
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Baza/RPR/2022/2023?sessionVariables=WAIT_TIMEOUT=2880", "freedb_shasic2", "vCpugK8F*!J*W4&");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Korisnik getById(int id) {
        return null;
    }

    @Override
    public Korisnik add(Korisnik item) {
        return null;
    }

    @Override
    public Korisnik update(Korisnik item) {
        return null;
    }
}
