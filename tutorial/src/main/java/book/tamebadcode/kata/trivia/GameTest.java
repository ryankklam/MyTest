package book.tamebadcode.kata.trivia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年10月30日 下午1:55:53
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class GameTest {
	//TODO-user-intent : The game should be over if 1 player rolls the dice and answered each questions correctly for 6 times.
	@Test
	public void game_should_be_over_if_1_player_rolls_the_dice_and_answered_each_questions_correctly_for_6_times(){
		//Arrange
		boolean isGameStillInProgress = true;
        Game aGame = new Game();
        aGame.add("Chet");
		
		//Act
        for(int i=0;i<=5;i++){
            aGame.roll(1);
            //here to follow up Rename variable 'winner' to be 'isGameStillInProgress'
            //notAWinner = aGame.wasCorrectlyAnswered();
            isGameStillInProgress = aGame.wasCorrectlyAnswered();
        }

		//Assert
		assertEquals(false,isGameStillInProgress);
		
		
	}
	
	//TODO-user-intent : The game should be over if 1 player rolls the dice for 7 times and answered the question wrongly for 1 time followed by an odd rolling number but then correctly for 6 times.
	@Test
	public void game_should_be_over_if_1_player_rolls_the_dice_for_7_times_and_answered__questions_wrongly_for_1_time_followed_by_an_odd_rolling_number_but_then_correctly_for_6_times(){
		//Arrange
		boolean isGameStillInProgress = true;
        Game aGame = new Game();
        aGame.add("Chet");
		
		//Act
        aGame.roll(1);
        isGameStillInProgress = aGame.wrongAnswer();
        
        for(int i=0;i<6;i++){
            aGame.roll(1);
            isGameStillInProgress = aGame.wasCorrectlyAnswered();
        }

		//Assert
		assertEquals(false,isGameStillInProgress);
		
		
	}
	
	
	//TODO-user-intent : The game should be over if 1 player rolls the dice for 8 times and and answered the question wrongly for 1 time followed by an even rolling number but then correctly for 7 times.
	@Test
	public void game_should_be_over_if_1_player_rolls_the_dice_for_8_times_and_answered__questions_wrongly_for_1_time_followed_by_an_even_rolling_number_but_then_correctly_for_7_times(){
		//Arrange
		boolean isGameStillInProgress = true;
        Game aGame = new Game();
        aGame.add("Chet");
		
		//Act
        aGame.roll(1);
        isGameStillInProgress = aGame.wrongAnswer();
        
        aGame.roll(2);
        isGameStillInProgress = aGame.wasCorrectlyAnswered(); // not sure why needs here
        
        for(int i=0;i<6;i++){
            aGame.roll(1);
            isGameStillInProgress = aGame.wasCorrectlyAnswered();
        }

		//Assert
		assertEquals(false,isGameStillInProgress);
		
		
	}
	
	@Test
	public void add_2_PopQuestions_and_could_remove_the_first_one(){
		
		//Arrange
		QuestionMaker questionMaker = new QuestionMaker();
		
		//Act
        for (int i = 1; i <= 2; i++) {
        	questionMaker.addPopQuestions("Pop Question " + i);
        }
		
		//Assert
		assertEquals("Pop Question 1",questionMaker.RemoveFirstPopQuestions());
	}
	
	@Test
	public void add_2_ScienceQuestions_and_could_remove_the_first_one(){
		
		//Arrange
		QuestionMaker questionMaker = new QuestionMaker();
		
		//Act
        for (int i = 1; i <= 2; i++) {
            questionMaker.addScienceQuestions("Science Question " + i);
        }
		
		//Assert
		assertEquals("Science Question 1",questionMaker.RemoveFirstScienceQuestions());
	}
	
	@Test
	public void add_2_SportsQuestions_and_could_remove_the_first_one(){
		
		//Arrange
		QuestionMaker questionMaker = new QuestionMaker();
		
		//Act
        for (int i = 1; i <= 2; i++) {
            questionMaker.addSportsQuestions("Sports Question " + i);
        }
		
		//Assert
		assertEquals("Sports Question 1",questionMaker.RemoveFirstSportsQuestions());
	}
	
	@Test
	public void add_2_RockQuestions_and_could_remove_the_first_one(){
		
		//Arrange
		QuestionMaker questionMaker = new QuestionMaker();
		
		//Act
        for (int i = 1; i <= 2; i++) {
            questionMaker.addRockQuestions("Rock Question " + i);
        }
		
		//Assert
		assertEquals("Rock Question 1",questionMaker.RemoveFirstRockQuestions());
	}
	
}
