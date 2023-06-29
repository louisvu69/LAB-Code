package utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Validate {

    private static final Scanner in = new Scanner(System.in);
    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";

    /*
    ^               represents starting character of the string.
    \\d             represents all character must be a digit and not have space
    {10}            represents this must have exactly 10 characters.
    $               represents the end of the string.
    
     */
    private static final String PASSWORD_VALID = "^(?=.*[0-9])(?=.*[A-Z]).{8,31}$";
    /*
    ^               represents starting character of the string.
    (?=.*[0-9])     represents a digit must occur at least once.
    (?=.*[A-Z])     represents an alphabet that must occur at least once.
    .{8,31}        represents at least 8 characters and at most 31 characters.
    $               represents the end of the string.
    
     */
    private static final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static void getWordLanguage(Locale curLocate, String key) {

        ResourceBundle words = ResourceBundle.getBundle("languagepack/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public static int getInputIntLimit(int min, int max, Locale language) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                getWordLanguage(language, "errCheckInputIntLimit");
            }
        }
    }

    public static String getCaptchaText() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 6; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public static boolean isValidAccount(String account) {
        return account.matches(ACCOUNT_NUMBER_VALID);
    }

    public static boolean isValidPassword(String password) {
        return password.toUpperCase().matches(PASSWORD_VALID);
    }

    public static boolean isValidCaptcha(String input, String captchaGenerated) {
        for (int i = 0; i < input.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
