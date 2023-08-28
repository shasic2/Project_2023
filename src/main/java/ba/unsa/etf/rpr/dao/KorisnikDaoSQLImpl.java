package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korisnik;

import java.sql.*;

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
    public Korisnik getById(int id){

        String query = "SELECT * FROM users WHERE id = ?";
        try{
            PreparedStatement stmt = this.konekcija.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Korisnik user = new Korisnik();
                user.setKorisnik_id(rs.getInt("id"));
                user.setIme(rs.getString("ime"));
                user.setPrezime(rs.getString("prezime"));
                user.setAdresa(rs.getString("adresa"));
                user.setEmail(rs.getString("email"));
                user.setSifra(rs.getString("password"));
                rs.close();
                return user;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
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
