package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.CountryHistory;

import java.io.File;

public class NewCountryViewController {

    private CountryHistory newCountry;

    @FXML private Label countryNameLabel;
    @FXML private Label continentLabel;
    @FXML private Label gdpLabel;
    @FXML private Label populationLabel;
    @FXML private Label currencyLabel;
    @FXML private Label historyLabel;
    @FXML private Label imageLabel;

    @FXML private TextField countryNameTextField;
    @FXML private TextField continentTextField;
    @FXML private TextField gdpTextField;
    @FXML private TextField populationTextField;
    @FXML private TextField currencyTextField;
    @FXML private TextArea historyTextArea;

    @FXML private Button imageButton;
    @FXML private Button submitButton;

    @FXML private ImageView flagImageView;

    public NewCountryViewController() {
    }

    public void selectImageButtonPressed(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose image");
        File imageFile = fileChooser.showOpenDialog(stage);

        if(imageFile.isFile())
        {
            flagImageView.setImage(new Image(imageFile.toURI().toString()));
        }
    }
    public void submitButtonPressed(ActionEvent event)
    {
        newCountry = new CountryHistory(countryNameTextField.getText(),
                                  continentTextField.getText(),
                                  gdpTextField.getText(),
                                    flagImageView.getImage(),
                                    Double.parseDouble(populationTextField.getText()),
                                    currencyTextField.getText(),
                                    historyTextArea.getText());
    }

}
