/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Country;
import entity.EastAsiaCountries;
import utils.Validation;

/**
 *
 * @author My PC
 */
public class CountryInputter {
    
    private EastAsiaCountries c = new EastAsiaCountries();
    
    public Country getCountry() {
        return c;
    }
    
    public EastAsiaCountries inputInformation() {
        c.setCountryCode(Validation.getStringByRegex("Enter country's Code: ", "Character only!", "[A-Za-z ]+"));
        c.setCountryName(Validation.getStringByRegex("Enter country's Name: ", "Character only!", "[A-Za-z ]+"));
        c.setCountryArea(Validation.getDouble("Enter total Area: ", 0.0000001, Double.MAX_VALUE));
        c.setCountryTerrain(Validation.getStringByRegex("Enter country's Terrain: ", "Character only!", "[A-Za-z ]+"));  
        return c;
    }
    
    
}
