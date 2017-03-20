package book.tamebadcode;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年3月20日 下午10:57:17
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class CityClock {

	private int utcOffset;
	private int utcZeroTime;

	public CityClock(int utcOffset) {
		this.utcOffset = utcOffset;
	}

	public int getTime() {
//		return this.utcOffset + this.utcZeroTime;
		return (this.utcOffset + this.utcZeroTime +24)%24;
	}

	public void setUtcZeroTime(int utcZeroTime) {
		this.utcZeroTime=utcZeroTime;
		
	}

}
