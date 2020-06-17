/** 
 * Matala MMN12 q.1 - class that present date
 * 
 * @author amaztia adler
 * @version 2020a
 */

public class Date {
	private int _day, _month, _year;
	private final int TWO_DIGITS=10, MAX_YEAR=9999, DAY31=31, DAY30=30, DAY29=29, DAY1=1;
	private final int JAN=1, FEB=2, MARCH=3, APRIL=4, MAY=5, JUN=6, JUL=7, AUG=8, SEP=9, OCT=10, NOV=11, DEC=12;
	
	
	// constructors
	/** constructor 1 - input day & month & year and check if all correct
	 * @param day - represent the date
	 * @param month - represent the month
	 * @param year - represent the year
	 */
	public Date (int day, int month, int year) {
		if(isDateRight(day, month, year)) {
			_day = day;
			_month = month;
			_year = year;
		}
		else { // default values
			_day = 1;
			_month = 1;
			_year = 2000;
		}
	}
	
	/**
	 * constructor 2 - copy constructor
	 */
	public Date (Date other) {
		if(other != null) { // check that the given object is initialized
			_day = other.getDay();
			_month = other.getMonth();
			_year = other.getYear();
		}
	}

	// getters && setters
	/** get the day */
	public int getDay() { return _day; }
	
	/** get the month */
	public int getMonth() { return _month; }
	
	/** get the year */
	public int getYear() { return _year; }
	
	/** set the day
	 * @param dayToSet the value to be set
	 */
	public void setDay(int dayToSet) {
		if(isDateRight(dayToSet, _month, _year)) 
			_day = dayToSet; }
	
	/** set the month
	 * @param monthToSet the value to be set
	 */
	public void setMonth(int monthToSet) {
		if(isDateRight(_day, monthToSet, _year))
			_month = monthToSet; }
	
	/** set the year
	 * @param yearToSet the value to be set
	 */
	public void setYear(int yearToSet) {
		if(isDateRight(_day, _month, yearToSet))
			_year = yearToSet; }
	
	
	/**
	 * method that check if the date other is equals to the current date
	 * @param other - input Date
	 * @return true or false
	 */
	public boolean equals (Date other) {
		if (other.getDay() == _day && other.getMonth() == _month && other.getYear() == _year)
			return true;
		return false;
	}
	
	/**
	 * method that check if the date other before the current date
	 * @param other - input Date
	 * @return true or false
	 */
	public boolean before (Date other) {
		if (other.getYear() > _year)
			return true;
		else if (other.getYear() == _year) { // compare the years
			if (other.getMonth() > _month)
				return true;
			else if (other.getMonth() == _month) { // compare the months
				if (other.getDay() > _day)
					return true;
				return false;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * check if the date other after the current date
	 * @param other - input date
	 * @return true or false
	 */
	public boolean after (Date other) {
		return other.before(this);
	}
	
	/**
	 * check the difference between the date other and the current date
	 * @param other - input date
	 * @return integer that present the difference in days
	 */
	public int difference (Date other) {
		if(after(other))
			return calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year);
		else if(before(other))
			return calculateDate(other._day, other._month, other._year) - calculateDate(_day, _month, _year);
		return 0;
	}
	
	/**
	 * ToString
	 * @return string of the date
	 * in the following format: dd/mm/yyyy
	 */
	public String toString() {
		if(_day < TWO_DIGITS || _month < TWO_DIGITS) {
			if(_month >= TWO_DIGITS)
				return "0" + _day + "/" + _month + "/" + _year; // all 0 to the day if missing 
			else if(_day >= TWO_DIGITS)
				return _day + "/0" + _month + "/" + _year; // all 0 to the month if missing 
			return "0" + _day + "/0" + _month + "/" + _year; // all 0 to the year if missing 
		}
		return _day + "/" + _month + "/" + _year; // else
	}
	
	/**
	 * make string of the day after the current date
	 * @return string
	 */
	public Date tomorrow() {
		if(_day == DAY31 && _month == DEC && _year == MAX_YEAR)
			return new Date (01, 01, 2000);
		else if(isDateRight(_day+1, _month, _year))
			return new Date(_day+1, _month, _year); // if the date+1 is right return the date+1
		else {
			if(_month == 12)
				return new Date (01, 01, _year+1); // if the date is the last one in the year return the first in the new year
			else
				return new Date(1, _month+1, _year); // else return the first in the next month 
		}
	}
	
	/**
	 * calculate which day in the week is the current date
	 * @param D - temp for the day
	 * @param M - temp for the month
	 * @param Y - two last digits in the year
	 * @param C - two first digits in the year
	 * @param dayNumber - which day in the week by numbers
	 * @return the day in the week (string)
	 */
	public int dayInWeek() {
		int D=_day, M=_month, Y, C, dayNumber;
		Y = _year % 10 + ((_year / 10) % 10)*10;
		C = _year / 100; 
		
		if(M == 1) {
			M = 13;
			Y--;
		}
		else if(M == 2) {
			M = 14;
			Y--;
		}
		dayNumber = (D + (26*(M+1))/10 + Y + Y/4 + C/4 - 2*C) % 7; // calculate which day in the week
		
		if(dayNumber < 0)
			return Math.floorMod(dayNumber, 7); // if the day is negative  - correct it
		return dayNumber;
	}
	
	/**
	 * private method that calculate number of days that pass from the beginning
	 * @return integer for the days
	 */
	private int calculateDate(int day, int month, int year) {
		if (month < 3) {
			year--;
			month = month + 12;
		}
		return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62); // formula for calculation
	}
	
	/**
	 * check if the date is right
	 * @param day - gets the _day
	 * @param month - gets the _month
	 * @param year - gets the _year
	 * @return true or false
	 */
	private boolean isDateRight(int day, int month, int year) {
		if(day < DAY1 || day > DAY31 || month < JAN || month > DEC || year < 1000 || year > MAX_YEAR)
			return false;
		else if(month == FEB && day == DAY29) {
			if(year % 4 == 0) {
				if(year % 100 == 0) {
					if(year % 400 == 0)
						return true; // divide in 4 and in 100 and in 400
					return false; // divide in 4 and in 100 but not in 400
				}
				return true; // divide in 4 and not in 100
			}
			return false; // not divide in 4
		}
		else if(day == DAY30) {
			if(month == APRIL || month == JUN || month == SEP || month == NOV) 
				return true;
			return false;
		}
		else if(day == DAY31) {
			if(month == JAN || month == MARCH || month == MAY || month == JUL || month == AUG || month == OCT || month == DEC) 
				return true;
			return false;
		}
		return true;
		
	}
}
