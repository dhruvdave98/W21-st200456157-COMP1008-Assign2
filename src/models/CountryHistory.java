package models;

import javafx.scene.image.Image;

public class CountryHistory extends Country{


    private String countryPopulation;
    private String countryCurrency;
    private String countryHistory;

    public CountryHistory(String countryName, String continent, String currentGdp, Image countryFlag,
            String countryPopulation, String countryCurrency, String countryHistory) {
        super(countryName, continent, currentGdp, countryFlag);
        setCountryPopulation(countryPopulation);
        setCountryCurrency(countryCurrency);
        setCountryHistory(countryHistory);
    }


    public void setCountryPopulation(String countryPopulation) {
        if(countryPopulation.length()>0)
            this.countryPopulation = countryPopulation;
        else
            throw new IllegalArgumentException("Country's population cannot be negative value and should be in numbers only");
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public void setCountryHistory(String countryHistory) {
        if(countryHistory.length() < 600)
            this.countryHistory = countryHistory;
        else
            throw new IllegalArgumentException("Country's history should be less than 600 characters long");
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public String getCountryHistory() {
        return countryHistory;
    }

}
