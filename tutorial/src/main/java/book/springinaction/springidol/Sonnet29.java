package book.springinaction.springidol;

public class Sonnet29 implements Poem {

	private static String[] LINES = {
			"If you were a teardrop;In my eye,", 
			"For fear of losing you,I would never cry", 
			"And if the golden sun,Should cease to shine its light,", 
			"Just one smile from you,Would make my whole world bright"
	};
	
	public void recite() {
		for(int i=0;i<LINES.length;i++){
			System.out.println(LINES[i]);
		}
		
	}

}
