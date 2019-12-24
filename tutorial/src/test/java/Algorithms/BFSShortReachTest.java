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

    @Test
    public void test2(){

        int[][] edges = new int[][]{{2,3}};

        int[] result = new int[]{-1,6};
        assertArrayEquals(result,BFSShortReach.bfs(3,1,edges,2));
    }

    @Test
    public void test3(){

        int[][] edges = new int[][]{{1,2},{2,3},{2,5},{3,4}};

        int[] result = new int[]{6,12,18,12};
        assertArrayEquals(result,BFSShortReach.bfs(5,4,edges,1));
    }



    @Test
    public void test5(){

        int[][] edges = new int[][]{{1,2},{1,3},{3,4}};

        int[] result = new int[]{6,6,12,-1};
        assertArrayEquals(result,BFSShortReach.bfs(5,3,edges,1));
    }

}
