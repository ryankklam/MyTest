package book.tamebadcode.kata.pressuresystem;
/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年1月22日 下午10:40:28
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class Alarm {
	public static final double LOW_PRESSURE_THRESHOLD =17;
	public static final double HIGH_PRESSURE_THRESHOLD =21;
	
	//TODO: 违反依赖倒置原则
//	private Sensor sensor = new Sensor();
	private Transducer transducer;
	private boolean alarmOn = false;
	
	public Alarm() {
		this.transducer=new Sensor();
	}

	public Alarm(Transducer transducer) {
		super();
		this.transducer = transducer;
	}

	public void check(){
		alarmOn=false;
//		double psiPressureValue = sensor.popNextPressurePsiValue();
		double psiPressureValue = transducer.popNextPressurePsiValue();
		
		if(psiPressureValue<LOW_PRESSURE_THRESHOLD ||
				HIGH_PRESSURE_THRESHOLD<psiPressureValue){
			alarmOn=true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}	

}
