package book.tamebadcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年3月24日 上午2:03:18
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class HotelWorldClockSystem {
	CityClock phoneClock;
	List<CityClock> clockList = new ArrayList<CityClock>();
	private ArrayList<CityClock> cityClocks = new ArrayList<CityClock>();
	
	public void attach(CityClock cityClock){
//		clockList.add(wc);
		this.cityClocks.add(cityClock);
	}

	public ArrayList<CityClock> getClocks(){
		return this.cityClocks;
	}
	
//	public void notify(){
//		for(CityClock cityclock : clockList){
//			cityclock.setUtcZeroTime(time - this.utcOffset);
//		}
//	}
}
