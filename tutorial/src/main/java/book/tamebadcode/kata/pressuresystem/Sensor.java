package book.tamebadcode.kata.pressuresystem;

import java.util.Random;

/**
 *  @author: 	Ryan K K Lam
 *  @date:      2018年1月22日 下午10:34:49
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
public class Sensor {
	public static final double OFFSET = 16;
	
	public double popNextPressurePsiValue(){
		double pressureTelemetryValue;
		pressureTelemetryValue = samplePressure();
		
		return OFFSET + pressureTelemetryValue;
	}

	private double samplePressure() {
		Random basicRandomNumbersGenerator = new Random(42);
		double pressureTelemetryValue = 6* basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
		return pressureTelemetryValue;
	}
}
