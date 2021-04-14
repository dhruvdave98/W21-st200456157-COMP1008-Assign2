import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Country;

import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<Country> countries;

    public static void main(String[] args) {
        launch(args);
    }
    public static ArrayList<Country> getCountries()
    {
        return countries;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/countryDashboardView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Explore country");
        stage.show();
    }
}
