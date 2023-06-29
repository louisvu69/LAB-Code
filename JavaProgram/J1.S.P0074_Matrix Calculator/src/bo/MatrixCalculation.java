package bo;

import model.Matrix;

public class MatrixCalculation {

    private Matrix additionMatrix(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.getRow(), matrix2.getColumn());
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix2.getColumn(); j++) {
                result.getData()[i][j] = matrix1.getData()[i][j] + matrix2.getData()[i][j];
            }
        }
        return result;
    }

    private Matrix subtractionMatrix(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.getRow(), matrix2.getColumn());
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix2.getColumn(); j++) {
                result.getData()[i][j] = matrix1.getData()[i][j] - matrix2.getData()[i][j];
            }
        }
        return result;
    }

    private Matrix multiplicationMatrix(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.getRow(), matrix2.getColumn());
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix2.getColumn(); j++) {
                result.getData()[i][j] = 0;
                for (int k = 0; k < matrix1.getColumn(); k++) {
                    result.getData()[i][j] += matrix1.getData()[i][k] * matrix2.getData()[k][j];
                }
            }
        }
        return result;
    }

    public void showCalculation(Matrix matrix1, Matrix matrix2, String operand) {
        matrix1.displayMatrix();
        System.out.println(operand);
        matrix2.displayMatrix();
        System.out.println("=");
    }

    public void showAdditionResult(Matrix matrix1, Matrix matrix2) {
        Matrix result = additionMatrix(matrix1, matrix2);
        showCalculation(matrix1, matrix2, "+");
        result.displayMatrix();
    }

    public void showSubtractionResult(Matrix matrix1, Matrix matrix2) {
        Matrix result = subtractionMatrix(matrix1, matrix2);
        showCalculation(matrix1, matrix2, "-");
        result.displayMatrix();
    }

    public void showMultiplicationResult(Matrix matrix1, Matrix matrix2) {
        Matrix result = multiplicationMatrix(matrix1, matrix2);
        showCalculation(matrix1, matrix2, "*");
        result.displayMatrix();
    }

}
