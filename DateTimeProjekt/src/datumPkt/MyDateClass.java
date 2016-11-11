package datumPkt;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.*;//temporal unit

public class MyDateClass {
	LocalDate localDate = LocalDate.now();
		
	LocalDate eleventhSep = LocalDate.of(2001, Month.SEPTEMBER, 11);
	
	LocalDate firstChristmas = LocalDate.of(1, 12, 24);
	
	public long dateSinceEleventh(){
		LocalDate ld = LocalDate.now();
				
		long res = ld.until(eleventhSep, ChronoUnit.DAYS);
		
		return res;
	}
	
	public long daysSinceYearZero(){
		LocalDate now = LocalDate.now();
		
		long result = 0;
		result = firstChristmas.until(now, ChronoUnit.DAYS);
				
		return result;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDate getEleventhSep() {
		return eleventhSep;
	}

	public void setEleventhSep(LocalDate eleventhSep) {
		this.eleventhSep = eleventhSep;
	}

	public LocalDate getFirstChristmas() {
		return firstChristmas;
	}

	public void setFirstChristmas(LocalDate firstChristmas) {
		this.firstChristmas = firstChristmas;
	}	
}
