/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import bo.CountryInputter;
import bo.CountryManager;
import entity.Country;
import entity.EastAsiaCountries;
import java.util.Collections;

/**
 *
 * @author My PC
 */
public class CountryManagerController {

    private CountryInputter countryInputter;
    private CountryManager countryManager;

    public CountryManagerController() {
        countryManager = new CountryManager();
    }

    public EastAsiaCountries inputCountry() throws Exception {
        countryInputter = new CountryInputter();
        EastAsiaCountries c = countryInputter.inputInformation();
        return c;
    }

    public Country addCountry() throws Exception {
        EastAsiaCountries c = inputCountry();
        if (countryManager.addCountry(c)) {
            return c;
        }
        throw new Exception("Add fail!");
    }

    public void displayNameBySorting() {
        Collections.sort(countryManager.getCountrysList(), (Country s1, Country s2) -> s1.getCountryName().compareTo(s2.getCountryName()));
        displayAllCountries();
    }

    public void displayAllCountries() {
        System.out.println(Country.TO_STRING);
        for (Country o : countryManager.getCountrysList()) {
            System.out.println(o);
        }
    }

    public void searchingByName(String name) throws Exception {
        Country c = countryManager.searchByName(name);
        if (c != null) {
            System.out.println(Country.TO_STRING);
            System.out.println(c.toString());
        }
    }
}
