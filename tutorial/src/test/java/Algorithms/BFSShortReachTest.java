package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 *  https://www.hackerrank.com/challenges/bfsshortreach/problem
 */
public class BFSShortReachTest {
    @Test
    public void test1(){

        int[][] edges = new int[][]{{1,2},{1,3}};

        int[] result = new int[]{6,6,-1};
        assertArrayEquals(result,BFSShortReach.bfs(4,2,edges,1));
    }

}
