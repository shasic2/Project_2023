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

    public void promjenaBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a;");
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");
    }

    public void promjenaBrojeZatvori(MouseEvent mouseEvent) {
    }

    public void promjenaBrojeOtvori(MouseEvent mouseEvent) {
    }
}
