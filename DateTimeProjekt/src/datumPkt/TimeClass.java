package datumPkt;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeClass {

	LocalTime lTime = LocalTime.of(21,15);
	DateTimeFormatter patternFormatter = DateTimeFormatter.ofPattern("HH:mm:ss:N");
	
	public void timeWork(){
		System.out.println("In the method timeWork");
		System.out.println("The time is here: " + lTime);		
		System.out.println("10 hours after it is: " + lTime.plusHours(10));		
		lTime = lTime.plusHours(10);
		System.out.println("Add 90 s and 291 ns - " + lTime.plusSeconds(90).plusNanos(291));
		lTime = lTime.plusSeconds(90).plusNanos(291);		
	}
}
