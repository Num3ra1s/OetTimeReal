/**
 * Date implements a date using month, day, and year
 * 
 * @author Rebecca Oet
 * @version September 2017
 */


public class Time {
	
	private int seconds, minutes, hour;
	private static int format;
	
	public static final int FORMAT_12 = 1;
	public static final int FORMAT_24 = 0;
	
	public Time() {
		seconds = 0;
		minutes = 0;
		hour = 0;
		format = FORMAT_24;
	}
	
	
	/**
	 * @param s The seconds
	 * @param m The minutes
	 * @param h The hour
	 */
	public Time(int h, int m, int s) {
		seconds = s;
		minutes = m;
		hour = h;
		format = FORMAT_24;
	}
	
	/**
	 * @param m The minutes
	 * @param h The hour
	 */
	public Time(int h, int m) {
		minutes = m;
		hour = h;
	}
	
	/**
	 * 
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}
	
	/**
	 * 
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	
	/**
	 * 
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	
	public void resetTime() {
		seconds = 0;
		minutes = 0;
		hour = 0;
	}

	public String toString() {
		
		if (format == FORMAT_24) {
			return (to2Digits(hour) + ":" + 
					to2Digits(minutes) + ":" + 
					to2Digits(seconds));
		} else { //if (format == Format_12)
			if (hour >= 12) {
				return ((hour-12) + ":" +
						to2Digits(minutes) + ":" +
						to2Digits(seconds) + " PM");
			} else if (hour == 12) {
				return ((hour) + ":" +
						to2Digits(minutes) + ":" +
						to2Digits(seconds) + " PM");
			}
			
			else if (hour > 0) {
				return ((hour) + ":" +
						to2Digits(minutes) + ":" +
						to2Digits(seconds) + " AM");
			} else {
				return ((hour) + ":" +
						to2Digits(minutes) + ":" +
						to2Digits(seconds) + " AM");
			}
		}
		
	}
	
	public void addMinutes(int n) {
		int newMin = this.minutes + n;
		this.minutes = newMin % 60;
		this.addHours(newMin / 60);
	}
	
	public void addHours(int n) {
		int newHours = this.hour + n;
		this.hour = newHours % 24;
	}
	
	public void addSeconds(int n) {
		int newSeconds = this.seconds + n;
		this.hour = newSeconds % 24;
	}
	
	/**
	 * Precondition: Time other is later than this time
	 * 
	 * @param other
	 * @return
	 */
	public Time elapsedTime(Time other) {
		int totalSecThis = (this.seconds) + (60 * this.minutes) + (3600 * this.hour);
		int totalSecOther = (other.getSeconds()) + (other.getMinutes() * 60) + (other.getHour() * 3600);
		int elapsedSeconds = totalSecOther - totalSecThis;
		int newHour = elapsedSeconds % 3600;
		int newMin = (elapsedSeconds % 3600) / 60;
		int newSec = elapsedSeconds % 60;
		return new Time(newHour, newMin, newSec);
		
	}
	
	public void setTime(int h, int m, int s) {
		hour = s;
		minutes = m;
		seconds = s;
	}
	
	public void setFormat(int f) {
		format = f;
	}
	
	public static boolean isValidTime(int h, int m, int s) {
		if (format == FORMAT_24) {
			if (h <= 0 || h > 24) {
				return false;
			} else if (m <= 0 || m > 60) {
				return false;
			} else if (s <= 0 || s > 60) {
				return false;
			} else {
				return true;
			}
		} else {
			if (h <= 0 || h > 12) {
				return false;
			} else if (m <= 0 || m > 60) {
				return false;
			} else if (s <= 0 || s > 60) {
				return false;
			} else {
				return true;
			}
		}	
	}
	
	private String to2Digits(int n) {
		
		if(n < 10) {
			return "0" + n;
		} else {
			return "" + n;
		}
	}
	
}
