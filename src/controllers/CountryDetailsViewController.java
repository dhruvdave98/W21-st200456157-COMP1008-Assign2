package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.CountryHistory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryDetailsViewController implements Initializable {
    private CountryHistory chooseCountry;

    @FXML private ImageView flagImage;
    @FXML private Label populationLabel, currencyLabel, continentLabel, countryGdpLabel;
    @FXML private TextArea historyTextArea;
    @FXML private ListView<CountryHistory> countryListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        countryListView.getItems().addAll(controllers.Main.getCountries());
//        flagImage.setImage(flagImage.getImage());
//        populationLabel.getText();
//        currencyLabel.getText();
//        countryGdpLabel.getText();
//        continentLabel.getText();
//        historyTextArea.getText();
    }

    public void listViewSelectCountry()
    {
        chooseCountry = countryListView.getSelectionModel().getSelectedItem();
        updateGUI();
    }
    public void chooseCountry(CountryHistory newCountry)
    {
        chooseCountry = newCountry;
        countryListView.getItems().addAll(Main.getCountries());
        updateGUI();
    }
    private void updateGUI()
    {
        flagImage.setImage(chooseCountry.getCountryFlag());
        populationLabel.setText(chooseCountry.getCountryPopulation());
        currencyLabel.setText(chooseCountry.getCountryCurrency());
        continentLabel.setText(chooseCountry.getContinent());
        countryGdpLabel.setText(chooseCountry.getCurrentGdp());
        historyTextArea.setText(chooseCountry.getCountryHistory());
    }

    public void createCountryButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/newCountryView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Add Country");
        stage.setScene(scene);
        stage.show();
    }
}
