package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Country;
import utilities.Utility;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryDashboardViewController implements Initializable {

    private Country selectedCountry;

    @FXML
    private Label countryListLabel;

    @FXML
    private ListView<Country> countryListView;

    @FXML
    private Button createCountryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryListView.getItems().addAll(Utility.getCountries());
    }

    public void newCountryButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/newCountryView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Create new Country");
        stage.setScene(scene);
        stage.show();
    }

    public void selectedCountry(Country country)
    {
        selectedCountry = country;
    }
}
