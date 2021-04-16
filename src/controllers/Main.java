package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.CountryHistory;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<CountryHistory> countries;
    public static boolean isExecuted = false;

    public static ArrayList<CountryHistory> getCountries()
    {
        if(!isExecuted)
        {
            preBuilt();
            isExecuted = true;
        }
        return countries;
    }
    public static void preBuilt()
    {
        countries = new ArrayList<>();
        countries.add(new CountryHistory("India","Asia","$2.869 trillion",new Image("images/india.jpg"),
                "1.366 billion","Rupees","India is a land of ancient civilizations. " +
                "India's social, economic, and cultural configurations are the products of a long process of regional expansion. " +
                "Indian history begins with the birth of the Indus Valley Civilization and the coming of the Aryans. " +
                "These two phases are usually described as the pre-Vedic and Vedic age. Hinduism arose in the Vedic period"));

        countries.add(new CountryHistory("Canada","North america","$1.736 trillion",new Image("images/canada.png"),
                "37.89 million","Canadian dollar","When Europeans explored Canada they found all regions " +
                "occupied by native peoples they called Indians, because the first explorers thought they had reached the East Indies. " +
                "following the bison (buffalo) herd. The Inuit lived off Arctic wildlife. West Coast natives preserved fish by drying and smoking. " +
                "Warfare was common among Aboriginal groups as they competed for land, resources and prestige."));

        countries.add(new CountryHistory("Australia","Oceania","$1.37 trillion",new Image("images/australia.jpg"),
                "25.36 million","Australian dollar","The history of Australia is the story of the land and " +
                "peoples of the continent of Australia. Aboriginal Australians first arrived on the Australian mainland by sea from " +
                "The artistic, musical and spiritual traditions they established are among the longest surviving such traditions " +
                "in human history."));
    }
    public static void main(String[] args) {
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
