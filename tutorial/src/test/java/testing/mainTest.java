package testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.util.Arrays;

public class mainTest {

    @Test
    public void jsonTest() throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        //test  using json string
        String json = "{\"2\":\"efg\",\"1\":\"abc\"}";
        String json2 = "{\"3\":\"ppp\",\"4\":\"xxx\"}";


        //test using object
        // create three JSON objects
        ObjectNode user1 = mapper.createObjectNode();
        user1.put("id", 1);
        user1.put("name", "John Doe");

        ObjectNode user2 = mapper.createObjectNode();
        user2.put("id", 2);
        user2.put("name", "Tom Doe");

        ObjectNode user3 = mapper.createObjectNode();
        user3.put("id", 3);
        user3.put("name", "Emma Doe");



        // create `ArrayNode` object
        ArrayNode jsonStringArrayNode = mapper.createArrayNode();
        jsonStringArrayNode.add(json);
        jsonStringArrayNode.add(json2);


        // add JSON users to array
        ArrayNode objectArrayNode = new ObjectMapper().createArrayNode();
        objectArrayNode.addAll(Arrays.asList(user1, user2, user3));

        // convert `ArrayNode` to pretty-print JSON
        // without pretty-print, use `arrayNode.toString()` method
        String jsonStrCombine = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonStringArrayNode);
        String objectStrCombine = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectArrayNode);

        System.out.println(jsonStrCombine);
        System.out.println(objectStrCombine);


//
//        JSONObject json_test = JSONObject.fromObject(json);
    }

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
