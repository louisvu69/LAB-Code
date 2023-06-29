/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Country;
import java.util.ArrayList;

/**
 *
 * @author My PC
 */
public class CountryManager {

    private ArrayList<Country> countries;

    public CountryManager() {
        countries = new ArrayList<>();
    }

    public ArrayList<Country> getCountrysList() {
        return countries;
    }

    public boolean addCountry(Country c) throws Exception {
        if (!checkIsExist(c)) {
            return countries.add(c);
        }
        throw new Exception("Country code already exist");
    }

    public boolean checkIsExist(Country c) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCountryCode().contains(c.getCountryCode())) {
                return true;
            }
        }
        return false;
    }

    public int searchByCode(String code) {
        for (int index = 0; index < countries.size(); index++) {
            if (countries.get(index).getCountryCode().equals(code)) {
                return index;
            }
        }
        return -1;
    }
    
    private int getCountryByName(String name) {
        for (int index = 0; index < countries.size(); index++) {
            if (countries.get(index).getCountryName().toLowerCase().contains(name.toLowerCase())) {
                return index;
            }
        }
        return -1;
    }

    public Country searchByName(String name)  {
        int index = getCountryByName(name);
        if (index != -1) {
            return countries.get(index);
        }
        return null;
    }

    public Country getCountryByCode(String code) {
        int index = searchByCode(code);
        if (index != -1) {
            return countries.get(index);
        }
        return null;
    }

}
