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
public class BomberManTest {
    @Test
    public void test3s(){

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] expectResult = new String[]{
                "OOO.OOO",
                "OO...OO",
                "OOO...O",
                "..OO.OO",
                "...OOOO",
                "...OOOO"
        };


        String[] result =BomberMan.bomb(3,grid);
        assertArrayEquals(expectResult,result);
    }

    @Test
    public void test1s(){

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] expectResult = grid;


        String[] result =BomberMan.bomb(1,grid);
        assertArrayEquals(expectResult,result);
    }

    @Test
    public void test2s(){

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] expectResult = new String[]{
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO"
        };


        String[] result =BomberMan.bomb(2,grid);
        assertArrayEquals(expectResult,result);
    }

    @Test
    public void test4s(){

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] expectResult = new String[]{
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO"
        };


        String[] result =BomberMan.bomb(4,grid);
        assertArrayEquals(expectResult,result);
    }

    @Test
    public void test5s(){

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        String[] expectResult = grid;


        String[] result =BomberMan.bomb(5,grid);
        assertArrayEquals(expectResult,result);
    }

    @Test
    public void testCase1_5s(){

        String[] grid = new String[]{
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."
        };

        String[] grid1s = new String[]{
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."
        };

        String[] grid2s = new String[]{
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO"
        };

        String[] grid3s = new String[]{
                "OOO.O.O",
                "OO.....",
                "OO....O",
                ".......",
                ".......",
                "......."
        };

        String[] grid4s = new String[]{
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO"
        };

        String[] grid5s = new String[]{
                ".......",
                "...O.O.",
                "...OO..",
                "..OOOO.",
                "OOOOOOO",
                "OOOOOOO"
        };

        String[] grid6s = new String[]{
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO"
        };

        String[] grid7s = new String[]{
                "OOO.O.O",
                "OO.....",
                "OO....O",
                ".......",
                ".......",
                "......."
        };

        String[] expectResult = grid5s;

        String[] result =BomberMan.bomb(1,grid);
        assertArrayEquals(grid1s,result);

        result =BomberMan.bomb(2,grid);
        assertArrayEquals(grid2s,result);

        result =BomberMan.bomb(3,grid);
        assertArrayEquals(grid3s,result);

        result =BomberMan.bomb(4,grid);
        assertArrayEquals(grid4s,result);

        result =BomberMan.bomb(5,grid);
        assertArrayEquals(grid5s,result);

        result =BomberMan.bomb(6,grid);
        assertArrayEquals(grid6s,result);

        result =BomberMan.bomb(7,grid);
        assertArrayEquals(grid7s,result);
    }
}
