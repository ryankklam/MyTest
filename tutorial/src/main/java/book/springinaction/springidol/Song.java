package book.springinaction.springidol;

public class Song implements ISong {

	String title;
	String LINE;

	public String getTitle() {
		return title;
	}

	public void sing() {
		System.out.println(LINE);
	}

	public void setLINE(String lINE) {
		LINE = lINE;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
