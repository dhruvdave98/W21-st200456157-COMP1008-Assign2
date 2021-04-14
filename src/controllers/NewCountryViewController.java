package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import java.io.IOException;

public class NewCountryViewController {

    private CountryHistory newCountry;

    @FXML private Label countryNameLabel;
    @FXML private Label continentLabel;
    @FXML private Label gdpLabel;
    @FXML private Label populationLabel;
    @FXML private Label currencyLabel;
    @FXML private Label historyLabel;
    @FXML private Label imageLabel;
    @FXML private Label errLabel;

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

        //filter image to jpg and png only
        FileChooser.ExtensionFilter imageFilter =
                                    new FileChooser.ExtensionFilter("Image files","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(imageFilter);

        //loading image to ImageView
        File imageFile = fileChooser.showOpenDialog(stage);

        if(imageFile != null && imageFile.isFile())
        {
            flagImageView.setImage(new Image(imageFile.toURI().toString()));
        }
    }
    public void submitButtonPressed(ActionEvent event) throws IOException {

        try {
            newCountry = new CountryHistory(countryNameTextField.getText(),
                    continentTextField.getText(),
                    gdpTextField.getText(),
                    flagImageView.getImage(),
                    populationTextField.getText(),
                    currencyTextField.getText(),
                    historyTextArea.getText());
            changeScenes(event, newCountry);
        }catch(IllegalArgumentException e)
        {
            errLabel.setText(e.getMessage());
        }
    }

    public void changeScenes(ActionEvent event,CountryHistory newCountry) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/countryDetailsView.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        CountryDetailsViewController controller = loader.getController();
        controller.selectedCountry(newCountry);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Explore country");
        stage.setScene(scene);
        stage.show();
    }
}
