package Algorithms;

import java.math.BigInteger;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static BigInteger[] miniMaxSum(int[] arr) {

        BigInteger total = BigInteger.valueOf(0);
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int k=0;k<arr.length;k++ ){
            total = total.add(BigInteger.valueOf(arr[k])) ;
            if(arr[k]<min) min = arr[k];
            if(arr[k]>max) max = arr[k];
        }

        BigInteger[] result = new BigInteger[2];
        result[0] = total.subtract(BigInteger.valueOf(max));
        result[1] = total.subtract(BigInteger.valueOf(min));

        System.out.print(result[0]);
        System.out.print(" ");
        System.out.print(result[1]);

        return result;
    }
}
