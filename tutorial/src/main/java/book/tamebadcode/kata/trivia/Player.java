package book.tamebadcode.kata.trivia;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年10月31日 下午3:53:59
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class Player {
	
	private String playerName;
	
	public Player(String playerName) {
		this.playerName = playerName;
	}

	//TODO override method to make logging printing correct player names
	@Override
	public String toString(){
		return this.playerName;
		
	}
}
