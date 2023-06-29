package bo;

import java.math.BigInteger;

public class Fibonacci {

    BigInteger[] temp = new BigInteger[10000];

    private BigInteger getFibonaccibyIndex(int index) {
        if (index == 0 || index == 1) {
            return BigInteger.ONE;
        }
        if (temp[index]!=null) {
            return temp[index];
        }
        BigInteger f = getFibonaccibyIndex(index - 2).add(getFibonaccibyIndex(index - 1));
        temp[index] = f;
        return f;
    }

    public BigInteger[] getFirstNFiboNumber(int n) {
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getFibonaccibyIndex(i);
        }
        return arr;
    }
}
