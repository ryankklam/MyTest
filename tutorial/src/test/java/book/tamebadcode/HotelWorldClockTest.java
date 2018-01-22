package book.tamebadcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HotelWorldClockTest {
	
	private HotelWorldClockSystem hotelWorldClockSystem;
	private PhoneClock phoneClock;
	
	@Before
	public void initialize(){
		this.hotelWorldClockSystem = new HotelWorldClockSystem();
		this.phoneClock = new PhoneClock(8);
	}
	
	@Test
	public void the_time_of_the_clock_London_should_be_1_after_the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock londonClock = new CityClock(0);
		hotelWorldClockSystem.attach(londonClock);
		
		//Act
//		phoneClock.setCityClock(londonClock);
		phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
		phoneClock.setTime(9);
		
		//Assert
		assertEquals(1,londonClock.getTime());
	}
	
	@Test
	public void the_time_of_the_clock_NewYork_should_be_20_after_the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock newyorkClock = new CityClock(-5);
		hotelWorldClockSystem.attach(newyorkClock);
		
		//Act
//		phoneClock.setCityClock(newyorkClock);
		phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
		phoneClock.setTime(9);

		//Assert
		assertEquals(20,newyorkClock.getTime());
	}
	
	@Test
	public void the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock newyorkClock = new CityClock(-5);
		CityClock londonClock = new CityClock(0);
		
		hotelWorldClockSystem.attach(londonClock);
		hotelWorldClockSystem.attach(newyorkClock);
		
		//Act
//		phoneClock.setCityClock(newyorkClock);
		phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
		
		phoneClock.setTime(9);

		//Assert
		assertEquals(1,londonClock.getTime());
		assertEquals(20,newyorkClock.getTime());

	}
	
	@Test
	public void the_time_of_phone_clock_should_be_set_after_its_setTime_method_is_invoked(){
		
		//Arrange
		
		//Act
		phoneClock.setTime(9);
		
		//Act
		assertEquals(9,phoneClock.getTime());
		
	}
	
	@Test
	public void the_time_of_the_clock_Moscow_should_be_5_before_the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock moscowClock = new CityClock(4);
		hotelWorldClockSystem.attach(moscowClock);
		
		//Act
//		phoneClock.setCityClock(londonClock);
		phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
		phoneClock.setTime(9);
		
		//Assert
		assertEquals(5,moscowClock.getTime());
	}
}
