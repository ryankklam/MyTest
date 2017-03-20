package book.tamebadcode;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年3月20日 下午10:57:41
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class PhoneClock {

	private CityClock cityClock;
	private int utcOffset;

	public PhoneClock(int utcOffset) {
		this.utcOffset=utcOffset;
	}
	
	public void setCityClock(CityClock cityClock) {
		this.cityClock=cityClock;
		
	}

	public void setTime(int time) {
		this.cityClock.setUtcZeroTime(time - this.utcOffset);
		
	}

}
