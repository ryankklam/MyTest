package book.springinaction.springidol;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TVSeries {
	String title;
	@Autowired
	@Qualifier("evanRachelWood")
	PlayActor majorAct;
	Map<String, PlayActor> castMap; // 角色 演员 map

	public void setCastMap(Map<String, PlayActor> castMap) {
		this.castMap = castMap;
	}
	
	public void introduceCast(){
		System.out.println("TVSeries - " + title + ", Major act is " + majorAct.getName());
		for (Map.Entry<String, PlayActor> entry : castMap.entrySet()) {  
			entry.getValue().introduceMyselfInSeries(title, entry.getKey());
		}  
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMajorAct(PlayActor majorAct) {
		this.majorAct = majorAct;
	}

	
}
