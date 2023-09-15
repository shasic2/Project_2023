package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX controller za kreiranje i izmjenu prozora potvrde korisnikove registracije
 *
 * @author Selma
 */

public class PotvrdaRegistracijeController {
    public Button btnZatvori;

    public void akcijaZatvaranja(ActionEvent actionEvent) {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }
}
