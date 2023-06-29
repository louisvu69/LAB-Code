package utils;

import java.util.Scanner;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);

    public static int getinputInt(String mess, String errorNumberFormat, String errorOutofRange, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.err.print(errorOutofRange);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.print(errorNumberFormat);
            }
        }
    }

    public static String getInputString(String mess, String regexError, String regex) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.matches(regex)) {
                System.err.print(regexError);
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN(String mess, String errorYN) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine();

            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.print(errorYN);
        }
    }

    public static boolean checkInputUD(String mess, String errorUD) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.print(errorUD);
        }
    }

    public static String getInputCourse(String mess, String errorCourse) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine();
            //check input course in java, .net, c/c++
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.print(errorCourse);
        }
    }

    public static String getInputSemester(String mess, String errorSemester) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine();
            //check input semester in Spring, Summer, Fall
            if (result.equalsIgnoreCase("Spring") || result.equalsIgnoreCase("Summer") || result.equalsIgnoreCase("Fall")) {
                return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
            }
            System.err.print(errorSemester);
        }
    }

}
