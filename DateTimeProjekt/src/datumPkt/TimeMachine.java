package datumPkt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//recommended link:
//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

public class TimeMachine {	
	DateTimeFormatter dtfPattern = DateTimeFormatter.ofPattern("HH:mm, eeee d MMMM yyyy G");
	
	public void travelBackwards(LocalDateTime locDateTime){
		if (LocalDateTime.now().isAfter(locDateTime)){						
			System.out.println("Time travel backwards in time");
			System.out.println("You have traveled backwards in time to " + dtfPattern.format(locDateTime));
			System.out.println("The day of the week is " + locDateTime.getDayOfWeek());
			System.out.println("Day since the start of the year: " + locDateTime.getDayOfYear());
			
			if (locDateTime.isEqual(LocalDateTime.of(1939, 9, 1, 4, 45))){
				System.out.println();
				System.out.println("Do you want to stop the second World War(invasion of Poland)?");
				Scanner sc = new Scanner(System.in);
				String svar = sc.nextLine();
				//sc.close();
				if (svar.equalsIgnoreCase("y")){
					System.out.println("You stopped the second World War! Well done!");
				}
				else if (svar.equalsIgnoreCase("yes")){
					System.out.println("You stopped the second World War! Well done!");
				}
				else if (svar.equalsIgnoreCase("n")){
					System.out.println("You let the second World War start. Over 60 million died...");
				}
				else if (svar.equalsIgnoreCase("no")){
					System.out.println("You let the second World War start. Over 60 million died...");
				}
			}
		}
		else{
			System.out.println("Today's date is not later than the date you want to travel to");
		}
	}
	
	public void travelForward(LocalDateTime locDateTime){
		if (LocalDateTime.now().isBefore(locDateTime)){
			System.out.println("Time travel forward in time");
			System.out.println("You have traveled forward in time to " + dtfPattern.format(locDateTime));
			System.out.println("The day of the week is " + locDateTime.getDayOfWeek());
			System.out.println("Day since the start of the year: " + locDateTime.getDayOfYear());
		}
		else {
			System.out.println("The date you chose is not in the future so you can't travel there");
		}
		
	}
	
	public LocalDateTime choseDateTime(){
		System.out.println("Chose year you want to travel to: ");
		int year = 0;
		int month = 0;
		int day	= 0;
		Scanner sc = new Scanner(System.in);
		year = Integer.parseInt(sc.nextLine());
		System.out.println("Chose month you want to travel to: ");
		month = Integer.parseInt(sc.nextLine());		
		System.out.println("Chose day you want to travel to: ");
		day = Integer.parseInt(sc.nextLine());
		LocalDate userDate = LocalDate.of(year, month, day);		
		
		int hour = 12;
		int minute = 0;
		System.out.println();
		System.out.println("Do you care about the time you want to travel to?");
		String svar = sc.nextLine();
		if (svar.equals("y")){
			System.out.println("Hour?");
			hour = Integer.parseInt(sc.nextLine());
			System.out.println("Minute?");
			minute = Integer.parseInt(sc.nextLine());
		}
		else if (svar.equals("yes")){
			System.out.println("Hour?");
			hour = Integer.parseInt(sc.nextLine());
			System.out.println("Minute?");
			minute = Integer.parseInt(sc.nextLine());
		}
		LocalTime userTime = LocalTime.of(hour, minute);
		sc.close();
		
		LocalDateTime userDateTime = LocalDateTime.of(userDate, userTime);
		
		
		return userDateTime;
	}
}
