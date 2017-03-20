package book.tamebadcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelWorldClockTest {
	
	@Test
	public void the_time_of_the_clock_London_should_be_1_after_the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock londonClock = new CityClock(0);
		PhoneClock phoneClock = new PhoneClock(8);
		
		//Act
		phoneClock.setCityClock(londonClock);
		phoneClock.setTime(9);
		
		//Assert
		assertEquals(1,londonClock.getTime());
	}
	
	@Test
	//TODO-Working-On Negative timezone checking
	public void the_time_of_the_clock_NewYork_should_be_20_after_the_phone_clock_is_set_to_9_Beijing_time(){
		//Arrange
		CityClock newyorkClock = new CityClock(-5);
		PhoneClock phoneClock = new PhoneClock(8);
		
		//Act
		phoneClock.setCityClock(newyorkClock);
		phoneClock.setTime(9);

		//Assert
		assertEquals(20,newyorkClock.getTime());
	}
}
