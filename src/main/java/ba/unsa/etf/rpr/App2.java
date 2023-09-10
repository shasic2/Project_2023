package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.PocetnaController;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class App2 {
    public static void prijavaUSistem(int broj) throws HealthyShopException {
        if(broj == 1){
            System.out.println("Login\n");
            String email, password;
            System.out.println("Unesite Vaš e-mail");
            Scanner scanner = new Scanner(System.in);
            email = scanner.next();
            System.out.println("Unesite Vas password");
            password = scanner.next();
            int pomocna = 0;
            List<Korisnik> korisnik = DaoFactory.KorisnikDao().pronadjiKorisnikaPoEmailu(email);
            for(Korisnik k : korisnik){
                if(k.getEmail().equals(email) && k.getSifra().equals(password)){
                    System.out.println("\nUspješno ste prijavljeni!");
                    pomocna = 1;
                    break;
                }
            }
            if (pomocna == 0){
                System.out.println("\nNeuspješna prijava!");
            }
        }else if(broj == 2){
            System.out.println("Registracija\n");
            System.out.println("Unesite vaše ime\n");
            String ime;
            Scanner scanner = new Scanner(System.in);
            ime = scanner.next();
            System.out.println("\nUnesite vaše prezime\n");
            String prezime;
            prezime = scanner.next();
            System.out.println("\nUnesite vaš e-mail\n");
            String email;
            email = scanner.next();
            System.out.println("\nUnesite vaš password\n");
            String password;
            password = scanner.next();

            if(ime != null && prezime != null && email != null && password != null){
                Korisnik korisnik = new Korisnik();
                korisnik.setPrezime(prezime);
                korisnik.setIme(ime);
                korisnik.setEmail(email);
                korisnik.setSifra(password);

                System.out.println("\nUspješno ste se registrovali");
            }else{
                System.out.println("\nRegistracija nije bila uspješna!");
            }
        }
    }
    public static void main( String[] args ) throws HealthyShopException {
        System.out.println("DOBRODOŠLI! NAŠA APLIKACIJA JE NAMIJENJENA ZA NARUČIVANJE PROIZVODA U PEKARI.\nMolimo Vas da odaberete jednu od sljedećih opcija:\n" +
                "1 - ukoliko imate već kreiran račun u našoj aplikaciji\n" +
                "2 - ukoliko tek želite da se registrujete");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        prijavaUSistem(x);
    }
}
