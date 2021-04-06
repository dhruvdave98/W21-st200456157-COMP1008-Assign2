package models;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    Country country;
    private JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setUp() {
        country = new Country("Canada","North America","$1,736,426 million",new Image("images/canada.png"));
    }

    @Test
    void setCountryName() {
        country.setCountryName("Canada");
        assertEquals("Canada", country.getCountryName());
    }

    @Test
    void setCountryNameInvalidEmpty(){
        assertThrows(IllegalArgumentException.class, ()-> country.setCountryName(""));
    }

    @Test
    void setCountryNameInvalidLowerCase(){
        assertThrows(IllegalArgumentException.class, ()-> country.setCountryName("canada"));
    }

    @Test
    void setCountryNameInvalidNumbers(){
        assertThrows(IllegalArgumentException.class, ()-> country.setCountryName("76Canada"));
    }

    @Test
    void setContinent() {
        country.setContinent("North America");
        assertEquals("North America", country.getContinent());
    }

    @Test
    void setContinentInvalidEmpty(){
        assertThrows(IllegalArgumentException.class, ()-> country.setContinent(""));
    }

    @Test
    void setContinentInvalidLowerCase(){
        assertThrows(IllegalArgumentException.class, ()-> country.setCountryName("north america"));
    }

    @Test
    void setContinentInvalidNumbers(){
        assertThrows(IllegalArgumentException.class, ()-> country.setContinent("76North America"));
    }

    @Test
    void setCurrentGdp() {
        country.setCurrentGdp("$1,736,426 million");
        assertEquals("$1,736,426 million", country.getCurrentGdp());
    }

    @Test
    void setCurrentGdpInvalid(){
        assertThrows(IllegalArgumentException.class, ()-> country.setCurrentGdp("    "));
    }

}