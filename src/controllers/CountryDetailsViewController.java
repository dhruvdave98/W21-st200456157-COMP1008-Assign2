package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import models.Country;
import models.CountryHistory;

public class CountryDetailsViewController {
    private CountryHistory selectedCountry;

    @FXML private ImageView flagImage;
    @FXML private Label populationLabel, currencyLabel;
    @FXML private TextArea historyTextArea;


    public void selectedCountry(CountryHistory newCountry)
    {
        selectedCountry = newCountry;
        updateGUI();
    }
    private void updateGUI()
    {
        flagImage.setImage(selectedCountry.getCountryFlag());
        populationLabel.setText(selectedCountry.getCountryPopulation());
        currencyLabel.setText(selectedCountry.getCountryCurrency());
        historyTextArea.setText(selectedCountry.getCountryHistory());
    }
}
