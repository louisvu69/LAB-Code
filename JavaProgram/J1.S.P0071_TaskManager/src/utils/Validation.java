package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public static int getinputIntLimit(String mess, String errorNumberFormat, String errorOutofRange, int min, int max) {
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
            } catch (NumberFormatException ex) {
                System.err.print(errorNumberFormat);
            }
        }
    }

    public static String getInputDate(String mess, String errorDateFormat) {
        System.out.print(mess);
        while (true) {
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.print(errorDateFormat);
                }
            } catch (ParseException ex) {
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

    public static int getInputInt(String mess, String errorNumberFormat) {
        System.out.print(mess);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.print(errorNumberFormat);
            }
        }
    }

    public static String getInputTaskTypeId() {
        while (true) {
            System.out.println("LIST OF TASK TYPES: ");
            System.out.println("1. Code");
            System.out.println("2. Test");
            System.out.println("3. Design");
            System.out.println("4. Review");
            int n = getinputIntLimit("Enter task type: ", "Please enter a valid integer: ", "Pleae input integer number in range 1-4: ", 1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Manager";
                    break;
                case 4:
                    result = "Learn";
            }
            return result;
        }
    }

    public static String getInputPlan(String mess, String errorNumberFormat) {
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                System.err.print(errorNumberFormat);
            }
        }
    }
}
