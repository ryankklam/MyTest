package book.springinaction.springidol;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PlayActor {
	String name;
//	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	String dateOfBirth;
	String placeOfBirth;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public PlayActor() {
		super();
	}

	public PlayActor(String name, String dateOfBirth, String placeOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
	}
	
	public void introduceMyselfInSeries(String title , String roleName){
		System.out.println("I'm " + name + ", I act " + roleName + " in " + title);
	}

}
