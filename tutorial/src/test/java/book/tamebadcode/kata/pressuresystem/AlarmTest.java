package book.tamebadcode.kata.pressuresystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年1月25日 下午9:57:11
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class AlarmTest {

	//TODO: 检测到正常的胎压不应该报警
	@Test
	public void normal_Pressure_should_not_trigger_Alarm(){
		StubSensor stubSensor = new StubSensor();	
		stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);
		Alarm alarm = new Alarm(stubSensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	
	//TODO: 检测到正常范围外的胎压，应该报警
	@Test
	public void abnormal_Pressure_should_trigger_Alarm(){
		StubSensor stubSensor = new StubSensor();	
		Alarm alarm = new Alarm(stubSensor);
		stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD-1);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	//TODO: 检测到正常范围外的胎压报警，之后检测到正常胎压，应该会让之前的报警停止
	@Test
	public void normal_Pressure_right_after_abnormal_Pressure_should_stop_Alarm(){
		StubSensor stubSensor = new StubSensor();	
		Alarm alarm = new Alarm(stubSensor);
		
		stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD-1);
		alarm.check();
//		assertTrue(alarm.isAlarmOn());
		
		stubSensor.arrangeNextPressurePsiValue(Alarm.LOW_PRESSURE_THRESHOLD);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
}
