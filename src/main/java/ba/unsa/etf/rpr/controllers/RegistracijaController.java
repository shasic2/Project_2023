package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistracijaController {
    public PasswordField idPassword;
    public TextField idEmail;
    public TextField idAdresa;
    public TextField idPrezime;
    public TextField idIme;
    public Label Labela1, Labela2, Labela3, Labela4, Labela5;
    public Button btnPomoc, btnONama, btnZatvori, btnRegistracija;

    public void akcijaRegistracije(ActionEvent actionEvent) {
    }

    public void akcijaZatvaranja(ActionEvent actionEvent) {
    }

    public void otvaranjePomoc(ActionEvent actionEvent) {
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
}
