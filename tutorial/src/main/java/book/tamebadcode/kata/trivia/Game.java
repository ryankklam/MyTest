package book.tamebadcode.kata.trivia;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年10月14日 下午10:02:57
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Game {
	
	private Logger logger = Logger.getLogger("book.tamebadcode.kata.trivia.Game");
	private static FileHandler fileHandler = null; 
	
//    private ArrayList players = new ArrayList();
	private ArrayList<Player> players = new ArrayList<Player>();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

//    private LinkedList popQuestions = new LinkedList();
//    private LinkedList scienceQuestions = new LinkedList();
//    private LinkedList sportsQuestions = new LinkedList();
//    private LinkedList rockQuestions = new LinkedList();

    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;
    private QuestionMaker questionMaker = new QuestionMaker();

    public Game() {
    	
    	try {
			fileHandler= new FileHandler("%h/Game-logging.log",10000000,1,true);
			fileHandler.setFormatter(new SimpleFormatter());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	logger.addHandler(fileHandler);

        for (int i = 1; i <= 50; i++) {
//            popQuestions.addLast("Pop Question " + i);
//            scienceQuestions.addLast(("Science Question " + i));
//            sportsQuestions.addLast(("Sports Question " + i));
//            rockQuestions.addLast("Rock Question " + i);
            questionMaker.addPopQuestions("Pop Question " + i);
            questionMaker.addScienceQuestions("Science Question " + i);
            questionMaker.addSportsQuestions("Sports Question " + i);
            questionMaker.addRockQuestions("Rock Question " + i);
        }
    }

    public void add(String playerName) {
//        players.add(playerName);
    	players.add(new Player(playerName));
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        logger.info(playerName + " was added");
        logger.info("The total num of players is " + players.size());
    }

    private int howManyPlayers() {
        return players.size();
    }

    public void roll(int rollingNumber) {
        logger.info(players.get(currentPlayer) + " is the current player");
        logger.info("They have rolled a " + rollingNumber);

        if (inPenaltyBox[currentPlayer]) {
            if (rollingNumber % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                logger.info(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayerMovesAToNewPlaceAndAnswersAQuestion(rollingNumber);
            } else {
            	logger.info(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
        	currentPlayerMovesAToNewPlaceAndAnswersAQuestion(rollingNumber);
        }

    }
    
    private void currentPlayerMovesAToNewPlaceAndAnswersAQuestion(int rollingNumber){
        places[currentPlayer] = places[currentPlayer] + rollingNumber;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        logger.info(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        logger.info("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
//            logger.info((String) popQuestions.removeFirst());
        	logger.info(questionMaker.RemoveFirstPopQuestions());
        if (currentCategory() == "Science")
//            logger.info((String) scienceQuestions.removeFirst());
        	logger.info(questionMaker.RemoveFirstScienceQuestions());
        if (currentCategory() == "Sports")
//            logger.info((String) sportsQuestions.removeFirst());
        	logger.info(questionMaker.RemoveFirstSportsQuestions());
        if (currentCategory() == "Rock")
//            logger.info((String) rockQuestions.removeFirst());
        	logger.info(questionMaker.RemoveFirstRockQuestions());
    }


    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]) {
			if (isGettingOutOfPenaltyBox) {
				return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
			} else {
				nextPlayer();
				return true;
			}

		} else {

			return currentPlayerGetsAGoldCoinAndSelectNextPlayer();
		}
	}
    
    private boolean currentPlayerGetsAGoldCoinAndSelectNextPlayer(){
    	logger.info("Answer was corrent!!!!");
        purses[currentPlayer]++;
        logger.info(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean isGameStillInProgress = isGameStillInProgress();
        nextPlayer();

        return isGameStillInProgress;
    }
    
    private void nextPlayer(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        logger.info("Question was incorrectly answered");
        logger.info(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        //TODO-later : The return value of method Game.wrongAnswer() is unnecessary and should be eliminated
        return true;
    }
    
    private boolean isGameStillInProgress() {
        return !(purses[currentPlayer] == 6);
    }
}
