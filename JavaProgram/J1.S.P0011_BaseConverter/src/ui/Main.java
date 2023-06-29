package ui;

import bo.BaseConverter;
import utils.Validate;

public class Main {

    public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        Display display = new Display();

        while (true) {
            display.menu();
            int choice = Validate.getInputIntLimit(1, 4);
            switch (choice) {
                case 1: {
                    String binary = Validate.getInputBinary();
                    display.displayConvert("binary", "decimal", "hexadecimal");
                    int choice1 = Validate.getInputIntLimit(1, 2);
                    switch (choice1) {
                        case 1:
                            System.out.println("Decimal: " + bc.convertBinaryToDecimal(binary));
                            break;
                        case 2:
                            System.out.println("Hexadecimal: " + bc.convertBinaryToHexa(binary));
                            break;
                    }
                    break;
                }
                case 2: {
                    int decimal = Validate.getInputDecimal();
                    display.displayConvert("decimal", "binary", "hexadecimal");
                    int choice2 = Validate.getInputIntLimit(1, 2);
                    switch (choice2) {
                        case 1:
                            System.out.println("Binary: " + bc.convertDecimalToBinary(decimal));
                            break;
                        case 2:
                            System.out.println("Hexadecimal: " + bc.convertDecimalToHexa(decimal));
                            break;
                    }
                    break;
                }

                case 3: {
                    String hexa = Validate.getInputHexaDecimal();
                    display.displayConvert("hexa", "binary", "decimal");
                    int choice3 = Validate.getInputIntLimit(1, 2);
                    switch (choice3) {
                        case 1:
                            System.out.println("Binary: " + bc.convertHexaToBinary(hexa));
                            break;
                        case 2:
                            System.out.println("Decimal: " + bc.convertHexaToDecimal(hexa));
                            break;
                    }
                    break;
                }

                case 4:
                    return;
            }
        }
    }
}
