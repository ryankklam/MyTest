package testing;

import org.junit.Test;

public class mainTest {

    @Test
    public void demoTest(){
        int x = 10 ;
        double y = 20.2 ;
        long z = 10L;
        String str = "" + x + y * z ;
        System.out.println(str) ;

        int num = 68 ;
        char c = (char) num ;
        System.out.println(c) ;


        char d = 'A' ;
        int number = 10 ;
        switch(d) {
            case 'B' :
                number ++ ;
            case 'A' :
                number ++ ;
            case 'Y' :
                number ++ ;
                break ;
            default :
                number -- ;
        }
        System.out.println(number) ;

//        long num2 = 100 ;
//        int x2 = num2 + 2 ;
//        System.out.println(x2) ;

        int num3 = 2147483647 ;
        long temp = num3 + 2L ;
        System.out.println(num3) ;


        int sum = 0 ;
        for (int x3 = 0 ; x3 < 10 ; x3 ++) {
            sum += x3 ;
            if (x3 % 3 == 0) {
                break ;
            }
        }
        System.out.println(sum) ;

        int i = 1 ;
        int j = i++ ;
//        if((i==(++j))&&((i++)==j))     {
        if(i==(++j)){
            if((i++)==j){
                i += j ;
            }
        }
        System.out.println("i = "+i);

    }
}
