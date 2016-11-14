package datumPkt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

//recommended link for all the values of the pattern formatter:
//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

public class TimeMachine {
	//"H" is 24-hour clock, "e" is local day, "G" is era, like AD, or "efter kristus" in Swedish
	DateTimeFormatter dtfPattern = DateTimeFormatter.ofPattern("HH:mm, eeee d MMMM yyyy G");
	//Scanner need to be closed, but I let it auto-close with the class
	private Scanner sc = new Scanner(System.in);
		
	public void travelBackwards(LocalDateTime locDateTime){
		if (LocalDateTime.now().isAfter(locDateTime)){						
			System.out.println("Time travel backwards in time");
			System.out.println("You have traveled backwards in time to " + dtfPattern.format(locDateTime));
			System.out.println("The day of the week is " + locDateTime.getDayOfWeek());
			System.out.println("Day since the start of the year: " + locDateTime.getDayOfYear());
			
			//catches specifically a call using this date and time in 1939
			if (locDateTime.isEqual(LocalDateTime.of(1939, 9, 1, 4, 45))){
				System.out.println();
				System.out.println("Do you want to stop the second World War(invasion of Poland)?");
				
				//try-catch in case the user inputs something wrong
				try{
					String svar = sc.nextLine();
					//2 statements because this computer lacks the pipeline sign for OR
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
				} catch(NoSuchElementException nsEx){
					System.out.println("No new line found, problem with the scanner. An exception occured: "
							+ nsEx.getMessage());
					nsEx.printStackTrace();
					
				} catch(IllegalStateException isEx){
					System.out.println("The scanner was closed. An exception occured: "
							+ isEx.getMessage());
					isEx.printStackTrace();
				} catch(NumberFormatException nfEx){//exception during parsing
					System.out.println("The input did not get correctly formated to a number. " 
							+ "An exception occured: " + nfEx.getMessage());
					nfEx.printStackTrace();
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
		
		//sets this to today's date just so it's initialized and so that the variable can be used
		LocalDateTime userDateTime = LocalDateTime.now();
				
		try{
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
			//read in time
			if (svar.equals("y")){
				System.out.println("Hour?");
				hour = Integer.parseInt(sc.nextLine());
				System.out.println("Minute?");
				minute = Integer.parseInt(sc.nextLine());
			}
			//2 statements because this computer lacks the pipeline sign for OR
			else if (svar.equals("yes")){
				System.out.println("Hour?");
				hour = Integer.parseInt(sc.nextLine());
				System.out.println("Minute?");
				minute = Integer.parseInt(sc.nextLine());
			}
			LocalTime userTime = LocalTime.of(hour, minute);			
			
			userDateTime = LocalDateTime.of(userDate, userTime);		
			
		} catch(NoSuchElementException nsEx){
			System.out.println("No new line found, problem with the scanner. An exception occured: "
					+ nsEx.getMessage());
			nsEx.printStackTrace();
		} catch(IllegalStateException isEx){
			System.out.println("The scanner was closed. An exception occured: "
					+ isEx.getMessage());
			isEx.printStackTrace();
		} catch(NumberFormatException nfEx){//exception during parsing
			System.out.println("The input did not get correctly formated to a number. " 
					+ "An exception occured: " + nfEx.getMessage());
			nfEx.printStackTrace();
		}
		
		return userDateTime;
	}	
}
