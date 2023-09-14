package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import ba.unsa.etf.rpr.business.KategorijeManager;
import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProizvodiController {



    public Button btnPomoc, btnONama, btnODjava,btnKorpa;


    public static Proizvodi selektovaniProizvod = new Proizvodi();
    public Button napiciId;
    public Button snackoviId;
    public Label idLabel;
    ProizvodiManager manager = new ProizvodiManager();

    @FXML public TableView<Proizvodi> tabelaId;
    @FXML public TableColumn<Proizvodi, String> tabelaNazivId;
    @FXML public TableColumn<Proizvodi, String> tabelaOpisId;
    @FXML public TableColumn<Proizvodi, Integer> tabelaCijenaID;



    @FXML
    void initialize() throws HealthyShopException {
        tabelaNazivId.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("ime"));
        tabelaOpisId.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("opis"));
        tabelaCijenaID.setCellValueFactory(new PropertyValueFactory<Proizvodi, Integer>("cijena"));
    }



    public void dodajProizvodUKorpu(ActionEvent actionEvent) {
        Proizvodi p = tabelaId.getSelectionModel().getSelectedItem();
        ModelManager model = ModelManager.getInstance();
        if(p != null){
            selektovaniProizvod = p;
            tabelaId.getSelectionModel().clearSelection();
            model.setProizvod(selektovaniProizvod);
            idLabel.setText("");
        }else{
            idLabel.setText("Greska");
        }
    }



    public void otvranjeKorpe(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/korpa.fxml"));
            KorpaController korpa = new KorpaController();
            fxmlLoader.setController(korpa);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Moja Healthy korpa");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void promjenaBojeKorpa(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a ;");
    }

    public void vracanjeBojeKorpa(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E  ;");
    }

    public void akcijaOdjaviSe(ActionEvent actionEvent) {
        try {
            Stage stage =(Stage)btnODjava.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/pocetna.fxml"));
            PocetnaController pocetna = new PocetnaController();
            fxmlLoader.setController(pocetna);
            Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage1.setTitle("Healthy shop");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void promjenaBojeOdjava(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a;");
    }

    public void vracanjeBojeOdjava(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E;");
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
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a ;");
    }

    public void vracanjeBojeONama(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E  ;");
    }



    public void promjenaBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #1e381a ;");
    }

    public void vracanjeBojePomoc(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setStyle("-fx-background-color:  #9CC23E  ;");
    }





    public void promjenaBojeNapici(MouseEvent mouseEvent) {
    }

    public void vracanjeBojeNapici(MouseEvent mouseEvent) {
    }


    public void promjneaBojeSnackovi(DragEvent dragEvent) {
    }

    public void vracanjeBojeSnackovi(DragEvent dragEvent) {
    }



    public void promjenaBojeDodajUKorpu(DragEvent dragEvent) {
    }

    public void vracanjeBojeDodajUKorpu(DragEvent dragEvent) {
    }
}
