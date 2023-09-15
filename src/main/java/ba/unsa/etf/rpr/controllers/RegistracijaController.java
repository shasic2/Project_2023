package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
/**
 * JavaFX controller za kreiranje i izmjenu prozora za registrovanje novog korisnika
 *
 * @author Selma
 */

public class RegistracijaController {
    public PasswordField idPassword;
    public TextField idEmail;
    public TextField idAdresa;
    public TextField idPrezime;
    public TextField idIme;
    public Label Labela1, Labela2, Labela3, Labela4, Labela5;
    public Button btnPomoc, btnONama, btnZatvori, btnRegistracija;

    KorisnikManager korisnikManager = new KorisnikManager();

    public void akcijaRegistracije(ActionEvent actionEvent) throws HealthyShopException {

        List<Korisnik> listaRegKorisnika = korisnikManager.dajSveKorisnike();

        String unesenoIme = idIme.getText();
        String unesenoPrezime = idPrezime.getText();
        String unesenaAdresa = idAdresa.getText();
        String uneseniEmail = idEmail.getText();
        String uneseniPassword = idPassword.getText();

        int brojac = 0, brojac1 = 0;
        if (Objects.equals(unesenoIme, "")) {
            Labela1.setText("Polje ne može biti prazno !");
            brojac++;
            idIme.getStyleClass().add("errorField");
        } else {
            Labela1.setText("");
            idIme.getStyleClass().remove("errorField");
        }
        if (Objects.equals(unesenoPrezime, "")) {
            Labela2.setText("Polje ne može biti prazno !");
            brojac++;
            idPrezime.getStyleClass().add("errorField");
        } else {
            Labela2.setText("");
            idPrezime.getStyleClass().remove("errorField");
        }
        if (Objects.equals(unesenaAdresa, "")) {
            Labela3.setText("Polje ne može biti prazno !");
            brojac++;
            idAdresa.getStyleClass().add("errorField");
        } else {
            Labela3.setText("");
            idAdresa.getStyleClass().remove("errorField");
        }
        if (Objects.equals(uneseniEmail, "")) {
            Labela4.setText("Polje ne može biti prazno !");
            brojac++;
            idEmail.getStyleClass().add("errorField");
        } else {
            for (Korisnik k : listaRegKorisnika) {
                if (k.getEmail().equals(uneseniEmail)) {
                    brojac++; //ako postoji vec isti email
                    brojac1++;
                    Labela4.setText("Email već postoji !");
                    idEmail.getStyleClass().add("errorField");
                    idEmail.getStyleClass().add("errorField");
                }
            }
            if (brojac1 == 0)
                Labela4.setText("");
            idEmail.getStyleClass().remove("errorField");
        }


        if (Objects.equals(uneseniPassword, "")) {
            Labela5.setText("Polje ne može biti prazno !");
            brojac++;
            idPassword.getStyleClass().add("errorField");
        } else if (idPassword.getText().length() < 6) {
            Labela5.setText("Password mora sadržavati 6 karaktera !");
            brojac++;
            idPassword.getStyleClass().add("errorField");
        }
        else {
            Labela5.setText("");
            idPassword.getStyleClass().remove("errorField");
        }

        if (brojac == 0 && brojac1 == 0) {
            Korisnik k = new Korisnik();
            k.setIme(unesenoIme);
            k.setPrezime(unesenoPrezime);
            k.setAdresa(unesenaAdresa);
            k.setEmail(uneseniEmail);
            k.setSifra(uneseniPassword);

            try {
                FileReader r = new FileReader("src/main/resources/database.properties");
                Properties p = new Properties();
                p.load(r);
                String string1 = p.getProperty("db.server");
                String string2 = p.getProperty("db.username");
                String string3 = p.getProperty("db.password");

                Connection connection = DriverManager.getConnection(string1, string2, string3);
                System.out.println(string1 + " " + string2 + " " + string3);

                Korisnik noviK = korisnikManager.dodajKorisnika(k);

                try {
                    Stage stage = (Stage) btnRegistracija.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/potvrdaRegistracije.fxml"));
                    fxmlLoader.setController(new PotvrdaRegistracijeController());
                    Parent root = fxmlLoader.load();
                    stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                    stage.setResizable(false);
                    stage.show();

                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
                connection.close();

            }catch (Exception e2) {
                e2.printStackTrace();
            }


        }
    }

    public void akcijaZatvaranja(ActionEvent actionEvent) {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }

    public void otvaranjePomoc(ActionEvent actionEvent) {
        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/pomoc.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pomoc");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void otvaranjeONama(ActionEvent actionEvent) {
        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/ONama.fxml"));
            Stage stage = new Stage();
            stage.setTitle("O nama");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void promjenaBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a;");
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");
    }

    public void promjenaBojeONama(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a;");

    }

    public void vracanjeBrojeONama(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");
    }
}
