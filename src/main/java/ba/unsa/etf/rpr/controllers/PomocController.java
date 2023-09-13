package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PomocController {
    public Button ZatvoriID;

    public void ZatvaranjeProzora(ActionEvent actionEvent) {
        Stage stage =(Stage)ZatvoriID.getScene().getWindow();
        stage.close();
    }
}
