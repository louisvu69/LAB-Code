package utils;

import java.math.BigInteger;

public class ArrayUtils {

    public static void displayArray(BigInteger arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("\n");
            }
        }

    }
}
