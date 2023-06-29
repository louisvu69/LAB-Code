/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author My PC
 */
public class Validation {

    private static String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    private static final Scanner sc = new Scanner(System.in);

    public static boolean pressYNtoContinue(String mess) {
        String input = getStringByRegex(mess, "Y/N only!!!", "[YNyn]");
        return input.equalsIgnoreCase("y");
    }

    public static String setSex() {
        int choice = Validation.getInt("Enter sex:\n [1] - Male\n [2] - Female\n ", "Integer only!", "Please enter in range from 1 to 2", 1, 2);
        switch (choice) {
            case 1:
                return "Male";
            case 2:
                return "Female";

        }
        return null;
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

    public static String getInputDate(String msg, String errorDateMsg) {
        System.out.println(msg);
        String result = "";
        while (true) {
            try {
                result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.out.println(errorDateMsg);
                }
            } catch (ParseException e) {
                System.out.println(errorDateMsg);
            }
        }
    }

    public static String getMail(String mess, String error) {

        String output = null;
        while (true) {
            System.out.print(mess);
            output = sc.nextLine();
            if (output.matches(EMAIL_VERIFICATION)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
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
}
