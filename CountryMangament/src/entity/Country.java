/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author My PC
 */
public class Country {

    public static final String TO_STRING = String.format("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");

    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, double countryArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-25s|%-20.0f", countryCode, countryName, countryArea);
    }

 

}
