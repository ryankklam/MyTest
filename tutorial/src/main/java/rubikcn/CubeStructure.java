package rubikcn;

import java.util.ArrayList;
import java.util.Arrays;

public class CubeStructure {
	
	ArrayList<String> up_side = new ArrayList(Arrays.asList("w", "g", "y",
															"y", "w", "o",
															"b", "g", "r"));  
	
	ArrayList<String> right_side = new ArrayList(Arrays.asList("y", "w", "g",
												            "y", "o", "g",
												            "g", "r", "r"));  
	
	ArrayList<String> front_side = new ArrayList(Arrays.asList("o", "b", "r",
            "y", "b", "o",
            "w", "w", "o"));  
	
	ArrayList<String> down_side = new ArrayList(Arrays.asList("y", "w", "b",
            "o", "y", "r",
            "r", "y", "w"));  

	ArrayList<String> left_side = new ArrayList(Arrays.asList("b", "r", "b",
            "b", "r", "g",
            "o", "r", "g")); 
	
	ArrayList<String> back_side = new ArrayList(Arrays.asList("y", "b", "o",
            "o", "g", "w",
            "w", "b", "g")); 
}
