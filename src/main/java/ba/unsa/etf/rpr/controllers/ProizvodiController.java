package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProizvodiController {
    public TableColumn idNazivNap;
    public TitledPane idNapier;
    public TableColumn idOpisNa;
    public TableColumn idCijenaNa;
    public TitledPane idNapici;
    public TableColumn idNazivNa;
    public TitledPane idSnackovi;
    public TableColumn idNazivSn;
    public TableColumn IdOpisSn;
    public TableColumn idCijenaSn;
    public Button btnDodajUKorpu;
    public Button btnPomoc, btnONama, btnODjava,btnKorpa;


    public void otvranjeKorpe(ActionEvent actionEvent) {
    }

    public void promjenaBojeKorpa(MouseEvent mouseEvent) {
    }

    public void vracanjeBojeKorpa(MouseEvent mouseEvent) {
    }

    public void akcijaOdjaviSe(ActionEvent actionEvent) {
    }

    public void promjenaBojeOdjava(MouseEvent mouseEvent) {
    }

    public void vracanjeBojeOdjava(MouseEvent mouseEvent) {
    }

    public void actionOtvaranjeONama(ActionEvent actionEvent) {
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
    public void otvaranjePomoci(ActionEvent actionEvent) {
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

    public void promjenaBojeONAma(MouseEvent mouseEvent) {
    }

    public void vracanjeBojeONama(MouseEvent mouseEvent) {
    }



    public void promjenaBojePomoc(MouseEvent mouseEvent) {
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
    }

    public void akcijaDodajUKorpu(ActionEvent actionEvent) {
    }
}
