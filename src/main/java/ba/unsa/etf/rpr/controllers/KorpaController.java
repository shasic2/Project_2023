package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.business.NarudzbaProizvodaManager;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.NarudzbaProizvoda;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.HealthyShopException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
/**
 * JavaFX controller za kreiranje i izmjenu prozora korisnikove korpe
 *
 * @author Selma
 */
public class KorpaController {

    public Label idLabelaNaziv;
    public Label idLabelaCijena;
    public Button btnObrisi;
    public Label idLabela1;
    public Button btnZatvori;
    public Button btnONama;
    public ButtonBar btnPomoc;
    public Label LabelaZaGresku;
    public Label idLabel1;
    public Label idLabel10;
    public Label idLabel2;
    NarudzbaManager manager = new NarudzbaManager();
    public static Proizvodi proizvodIzKorpe = new Proizvodi();

    @FXML public void initialize() throws HealthyShopException {
        if (ProizvodiController.selektovaniProizvod != null) {
            idLabelaNaziv.setText(ProizvodiController.selektovaniProizvod.getIme());
            idLabelaCijena.setText(String.valueOf(ProizvodiController.selektovaniProizvod.getCijena()));

        }

  
}
/**
    * Metoda za bilježenje narudžbe ukoliko se korisnik odluči da neki proizvod poruči
     *
 */
    public void zabiljeziNarudzbu() throws HealthyShopException {
        Model model = Model.getInstance();
        Narudzba narudzba = new Narudzba();
        NarudzbaProizvoda srednja = new NarudzbaProizvoda();

        /**
         * promjenjiva koja ce cuvati informacije o proizvodima
         */
        proizvodIzKorpe.setIme(idLabel1.getText());
        proizvodIzKorpe.setOpis(idLabel2.getText());
        proizvodIzKorpe.setCijena(Integer.parseInt(idLabel10.getText()));

        System.out.println(proizvodIzKorpe.getIme() + "radiii");

        narudzba.setKorisnik_id(model.getKorisnik());
        narudzba.setRacun(model.getProizvodi().getCijena());
        manager.dodajNarudbu(narudzba);
        model.setNarudzba(narudzba);
        srednja.setNarudzba_id(model.getNarudzba());
        srednja.setProizvod_id(model.getProizvodi());

        NarudzbaProizvodaManager narProManager = new NarudzbaProizvodaManager();
        narProManager.dodajNP(srednja);
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

    public void otvaranjePomoci(MouseEvent mouseEvent) {

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
    /**
     * Događaj za brisanje dodanog proizvoda u korpu
     *
     * @param actionEvent
     */
    public void brisanjeProizvodaIzKorpe(ActionEvent actionEvent) {
        if (idLabelaNaziv != null && idLabelaCijena != null )
        {
            ProizvodiController.selektovaniProizvod = null;
            idLabelaNaziv.setText("");
            idLabelaCijena.setText("");
        }

        else {
            LabelaZaGresku.setText("Korpa je već prazna, ne postoji proizvod za brisanje !");
        }


    }

    public void narudzbaProizvoda(ActionEvent actionEvent) throws HealthyShopException {
        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/potvrdaNarudzbe.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Potvrda Narudzbe");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public void zatvaranjeKorpe(ActionEvent actionEvent) {
        Stage stage =(Stage)btnZatvori.getScene().getWindow();
        stage.close();
    }

}
