package Algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      30Nov2019 22:16:35
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 *  https://www.hackerrank.com/challenges/encryption/problem
 */
public class GradingStudentsTest {
    @Test
    public void test_case1(){


        List<Integer> input = Arrays.asList(73,67,38,33);

        List<Integer> result = GradingStudents.gradingStudents(input);


        List<Integer>  expectResult = Arrays.asList(75,67,40,33);

        assertEquals(expectResult,result);
    }

    @Test
    public void test_case2(){


        List<Integer> input = Arrays.asList(37,38);

        List<Integer> result = GradingStudents.gradingStudents(input);


        List<Integer>  expectResult = Arrays.asList(37,40);

        assertEquals(expectResult,result);
    }

}
