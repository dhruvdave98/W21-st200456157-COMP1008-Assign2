package models;

import javafx.scene.image.Image;

public class Country {
    private String countryName;
    private String continent;
    private String currentGdp;
    private Image countryFlag;


    public Country(String countryName, String continent, String currentGdp, Image countryFlag) {
        setCountryName(countryName);
        setContinent(continent);
        setCurrentGdp(currentGdp);
        setCountryFlag(countryFlag);
    }

    public void setCountryName(String countryName) {
        if (countryName.matches("[A-Z][a-z]*"))
            this.countryName = countryName;
        else
            throw new IllegalArgumentException("Country name should start with upper case letter and only contain alphabets");
    }

    public void setContinent(String continent) {
        if (countryName.matches("[A-Z][a-z]*"))
            this.continent = continent;
        else
            throw new IllegalArgumentException("Continent name should start with upper case letter and only contain alphabets");
    }

    public void setCurrentGdp(String currentGdp) {
        if (currentGdp.startsWith("$"))
            this.currentGdp = currentGdp;
        else
            throw new IllegalArgumentException("Country's GDP should be in USD so it should start with $ sign");
    }

    public void setCountryFlag(Image countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getContinent() {
        return continent;
    }

    public String getCurrentGdp() {
        return currentGdp;
    }

    public Image getCountryFlag() {
        return countryFlag;
    }

    public String toString()
    {
        return String.format("%s",countryName);
    }
}
