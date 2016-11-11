package mainPkt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import datumPkt.MyDateClass;
import datumPkt.TimeClass;
import datumPkt.TimeMachine;

public class MainDate {

	public static void main(String[] args) {		
		LocalDateTime now = LocalDateTime.now();
		LocalDate today = LocalDate.now();
		System.out.println("Today the date and time(unformated): " + now);
		ZoneId zoneId = ZoneId.of("Europe/Stockholm");
		
		System.out.println("Seconds since 1st of January 1970: " + now.atZone(zoneId).toEpochSecond());
		System.out.println("Days since 1st of January 1970: " + today.toEpochDay());
		System.out.println();
		Period quarter = Period.ofMonths(3);
		Period in5years = Period.ofYears(5);
		LocalDate threeMonthsAgo = today.minus(quarter);
		System.out.println("3 months back from today the date was: " + threeMonthsAgo);
		LocalDate fiveYearsForwards = threeMonthsAgo.plus(in5years);
		System.out.println("5 years after the date above the date will be: " + fiveYearsForwards);
		System.out.println();
		
		MyDateClass dateClass = new MyDateClass();
		
		System.out.println("Week day the first Christmas was on: " + dateClass.getFirstChristmas().getDayOfWeek());

		System.out.println("Days since the very first Christmas: " + dateClass.daysSinceYearZero());
		System.out.println();
		
		System.out.println("Day the Eleventh of September was on: " + dateClass.getEleventhSep().getDayOfWeek());
		
		ZoneId tokyo = ZoneId.of("Asia/Tokyo");
		ZoneId chicago = ZoneId.of("America/Chicago");
		DateTimeFormatter foreignFormatter = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println();
		System.out.println("The time is now in Tokyo: " + foreignFormatter.format(LocalTime.now(tokyo)));
		System.out.println();
		System.out.println("The time is now in Chicago: " + foreignFormatter.format(LocalTime.now(chicago)));
		
		TimeMachine tTravel = new TimeMachine();
		LocalDateTime earlierDate = LocalDateTime.of(1939, 9, 1, 4, 45);
		System.out.println();
		tTravel.travelBackwards(earlierDate);
		System.out.println();
		LocalDateTime futureDate = LocalDateTime.of(2030, 12, 31, 23, 59);
		
		tTravel.travelForward(futureDate);
						
		System.out.println();
		LocalDateTime anvDatTid = tTravel.choseDateTime();
		System.out.println();
		
		if(anvDatTid.isAfter(LocalDateTime.now()) == true){
			tTravel.travelForward(anvDatTid);
		}
		else if(anvDatTid.isBefore(LocalDateTime.now()) == true){
			tTravel.travelBackwards(anvDatTid);
		}
		
		System.out.println();
		TimeClass timeClass = new TimeClass();
		timeClass.timeWork();
	}

}
