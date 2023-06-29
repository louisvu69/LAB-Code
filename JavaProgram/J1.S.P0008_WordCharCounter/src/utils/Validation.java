package utils;

import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

        public static String getStringWithErrMess(String message, String errRegex) {
        System.out.print(message);
        String inputString = "";
        while (true) {
            inputString = sc.nextLine();
            if (!inputString.isEmpty()) {
                return inputString;
            }
            System.err.print(errRegex);
        }
    }
}
