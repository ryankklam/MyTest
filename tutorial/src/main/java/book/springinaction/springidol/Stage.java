package book.springinaction.springidol;

public class Stage {

	public Stage() {
		super();
	}
	
	private static class StageSingletonHolder{
		static Stage instance = new Stage();
	}
	
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}

}
