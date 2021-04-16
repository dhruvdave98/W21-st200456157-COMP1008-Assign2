package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML private Label errLabel;

    @FXML private TextField countryNameTextField;
    @FXML private TextField continentTextField;
    @FXML private TextField gdpTextField;
    @FXML private TextField populationTextField;
    @FXML private TextField currencyTextField;
    @FXML private TextArea historyTextArea;

    @FXML private ImageView flagImageView;


    /**
     * Method to execute after select image button is pressed and
     * have some validations in it
     * @param event
     * @throws IOException
     */
    public void selectImageButtonPressed(ActionEvent event) throws IOException {
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

    /**
     * Method to execute after submit button is pressed
     * @param event
     * @throws IOException
     */
    public void submitButtonPressed(ActionEvent event) throws IOException {

        try {
            newCountry = new CountryHistory(countryNameTextField.getText(),
                    continentTextField.getText(),
                    gdpTextField.getText(),
                    flagImageView.getImage(),
                    populationTextField.getText(),
                    currencyTextField.getText(),
                    historyTextArea.getText());
            Main.getCountries().add(newCountry);
            changeScenes(event, newCountry);
        }catch(IllegalArgumentException e)
        {
            errLabel.setText(e.getMessage());
        }
    }

    /**
     * method to change scene after submit button is pressed
     * @param event
     * @param newCountry
     * @throws IOException
     */
    public void changeScenes(ActionEvent event,CountryHistory newCountry) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/countryDetailsView.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        CountryDetailsViewController controller = loader.getController();
        controller.chooseCountry(newCountry);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Explore country");
        stage.setScene(scene);
        stage.show();
    }
}
