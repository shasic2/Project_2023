package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

          Korisnik k1 = new Korisnik(1, "Selma", "Hasic", "shasic2@etf.unsa.ba", "Mekote 50", "123456");
          Kategorije kategorija1 = new Kategorije(1,"Napici");
          Kategorije kategorija2 = new Kategorije(2, "Snackovi");
          Proizvodi p = new Proizvodi(1, 1, "Zeleni Energetski Pojačivač", " Kuglica napravljena od kokosovog brašna i meda.", 6);
          Korisnik k2 = new Korisnik();


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

    @Test
    public void Test3(){

        assertTrue(p.getKategorija_id()==kategorija1.getId());
    }

    @Test
    public void Test4() {

        k2.setIme("Nedzla");
        assertEquals("Nedzla", k2.getIme());
        k2.setPrezime("Helać");
        assertEquals("Helać", k2.getPrezime());
        k2.setAdresa("Zmaja od Bosne ");
        assertEquals("Zmaja od Bosne ", k2.getAdresa());
        k2.setEmail("nhelac1@etf.unsa.ba");
        assertNotEquals("nhelaccc1@etf.unsa.ba", k2.getEmail());
        k2.setSifra("159753");
        assertNotEquals("123685", k2.getSifra());
    }

    @Test
    public void Test5(){
        KorisnikManager manager = new KorisnikManager();
        try{
            manager.validacijaImena("n");
        } catch (HealthyShopException e) {
            assertEquals("Ime mora sadržavati samo slova", e.getMessage());
        }
    }

    @Test
    public void Test6(){
        Narudzba n1 = new Narudzba(1, 1, 6);
        assertEquals(n1.getRacun(), p.getCijena());
    }

    @Test
    public void Test7() throws HealthyShopException {
        ProizvodiManager manager = new ProizvodiManager();
        manager.obrisiProizvod(1);
        assertNotNull(manager.dajSveProizvode().size());
    }

    @Test
    public void Test8(){
        KorisnikManager manager = new KorisnikManager();
        try{
            manager.validacijaPrezimena("123");
        } catch (HealthyShopException e) {
            assertEquals("Prezime mora sadržavati samo slova", e.getMessage());
        }
    }












}
