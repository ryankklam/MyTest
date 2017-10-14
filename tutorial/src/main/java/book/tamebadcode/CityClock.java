package book.tamebadcode;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2017年3月20日 下午10:57:17
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class CityClock extends Clock{

	private int utcZeroTime;

	public CityClock(int utcOffset) {
		super.utcOffset = utcOffset;
	}

	@Override
	public int getTime() {
//		return this.utcOffset + this.utcZeroTime;
		return (super.utcOffset + this.utcZeroTime +24)%24;
	}

	public void setUtcZeroTime(int utcZeroTime) {
		this.utcZeroTime=utcZeroTime;
		
	}

}
