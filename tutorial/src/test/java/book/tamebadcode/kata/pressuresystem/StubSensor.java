package book.tamebadcode.kata.pressuresystem;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年1月25日 下午10:16:35
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class StubSensor implements Transducer{

	double stubNextPsiValue;
	
	public void arrangeNextPressurePsiValue(double stubValue) {
		this.stubNextPsiValue = stubValue;
	}

	public double popNextPressurePsiValue() {
		return this.stubNextPsiValue;
	}


}
