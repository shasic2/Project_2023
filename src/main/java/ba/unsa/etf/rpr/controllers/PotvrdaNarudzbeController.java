package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * JavaFX controller za kreiranje i izmjenu prozora potvrde korisnikove narudzbe
 *
 * @author Selma
 */

public class PotvrdaNarudzbeController {
    public Label idLabela;
    public Button btnZatvori;

    @FXML
    public void initialize() throws HealthyShopException {
        Model model = Model.getInstance();
        idLabela.setText("Hvala, " + model.getKorisnik().getIme() + " " + model.getKorisnik().getPrezime() + "!");
    }

    public void zatvaranjeProzora(ActionEvent actionEvent) {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }

    public void promjenaBoje(MouseEvent mouseEvent) {
    }

    public void vracanjeBoje(MouseEvent mouseEvent) {
    }
}
