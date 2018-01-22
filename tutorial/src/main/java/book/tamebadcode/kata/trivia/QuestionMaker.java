package book.tamebadcode.kata.trivia;

import java.util.LinkedList;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年10月31日 下午3:01:52
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class QuestionMaker {

    private LinkedList<String> popQuestions = new LinkedList<String>();
    private LinkedList<String> scienceQuestions = new LinkedList<String>();
    private LinkedList<String> sportsQuestions = new LinkedList<String>();
    private LinkedList<String> rockQuestions = new LinkedList<String>();
    
    public void addPopQuestions(String popQuestion){
    	popQuestions.add(popQuestion);
    }
    
    public void addScienceQuestions(String scienceQuestion){
    	scienceQuestions.add(scienceQuestion);
    }
    
    public void addSportsQuestions(String sportsQuestion){
    	sportsQuestions.add(sportsQuestion);
    }
    
    public void addRockQuestions(String rockQuestion){
    	rockQuestions.add(rockQuestion);
    }
    
    public String RemoveFirstPopQuestions(){
    	return popQuestions.removeFirst();
    }
    
    public String RemoveFirstScienceQuestions(){
    	return scienceQuestions.removeFirst();
    }
    
    public String RemoveFirstSportsQuestions(){
    	return sportsQuestions.removeFirst();
    }
    
    public String RemoveFirstRockQuestions(){
    	return rockQuestions.removeFirst();
    }
}
