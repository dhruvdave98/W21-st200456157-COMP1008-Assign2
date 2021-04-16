package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Country;
import models.CountryHistory;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<CountryHistory> countries;

    public static ArrayList<CountryHistory> getCountries()
    {
        return countries;
    }
    public static void main(String[] args) {
        countries = new ArrayList<>();
//        countries.add(new CountryHistory("India","Asia","$2.869 trillion",new Image("images/india.jpg"),
//                "1.366 billion","Rupees","India is a land of ancient civilizations. " +
//                "India's social, economic, and cultural configurations are the products of a long process of regional expansion. " +
//                "Indian history begins with the birth of the Indus Valley Civilization and the coming of the Aryans. " +
//                "These two phases are usually described as the pre-Vedic and Vedic age. Hinduism arose in the Vedic period"));

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/countryDetailsView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add country");
        stage.show();
    }
}
