package utils;

import java.util.Scanner;

public class Validate {

    private static final Scanner in = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1]+";
    private static final String DECIMAL_VALID = "[0-9]+";
    //hàm static chỉ dùng đc những cái static, chứ k phải ngược lại, của object, truyền reference thì thích dùng cgi cũng đc
    //nên là những object như hằng số BI_VALID cũng phải để static
    private static final String HEXADECIMAL_VALID = "[0-9A-Fa-f]+"; // hằng số nên để final, vì
    // Nếu bạn tạo bất cứ biến nào là final, bạn không thể thay đổi giá trị của biến final (nó sẽ là hằng số).

    //check user input number limit
    public static int getInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Please input number in range [" + min + ", " + max + "] : ");
            }
        }
    }

    //check user input number binary
    public static String getInputBinary() {
        System.out.print("Enter number binary: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(BINARY_VALID)) {
                return result;
            }
            System.err.print("Must be 0 or 1. Please enter again : ");
        }
    }

    //    //check user input number binary
    public static int getInputDecimal() {
        System.out.print("Enter number decimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(DECIMAL_VALID)) {
                return Integer.valueOf(result);
            }
            System.err.print("Must be 0-9. Please enter again : ");
        }
    }

    //    //check user input number binary
    public static String getInputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches(HEXADECIMAL_VALID)) {
                return result;
            }
            System.err.print("Must be 0-9 or A-F. Please enter again : ");
        }
    }
}
