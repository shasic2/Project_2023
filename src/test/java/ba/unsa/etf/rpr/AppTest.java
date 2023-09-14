package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Proizvodi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

       Korisnik k1 = new Korisnik(1, "Selma", "Hasic", "shasic2@etf.unsa.ba", "Mekote 50", "123456");

        @Test
        public void Test1(){
                assertAll(
                        () -> assertEquals(1, k1.getId(), "ID je netačan!"),
                        () -> assertEquals("Selma", k1.getIme(), "Ime je netačno!"),
                        () -> assertEquals("Hasic", k1.getPrezime(), "Prezime je netačno!"),
                        () -> assertEquals("shasic2@etf.unsa.ba", k1.getEmail(), "Email je netačan!"),
                        () -> assertEquals("Mekote 50", k1.getAdresa(), "Adresa je netačna!"),
                        () -> assertEquals("123456", k1.getSifra(), "Password je netačan!")
                );
        }

    @Test
    public void Test2(){
        assertEquals(6, k1.getSifra().length());
    }

    Kategorije kategorija1 = new Kategorije(1,"Napici");
    Kategorije kategorija2 = new Kategorije(2, "Snackovi");
    Proizvodi p = new Proizvodi(1, 1, "Zeleni Energetski Pojačivač", " Kuglica napravljena od kokosovog brašna i meda.", 6);

    @Test
    public void Test3(){

        assertTrue(p.getKategorija_id()==kategorija1.getId());
    }











}
