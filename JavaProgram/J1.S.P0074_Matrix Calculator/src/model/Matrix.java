package model;

import utils.Validate;

public class Matrix {

    private int row;
    private int column;
    private int[][] data;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getData() {
        return data;
    }

    public void inputMatrix(String matrixname) {
        System.out.print("Enter row number of matrix " + matrixname + " : ");
        this.row = Validate.checkInputInt();
        System.out.print("Enter column number of matrix " + matrixname + " : ");
        this.column = Validate.checkInputInt();
        data = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter number of " + matrixname + "[" + i + "][" + j + "]: ");
                this.data[i][j] = Validate.checkInputInt();
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print("[" + this.data[i][j] + "]");
            }
            System.out.println();
        }
    }

}
