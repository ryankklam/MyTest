package book.springinaction.springidol;

public class Juggler implements Performer {
	int beanBags = 3;

	public Juggler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juggler(int beanBags) {
		super();
		this.beanBags = beanBags;
	}

	public void perform() {
		System.out.println("Juggling " + beanBags + " BEANBAGs!");

	}

}
