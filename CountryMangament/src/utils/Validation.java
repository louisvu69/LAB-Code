/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author My PC
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static boolean pressYNtoContinue(String mess) {
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String getStringByRegex(String mess, String error, String regex) {

        String output = null;
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }

    public static int inputInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
            return inputInt();
        }
    }

    public static String inputString() {
        try {
            return sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid string format!");
            return inputString();
        }
    }
    
    public static double getDouble(String msg, double min, double max) {
        String str;
        double choice;
        do {
            try {
                System.out.print(msg);
                str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    System.err.println("Not empty!");
                    continue;
                }
                choice = Double.parseDouble(str);
                if (choice < min || choice > max) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("Input must be in range from " + min + " to " + max);
            }

        } while (true);
        return choice;
    }
}
