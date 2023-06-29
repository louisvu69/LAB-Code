package ui;

import bo.MatrixCalculation;
import model.Matrix;
import utils.Validate;

public class Main {

    public static void main(String[] args) {
        MatrixCalculation mc = new MatrixCalculation();
        Matrix matrix1 = new Matrix(0, 0);
        Matrix matrix2 = new Matrix(0, 0);
        matrix1.inputMatrix("A");
        matrix2.inputMatrix("B");
        while (true) {
            System.out.println("=========Calculator program===========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = Validate.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    if (Validate.isAddable(matrix1, matrix2)) {
                        mc.showAdditionResult(matrix1, matrix2);
                    } else {
                        System.err.println("Two matrices do not have same column and row. Can not add");

                    }
                    break;
                case 2:
                    if (Validate.isSubtractable(matrix1, matrix2)) {
                        mc.showSubtractionResult(matrix1, matrix2);
                    } else {
                        System.err.println("Two matrices do not have same column and row. Can not subtract");
                    }
                    break;
                case 3:
                    if (Validate.isMultiplicable(matrix1, matrix2)) {
                        mc.showMultiplicationResult(matrix1, matrix2);
                    } else {
                        System.err.println("Matrix A's column is not equal to matrix B's row. Can not multiply");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
