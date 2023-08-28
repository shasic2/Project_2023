package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;

import java.sql.Connection;
import java.sql.DriverManager;

public class KategorijeDaoSQLImpl extends KategorijeDao {

    private Connection konekcija;

    public KategorijeDaoSQLImpl(){
        try{
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Baza/RPR/2022/2023?sessionVariables=WAIT_TIMEOUT=2880", "freedb_shasic2", "vCpugK8F*!J*W4&");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Kategorije getById(int id) {
        return null;
    }

    @Override
    public Kategorije add(Kategorije item) {
        return null;
    }

    @Override
    public Kategorije update(Kategorije item) {
        return null;
    }


    }

