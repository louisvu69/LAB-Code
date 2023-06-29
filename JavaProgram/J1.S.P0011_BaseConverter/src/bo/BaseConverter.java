package bo;

public class BaseConverter {

    private int chartoInt(char c) {
        if (c >= '0' && c <= '9') {
            return (int) c - '0';
        } else {
            return (int) Character.toUpperCase(c) - 'A' + 10;
        }
    }

    private char inttoChar(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + 48); // 48 là mã dec của char '0';
        } else {
            return (char) (num - 10 + 65); // 65 là mã dec của A, nếu num = 11 tương đương -> 66 là B
        }
    }

    private int convertBaseto10(String from, int base) {
        int decimal = 0;
        for (int i = 0; i < from.length(); i++) {
            decimal += chartoInt(from.charAt(i)) * Math.pow(base, from.length() - 1 - i);
        }
        return decimal;
    }

    private String convert10toBase(int decimal, int base) {
        String s = "";
        while (decimal > 0) {
            s += inttoChar(decimal % base);
            decimal /= base;
        }
        StringBuilder result = new StringBuilder();
        result.append(s);
        return new String(result.reverse());
    }

    //allow user convert from binary to decimal
    public int convertBinaryToDecimal(String binary) {
        return convertBaseto10(binary, 2);
    }

    //allow user convert from binary to hexadecimal
    public String convertBinaryToHexa(String binary) {
        return convert10toBase(convertBaseto10(binary, 2), 16).toUpperCase();
    }

    //allow user convert from decimal to binary
    public String convertDecimalToBinary(int decimal) {
        return convert10toBase(decimal, 2);
    }

    //allow user convert from decimal to hexadecimal
    public String convertDecimalToHexa(int decimal) {
        return convert10toBase(decimal, 16).toUpperCase();
    }

    //allow user convert from hexa to binary
    public String convertHexaToBinary(String hexa) {
        return convert10toBase(convertBaseto10(hexa, 16), 2);
    }

    //allow user convert from hexa to decimal
    public int convertHexaToDecimal(String hexa) {
        return convertBaseto10(hexa, 16);
    }
}
