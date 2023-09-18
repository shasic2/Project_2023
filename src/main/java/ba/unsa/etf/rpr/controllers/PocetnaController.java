package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ModelManager;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
/**
 * JavaFX controller za kreiranje i izmjenu prozora koji se otvori kada se aplikacija pokrene
 *
 * @author Selma
 */

public class PocetnaController {
    public TextField Emaild;
    public Button BtnRegistracija;
    public Button BtnPrijava;
    public PasswordField PasswordId;
    public Label GreskaId;
    public Label dodatnoPolje;

    public void akcijaPrijave(ActionEvent actionEvent) throws HealthyShopException {
        String uneseniEmail = Emaild.getText();
        String uneseniPassword = PasswordId.getText();
        List<Korisnik> listaPrijavljenihKorisnika = KorisnikManager.dajSveKorisnike();
        ModelManager modelKorisnik = ModelManager.getInstance();
        int brojac = 0, brojac1 = 0;

        if (Objects.equals(PasswordId.getText(), "") || Objects.equals(Emaild.getText(), "")) {
            dodatnoPolje.setText("Polje ne može biti prazno !");
            brojac++;

        } else {
            for (Korisnik k : listaPrijavljenihKorisnika) {
                if (k.getEmail().equals(uneseniEmail) && k.getSifra().equals(uneseniPassword)) {
                    brojac1++;
                    modelKorisnik.setKorisnik(k);
                }
            }
            if (brojac1 != 0)
                dodatnoPolje.setText("");
            else
                dodatnoPolje.setText("Neispravni uneseni podaci!");
        }

        if (brojac == 0 && brojac1 != 0) {
            try {

                Stage stage =(Stage)BtnPrijava.getScene().getWindow();
                stage.close();
                Stage stage1 = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/proizvodi.fxml"));
                ProizvodiController proizvodi = new ProizvodiController();
                fxmlLoader.setController(proizvodi);
                Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                stage1.setTitle("Healthy ponuda");
                stage1.setScene(scene);
                stage1.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void OtvaranjeONama(ActionEvent actionEvent) {
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

    public void OtvaranjePomoci(ActionEvent actionEvent) {
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

    public void akcijaRegistracije(ActionEvent actionEvent) {
        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/Registracija.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registracija");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void promjenaBojeRegis(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #5B8F52 ;");
    }

    public void vracanjeBrojeRegist(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #ccd7ca ;");
    }

    public void promjenaBojeONama(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a ;");
    }

    public void vracanjeBojeONama(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");
    }

    public void promjenaBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a;");
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");

    }

    public void promjenaBojeLog(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #5B8F52 ;");
    }

    public void bvracanjeBrojeLog(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #ccd7ca ;");
    }
}
