package utilities;

import javafx.scene.image.Image;
import models.Country;

import java.util.ArrayList;

public class Utility {
    public static ArrayList<Country> getCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Canada","North America","$1,736,426 million",new Image("images/canada.png")));
        countries.add(new Country("India","Asia","$2.869 trillion",new Image("images/india.jpg")));
        countries.add(new Country("Australia","Oceania","$1.397 trillion",new Image("images/australia.jpg")));
        countries.add(new Country("Italy","Europe","$2.004 trillion",new Image("images/italy.png")));
        countries.add(new Country("Norway","Europe","$403.3 billion",new Image("images/norway.jpg")));
        countries.add(new Country("France","Europe","$2.716 trillion",new Image("images/france.jpg")));
        countries.add(new Country("Japan","Asia","$5.082 trillion",new Image("images/japan.png")));
        return countries;
    }
}
