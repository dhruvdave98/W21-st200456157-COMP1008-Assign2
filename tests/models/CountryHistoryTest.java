package models;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryHistoryTest {

    CountryHistory countryHistory;
    private JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setUp() {
        countryHistory = new CountryHistory("Canada","North America","$1,736,426 million",new Image("images/canada.png"),
                37742154,"Canadian Dollar",
                "When Europeans explored Canada they found all regions occupied by native peoples " +
                        "they called Indians, because the first explorers thought they had reached the East Indies. " +
                        "The native people lived off the land, some by hunting and gathering, others by raising crops. " +
                        "The Huron-Wendat of the Great Lakes region, like the Iroquois, were farmers and hunters. " +
                        "formed strong economic, religious and military bonds in the first 200 years of coexistence " +
                        "which laid the foundations of Canada.");
    }


    @Test
    void setCountryPopulation() {
        countryHistory.setCountryPopulation(37742154);
        assertEquals(37742154, countryHistory.getCountryPopulation());
    }

    @Test
    void setCountryCurrency() {
        countryHistory.setCountryCurrency("Canadian Dollar");
        assertEquals("Canadian Dollar", countryHistory.getCountryCurrency());
    }

    @Test
    void setCountryHistory() {
        countryHistory.setCountryHistory("When Europeans explored Canada they found all regions occupied by native peoples " +
                "they called Indians, because the first explorers thought they had reached the East Indies. " +
                "The native people lived off the land, some by hunting and gathering, others by raising crops. " +
                "The Huron-Wendat of the Great Lakes region, like the Iroquois, were farmers and hunters. " +
                "formed strong economic, religious and military bonds in the first 200 years of coexistence " +
                "which laid the foundations of Canada.");
        assertEquals("When Europeans explored Canada they found all regions occupied by native peoples " +
                "they called Indians, because the first explorers thought they had reached the East Indies. " +
                "The native people lived off the land, some by hunting and gathering, others by raising crops. " +
                "The Huron-Wendat of the Great Lakes region, like the Iroquois, were farmers and hunters. " +
                "formed strong economic, religious and military bonds in the first 200 years of coexistence " +
                "which laid the foundations of Canada.", countryHistory.getCountryHistory());
    }
}