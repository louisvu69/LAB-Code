/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import utils.Validation;
import controller.CountryManagerController;
import entity.Country;

/**
 *
 * @author My PC
 */
public class Menu {

    public Boolean isExit = false;
    private CountryManagerController controller = new CountryManagerController();

    public void displayMenu() {
        System.out.println("                MENU                ");
        System.out.println("====================================================");
        System.out.println("    1.Input the information of 11 countries in East Asia");
        System.out.println("    2.Display the information of country you've just input");
        System.out.println("    3.Search the information of country by user-entered name");
        System.out.println("    4.Display the information of countries sorted name in ascending order");
        System.out.println("    5.Exit");
    }

    public int getChoice() {
        return Validation.getInt("", "Integer only!", "Please enter from [1] to [5] ", 1, 5);
    }

    public void run(int choice) throws Exception {

        try {
            switch (choice) {
                case 1:
                    try {
                        do {
                            Country addCountry = controller.addCountry();
                            System.err.println("Add success!");
                            System.out.println(addCountry);
                        } while (Validation.pressYNtoContinue("Do you want to continue? (Y/N): "));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    controller.displayAllCountries();
                    break;
                case 3:
                    try {
                        String name = Validation.getStringByRegex("Enter name of the country you want to search: ", "Character only!", "[A-Za-z ]+");
                        System.out.println("The countries found: ");
                        controller.searchingByName(name);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        controller.displayNameBySorting();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;
                case 5:
                    isExit = true;
                    break;
            }
        } catch (Exception e) {
//                e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
