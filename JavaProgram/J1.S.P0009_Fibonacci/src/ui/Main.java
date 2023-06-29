package ui;

import bo.Fibonacci;
import java.math.BigInteger;
import utils.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        int n = 1000;
        BigInteger[] arr;
        Fibonacci f = new Fibonacci();
        System.out.println("The " + n + " sequence fibonacci : ");
        arr = f.getFirstNFiboNumber(n);
        ArrayUtils.displayArray(arr);
    }
}
