package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorije;

import java.sql.*;

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
        String query = "SELECT * FROM categories WHERE id = ?";
        try{
            PreparedStatement stmt = this.konekcija.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Kategorije category = new Kategorije();
                category.setKategorija_id(rs.getInt("id"));
                category.setIme(rs.getString("ime"));
                rs.close();
                return category;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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

