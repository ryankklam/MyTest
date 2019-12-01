package Algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      30Nov2019 22:16:35
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 *  https://www.hackerrank.com/challenges/encryption/problem
 */
public class EncryptionTest {
    @Test
    public void test_iffactsdontfittotheorychangethefacts(){

        Encryption.encryption("iffactsdontfittotheorychangethefacts");

        //iffactsdontfittotheorychangethefacts //36

        String expectResult = "isieae fdtonf fotrga anoyec cttctt tfhhhs ";

        assertEquals(expectResult,Encryption.encryption("iffactsdontfittotheorychangethefacts"));
    }


    @Test
    public void test_feedthedog(){

        Encryption.encryption("feedthedog");

        //iffactsdontfittotheorychangethefacts //36

        String expectResult = "fto ehg ee dd ";

        assertEquals(expectResult,Encryption.encryption("feedthedog"));
    }
}
