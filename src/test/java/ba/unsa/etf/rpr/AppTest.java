package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KategorijeManager;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.KorisnikDao;
import ba.unsa.etf.rpr.dao.KorisnikDaoSQLImpl;
import ba.unsa.etf.rpr.dao.ProizvodiDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Kategorije;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        Narudzba n1 = new Narudzba(1, 1, 6, "Kokosova Kuglica ");
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

    @Mock
    public Korisnik korisnik = new Korisnik();
    private KorisnikDao daoKorisnik;
    private KorisnikDaoSQLImpl sqlKorisnik = Mockito.mock(KorisnikDaoSQLImpl.class);
    private ProizvodiDaoSQLImpl sqlProizvod = Mockito.mock(ProizvodiDaoSQLImpl.class);
    private KorisnikManager korisnikManager = new KorisnikManager();
    private KategorijeManager kategorijaManager = new KategorijeManager();
    private ProizvodiManager proizvodManager = new ProizvodiManager();

    @BeforeEach
    public void setUp() {
        korisnik.setId(1);
        korisnik.setIme("Selmaa");
        korisnik.setPrezime("Hassic");
        korisnik.setAdresa("Mekote 55");
        korisnik.setEmail("shasic2@etfff.unsa.ba");
        korisnik.setSifra("12344321");
        MockitoAnnotations.openMocks(this);
        korisnikManager = new KorisnikManager();
        kategorijaManager = Mockito.mock(KategorijeManager.class);
        proizvodManager = Mockito.mock(ProizvodiManager.class);
    }






        @Test
       public void Test9() throws HealthyShopException {
        Proizvodi proizvod = new Proizvodi(3, 1, "Kokosova Oaza Osveženja", "Napitak koji se sastoji od kokosove vode i komadića svježeg ananasa.", 7);
        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::proizvodiDao).thenReturn(sqlProizvod);
        Proizvodi proizvod1 = new Proizvodi();
        when(sqlProizvod.add(Mockito.any(Proizvodi.class))).thenReturn(proizvod1);
        Proizvodi proizvod2 = sqlProizvod.add(new Proizvodi());
        assertEquals(proizvod1, proizvod2);
        mockedFactory.close();
    }


    @Test
    public void Test10() throws HealthyShopException {
        Proizvodi proizvod = new Proizvodi(1,1, "Kokosova Oaza Osveženja", "Napitak koji se sastoji od kokosove vode i komadića svježeg ananasa.", 6);
        proizvodManager.dodajProizvod(proizvod);
        Assertions.assertTrue(true);
        Mockito.verify(proizvodManager).dodajProizvod(proizvod);
    }
















}
