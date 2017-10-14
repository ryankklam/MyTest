package book.tamebadcode;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年3月20日 下午10:57:41
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class PhoneClock extends Clock{

	private HotelWorldClockSystem hotelWorldClockSystem;
	private int time;

	public PhoneClock(int utcOffset) {
		super.utcOffset=utcOffset;
	}

	public void setTime(int time) {
		this.time=time;
		if(hotelWorldClockSystem==null) return;
//		this.cityClock.setUtcZeroTime(time - this.utcOffset);
		for(CityClock cityClock :hotelWorldClockSystem.getClocks() ){
			cityClock.setUtcZeroTime(time - super.utcOffset);
		}
		
	}

	public HotelWorldClockSystem getHotelWorldClockSystem() {
		return hotelWorldClockSystem;
	}

	public void setHotelWorldClockSystem(HotelWorldClockSystem hotelWorldClockSystem) {
		this.hotelWorldClockSystem = hotelWorldClockSystem;
	}

	@Override
	public int getTime() {
		return this.time;
	}
	
	

}
