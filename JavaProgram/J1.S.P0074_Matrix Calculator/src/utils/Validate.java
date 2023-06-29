package utils;

import bo.MatrixCalculation;
import java.util.Scanner;
import model.Matrix;

public class Validate {

    public static Scanner in = new Scanner(System.in);
    MatrixCalculation mc = new MatrixCalculation();

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Please input integer number in range [" + min + ", " + max + "]: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Value of matrix is digit");
            }
        }

    }

    public static boolean isAddable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getRow() == matrix2.getRow() && matrix1.getColumn() == matrix2.getColumn();
    }

    public static boolean isSubtractable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getRow() == matrix2.getRow() && matrix1.getColumn() == matrix2.getColumn();
    }

    public static boolean isMultiplicable(Matrix matrix1, Matrix matrix2) {
        return matrix1.getColumn() == matrix2.getRow();
    }

}
