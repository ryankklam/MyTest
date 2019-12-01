package Algorithms;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertArrayEquals;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      30Nov2019 10:16:35
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 *  //https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MiniMaxSumTest {
    @Test
    public void test(){

        int[] scores = new int[]{1,2,3,4,5};

        BigInteger[] expectResult = new BigInteger[]{BigInteger.valueOf(10),BigInteger.valueOf(14)};
        BigInteger[] result = MiniMaxSum.miniMaxSum(scores);
        assertArrayEquals(expectResult,result);
    }
}
