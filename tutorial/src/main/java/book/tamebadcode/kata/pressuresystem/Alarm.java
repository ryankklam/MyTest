package book.tamebadcode.kata.pressuresystem;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年1月22日 下午10:40:28
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class Alarm {
	private final double lowPressureThreshold =17;
	private final double highPressureThreshold =21;
	
	private Sensor sensor = new Sensor();
	private boolean alarmOn = false;
	
	public void check(){
		
		double psiPressureValue = sensor.popNextPressurePsiValue();
		
		if(psiPressureValue<lowPressureThreshold ||
				highPressureThreshold<psiPressureValue){
			alarmOn=true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}

}
