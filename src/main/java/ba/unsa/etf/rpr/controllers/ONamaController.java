package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ONamaController {
    public Button ZatvoriId;

    public void ZatvaranjeProzora(ActionEvent actionEvent) {
        Stage stage =(Stage)ZatvoriId.getScene().getWindow();
        stage.close();
    }

    public void OtvoriPomoc(ActionEvent actionEvent) {

    }

    public void promjenaBojePomoc(MouseEvent mouseEvent) {
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
    }

    public void promjenaBrojeZatvori(MouseEvent mouseEvent) {
    }

    public void promjenaBrojeOtvori(MouseEvent mouseEvent) {
    }
}
