package Algorithms;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      30Nov2019 10:16:35
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 *  //https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class QueensAttackTest {
    @Test
    public void test(){

        int[][] obstacles = new int[][]{};

        int expectResult = 9;
        int result = QueensAttack.queensAttack(4,0 ,4,4,obstacles);
        assertEquals(expectResult,result);
    }

    @Test
    public void test2(){

        int[][] obstacles = new int[][]{{5,5},{4,2},{2,3}};

        int expectResult = 10;
        int result = QueensAttack.queensAttack(5,3 ,4,3,obstacles);
        assertEquals(expectResult,result);
    }
}
